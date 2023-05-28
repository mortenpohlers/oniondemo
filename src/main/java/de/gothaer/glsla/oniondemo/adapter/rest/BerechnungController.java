package de.gothaer.glsla.oniondemo.adapter.rest;

import de.gothaer.glsla.oniondemo.adapter.rest.dto.BerechnungsErgebnisDto;
import de.gothaer.glsla.oniondemo.adapter.rest.dto.BerechnungsVorgabeDto;
import de.gothaer.glsla.oniondemo.adapter.rest.dto.mapper.BerechnungsErgebnisMapper;
import de.gothaer.glsla.oniondemo.adapter.rest.dto.mapper.BerechnungsVorgabeMapper;
import de.gothaer.glsla.oniondemo.domain.services.BerechnungsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/berechnung")
@RequiredArgsConstructor
@Tag(name = "Berechnung", description = "Fachlich völlig falsche Tarifierung als Demo onion Architektur")
public class BerechnungController {

    private final BerechnungsVorgabeMapper vorgabeMapper;
    private final BerechnungsErgebnisMapper ergebnisMapper;
    private final BerechnungsService berechnungsService;

    @Operation(summary = "Eine simple Berechnung. Fachlicher nonsense",
            description = "Führt eine Berechnung durch und persistiert diese unter der zurückgegebenen uuid. Inhaltlich nur eine fachlich völlig falsche Berechnung.",
            tags = {"Berechnung"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Das Berechnung wurde durchgeführt und gespeichert",
                            content = @Content(
                                schema = @Schema(implementation = BerechnungsErgebnisDto.class)
                            )
                    )
            })
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BerechnungsErgebnisDto> berechne(@RequestBody() BerechnungsVorgabeDto vorgabeDto) {
        var vorgabeEntity = vorgabeMapper.convert(vorgabeDto);
        var ergebnisEntity = berechnungsService.berechneUndSpeicher(vorgabeEntity);
        return ResponseEntity.ok(ergebnisMapper.convert(ergebnisEntity));
    }

    @Operation(summary = "Lädt eine vorher durchgeführte Berechnung.",
    tags= {"Berechnung"},
    parameters = {@Parameter(in = ParameterIn.PATH, name = "uuid", description = "UUID der Berechnung. wird bei der Berechnung vergeben.")})

    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BerechnungsErgebnisDto> findErgebnis(@PathVariable String uuid) {
        return ResponseEntity.ok(ergebnisMapper.convert(berechnungsService.findBerechnungsergebnis(uuid)));
    }
}

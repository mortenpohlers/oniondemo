package de.gopthaer.glsla.oniondemo.controller;

import de.gopthaer.glsla.oniondemo.dto.BerechnungsErgebnisDto;
import de.gopthaer.glsla.oniondemo.dto.BerechnungsVorgabeDto;
import de.gopthaer.glsla.oniondemo.dto.mapper.BerechnungsErgebnisMapper;
import de.gopthaer.glsla.oniondemo.dto.mapper.BerechnungsVorgabeMapper;
import de.gopthaer.glsla.oniondemo.service.BerechnungsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/berechnung")
@RequiredArgsConstructor
@Tag(name="Berechnung", description = "Fachlich völlig falsche Tarifierung als Demo onion Architektur")
public class BerechnungController {

    private final BerechnungsVorgabeMapper vorgabeMapper;
    private final BerechnungsErgebnisMapper ergebnisMapper;
    private final BerechnungsService berechnungsService;
    @Operation(summary = "Eine simple Berechnung. Fachlicher nonsense")

    @PostMapping("/")
    public ResponseEntity<BerechnungsErgebnisDto> berechene(@RequestBody BerechnungsVorgabeDto vorgabeDto){
        var vorgabeEntity = vorgabeMapper.convert(vorgabeDto);
        var ergebnisEntity = berechnungsService.berechneUndSpeicher(vorgabeEntity);
        return ResponseEntity.ok(ergebnisMapper.convert(ergebnisEntity));
    }

    @Operation(summary = "Lädt eine vorher durchgeführte Berechnung.")
    @GetMapping("/{uuid}")
    public ResponseEntity<BerechnungsErgebnisDto> findErgebnis(@PathVariable String uuid){
        return ResponseEntity.ok(ergebnisMapper.convert(berechnungsService.findBerechnungsergebnis(uuid)));
    }
}

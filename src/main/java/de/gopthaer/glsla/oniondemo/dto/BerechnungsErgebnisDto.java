package de.gopthaer.glsla.oniondemo.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class BerechnungsErgebnisDto {
    @Schema(description = "Eindeutige id, unter der die Berechnung wieder abgerufen werden kann.")
    private String uuid;
    @Schema(description = "Berechnungsvorgabe, auf dem diesen Ergebnis beruht.")
    private BerechnungsVorgabeDto berechnungsVorgabe;
    @Schema(example = "204.73933649289097", description = "Höhe des monatlichen Beitrags")
    private Double beitrag;
    @Schema(example = "2041-01-01",  description = "Datum an dem die Zahlungen aufhören und die Rente beginnt. (Renteneintritt)")
    private LocalDate zahlungBis;
}

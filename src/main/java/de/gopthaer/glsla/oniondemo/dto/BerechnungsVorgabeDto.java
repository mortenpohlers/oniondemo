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
public class BerechnungsVorgabeDto {
    @Schema(example = "", description = "Sollte beim request leer sein und wird bei einer Berechnung neu generiert.")
    private String uuid;
    @Schema(example= "1974-01-01", description = "Geburtsdatum der VP.")
    private LocalDate geburtsDatum;
    @Schema(example="2023-06-01", description = "Beginn der Zahlungen, normalerweise der Versicherungsbeginn.")
    private LocalDate zahlungAb;
    @Schema(example="150.0", description = "Höhe der gewünschten Rentenzahlung.")
    private Double wunschrente;
}

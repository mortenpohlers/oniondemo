package de.gopthaer.glsla.oniondemo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class BerechnungsErgebnisDto {
    private String uuid;
    private BerechnungsVorgabeDto berechnungsVorgabe;
    private Double beitrag;
    private LocalDate zahlungBis;
}

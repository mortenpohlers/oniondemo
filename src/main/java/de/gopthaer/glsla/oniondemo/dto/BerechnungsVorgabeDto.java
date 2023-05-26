package de.gopthaer.glsla.oniondemo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class BerechnungsVorgabeDto {
    private String uuid;
    private LocalDate geburtsDatum;
    private LocalDate zahlungAb;
    private Double wunschrente;
}

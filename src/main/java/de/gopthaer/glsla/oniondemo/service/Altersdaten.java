package de.gopthaer.glsla.oniondemo.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Altersdaten {
    private Double alterszuschlag;
    private LocalDate zahlungBis;
    private Integer anzahlRaten;
}

package de.gothaer.glsla.oniondemo.domain.services;

import de.gothaer.glsla.oniondemo.domain.aggregates.Altersdaten;

import java.time.LocalDate;

public interface AlterService {

    Altersdaten berechneAltersdaten(LocalDate geburtsdatum, LocalDate beginn);

}

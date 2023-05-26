package de.gopthaer.glsla.oniondemo.service;

import java.time.LocalDate;

public interface AlterService {

    Altersdaten berechneAltersdaten(LocalDate geburtsdatum, LocalDate beginn);

}

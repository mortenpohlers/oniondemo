package de.gopthaer.glsla.oniondemo.service;

import de.gopthaer.glsla.oniondemo.entity.BerechnungsErgebnisEntity;
import de.gopthaer.glsla.oniondemo.entity.BerechnungsVorgabeEntity;

public interface BerechnungsService {
    BerechnungsErgebnisEntity berechneUndSpeicher(BerechnungsVorgabeEntity vorgabe);
    BerechnungsErgebnisEntity findBerechnungsergebnis(String uuid);


}

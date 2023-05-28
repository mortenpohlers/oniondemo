package de.gothaer.glsla.oniondemo.domain.services;

import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsErgebnisEntity;
import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsVorgabeEntity;

public interface BerechnungsService {
    BerechnungsErgebnisEntity berechneUndSpeicher(BerechnungsVorgabeEntity vorgabe);
    BerechnungsErgebnisEntity findBerechnungsergebnis(String uuid);


}

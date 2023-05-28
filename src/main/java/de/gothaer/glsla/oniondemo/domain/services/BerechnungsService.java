package de.gothaer.glsla.oniondemo.domain.services;

import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsErgebnisEntity;
import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsVorgabeEntity;
import de.gothaer.glsla.oniondemo.domain.aggregates.BerechnungsErgebnis;
import de.gothaer.glsla.oniondemo.domain.aggregates.BerechnungsVorgabe;

public interface BerechnungsService {
    BerechnungsErgebnis berechneUndSpeicher(BerechnungsVorgabe vorgabe);
    BerechnungsErgebnis findBerechnungsergebnis(String uuid);


}

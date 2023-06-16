package de.gothaer.glsla.oniondemo.domain.services.internal;

import de.gothaer.glsla.oniondemo.domain.aggregates.BerechnungsErgebnis;
import de.gothaer.glsla.oniondemo.domain.aggregates.BerechnungsVorgabe;
import de.gothaer.glsla.oniondemo.domain.aggregates.alter.Altersdaten;
import de.gothaer.glsla.oniondemo.domain.services.BerechnungsRepository;
import de.gothaer.glsla.oniondemo.domain.services.BerechnungsService;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class BerechnungsServiceImpl implements BerechnungsService {



    private final BerechnungsRepository repository;
    private static final Integer ANZAHL_RENTENZAHLUNGEN = 20 * 12;


    private Double berechneBeitrag(Integer anzahlRaten, Double wunschrente, Double alterszuschlag) {
        var bedarf = wunschrente * ANZAHL_RENTENZAHLUNGEN;
        return bedarf / anzahlRaten * alterszuschlag;
    }

    @Override
    public BerechnungsErgebnis berechneUndSpeicher(BerechnungsVorgabe vorgabe) {
        var uuid = UUID.randomUUID().toString();
        vorgabe.setUuid(uuid);
        var altersdaten = Altersdaten.ofGeburtsdatumUndBeginn(vorgabe.getGeburtsDatum(), vorgabe.getZahlungAb());
        var beitrag = berechneBeitrag(altersdaten.getAnzahlRaten(), vorgabe.getWunschrente(), altersdaten.getAlterszuschlag());
        var ergebnis = BerechnungsErgebnis.builder()
                .uuid(uuid)
                .berechnungsVorgabe(vorgabe)
                .zahlungBis(altersdaten.getZahlungBis())
                .beitrag(beitrag)
                .build();
        repository.save(ergebnis);
        return ergebnis;
    }

    @Override
    public BerechnungsErgebnis findBerechnungsergebnis(String uuid) {
        return repository.findById(uuid).orElseThrow(() -> new IllegalArgumentException(String.format("UUID '%s' nicht gefunden", uuid)));
    }
}

package de.gothaer.glsla.oniondemo.domain.services.internal;

import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsErgebnisEntity;
import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsVorgabeEntity;
import de.gothaer.glsla.oniondemo.adapter.persistence.BerechnungsErgebnisRepository;
import de.gothaer.glsla.oniondemo.adapter.persistence.BerechnungsVorgabeRepository;
import de.gothaer.glsla.oniondemo.domain.services.AlterService;
import de.gothaer.glsla.oniondemo.domain.services.BerechnungsRepository;
import de.gothaer.glsla.oniondemo.domain.services.BerechnungsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BerechnungsServiceImpl implements BerechnungsService {


    private final AlterService alterService = new AlterServiceImpl();
    private final BerechnungsRepository repository;
    private static final Integer ANZAHL_RENTENZAHLUNGEN = 20 * 12;


    private Double berechneBeitrag(Integer anzahlRaten, Double wunschrente, Double alterszuschlag) {
        var bedarf = wunschrente * ANZAHL_RENTENZAHLUNGEN;
        return bedarf / anzahlRaten * alterszuschlag;
    }

    @Override
    public BerechnungsErgebnisEntity berechneUndSpeicher(BerechnungsVorgabeEntity vorgabe) {
        var uuid = UUID.randomUUID().toString();
        vorgabe.setUuid(uuid);
        var altersdaten = alterService.berechneAltersdaten(vorgabe.getGeburtsDatum(), vorgabe.getZahlungAb());
        var beitrag = berechneBeitrag(altersdaten.getAnzahlRaten(), vorgabe.getWunschrente(), altersdaten.getAlterszuschlag());
        var ergebnis = BerechnungsErgebnisEntity.builder()
                .uuid(uuid)
                .berechnungsVorgabe(vorgabe)
                .zahlungBis(altersdaten.getZahlungBis())
                .beitrag(beitrag)
                .build();
        repository.save(ergebnis);
        return ergebnis;
    }

    @Override
    public BerechnungsErgebnisEntity findBerechnungsergebnis(String uuid) {
        return repository.findById(uuid).orElseThrow(() -> new IllegalArgumentException(String.format("UUID '%s' nicht gefunden", uuid)));
    }
}

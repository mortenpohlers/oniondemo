package de.gopthaer.glsla.oniondemo.service.internal;

import de.gopthaer.glsla.oniondemo.entity.BerechnungsErgebnisEntity;
import de.gopthaer.glsla.oniondemo.entity.BerechnungsVorgabeEntity;
import de.gopthaer.glsla.oniondemo.repository.BerechnungsErgebnisRepository;
import de.gopthaer.glsla.oniondemo.repository.BerechnungsVorgabeRepository;
import de.gopthaer.glsla.oniondemo.service.AlterService;
import de.gopthaer.glsla.oniondemo.service.BerechnungsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BerechnungsServiceImpl implements BerechnungsService {


    private final AlterService alterService;
    private final BerechnungsErgebnisRepository repository;
    private final BerechnungsVorgabeRepository vorgabeRepository;
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
        vorgabeRepository.save(vorgabe);
        repository.save(ergebnis);
        return ergebnis;
    }

    @Override
    public BerechnungsErgebnisEntity findBerechnungsergebnis(String uuid) {
        return repository.findById(uuid).orElseThrow(() -> new IllegalArgumentException(String.format("UUID '%s' nicht gefunden", uuid)));
    }
}

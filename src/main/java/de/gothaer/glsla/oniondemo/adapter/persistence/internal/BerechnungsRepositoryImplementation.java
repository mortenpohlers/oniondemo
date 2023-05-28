package de.gothaer.glsla.oniondemo.adapter.persistence.internal;

import de.gothaer.glsla.oniondemo.adapter.persistence.mapper.BerechnungsErgebnisEntityMapper;
import de.gothaer.glsla.oniondemo.adapter.persistence.repositories.BerechnungsErgebnisRepository;
import de.gothaer.glsla.oniondemo.adapter.persistence.repositories.BerechnungsVorgabeRepository;
import de.gothaer.glsla.oniondemo.domain.aggregates.BerechnungsErgebnis;
import de.gothaer.glsla.oniondemo.domain.services.BerechnungsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.constant.ConstantDesc;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BerechnungsRepositoryImplementation implements BerechnungsRepository {

    private final BerechnungsErgebnisRepository ergebnisRepository;
    private final BerechnungsVorgabeRepository vorgabeRepository;
    private final BerechnungsErgebnisEntityMapper ergebnisMapper;
    @Override
    public void save(BerechnungsErgebnis ergebnis) {
        var entity = ergebnisMapper.convert(ergebnis);
        vorgabeRepository.save(entity.getBerechnungsVorgabe());
        ergebnisRepository.save(entity);
    }

    @Override
    public Optional<BerechnungsErgebnis> findById(String uuid) {
        return ergebnisRepository.findById(uuid).map(ergebnisMapper::convert);
    }
}

package de.gothaer.glsla.oniondemo.domain.services;

import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsErgebnisEntity;

import java.lang.constant.ConstantDesc;
import java.util.Optional;

public interface BerechnungsRepository {
    void save(BerechnungsErgebnisEntity ergebnis);

    Optional<BerechnungsErgebnisEntity> findById(ConstantDesc uuid);
}

package de.gothaer.glsla.oniondemo.domain.services;


import de.gothaer.glsla.oniondemo.domain.aggregates.BerechnungsErgebnis;

import java.util.Optional;

public interface BerechnungsRepository {
    void save(BerechnungsErgebnis ergebnis);

    Optional<BerechnungsErgebnis> findById(String uuid);
}

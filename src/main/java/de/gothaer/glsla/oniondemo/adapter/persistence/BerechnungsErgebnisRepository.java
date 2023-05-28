package de.gothaer.glsla.oniondemo.adapter.persistence;

import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsErgebnisEntity;
import org.springframework.data.repository.CrudRepository;

public interface BerechnungsErgebnisRepository extends CrudRepository<BerechnungsErgebnisEntity, String> {
}

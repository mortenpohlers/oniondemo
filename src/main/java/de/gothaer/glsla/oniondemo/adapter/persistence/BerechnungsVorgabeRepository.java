package de.gothaer.glsla.oniondemo.adapter.persistence;

import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsVorgabeEntity;
import org.springframework.data.repository.CrudRepository;

public interface BerechnungsVorgabeRepository extends CrudRepository<BerechnungsVorgabeEntity,String> {
}

package de.gothaer.glsla.oniondemo.adapter.persistence.mapper;

import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsErgebnisEntity;
import de.gothaer.glsla.oniondemo.domain.aggregates.BerechnungsErgebnis;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses= BerechnungsVorgabeEntityMapper.class)
public interface BerechnungsErgebnisEntityMapper {

    BerechnungsErgebnisEntity convert(BerechnungsErgebnis domain);

    BerechnungsErgebnis convert(BerechnungsErgebnisEntity entity);
}

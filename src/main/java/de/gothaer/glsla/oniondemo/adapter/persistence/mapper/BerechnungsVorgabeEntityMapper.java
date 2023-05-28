package de.gothaer.glsla.oniondemo.adapter.persistence.mapper;

import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsVorgabeEntity;
import de.gothaer.glsla.oniondemo.domain.aggregates.BerechnungsVorgabe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BerechnungsVorgabeEntityMapper {

    BerechnungsVorgabeEntity convert(BerechnungsVorgabe domain);

    BerechnungsVorgabe convert(BerechnungsVorgabeEntity entity);
}

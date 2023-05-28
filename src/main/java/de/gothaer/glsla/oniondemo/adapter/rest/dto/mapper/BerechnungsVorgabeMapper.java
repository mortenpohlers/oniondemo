package de.gothaer.glsla.oniondemo.adapter.rest.dto.mapper;

import de.gothaer.glsla.oniondemo.adapter.rest.dto.BerechnungsVorgabeDto;
import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsVorgabeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BerechnungsVorgabeMapper {

    BerechnungsVorgabeDto convert(BerechnungsVorgabeEntity entity);

    BerechnungsVorgabeEntity convert(BerechnungsVorgabeDto dto);
}

package de.gopthaer.glsla.oniondemo.dto.mapper;

import de.gopthaer.glsla.oniondemo.dto.BerechnungsVorgabeDto;
import de.gopthaer.glsla.oniondemo.entity.BerechnungsVorgabeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BerechnungsVorgabeMapper {

    BerechnungsVorgabeDto convert(BerechnungsVorgabeEntity entity);

    BerechnungsVorgabeEntity convert(BerechnungsVorgabeDto dto);
}

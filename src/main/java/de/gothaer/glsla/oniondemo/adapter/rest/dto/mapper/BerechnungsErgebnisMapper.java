package de.gothaer.glsla.oniondemo.adapter.rest.dto.mapper;

import de.gothaer.glsla.oniondemo.adapter.rest.dto.BerechnungsErgebnisDto;
import de.gothaer.glsla.oniondemo.adapter.persistence.entity.BerechnungsErgebnisEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses=BerechnungsVorgabeMapper.class)
public interface BerechnungsErgebnisMapper {

    BerechnungsErgebnisDto convert(BerechnungsErgebnisEntity entity);

    BerechnungsErgebnisEntity convert(BerechnungsErgebnisDto dto);
}

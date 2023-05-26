package de.gopthaer.glsla.oniondemo.dto.mapper;

import de.gopthaer.glsla.oniondemo.dto.BerechnungsErgebnisDto;
import de.gopthaer.glsla.oniondemo.entity.BerechnungsErgebnisEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses=BerechnungsVorgabeMapper.class)
public interface BerechnungsErgebnisMapper {

    BerechnungsErgebnisDto convert(BerechnungsErgebnisEntity entity);

    BerechnungsErgebnisEntity convert(BerechnungsErgebnisDto dto);
}

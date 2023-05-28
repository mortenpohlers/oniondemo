package de.gothaer.glsla.oniondemo.adapter.rest.dto.mapper;

import de.gothaer.glsla.oniondemo.adapter.rest.dto.BerechnungsVorgabeDto;
import de.gothaer.glsla.oniondemo.domain.aggregates.BerechnungsVorgabe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BerechnungsVorgabeDtoMapper {

    BerechnungsVorgabeDto convert(BerechnungsVorgabe domain);

    BerechnungsVorgabe convert(BerechnungsVorgabeDto dto);
}

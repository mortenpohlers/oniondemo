package de.gothaer.glsla.oniondemo.adapter.rest.dto.mapper;

import de.gothaer.glsla.oniondemo.adapter.rest.dto.BerechnungsErgebnisDto;
import de.gothaer.glsla.oniondemo.domain.aggregates.BerechnungsErgebnis;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses= BerechnungsVorgabeDtoMapper.class)
public interface BerechnungsErgebnisDtoMapper {

    BerechnungsErgebnisDto convert(BerechnungsErgebnis domain);

    BerechnungsErgebnis convert(BerechnungsErgebnisDto dto);
}

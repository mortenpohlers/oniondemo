package de.gothaer.glsla.oniondemo.domain.aggregates;


import de.gothaer.glsla.oniondemo.domain.aggregates.alter.Altersdaten;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE) @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BerechnungsErgebnis {
    private String uuid;
    @Getter(AccessLevel.PACKAGE)
    private Altersdaten altersdaten;
    private BerechnungsVorgabe berechnungsVorgabe;
    private Double beitrag;
    private LocalDate zahlungBis;
}

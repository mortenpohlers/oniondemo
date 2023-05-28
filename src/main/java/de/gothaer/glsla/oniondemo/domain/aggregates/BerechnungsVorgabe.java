package de.gothaer.glsla.oniondemo.domain.aggregates;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class BerechnungsVorgabe {
    private String uuid;
    private LocalDate geburtsDatum;
    private LocalDate zahlungAb;
    private Double wunschrente;
}

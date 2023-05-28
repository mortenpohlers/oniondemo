package de.gopthaer.glsla.oniondemo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class BerechnungsErgebnisEntity {
    @Id
    private String uuid;
    @OneToOne
    private BerechnungsVorgabeEntity berechnungsVorgabe;
    private Double beitrag;
    private LocalDate zahlungBis;
}

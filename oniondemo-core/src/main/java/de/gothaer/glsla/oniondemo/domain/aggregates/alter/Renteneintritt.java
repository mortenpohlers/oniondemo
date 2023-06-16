package de.gothaer.glsla.oniondemo.domain.aggregates.alter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Renteneintritt {
    O(1800, 65),
    I(1970, 67),
    II(2000, 75);

    final Integer jahrgang;
    final Integer eintrittsalter;
}

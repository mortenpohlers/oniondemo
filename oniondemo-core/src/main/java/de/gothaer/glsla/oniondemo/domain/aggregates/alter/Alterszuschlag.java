package de.gothaer.glsla.oniondemo.domain.aggregates.alter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Alterszuschlag {
    I(40, 1.2),
    II(50, 1.5),
    III(60, 2.0),
    O(0, 1.0);
    final Integer alter;
    final Double value;

}

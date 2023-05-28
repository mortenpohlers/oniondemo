package de.gothaer.glsla.oniondemo.domain.aggregates.alter;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE) @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Altersdaten {
    private Double alterszuschlag;
    private LocalDate zahlungBis;
    private Integer anzahlRaten;


    private static Double berechneAltersZuschlag(LocalDate geburtsdatum, LocalDate beginn) {
        var alterZuBeginn = Period.between(geburtsdatum, beginn).getYears();
        if (alterZuBeginn >= Alterszuschlag.III.alter) {
            return Alterszuschlag.III.value;
        } else if (alterZuBeginn >= Alterszuschlag.II.alter) {
            return Alterszuschlag.II.value;
        } else if (alterZuBeginn >= Alterszuschlag.I.alter) {
            return Alterszuschlag.I.value;
        } else if (alterZuBeginn >= Alterszuschlag.O.alter) {
            return Alterszuschlag.O.value;
        }
        return Alterszuschlag.O.value;

    }

    private static LocalDate berechneRentenEintritt(LocalDate geburtsdatum) {
        var jahrgang = geburtsdatum.getYear();
        var eintrittsalter = Renteneintritt.O.eintrittsalter;
        if(jahrgang >= Renteneintritt.II.jahrgang){
            eintrittsalter =Renteneintritt.II.eintrittsalter;
        }else if(jahrgang >= Renteneintritt.I.jahrgang){
            eintrittsalter= Renteneintritt.I.eintrittsalter;
        }
        return LocalDate.of(jahrgang+eintrittsalter,geburtsdatum.getMonth(),1);

    }

    private static int berechneAnzahlRaten(LocalDate beginn, LocalDate rentenEintritt){
        return (int) ChronoUnit.MONTHS.between(beginn,rentenEintritt);
    }

    public static Altersdaten ofGeburtsdatumUndBeginn(LocalDate geburtsdatum, LocalDate beginn){
        var renteneintritt = berechneRentenEintritt(geburtsdatum);
        return Altersdaten.builder()
                .alterszuschlag(berechneAltersZuschlag(geburtsdatum, beginn))
                .zahlungBis(renteneintritt)
                .anzahlRaten(berechneAnzahlRaten(beginn,renteneintritt))
                .build();
    }
}

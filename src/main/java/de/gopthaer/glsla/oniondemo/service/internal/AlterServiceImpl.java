package de.gopthaer.glsla.oniondemo.service.internal;

import de.gopthaer.glsla.oniondemo.service.AlterService;
import de.gopthaer.glsla.oniondemo.service.Altersdaten;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Service
public class AlterServiceImpl implements AlterService {

    @AllArgsConstructor
    private enum Alterszuschlag {
        I(40, 1.2),
        II(50, 1.5),
        III(60, 2.0),
        O(0, 1.0);
        Integer alter;
        Double value;

    }

    @AllArgsConstructor
    private enum Renteneintritt {
        O(1800, 65),
        I(1970, 67),
        II(2000, 75);

        Integer jahrgang;
        Integer eintrittsalter;
    }


    private Double berechneAltersZuschlag(LocalDate geburtsdatum, LocalDate beginn) {
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

    private LocalDate berechneRentenEintritt(LocalDate geburtsdatum) {
        var jahrgang = geburtsdatum.getYear();
        var eintrittsalter = Renteneintritt.O.eintrittsalter;
        if(jahrgang >= Renteneintritt.II.jahrgang){
            eintrittsalter =Renteneintritt.II.eintrittsalter;
        }else if(jahrgang >= Renteneintritt.I.jahrgang){
            eintrittsalter= Renteneintritt.I.eintrittsalter;
        }
        return LocalDate.of(jahrgang+eintrittsalter,geburtsdatum.getMonth(),1);

    }

    private int berechneAnzahlRaten(LocalDate beginn, LocalDate rentenEintritt){
        return (int)ChronoUnit.MONTHS.between(beginn,rentenEintritt);
    }
    @Override
    public Altersdaten berechneAltersdaten(LocalDate geburtsdatum, LocalDate beginn) {
        var renteneintritt = berechneRentenEintritt(geburtsdatum);
        return Altersdaten.builder()
                .alterszuschlag(berechneAltersZuschlag(geburtsdatum, beginn))
                .zahlungBis(renteneintritt)
                .anzahlRaten(berechneAnzahlRaten(beginn,renteneintritt))
                .build();
    }
}

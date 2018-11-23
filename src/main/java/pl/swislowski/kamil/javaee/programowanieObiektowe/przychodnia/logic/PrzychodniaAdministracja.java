package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.logic;

import pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrzychodniaAdministracja {

    private Przychodnia przychodnia;

    private Map<String, Pacjent> spisPacjentow = new HashMap<>();

    public PrzychodniaAdministracja(Przychodnia przychodnia) {
        this.przychodnia = przychodnia;
    }

    public void rejestrujPacjenta(Pacjent pacjent) {
        System.out.println("\n## Rejestruję pacjenta " + pacjent);
        this.spisPacjentow.put(pacjent.getPesel(), pacjent);
    }

    public void rejestrujLekarza(Lekarz lekarz) {
        System.out.println("\n## Rejestruję lekarza " + lekarz);
        this.przychodnia.getSpisLekarzy().put(lekarz.getPesel(), lekarz);
    }

    public void dodajTerminDoGrafiku(Termin nowyTermin) {
        System.out.println("\n## Dodaję termin do grafiku " + nowyTermin);
        this.przychodnia.getGrafik().getTerminy().add(nowyTermin);
    }

    public void usunTerminZGrafiku(Termin termin) {
        System.out.println("\n## Usuwam termin z grafiku " + termin);
        // Termin można zarezerwować dla pacjenta lub usunąć gdy nie ma rezerwacji.
        if (termin.getPacjent() == null) {
            this.przychodnia.getGrafik().getTerminy().remove(termin);
        } else {
            System.out.println("Usunięcie terminu z grafiku nie jest możliwe, ponieważ jest przypisany do niego pacjent "
                    + termin + " " + termin.getPacjent());
        }
    }

    public void historiaTerminow(Grafik grafik) {
        System.out.println();
        System.out.println("HISTORIA TERMINÓW");

        List<Termin> terminy = grafik.getTerminy();

        boolean jestHistoriaTerminow = false;
        for (Termin termin : terminy) {
            if (termin.getStatusTerminu() == StatusTerminu.WYKONANY) {
                System.out.println("Termin wykonany: " + termin);
                jestHistoriaTerminow = true;
                // Rozważyć zwrócenie nowej listy zawierającej tylko wykonane statusy.
            }
        }

        if (!jestHistoriaTerminow) {
            System.out.println("Brak historii terminów.");
        }
    }

    public void oznaczTerminJakoWykonany(Termin termin) {
        System.out.println("\n## Oznaczam termin jako wykonany " + termin);
        if (!(termin.getStatusTerminu() == StatusTerminu.WOLNY)) {
//            if (termin.getStatusTerminu() == StatusTerminu.ZAREZERWOWANY)
            termin.setStatusTerminu(StatusTerminu.WYKONANY);
        } else {
            System.out.printf("Nie można oznaczyć terminu %s jako %s, ponieważ jest on %s.%n",
                    termin, StatusTerminu.WYKONANY, termin.getStatusTerminu());
        }
    }

    public void przegladajGrafik() {
        System.out.println();
        System.out.println("GRAFIK");
        List<Termin> terminy = this.przychodnia.getGrafik().getTerminy();
        int licznik = 0;
        for (Termin termin : terminy) {
//            if (licznik < 10) {
                System.out.println(termin);
//            }
            licznik++;
        }
    }

    public void przegladajSpisLekarzy() {
        System.out.println();
        System.out.println("SPIS LEKARZY");
        for (Lekarz lekarz : this.przychodnia.getSpisLekarzy().values()) {
            System.out.println(lekarz);
        }
    }

    public void przegladajSpisPacjentow() {
        System.out.println();
        System.out.println("SPIS PACJENTÓW");
        for (Pacjent pacjent : this.spisPacjentow.values()) {
            System.out.println(pacjent);
        }
    }

    public Grafik wypelnijGrafikTerminami(long dlugoscTerminuMinuty, long liczbaDni) {
        Grafik grafik = new Grafik();

        long iloscMinutWDniu = 1440;
        long iloscTerminow = (iloscMinutWDniu / dlugoscTerminuMinuty) * liczbaDni;

        LocalDateTime teraz = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
        while (iloscTerminow > 0) {
            for (Lekarz lekarz : this.przychodnia.getSpisLekarzy().values()) {
                teraz = teraz.plusMinutes(dlugoscTerminuMinuty);
                grafik.getTerminy().add(new Termin(lekarz, teraz));
                iloscTerminow--;
            }
        }

        System.out.println("#### GRAFIK " +  grafik.getTerminy().size());
        return grafik;
    }
}

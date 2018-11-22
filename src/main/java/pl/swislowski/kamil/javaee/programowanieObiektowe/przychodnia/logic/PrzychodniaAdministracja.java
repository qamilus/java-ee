package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.logic;

import pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data.*;

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
        this.spisPacjentow.put(pacjent.getPesel(), pacjent);
    }

    public void rejestrujLekarza(Lekarz lekarz) {
        this.przychodnia.getSpisLekarzy().put(lekarz.getPesel(), lekarz);
    }

    public void dodajTerminDoGrafiku(Termin nowyTermin) {
        this.przychodnia.getGrafik().getTerminy().add(nowyTermin);
    }

    public void usunTerminZGrafiku(Termin termin) {
        // Termin można zarezerwować dla pacjenta lub usunąć gdy nie ma rezerwacji.
        if (termin.getPacjent() == null) {
            this.przychodnia.getGrafik().getTerminy().remove(termin);
        } else {
            System.out.println("Usunięcie terminu " + termin +
                    " z grafiku nie jest możliwe, ponieważ jest przypisany do niego pacjent " + termin.getPacjent() + ".");
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
                // Rozważycć zwrócenie nowej listy zawierającej tylko wykonane statusy.
            }
        }

        if (!jestHistoriaTerminow) {
            System.out.println("Brak historii terminów.");
        }
    }

    public void oznaczTerminJakoWykonany(Termin termin) {
        if (!(termin.getStatusTerminu() == StatusTerminu.WOLNY)) {
//            if (termin.getStatusTerminu() == StatusTerminu.ZAREZERWOWANY)
            termin.setStatusTerminu(StatusTerminu.WYKONANY);
        } else {
            System.out.printf("Nie można oznaczyć terminu %s jako %s, ponieważ jest on %s.%n",
                    termin ,StatusTerminu.WYKONANY, termin.getStatusTerminu());
        }
    }

    public void przegladajGrafik() {
        System.out.println();
        System.out.println("GRAFIK");
        List<Termin> terminy = this.przychodnia.getGrafik().getTerminy();
        for (Termin termin : terminy) {
            System.out.println(termin);
        }
    }

    public void przegladajSpisLekarzy() {
        System.out.println();
        System.out.println("SPIS LEKARZY");
        for (Map.Entry<String, Lekarz> lekarz : this.przychodnia.getSpisLekarzy().entrySet()) {
            System.out.println(lekarz.getValue());
        }
    }

    public void przegladajSpisPacjentow() {
        System.out.println();
        System.out.println("SPIS PACJENTÓW");
        for (Map.Entry<String, Pacjent> pacjent : this.spisPacjentow.entrySet()) {
            System.out.println(pacjent.getValue());
        }
    }
}

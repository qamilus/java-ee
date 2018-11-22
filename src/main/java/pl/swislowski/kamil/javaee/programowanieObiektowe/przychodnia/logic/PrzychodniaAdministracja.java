package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.logic;

import pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrzychodniaAdministracja {

    private Przychodnia przychodnia;

//    private Grafik grafik = new Grafik();
    private Map<String, Pacjent> spisPacjentow = new HashMap<>();
//    private Map<String, Lekarz> spisLekarzy = new HashMap<>();

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
        if (termin.getPacjent() == null) {
            this.przychodnia.getGrafik().getTerminy().remove(termin);
        } else {
            System.out.println("Usunięcie terminu " + termin +
                    " z grafiku nie jest możliwe, ponieważ jest przypisany do niego pacjent " + termin.getPacjent() + ".");
        }
    }

    public void historiaTerminow(Grafik grafik) {
        List<Termin> terminy = grafik.getTerminy();
        for (Termin termin : terminy) {
            if (termin.getStatusTerminu() == StatusTerminu.WYKONANY) {
                System.out.println("Termin wykonany: " + termin);
                //TODO: Rozważycć zwrócenie nowej listy zawierającej tylko wykonane statusy.
            }
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

package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.logic;

import pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrzychodniaPacjent {

    private Przychodnia przychodnia;

    public PrzychodniaPacjent(Przychodnia przychodnia) {
        this.przychodnia = przychodnia;
    }

    public Termin wyszukajTermin(LocalDateTime wyszukiwanaDataGodzina) {
        for (Termin termin : this.przychodnia.getGrafik().getTerminy()) {
            LocalDateTime dataGodzina = termin.getDataGodzina();
            if (wyszukiwanaDataGodzina.isEqual(dataGodzina)) {
                return termin;
            }
        }
        return null;
    }

    /**
     * Metoda wyszukująca może wyszukiwać tylko po jednym parametrze w danym momencie(takie zostało przyjęte założenie.),
     * pozostałe parametry po których nie wyszukujemy ustawiamy na null.
     *
     * @param szukaneImie
     * @param szukaneNazwisko
     * @param szukanyPesel
     * @param szukanaSpecjalnosc
     * @return
     */

    public List<Lekarz> wyszukajLekarza(String szukaneImie, String szukaneNazwisko,
                                        String szukanyPesel, Specjalnosc szukanaSpecjalnosc) {
        List<Lekarz> wyszukaniLekarze = new ArrayList<>();

        for (Map.Entry<String, Lekarz> mapEntry : this.przychodnia.getSpisLekarzy().entrySet()) {
            Lekarz lekarz = mapEntry.getValue();
            // TODO: Dokończyć pozostałe wyszukiwania po innych parametrach.
            if (szukaneImie != null) {
                if (szukaneImie.equalsIgnoreCase(lekarz.getImie())) {
                    wyszukaniLekarze.add(lekarz);
                }
            } else if (szukaneNazwisko != null) {
                if (szukaneNazwisko.equalsIgnoreCase(lekarz.getNazwisko())) {
                    wyszukaniLekarze.add(lekarz);
                }
            } else if (szukanyPesel != null) {
                if (szukanyPesel.equals(lekarz.getPesel())) {
                    wyszukaniLekarze.add(lekarz);
                }
            } else if (szukanaSpecjalnosc != null) {
                if (szukanaSpecjalnosc.equals(lekarz.getSpecjalnosc())) {
                    wyszukaniLekarze.add(lekarz);
                }
            }
        }
        return wyszukaniLekarze;
    }

    public List<Termin> wyszukajSpecjalnosc(Specjalnosc specjalnosc) {
        //TODO: Po wyborze specjalności (i opcjonalnie daty) dostaje listę 5 najbliższych wolnych terminów (nawet jeśli są za rok).
        return new ArrayList<>(5);
    }

    public void rezerwujTermin(Termin termin, Pacjent pacjent) {
        //TODO: Termin można zarezerwować dla pacjenta lub usunąć gdy nie ma rezerwacji.
        termin.setPacjent(pacjent);
        termin.setStatusTerminu(StatusTerminu.ZAREZERWOWANY);
    }

    public void przeniesTermin(Termin staryTermin, LocalDateTime nowaDataGodzina) {
        Termin nowyTermin = wyszukajTermin(nowaDataGodzina);
        if (nowyTermin != null) {
            rezerwujTermin(nowyTermin, staryTermin.getPacjent());
//            nowyTermin.setPacjent(staryTermin.getPacjent());
//            nowyTermin.setStatusTerminu(StatusTerminu.ZAREZERWOWANY);

            odwolajTermin(staryTermin);
            System.out.println("Przeniesiono na nowy termin " + nowyTermin);
        } else {
            System.out.println("Nie można przenieść terminu " + staryTermin + " na nowy termin,  bo nie ma takiego wolnego terminu.");
        }
    }

    public void odwolajTermin(Termin termin) {
        termin.setPacjent(null);
        termin.setStatusTerminu(StatusTerminu.WOLNY);
    }

}

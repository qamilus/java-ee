package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.logic;

import pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PrzychodniaPacjent {

    private Przychodnia przychodnia;

    public PrzychodniaPacjent(Przychodnia przychodnia) {
        this.przychodnia = przychodnia;
    }

    public Termin wyszukajTermin(LocalDateTime wyszukiwanaDataGodzina) {
        System.out.println("\n## Wyszukuję termin " + wyszukiwanaDataGodzina);
        for (Termin termin : this.przychodnia.getGrafik().getTerminy()) {
            LocalDateTime dataGodzina = termin.getDataGodzina();
            if (wyszukiwanaDataGodzina.isEqual(dataGodzina)) {
                System.out.println("Wyszukany termin " + termin);
                return termin;
            }
        }

        System.out.println("Wyszukiwany termin nie został odnaleziony. ");
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
        System.out.println("\n## Wyszukuję lekarza ");
        System.out.print(" szukane imię: " + szukaneImie);
        System.out.print(" szukane nazwisko: " + szukaneNazwisko);
        System.out.print(" szukany pesel: " + szukanyPesel);
        System.out.print(" szukana specjalność: " + szukanaSpecjalnosc);
        List<Lekarz> wyszukaniLekarze = new ArrayList<>();

        for (Lekarz lekarz : this.przychodnia.getSpisLekarzy().values()) {
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
                // Sprawdzić po elastycznej liście specjalności, nie tylko po głównej.
                for (Specjalnosc specjalnosc : lekarz.getSpecjalnosci()) {
                    if (szukanaSpecjalnosc.equals(specjalnosc)) {
                        wyszukaniLekarze.add(lekarz);
                    }
                }
            }
        }

        System.out.println("Wyszukani lekarze " + wyszukaniLekarze);
        return wyszukaniLekarze;
    }

    public List<Termin> wyszukajSpecjalnosc(Specjalnosc szukanaSpecjalnosc) {
        // Po wyborze specjalności (i opcjonalnie daty) dostaje listę 5 najbliższych wolnych terminów (nawet jeśli są za rok).
        System.out.println("\n## Wyszukuję specjalność " + szukanaSpecjalnosc);
        List<Termin> wyszukaneTerminy = new ArrayList<>();
        int licznik = 0;
        int maxLiczbaTerminow = 5;

        for (Termin termin : this.przychodnia.getGrafik().getTerminy()) {
            Lekarz lekarz = termin.getLekarz();

            if (termin.getStatusTerminu() == StatusTerminu.WOLNY) {
                // Sprawdzić po elastycznej liście specjalności, nie tylko po głównej.
                for (Specjalnosc specjalnosc : lekarz.getSpecjalnosci()) {
                    if (szukanaSpecjalnosc.equals(specjalnosc)) {
                        if (licznik < maxLiczbaTerminow) {
                            wyszukaneTerminy.add(termin);
                            licznik++;
                        }
                    }
                }
            }
        }

        System.out.printf("Dostępne terminy dla wybranej specjalności %s -> %s%n", szukanaSpecjalnosc, wyszukaneTerminy);
        return wyszukaneTerminy;
    }

    public void rezerwujTermin(Termin termin, Pacjent pacjent) {
        System.out.println("\n## Rezerwuję termin dla pacjenta " + termin + " " + pacjent);
        if (termin.getStatusTerminu() == StatusTerminu.WOLNY) {
            termin.setPacjent(pacjent);
            termin.setStatusTerminu(StatusTerminu.ZAREZERWOWANY);
        } else {
            System.out.println("Nie udało się zarezerwować terminu.");
        }
    }

    public void przeniesTermin(Termin staryTermin, LocalDateTime nowaDataGodzina) {
        System.out.println("\n## Przenoszę termin dla pacjenta z " + staryTermin + " na " + nowaDataGodzina);
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
        System.out.println("\n## Odwołuję termin " + termin);
        if (termin.getStatusTerminu() == StatusTerminu.ZAREZERWOWANY) {
            termin.setPacjent(null);
            termin.setStatusTerminu(StatusTerminu.WOLNY);
        } else {
            System.out.println("Nie udało się odwołać terminu.");
        }
    }

}

package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia;

import pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data.*;
import pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.logic.PrzychodniaAdministracja;
import pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.logic.PrzychodniaPacjent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {

        Przychodnia przychodnia = new Przychodnia();
        PrzychodniaAdministracja administracja = new PrzychodniaAdministracja(przychodnia);
        PrzychodniaPacjent obslugaPacjenta = new PrzychodniaPacjent(przychodnia);

        Lekarz janKowalskiLekarz = new Lekarz("Jan", "Kowalski", "01234567890", Specjalnosc.INTERNISTA);
        Lekarz janNowakLekarz = new Lekarz("Jan", "Kowalski", "01234567891", Specjalnosc.INTERNISTA);
        Lekarz janMajewskiLekarz = new Lekarz("Jan", "Kowalski", "01234567892", Specjalnosc.INTERNISTA);
        Lekarz jacekMajewskiLekarz = new Lekarz("Jacek", "Kowalski", "01234567893", Specjalnosc.INTERNISTA);

        Pacjent stefanRadomskiPacjent = new Pacjent("Stefan", "Radomski", "11234567890");

        Termin naDzisTermin = new Termin(janKowalskiLekarz, LocalDateTime.now());
        Termin naJutroTermin = new Termin(janKowalskiLekarz,
                LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 21),
                        LocalTime.of(13, 30)));
        Termin naZaTydzienTermin = new Termin(janKowalskiLekarz,
                LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 27),
                        LocalTime.of(15, 30)));
        Termin naZaDwaDniTermin = new Termin(janKowalskiLekarz,
                LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 22),
                        LocalTime.of(14, 30)));


        administracja.rejestrujLekarza(janKowalskiLekarz);
        administracja.rejestrujLekarza(janNowakLekarz);
        administracja.rejestrujLekarza(janMajewskiLekarz);
        administracja.rejestrujLekarza(jacekMajewskiLekarz);
        administracja.przegladajSpisLekarzy();

        administracja.rejestrujPacjenta(stefanRadomskiPacjent);
        administracja.przegladajSpisPacjentow();

        administracja.dodajTerminDoGrafiku(naDzisTermin);
        administracja.dodajTerminDoGrafiku(naJutroTermin);
        administracja.dodajTerminDoGrafiku(naZaTydzienTermin);
        administracja.dodajTerminDoGrafiku(naZaDwaDniTermin);
        administracja.przegladajGrafik();

        obslugaPacjenta.rezerwujTermin(naZaTydzienTermin, stefanRadomskiPacjent);
        obslugaPacjenta.rezerwujTermin(naDzisTermin, stefanRadomskiPacjent);
        administracja.przegladajGrafik();

        administracja.usunTerminZGrafiku(naDzisTermin);
        administracja.przegladajGrafik();

        obslugaPacjenta.odwolajTermin(naDzisTermin);
        administracja.przegladajGrafik();

        obslugaPacjenta.przeniesTermin(naDzisTermin, LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 22),
                LocalTime.of(14, 30)));
        administracja.przegladajGrafik();

        Termin wyszukanyTermin = obslugaPacjenta.wyszukajTermin(LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 22),
                LocalTime.of(14, 30)));
        System.out.println("Znaleziono termin: " + wyszukanyTermin);

        administracja.przegladajSpisLekarzy();
        List<Lekarz> wyszukaniLekarze = obslugaPacjenta.wyszukajLekarza("Jan", null, null, Specjalnosc.INTERNISTA);
        System.out.println(wyszukaniLekarze);
        System.out.println(wyszukaniLekarze.size());

        List<Lekarz> wyszukaniLekarze2 = obslugaPacjenta.wyszukajLekarza(null, null, "01234567891", null);
        System.out.println(wyszukaniLekarze2);

        administracja.oznaczTerminJakoWykonany(naDzisTermin);
        administracja.historiaTerminow(przychodnia.getGrafik());

        administracja.oznaczTerminJakoWykonany(naZaTydzienTermin);
        administracja.historiaTerminow(przychodnia.getGrafik());

        obslugaPacjenta.wyszukajSpecjalnosc(Specjalnosc.INTERNISTA);
    }
}

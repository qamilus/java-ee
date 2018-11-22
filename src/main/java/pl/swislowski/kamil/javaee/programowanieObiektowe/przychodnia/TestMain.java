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

        Lekarz janKowalskiLekarz = new Lekarz("Jan", "Kowalski", "01234567890", Specjalnosc.GINEKOLOG);
        Lekarz tomaszGadomskikLekarz = new Lekarz("Tomasz", "Gadomski", "01234567891", Specjalnosc.PEDIATRA);
        Lekarz pawelZagumnyLekarz = new Lekarz("Pawel", "Zagumny", "01234567892", Specjalnosc.NEUROLOG);
        Lekarz jacekMajewskiLekarz = new Lekarz("Jacek", "Majewski", "01234567893", Specjalnosc.INTERNISTA);
        Lekarz maciejKielakLekarz = new Lekarz("Maciej", "Kielak", "01234567894", Specjalnosc.KARDIOLOG);
        Lekarz rafalWroclawskiLekarz = new Lekarz("Rafał", "Wrocławski", "01234567895", Specjalnosc.REUMATOLOG);
        jacekMajewskiLekarz.dodajSpecjalnosc(Specjalnosc.LARYNGOLOG);

        Pacjent stefanRadomskiPacjent = new Pacjent("Stefan", "Radomski", "11234567890");
        Pacjent piotrRuszczykiewiczPacjent = new Pacjent("Piotr", "Ruszczykiewicz", "11234567891");
        Pacjent zenonGoldaPacjent = new Pacjent("Zenon", "Gołda", "11234567892");
        Pacjent jurekMachalicaPacjent = new Pacjent("Jurek", "Machalica", "11234567893");
        Pacjent michałWaligoraPacjent = new Pacjent("Michał", "Waligóra", "11234567894");

        Termin naDzisTermin = new Termin(janKowalskiLekarz, LocalDateTime.now());
        Termin naJutroTermin = new Termin(tomaszGadomskikLekarz,
                LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 21),
                        LocalTime.of(13, 30)));
        Termin naZaTydzienTermin = new Termin(maciejKielakLekarz,
                LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 27),
                        LocalTime.of(15, 30)));
        Termin naZaDwaDniTermin = new Termin(jacekMajewskiLekarz,
                LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 22),
                        LocalTime.of(14, 30)));
        Termin naZaDwaTygodnieTermin = new Termin(rafalWroclawskiLekarz,
                LocalDateTime.of(LocalDate.of(2018, Month.DECEMBER, 6),
                        LocalTime.of(14, 30)));


        administracja.rejestrujLekarza(janKowalskiLekarz);
        administracja.rejestrujLekarza(tomaszGadomskikLekarz);
        administracja.rejestrujLekarza(pawelZagumnyLekarz);
        administracja.rejestrujLekarza(jacekMajewskiLekarz);
        administracja.rejestrujLekarza(maciejKielakLekarz);
        administracja.rejestrujLekarza(rafalWroclawskiLekarz);
        administracja.przegladajSpisLekarzy();

        administracja.rejestrujPacjenta(stefanRadomskiPacjent);
        administracja.rejestrujPacjenta(piotrRuszczykiewiczPacjent);
        administracja.rejestrujPacjenta(zenonGoldaPacjent);
        administracja.rejestrujPacjenta(jurekMachalicaPacjent);
        administracja.rejestrujPacjenta(michałWaligoraPacjent);
        administracja.przegladajSpisPacjentow();

        administracja.dodajTerminDoGrafiku(naDzisTermin);
        administracja.dodajTerminDoGrafiku(naJutroTermin);
        administracja.dodajTerminDoGrafiku(naZaTydzienTermin);
        administracja.dodajTerminDoGrafiku(naZaDwaDniTermin);
        administracja.dodajTerminDoGrafiku(naZaDwaTygodnieTermin);
        administracja.przegladajGrafik();

        obslugaPacjenta.rezerwujTermin(naZaTydzienTermin, stefanRadomskiPacjent);
        obslugaPacjenta.rezerwujTermin(naDzisTermin, stefanRadomskiPacjent);
        obslugaPacjenta.rezerwujTermin(naJutroTermin, michałWaligoraPacjent);
        obslugaPacjenta.rezerwujTermin(naZaDwaTygodnieTermin, piotrRuszczykiewiczPacjent);
        obslugaPacjenta.rezerwujTermin(naZaDwaDniTermin, zenonGoldaPacjent);
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

        obslugaPacjenta.wyszukajSpecjalnosc(Specjalnosc.GINEKOLOG);
    }
}

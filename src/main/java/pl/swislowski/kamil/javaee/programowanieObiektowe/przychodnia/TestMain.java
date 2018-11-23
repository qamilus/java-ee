package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia;

import pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data.*;
import pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.logic.PrzychodniaAdministracja;
import pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.logic.PrzychodniaPacjent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
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

        LocalDateTime teraz = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
        Termin naDzisTermin = new Termin(janKowalskiLekarz, teraz);

//        Termin naDzis1630Termin = new Termin(tomaszGadomskikLekarz, LocalDateTime.now().withHour(16).withMinute(30));
//        Termin naJutroTermin = new Termin(tomaszGadomskikLekarz, teraz.plusDays(1).withHour(14).withMinute(30));
//        Termin naJutroTermin = new Termin(tomaszGadomskikLekarz,
//                LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 21),
//                        LocalTime.of(13, 30)));
//        Termin naZaTydzienTermin = new Termin(maciejKielakLekarz,
//                LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 27),
//                        LocalTime.of(15, 30)));
//        Termin naZaDwaDniTermin = new Termin(jacekMajewskiLekarz,
//                LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 22),
//                        LocalTime.of(14, 30)));
//        Termin naZaDwaTygodnieTermin = new Termin(rafalWroclawskiLekarz,
//                LocalDateTime.of(LocalDate.of(2018, Month.DECEMBER, 6),
//                        LocalTime.of(14, 30)));

        administracja.rejestrujLekarza(janKowalskiLekarz);
        administracja.rejestrujLekarza(tomaszGadomskikLekarz);
        administracja.rejestrujLekarza(pawelZagumnyLekarz);
        administracja.rejestrujLekarza(jacekMajewskiLekarz);
        administracja.rejestrujLekarza(maciejKielakLekarz);
        administracja.rejestrujLekarza(rafalWroclawskiLekarz);
        administracja.przegladajSpisLekarzy();

        przychodnia.setGrafik(administracja.wypelnijGrafikTerminami(30, 1));

        administracja.rejestrujPacjenta(stefanRadomskiPacjent);
        administracja.rejestrujPacjenta(piotrRuszczykiewiczPacjent);
        administracja.rejestrujPacjenta(zenonGoldaPacjent);
        administracja.rejestrujPacjenta(jurekMachalicaPacjent);
        administracja.rejestrujPacjenta(michałWaligoraPacjent);
        administracja.przegladajSpisPacjentow();

//        administracja.dodajTerminDoGrafiku(naDzisTermin);
//        administracja.dodajTerminDoGrafiku(naJutroTermin);
//        administracja.dodajTerminDoGrafiku(naZaTydzienTermin);
//        administracja.dodajTerminDoGrafiku(naZaDwaDniTermin);
//        administracja.dodajTerminDoGrafiku(naZaDwaTygodnieTermin);
//        administracja.przegladajGrafik();

//        obslugaPacjenta.rezerwujTermin(naZaTydzienTermin, stefanRadomskiPacjent);
//        obslugaPacjenta.rezerwujTermin(naDzisTermin, stefanRadomskiPacjent);

        // ## REZERWACJA TERMINU - PACJENT
        System.out.println("## REZERWACJA TERMINU - PACJENT");
        Termin wyszukajTermin1 = obslugaPacjenta.wyszukajTermin(
                LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).withHour(16).withMinute(30));
        if (wyszukajTermin1 != null) {
            obslugaPacjenta.rezerwujTermin(wyszukajTermin1, stefanRadomskiPacjent);
        }
        administracja.przegladajGrafik();

        Termin wyszukajTermin4 = obslugaPacjenta.wyszukajTermin(
                LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).withHour(16).withMinute(30));

        // ## ODWOŁANIE TERMINU - PACJENT
        System.out.println("## ODWOŁANIE TERMINU - PACJENT");
        if (wyszukajTermin1 != null) {
            obslugaPacjenta.odwolajTermin(wyszukajTermin1);
        }
        administracja.przegladajGrafik();

        // ## PRZENIESIENIE TERMINU - PACJENT
        System.out.println("## PRZENIESIENIE TERMINU - PACJENT");
        System.out.println("REZERWACJA");
        // 1. REZERWACJA
        Termin wyszukajTermin5 = obslugaPacjenta.wyszukajTermin(
                LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).withHour(18).withMinute(30));
        if (wyszukajTermin5 != null) {
            obslugaPacjenta.rezerwujTermin(wyszukajTermin5, stefanRadomskiPacjent);
        }
        administracja.przegladajGrafik();
        // 2. PRZENIESIENIE
        System.out.println("PRZENIESIENIE");
        obslugaPacjenta.przeniesTermin(wyszukajTermin5,
                LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).withHour(20).withMinute(00));
        administracja.przegladajGrafik();

        // ## OZNACZENIE TERMINU JAKO WYKONANY - PACJENT
        System.out.println("OZNACZENIE TERMINU JAKO WYKONANY");
        Termin wyszukajTermin6 = obslugaPacjenta.wyszukajTermin(
                LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).withHour(20).withMinute(00));
        if (wyszukajTermin6 != null) {
            administracja.oznaczTerminJakoWykonany(wyszukajTermin6);
        }
        administracja.przegladajGrafik();

        // ## ----
        Termin wyszukajTermin2 = obslugaPacjenta.wyszukajTermin(
                LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).plusDays(1).withHour(16).withMinute(30));
        if (wyszukajTermin2 != null) {
            obslugaPacjenta.rezerwujTermin(wyszukajTermin2, stefanRadomskiPacjent);
        }

//        obslugaPacjenta.rezerwujTermin(naJutroTermin, michałWaligoraPacjent);
//        obslugaPacjenta.rezerwujTermin(naZaDwaTygodnieTermin, piotrRuszczykiewiczPacjent);
//        obslugaPacjenta.rezerwujTermin(naZaDwaDniTermin, zenonGoldaPacjent);
        administracja.przegladajGrafik();

        Termin wyszukajTermin3 = obslugaPacjenta.wyszukajTermin(
                LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).withHour(21).withMinute(30));
        if (wyszukajTermin1 != null) {
            administracja.usunTerminZGrafiku(wyszukajTermin3);
        }
        administracja.przegladajGrafik();
//        administracja.przegladajGrafik();

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

//        administracja.oznaczTerminJakoWykonany(naZaTydzienTermin);
        administracja.historiaTerminow(przychodnia.getGrafik());

        obslugaPacjenta.wyszukajSpecjalnosc(Specjalnosc.GINEKOLOG);

//        Grafik wypelnionyGrafik = administracja.wypelnijGrafikTerminami(30, 1);
//
//        for (Termin termin : wypelnionyGrafik.getTerminy()) {
//            System.out.println(termin);
//        }

    }
}

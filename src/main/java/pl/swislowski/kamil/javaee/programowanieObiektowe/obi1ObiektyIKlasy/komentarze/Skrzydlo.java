package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.komentarze;

public class Skrzydlo {
    // Deklaracja pola/atrybutu w klasie z inicjalizacją wartości. Pole czyKluczyk typu boolean.
    // Pole prywatne, może być zmienione tylko za pomocą metod dostępowych.
    private int dlugosc;
    private int wysokosc;
    private Klamka klamka;
    private boolean otwarte = false;

    //Konstruktor argumentowy.
    public Skrzydlo(int dlugosc, int wysokosc) {
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
    }

    //Kolejny konstruktor argumentowy.W ciele konstruktora odwołanie do poprzedniego konstruktora.
    // Większa liczba argumentów niż w poprzednim konstruktorze. Dlatego może istnieć drugi konstruktor argumentowy.
    public Skrzydlo(int dlugosc, int wysokosc, Klamka klamka) {
        this(dlugosc, wysokosc);
        this.klamka = klamka;
    }

    // Metody dostępowe. Wprzypadku pól typu boolean zamiast "get" używamy "is".
    public int getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }

    public Klamka getKlamka() {
        return klamka;
    }

    public void setKlamka(Klamka klamka) {
        this.klamka = klamka;
    }

    public boolean isOtwarte() {
        return otwarte;
    }

    public void setOtwarte(boolean otwarte) {
        this.otwarte = otwarte;
    }

    // Metoda publiczna określająca stan. Zwraca wartość typu String.
    public String stan() {
        String wymiary = dlugosc + "x" + wysokosc;
        String otwarcie = otwarte ? "otwarte" : "zamkniete";
        String stanKlamki = klamka != null ? klamka.stan() : "bez klamki";
        return wymiary + " " + otwarcie + " " + stanKlamki;
    }
}

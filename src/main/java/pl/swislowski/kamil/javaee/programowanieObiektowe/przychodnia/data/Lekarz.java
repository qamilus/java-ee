package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data;

import java.util.ArrayList;
import java.util.List;

public class Lekarz {
    private String imie;
    private String nazwisko;
    private String pesel;

    private Specjalnosc glownaSpecjalnosc;
    // Elastyczna lista specjalizacji.
    private List<Specjalnosc> specjalnosci = new ArrayList<>();

    public Lekarz(String imie, String nazwisko, String pesel, Specjalnosc glownaSpecjalnosc) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.glownaSpecjalnosc = glownaSpecjalnosc;

        this.specjalnosci.add(glownaSpecjalnosc);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Specjalnosc getGlownaSpecjalnosc() {
        return glownaSpecjalnosc;
    }

    public void setGlownaSpecjalnosc(Specjalnosc glownaSpecjalnosc) {
        this.glownaSpecjalnosc = glownaSpecjalnosc;
    }

    public void dodajSpecjalnosc(Specjalnosc specjalnosc) {
        this.specjalnosci.add(specjalnosc);
    }

    public List<Specjalnosc> getSpecjalnosci() {
        return specjalnosci;
    }

    @Override
    public String toString() {
        return "Lekarz{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", glownaSpecjalnosc=" + glownaSpecjalnosc +
                ", specjalnosci=" + specjalnosci +
                '}';
    }
}

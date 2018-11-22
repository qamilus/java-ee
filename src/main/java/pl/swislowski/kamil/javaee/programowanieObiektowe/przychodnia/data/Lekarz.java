package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data;

public class Lekarz {
    private String imie;
    private String nazwisko;
    private String pesel;

    private Specjalnosc specjalnosc;
    //TODO: Elastyczna lista specjalizacji.

    public Lekarz(String imie, String nazwisko, String pesel, Specjalnosc specjalnosc) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.specjalnosc = specjalnosc;
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

    public Specjalnosc getSpecjalnosc() {
        return specjalnosc;
    }

    public void setSpecjalnosc(Specjalnosc specjalnosc) {
        this.specjalnosc = specjalnosc;
    }

    @Override
    public String toString() {
        return "Lekarz{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", specjalnosc=" + specjalnosc +
                '}';
    }
}

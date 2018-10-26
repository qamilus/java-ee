package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.linieLotnicze;

public class Pasazer {
    private String imie;
    private String nazwisko;
    private String numerDowodu;
    private String numerTelefonu;

    private Bilet bilet;

    public Pasazer(String imie, String nazwisko, String numerDowodu, String numerTelefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerDowodu = numerDowodu;
        this.numerTelefonu = numerTelefonu;
    }

    public Pasazer(String imie, String nazwisko, String numerDowodu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerDowodu = numerDowodu;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setBilet(Bilet bilet) {
        this.bilet = bilet;
    }

    @Override
    public String toString() {
        return "Pasazer{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", numerDowodu='" + numerDowodu + '\'' +
                ", numerTelefonu='" + numerTelefonu + '\'' +
                ", bilet=" + bilet +
                '}';
    }
}

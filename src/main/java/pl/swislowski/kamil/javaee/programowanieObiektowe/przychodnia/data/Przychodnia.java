package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data;


import java.util.HashMap;
import java.util.Map;

public class Przychodnia {

    private Grafik grafik = new Grafik();
    private Map<String, Lekarz> spisLekarzy = new HashMap<>();

    private String nazwa;
    private String adres;

    public Grafik getGrafik() {
        return grafik;
    }

    public void setGrafik(Grafik grafik) {
        this.grafik = grafik;
    }

    public Map<String, Lekarz> getSpisLekarzy() {
        return spisLekarzy;
    }

    @Override
    public String toString() {
        return "Przychodnia{" +
                "grafik='" + grafik + '\'' +
                "spisLekarzy='" + spisLekarzy + '\'' +
                "nazwa='" + nazwa + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}

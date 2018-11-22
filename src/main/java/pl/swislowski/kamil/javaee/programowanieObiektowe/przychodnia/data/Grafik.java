package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data;

import java.util.ArrayList;
import java.util.List;

public class Grafik {
    //TODO : Zamienić listę na mapę, gdzie kluczem jest LocalDateTime, a wartość to Termin.
    private List<Termin> terminy = new ArrayList<>();

    public List<Termin> getTerminy() {
        return terminy;
    }

    @Override
    public String toString() {
        return "Grafik{" +
                "terminy=" + terminy +
                '}';
    }
}

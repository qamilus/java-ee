package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafik {
    //TODO : Zamienić listę na mapę, gdzie kluczem jest LocalDateTime, a wartość to Termin.
    private List<Termin> terminy = new ArrayList<>();
    private Map<LocalDateTime, Termin> terminyMap = new HashMap<>();

    public List<Termin> getTerminy() {
        return terminy;
    }

    public Map<LocalDateTime, Termin> getTerminyMap() {
        return terminyMap;
    }

    @Override
    public String toString() {
        return "Grafik{" +
                "terminy=" + terminy +
                "terminyMap=" + terminyMap +
                '}';
    }
}

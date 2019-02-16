package pl.swislowski.kamil.javaee.przejsciowy.model;

import java.util.Comparator;

public class FieldTitleComparator implements Comparator<Painting> {

    @Override
    public int compare(Painting o1, Painting o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}

package pl.swislowski.kamil.javaee.przejsciowy.model;

import java.util.Comparator;

public class FieldAuthorComparator implements Comparator<Painting> {

    @Override
    public int compare(Painting o1, Painting o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}

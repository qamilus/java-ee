package pl.swislowski.kamil.javaee.przejsciowy.model;

import java.util.Comparator;

public class FieldPriceComparator implements Comparator<Painting> {

    @Override
    public int compare(Painting o1, Painting o2) {

        Integer field1 = Integer.parseInt(o1.getPrice());
        Integer field2 = Integer.parseInt(o2.getPrice());

        return field1.compareTo(field2);
    }
}

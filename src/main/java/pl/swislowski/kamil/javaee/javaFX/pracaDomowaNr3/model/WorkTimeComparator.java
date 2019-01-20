package pl.swislowski.kamil.javaee.javaFX.pracaDomowaNr3.model;

import java.util.Comparator;

public class WorkTimeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        int workEndTime1 = Integer.parseInt(o1.getWorkEndHour());
        int workEndTime2 = Integer.parseInt(o2.getWorkEndHour());

        if (workEndTime1 < workEndTime2) {
            return -1;
        } else if (workEndTime1 > workEndTime2) {
            return 1;
        } else {
            return 0;
        }
    }
}

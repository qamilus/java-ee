package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateAndCalendarMain {
    public static void main(String[] args) {
        Scanner scDate = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Podaj datę w formacie yyyy-MM-dd :");
        Date parse = null;
        try {
            parse = sdf.parse(scDate.nextLine());
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = DateAndCalendar.toCalendar(parse);

        System.out.println(sdf.format(calendar.getTime()));

        int dayOfWeek1 = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek1);
        DateAndCalendar.dayOfWeek(calendar);

        calendar.add(Calendar.YEAR, 1);
        int dayOfWeek2 = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println();
        System.out.println("Równo rok później będzie: ");
        System.out.println(dayOfWeek2);
        DateAndCalendar.dayOfWeek(calendar);
    }

}


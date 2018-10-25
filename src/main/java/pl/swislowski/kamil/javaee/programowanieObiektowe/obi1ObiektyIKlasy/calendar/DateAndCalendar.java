package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.calendar;

import java.util.Calendar;
import java.util.Date;

public class DateAndCalendar {
//    private static int liczbaKalendarzy;
//    static {
//        liczbaKalendarzy = 0;
//    }

    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
//        liczbaKalendarzy++;
        return cal;
    }

    public static void dayOfWeek(Calendar calendar) {
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1: {
                System.out.println("Niedziela");
                break;
            }
            case 2: {
                System.out.println("Poniedziałek");
                break;
            }
            case 3: {
                System.out.println("Wtorek");
                break;
            }
            case 4: {
                System.out.println("Sroda");
                break;
            }
            case 5: {
                System.out.println("Czwartek");
                break;
            }
            case 6: {
                System.out.println("Piątek");
                break;
            }
            case 7: {
                System.out.println("Sobota");
                break;
            }
            default:
                break;
        }
    }
}

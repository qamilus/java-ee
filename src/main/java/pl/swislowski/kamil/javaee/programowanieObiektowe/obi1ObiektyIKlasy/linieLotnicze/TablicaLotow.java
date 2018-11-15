package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.linieLotnicze;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TablicaLotow {
    private List<Lot> lotList = new ArrayList<>();

    public TablicaLotow() {
        LiniaLotnicza plLot = new LiniaLotnicza("PlLot", "0987654h");

        Lot warszawaLondynLot = new Lot(FlightClassEnum.BUSINESS, "2,5h", "Warszawa",
                "Londyn", plLot, "Being 787",
                ustawDateWylotu(2018, Calendar.APRIL, 12, 11,55) );

        Lot warszawaBerlinLot = new Lot("1,5h", "Warszawa",
                "Berlin", new LiniaLotnicza("Lufthansa", "1234567h"), "AirBus A-360",
                ustawDateWylotu(2018, Calendar.AUGUST, 14, 22,35));

        Lot warszawaParyz = new LotBuilder()
                .setDataOdlotu(Calendar.getInstance())
                .setDlugoscLotu("3")
                .setKlasaLotu(FlightClassEnum.E_1)
                .setLiniaLotnicza(new LiniaLotnicza("Wizzair", "23123123g"))
                .setLotniskoOdlotu("Warszawa")
                .setLotniskoPrzylotu("Paryż")
                .setModelSamolotu("Airbus 321")
                .createLot();

        this.lotList.add(warszawaLondynLot);
        this.lotList.add(warszawaBerlinLot);
    }

    public List<Lot> getLotList() {
        return lotList;
    }

    private Calendar ustawDateWylotu(int year, int month, int date, int hourOfDay, int minute){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date, hourOfDay, minute);
        return calendar;
    }
}

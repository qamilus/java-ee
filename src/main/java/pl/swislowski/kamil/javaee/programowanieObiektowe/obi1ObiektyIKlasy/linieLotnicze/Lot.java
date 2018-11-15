package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.linieLotnicze;

import java.util.Calendar;

public class Lot {
    private LiniaLotnicza liniaLotnicza;

    private FlightClassEnum klasaLotu;
    private String dlugoscLotu;
    private String lotniskoOdlotu;
    private String lotniskoPrzylotu;
    private String modelSamolotu;
    private Calendar dataOdlotu;

    public Lot(String dlugoscLotu, String lotniskoOdlotu, String lotniskoPrzylotu, LiniaLotnicza liniaLotnicza, String modelSamolotu, Calendar dataOdlotu) {
        this.dlugoscLotu = dlugoscLotu;
        this.lotniskoOdlotu = lotniskoOdlotu;
        this.lotniskoPrzylotu = lotniskoPrzylotu;
        this.liniaLotnicza = liniaLotnicza;
        this.modelSamolotu = modelSamolotu;
        this.dataOdlotu = dataOdlotu;
    }

    public Lot(FlightClassEnum klasaLotu, String dlugoscLotu, String lotniskoOdlotu, String lotniskoPrzylotu, LiniaLotnicza liniaLotnicza, String modelSamolotu, Calendar dataOdlotu) {
        this.klasaLotu = klasaLotu;
        this.dlugoscLotu = dlugoscLotu;
        this.lotniskoOdlotu = lotniskoOdlotu;
        this.lotniskoPrzylotu = lotniskoPrzylotu;
        this.liniaLotnicza = liniaLotnicza;
        this.modelSamolotu = modelSamolotu;
        this.dataOdlotu = dataOdlotu;
    }

    public String getLotniskoOdlotu() {
        return lotniskoOdlotu;
    }

    public String getLotniskoPrzylotu() {
        return lotniskoPrzylotu;
    }

    public Calendar getDataOdlotu() {
        return dataOdlotu;
    }

    public FlightClassEnum getKlasaLotu() {
        return klasaLotu;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "liniaLotnicza=" + liniaLotnicza +
                ", klasaLotu=" + klasaLotu.getUserFriendlyName() +
                ", dlugoscLotu='" + dlugoscLotu + '\'' +
                ", lotniskoOdlotu='" + lotniskoOdlotu + '\'' +
                ", lotniskoPrzylotu='" + lotniskoPrzylotu + '\'' +
                ", modelSamolotu='" + modelSamolotu + '\'' +
                ", dataOdlotu=" + dataOdlotu.getTime() +
                '}';
    }
}

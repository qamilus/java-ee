package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.linieLotnicze;

import java.util.Calendar;

public class Lot {
    private LiniaLotnicza liniaLotnicza;

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

    public String getLotniskoOdlotu() {
        return lotniskoOdlotu;
    }

    public String getLotniskoPrzylotu() {
        return lotniskoPrzylotu;
    }

    public Calendar getDataOdlotu() {
        return dataOdlotu;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "dlugoscLotu='" + dlugoscLotu + '\'' +
                ", lotniskoOdlotu='" + lotniskoOdlotu + '\'' +
                ", lotniskoPrzylotu='" + lotniskoPrzylotu + '\'' +
                ", liniaLotnicza='" + liniaLotnicza + '\'' +
                ", modelSamolotu='" + modelSamolotu + '\'' +
                ", dataOdlotu='" + dataOdlotu.getTime() + '\'' +
                '}';
    }
}

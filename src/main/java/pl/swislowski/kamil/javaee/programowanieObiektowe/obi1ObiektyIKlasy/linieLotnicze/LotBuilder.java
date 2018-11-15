package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.linieLotnicze;

import java.util.Calendar;

public class LotBuilder {
    private String dlugoscLotu;
    private String lotniskoOdlotu;
    private String lotniskoPrzylotu;
    private LiniaLotnicza liniaLotnicza;
    private String modelSamolotu;
    private Calendar dataOdlotu;
    private FlightClassEnum klasaLotu;

    public LotBuilder setDlugoscLotu(String dlugoscLotu) {
        this.dlugoscLotu = dlugoscLotu;
        return this;
    }

    public LotBuilder setLotniskoOdlotu(String lotniskoOdlotu) {
        this.lotniskoOdlotu = lotniskoOdlotu;
        return this;
    }

    public LotBuilder setLotniskoPrzylotu(String lotniskoPrzylotu) {
        this.lotniskoPrzylotu = lotniskoPrzylotu;
        return this;
    }

    public LotBuilder setLiniaLotnicza(LiniaLotnicza liniaLotnicza) {
        this.liniaLotnicza = liniaLotnicza;
        return this;
    }

    public LotBuilder setModelSamolotu(String modelSamolotu) {
        this.modelSamolotu = modelSamolotu;
        return this;
    }

    public LotBuilder setDataOdlotu(Calendar dataOdlotu) {
        this.dataOdlotu = dataOdlotu;
        return this;
    }

    public LotBuilder setKlasaLotu(FlightClassEnum klasaLotu) {
        this.klasaLotu = klasaLotu;
        return this;
    }

    public Lot createLot() {
        if (lotniskoOdlotu == null || lotniskoPrzylotu == null) throw new IllegalStateException();
        return new Lot(klasaLotu, dlugoscLotu, lotniskoOdlotu, lotniskoPrzylotu, liniaLotnicza, modelSamolotu, dataOdlotu);
    }
}
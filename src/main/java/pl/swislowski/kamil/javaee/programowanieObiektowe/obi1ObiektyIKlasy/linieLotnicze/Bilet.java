package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.linieLotnicze;

import java.util.Calendar;

public class Bilet {
    private Lot lot;

    private String numerBiletu;
    private Calendar dataWylotu;
    private String numerBramki;
    private String imiePasazera;
    private String nazwiskoPasazera;
    private String klasa;
    private String bagazRejestrowany;

    public Bilet() {
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public void setNumerBiletu(String numerBiletu) {
        this.numerBiletu = numerBiletu;
    }

    public void setDataWylotu(Calendar dataWylotu) {
        this.dataWylotu = dataWylotu;
    }

    public void setNumerBramki(String numerBramki) {
        this.numerBramki = numerBramki;
    }

    public void setImiePasazera(String imiePasazera) {
        this.imiePasazera = imiePasazera;
    }

    public void setNazwiskoPasazera(String nazwiskoPasazera) {
        this.nazwiskoPasazera = nazwiskoPasazera;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public void setBagazRejestrowany(String bagazRejestrowany) {
        this.bagazRejestrowany = bagazRejestrowany;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "lot=" + lot +
                ", numerBiletu='" + numerBiletu + '\'' +
                ", dataWylotu=" + dataWylotu.getTime() +
                ", numerBramki='" + numerBramki + '\'' +
                ", imiePasazera='" + imiePasazera + '\'' +
                ", nazwiskoPasazera='" + nazwiskoPasazera + '\'' +
                ", klasa='" + klasa + '\'' +
                ", bagazRejestrowany='" + bagazRejestrowany + '\'' +
                '}';
    }
}

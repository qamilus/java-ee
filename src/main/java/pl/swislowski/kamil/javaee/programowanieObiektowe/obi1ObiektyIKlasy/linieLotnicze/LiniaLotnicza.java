package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.linieLotnicze;

public class LiniaLotnicza {
    private String nazwa;
    private String numerKoncesji;

    public LiniaLotnicza(String nazwa, String numerKoncesji) {
        this.nazwa = nazwa;
        this.numerKoncesji = numerKoncesji;
    }

    @Override
    public String toString() {
        return "LiniaLotnicza{" +
                "nazwa='" + nazwa + '\'' +
                ", numerKoncesji='" + numerKoncesji + '\'' +
                '}';
    }
}

package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.linieLotnicze;

public class LinieLotniczeMain {
    public static void main(String[] args) {
        SystemRezerwacji systemRezerwacji = new SystemRezerwacji();

        Pasazer kowalskiPasazer = new Pasazer("Jan", "Kowalski", "CDA 829010");

        Lot warszawaLondynLot = systemRezerwacji.wyszukajPolaczenie("Warszawa", "Londyn");
        Bilet warszawaLondynBilet = systemRezerwacji.dokonajRezerwacji(warszawaLondynLot, kowalskiPasazer);

        kowalskiPasazer.setBilet(warszawaLondynBilet);

        Pasazer jankowskiPasazer = new Pasazer("Stefan", "Jankowski", "BDE 823454", "549281716");

        Lot brukselaWarszawaLot = systemRezerwacji.wyszukajPolaczenie("Bruksela", "Warszawa");
        Bilet brukselaWarszawaBilet = systemRezerwacji.dokonajRezerwacji(brukselaWarszawaLot, jankowskiPasazer);

        jankowskiPasazer.setBilet(brukselaWarszawaBilet);





    }

}

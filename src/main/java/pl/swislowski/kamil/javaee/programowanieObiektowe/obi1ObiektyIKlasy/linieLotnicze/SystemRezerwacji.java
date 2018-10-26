package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.linieLotnicze;

public class SystemRezerwacji {
    private TablicaLotow tablicaLotow = new TablicaLotow();

    public SystemRezerwacji() {
    }

    public Lot wyszukajPolaczenie(String lotniskoOdlotu, String lotniskoPrzylotu) {
        System.out.println("Wyszukuję połączenie.");
        for (Lot lot : tablicaLotow.getLotList()) {
            String odlot = lot.getLotniskoOdlotu();
            String przylot = lot.getLotniskoPrzylotu();

            if (odlot != null) {
                boolean znalezionoOdlot = odlot.contains(lotniskoOdlotu);
               boolean znalezionoPrzylot = przylot.contains(lotniskoPrzylotu);
                if (znalezionoOdlot && znalezionoPrzylot) {
                    System.out.println("Znalezione połączenie " + lot);
                    return lot;
                }
            }
        }
        System.out.println("Nie odnaleziono  połączenia z " + lotniskoOdlotu + " do " + lotniskoPrzylotu);
        return null;
    }

    public Bilet dokonajRezerwacji(Lot lot, Pasazer pasazer) {
        if (lot != null) {
            System.out.println("Dokonuję rezerwacji.");
            Bilet bilet = przygotujBilet(lot, pasazer);
            System.out.println("Dokonałem rezerwacji, drukuję bilet: " + bilet);
            return bilet;
        }
        System.out.println("Nie mogę dokonać rezerwacji. Nie podano lotu. ");
        return null;
    }

    private Bilet przygotujBilet(Lot lot, Pasazer pasazer) {
//        String imiePasazera = pasazer.getImie();
//        bilet.setImiePasazera(imiePasazera);

        Bilet bilet = null;
        if (lot != null) {

            bilet = new Bilet();
            bilet.setLot(lot);
            bilet.setImiePasazera(pasazer.getImie());
            bilet.setNazwiskoPasazera(pasazer.getNazwisko());
            bilet.setDataWylotu(lot.getDataOdlotu());
            bilet.setKlasa("Economic");
            bilet.setBagazRejestrowany(null);
            bilet.setNumerBiletu("" + Math.random() * 1000 + 1);
            bilet.setNumerBramki("38D");
        }

        return bilet;
    }
}

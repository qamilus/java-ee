package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.linieLotnicze;

public enum FlightClassEnum {
    E_1("Economy"), STANDARD("Standard", "Standard Class"),
    BUSINESS("Business", "Business Class", "B_1"), UBER;         //Finalne stałe, które wywołują odpowiedni konstruktor.

    private String userFriendlyName;
    private String longName;
    private String technicalName;

    FlightClassEnum() {     // W zależności od ilości elementów w enumie, tyle razy razy wywoła się konstruktor tworząc
        // stałą liczbę instancji danej klasy. Jeżeli mamy dwa pola, to zostaną stworzone dwa obiekty danej klasy.

        System.out.println("Konstruktor bezargumentowy.");
    }

    FlightClassEnum(String userFriendlyName) {
        this.userFriendlyName = userFriendlyName;
        System.out.println("Konstruktor 1");
    }

    FlightClassEnum(String userFriendlyName, String longName) {
        this.userFriendlyName = userFriendlyName;
        this.longName = longName;
        System.out.println("Konstruktor 2");
    }

    FlightClassEnum(String userFriendlyName, String longName, String technicalName) {
        this.userFriendlyName = userFriendlyName;
        this.longName = longName;
        this.technicalName = technicalName;
        System.out.println("Konstruktor 3");
    }

    public String getUserFriendlyName() {
        return userFriendlyName;
    }

    public String getLongName() {
        return longName;
    }

    public String getTechnicalName() {
        return technicalName;
    }

//    @Override
//    public String toString() {
//        return "FlightClassEnum{" +
//                "userFriendlyName='" + userFriendlyName + '\'' +
//                ", longName='" + longName + '\'' +
//                ", technicalName='" + technicalName + '\'' +
//                '}';
//    }
}


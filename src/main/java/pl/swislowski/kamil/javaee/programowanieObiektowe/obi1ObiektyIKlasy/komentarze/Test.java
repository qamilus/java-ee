package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.komentarze;

public class Test {
    public static void main(String[] args) {
        //Utworzenie nowego obiektu typu Okno przy pomocy konstruktora bezargumentowego.
        Okno okno1 = new Okno();
        //Utworzenie nowego obiektu typu Okno przy pomocy konstruktora argumentowego wraz z przypisaniem wartości do zmiennych.
        Okno okno2 = new Okno(1800, 1800, 3);

        //Wywołanie dwóch różnych metod otwórz dla obiektów okno1 oraz okno2. Metody te różnią się sygnaturą, a konkretnie argumentami.
        okno1.otworz();
        okno2.otworz(0);
        okno2.otworz(2);

        //Wywołanie metody wypisz stan dla obiektów okno1 i okno2.
        okno1.wypiszStan();
        okno2.wypiszStan();

        //Wywołanie metody zamknij dla obiektu okno1. W tym przypadku nie ma konieczności podawania argumentu.
        okno1.zamknij();
        //Wywołanie metody ustanawiającej wartość dla pola prywatnego długość.
        okno2.setDlugosc(2100);
        //Wywołanie metody zamknij z podaniem wartości argumentu.
        okno2.zamknij(0);
        //Utworzenie nowego obiektu o referencji k1 typu Klamka. Użyty w tym przypadku jest konstruktor domyślny.
        Klamka kl = new Klamka();
        //Wywołanie metody ustanawiającej wartoś pola czyKluczyk.
        kl.setCzyKluczyk(true);

        //Wywołanie metod getSkrzydła oraz setKlamka dla obiektu o referencji okno2.
        okno2.getSkrzydla()[1].setKlamka(kl);
        okno2.getSkrzydla()[2].setKlamka(null);

        //Wywołanie metod wypisujących stan dla obiektów o referencji okno1 oraz okno2.
        okno1.wypiszStan();
        okno2.wypiszStan();

    }
}

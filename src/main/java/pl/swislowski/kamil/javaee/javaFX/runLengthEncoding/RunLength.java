package pl.swislowski.kamil.javaee.javaFX.runLengthEncoding;


public class RunLength {

    public static final int START = 1;

    public static String decode(String encodedText) {
        String decoded = ""; // Zmienna pomocnicza zawierająca wynik algorytmu.

        String[] split = encodedText.split(","); //Dzielenie Stringa na oddzielne elementy przy pomocy separatora " , ".

        int i = 0;
        while (i < split.length) {
            String pair = split[i];
            char value = pair.charAt(0);
            String occurrences = pair.substring(1); // Pobiera znaki pomijając pierwszy, ponieważ może być więcej niż jeden znak.
            i++;

            Integer integerOccurences = Integer.valueOf(occurrences); // Zamiana Stringa na inta.
            for (int j = 0; j < integerOccurences; j++) {
                decoded += value; // Do zmiennej pomocniczej przypisuję wartość tyle razy ile było w zmiennej occurences.
            }
        }
        return decoded;
    }


    public static String encode(String plainText) {
        String encoded = "";

        char[] chars = plainText.toCharArray();

        int count = START;  // Uwzględnienie pierwszego elementu.
        int i = 0;
        while (i < chars.length - 1) { // - 1, zabezpiecza przed ArrayIndexOutOfBoundException, który może wystąpić chars[i + 1].

            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                encoded += chars[i] + "" + count + ","; // przypisanie wartości do wyniku algorytmu.
                count = START; // reset licznika.
            }
            i++;
        }

        encoded += chars[chars.length - 1] + "" + count;   // obsługa ostatniego ciągu znaków zawierającego powtarzające
        // się znaki bez konieczności stosowania kolejnego warunku w algorytmie. Warunek w while nie pozwala nam na
        // sprawdzenie ostatniego znaku.

        return encoded;
    }
}

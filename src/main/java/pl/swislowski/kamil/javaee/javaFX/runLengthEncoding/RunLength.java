package pl.swislowski.kamil.javaee.javaFX.runLengthEncoding;


public class RunLength {

    public static final int START = 1;

    public static String decode(String encodedText) {
        String decoded = "";

        String[] split = encodedText.split(",");

        int i = 0;
        while (i < split.length) {
            String pair = split[i];
            char value = pair.charAt(0);
            String occurrences = pair.substring(1);
            i++;

            for (int j = 0; j < Integer.valueOf(occurrences); j++) {
                decoded += value;
            }
        }
        return decoded;
    }


    public static String encode(String plainText) {
        String encoded = "";

        char[] chars = plainText.toCharArray();

        int count = START;
        int i = 0;
        while (i < chars.length - 1) {

            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                encoded += chars[i] + "" + count + ",";
                count = START;
            }
            i++;
        }

        encoded += chars[chars.length - 1] + "" + count;

        return encoded;
    }
}

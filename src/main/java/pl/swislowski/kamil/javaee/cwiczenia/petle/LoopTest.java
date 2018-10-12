package pl.swislowski.kamil.javaee.cwiczenia.petle;


public class LoopTest {
    public static void main(String[] args) {

        int[][] multiplicationTable = new int[10][10];

        for (int i = 0; i < multiplicationTable.length; i++) {
            for (int j = 0; j < multiplicationTable[i].length; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
                System.out.println(multiplicationTable[i][j]);
            }
            System.out.println();
        }

        System.out.printf("The value of " + "the float variable is " +
                "%f, while the value of the " + "integer variable is %d, " +
                "and the string is %s", 1.5f, 2, "Tabliczka mnożenia.");


    }

}


package pl.swislowski.kamil.javaee.cwiczenia.petle;

import java.util.Scanner;

public class PetlaZTablica {
    public static void main(String[] args) {

        System.out.println("Wprowadź liczbę elementów, które mają być w tablicy:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);

        int[] tablica = new int[n];

        System.out.println("Długość tablicy to: " + tablica.length);

//        int[][] tablica2Wymiary = new int[n][n];

        for (int i = 0; i < tablica.length; i++) {
//            tablica[i] = i + 2;
            tablica[i] = i;
        }

        for (int j = 0; j < tablica.length; j++) {
            for (int k = 0; k <= tablica[j]; k++) {
                tablica[j] = j;
                System.out.print(k + " ");
            }
            System.out.println();

        }

//        for (int j = 0; j < tablica.length; j++) {
//            for (int k = 0; k <= tablica[j]; k++) {
//                tablica2Wymiary[j][k] = k;
//            }
//        }
//
//        System.out.println("TABLICA 2 WYMIARY");
//        for (int x = 0; x < n; x++) {
//            for (int y = 0; y < n; y++) {
//                System.out.print(" " + tablica2Wymiary[x][y]);
//            }
//            System.out.println();
//        }
    }
}

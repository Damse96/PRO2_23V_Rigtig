package opgave1_2dobbelArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Opgave2DobbelArray {

    public static void main(String[] args) {
        final int ROW = 8;
        final int COL = 8;
        int[][] values = new int[ROW][COL];
        DobbelArrayMethods da = new DobbelArrayMethods();

        //Udskriv values på tabel form
        da.udskrivArray(values);


        for (int[] row : values) {
            for (int col = 0; col < row.length; col++) {
                row[col] = 5;
            }

            // Can be replaced with:
            // Arrays.fill(row, 5);
        }

        System.out.println();
        System.out.println("Nedenfor skulle der stå 5 på alle pladser");
        System.out.println();
        da.udskrivArray(values);

        // Opgave 2.2 lav ændringer i values så der står 2 i lige rækker og 3 i ulige

        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                if (row % 2 == 0) {
                    values[row][col] = 2;
                } else {
                    values[row][col] = 3;
                }
            }
        }

        System.out.println();
        System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden række");
        System.out.println();
        da.udskrivArray(values);

        // Opgave 2.3  lav ændringer i values så der står 2 i lige søjler og 3 i ulige

        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                if (col % 2 == 0) {
                    values[row][col] = 2;
                } else {
                    values[row][col] = 3;
                }
            }
        }

        

        System.out.println();
        System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden søjle");
        System.out.println();
        da.udskrivArray(values);


        // Opgave 2.4 lav ændringer i values så den har skiftende 0'er og 1'er som på et skakbræt

        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                if ((row + col) % 2 == 0) {
                    values[row][col] = 0;
                } else {
                    values[row][col] = 1;
                }
            }
        }

        System.out.println();
        System.out.println("Nedenfor skulle der stå 0 og 1 på alle pladser som på skakbræt");
        System.out.println();
        da.udskrivArray(values);

        // Opgave 2.5 lav ændringer så alle elementer i nederste og øverste række samt første
        // og sidste søjle er 5 og resten skal være 2.

        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                if (row == 0 || row == values.length - 1 || col == 0 || col == values[row].length - 1) {
                    values[row][col] = 5;
                } else {
                    values[row][col] = 2;
                }
            }
        }

        System.out.println();
        System.out.println("Nedenfor skulle der stå 5 i kanten og 2 ellers");
        System.out.println();
        da.udskrivArray(values);
    }
}
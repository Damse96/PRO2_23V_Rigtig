package opgave1_2dobbelArray;

/**
 * @author mad
 */
public class DobbelArrayMethods {

    public void udskrivArray(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.print(array[row][col] + "  ");
            }
            System.out.println();
        }
    }

    // Opgave 1.1
    public int getValueAt(int[][] numbers, int row, int col) {
        //TODO returner værdien på plads (row,col) i numbers
        int value = numbers[row][col];
        return value;
    }

    // Opgave 1.2
    public void setValueAt(int[][] numbers, int row, int col, int value) {
        //TODO opdater pladsen (row,col) i numbers til value
        value = numbers[row][col];
    }

    // Opgave 1.3
    public int sumRow(int[][] numbers, int row) {
        //TODO returner summen af tallene i rækken row
        int sum = 0;
        for (int col = 0; col < numbers[row].length; col++) {
            sum += numbers[row][col];
        }
        return sum;
    }


    // Opgave 1.4
    public int sumCol(int[][] numbers, int col) {
        //TODO returner summen af tallene i kolonnen col
        int sum = 0;
        for (int row = 0; row < numbers.length; row++) {
            sum += numbers[row][col];
        }
        return sum;
    }

    // Opgave 1.5
    public int sum(int[][] numbers) {
        //TODO returnerer summen af alle tallene i numbers
        int sum = 0;

        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                sum += numbers[row][col];
            }
        }
        return sum;
    }

}

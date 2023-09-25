package opgave1_2dobbelArray;

/**
 * @author mad
 *
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
	public  int getValueAt(int[][] numbers, int row, int col){
		//TODO returner værdien på plads (row,col) i numbers
		return -1;
	}

	// Opgave 1.2
	public  void setValueAt(int[][] numbers, int row, int col, int value){
		//TODO opdater pladsen (row,col) i numbers til value
	}

	// Opgave 1.3
	public  int sumRow(int[][] numbers, int row) {
		//TODO returner summen af tallene i rækken row
		return -1;
	}

	// Opgave 1.4
	public  int sumCol(int[][] numbers, int row) {
		//TODO returner summen af tallene i kolonnen col
		return -1;
	}

	// Opgave 1.5
	public  int sum(int[][] numbers) {
		//TODO returnerer summen af alle tallene i numbers
		return -1;
	}

}

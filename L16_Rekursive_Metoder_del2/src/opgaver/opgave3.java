package opgaver;

public class opgave3 {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(binSearch(array, 5));
    }

    public static boolean binSearch(int[] array, int a){
        return binSearch(array,a, 0,  array.length - 1);
    }


    public static boolean binSearch(int[] array, int a, int left, int right){
        if (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == a) {
                return true;
            } else if (array[mid] > a) {
                return binSearch(array, a, left, mid - 1);
            }
            return binSearch(array, a, mid + 1, right);
        }
        return false;
    }
}

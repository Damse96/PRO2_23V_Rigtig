package opgaver;


import java.util.ArrayList;

public class Opgave1 {

    public static void main(String[] args) {

    }
    public static int ligeTal(ArrayList<Integer> list) {
        return ligeTal(list, 0);
    }

    public static  int ligeTal(ArrayList<Integer> list, int index){
        int result = 0;
        if (list.size() == index){
            result = 0;
            } else if (list.get(index) % 2 == 0){
                result = 1 + ligeTal(list, index + 1);
            } else {
            result = ligeTal(list,index + 1);
        } return result;
    }
}

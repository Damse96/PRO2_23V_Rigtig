package opgaver;


import java.util.ArrayList;

public class Opgave1 {


    public static void main(String[] args) {
        ArrayList<Integer> tal = new ArrayList<>();
        tal.add(1);
        tal.add(2);
        tal.add(3);
        tal.add(4);
        tal.add(5);
        tal.add(6);


        System.out.println(ligeTal(tal));
        System.out.println(ligeTal2(tal));
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

    public static int ligeTal2(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        int firstElement = list.get(0);
        int restCount = ligeTal(
                new ArrayList<>(list.subList(1, list.size())));

        if (firstElement % 2 == 0) {
            return 1 + restCount;

        } else {
            return restCount;
        }
    }



}

package opgaver;

import java.util.ArrayList;

public class Opgave1 {

    public static void main(String[] args) {
        ArrayList<Integer> tal = new ArrayList<>();
        tal.add(2);
        tal.add(2);
        tal.add(2);
        tal.add(4);

        System.out.println(sum(tal));

    }

    public static int sum(ArrayList<Integer> list) {
        return sum(list, 0, list.size() - 1);
    }

    private static int sum(ArrayList<Integer> list, int l, int h) {
        int result = 0;
        if (l == h) {
            return list.get(l);
        } else {
            int m = (l + h) / 2;
            int sum1 = sum(list, l, m);
            int sum2 = sum(list, m + 1, h);
            result = sum1 + sum2;
        }
        return result;
    }
}

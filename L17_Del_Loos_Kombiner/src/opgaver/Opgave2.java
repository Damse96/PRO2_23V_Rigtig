package opgaver;

import java.util.ArrayList;

public class Opgave2 {
    public static void main(String[] args) {
        ArrayList<Integer> tal = new ArrayList<>();
        tal.add(2);
        tal.add(2);
        tal.add(2);
        tal.add(4);
        tal.add(0);
        tal.add(0);
        tal.add(0);

        System.out.println(antalNuller(tal));
    }

    public static int antalNuller(ArrayList<Integer> list) {
        return antalNuller(list, 0, list.size() - 1);
    }

    private static int antalNuller(ArrayList<Integer> list, int l, int h) {
        int result = 0;
        if (l == h) {
            if (list.get(l) == 0)
                return 1;
            else {
                return 0;
            }
        } else {
            int m = (l + h) / 2;
            int antalNuller1 = antalNuller(list, l, m);
            int antalNuller2 = antalNuller(list, m + 1, h);
            result = antalNuller1 + antalNuller2;
        }
        return result;
    }
}




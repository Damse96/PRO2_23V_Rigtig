package opgaver;

import java.util.ArrayList;

public class Opgave3Loosning {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(45);
        list.add(12);
        list.add(56);
        list.add(37);
        list.add(48);
        list.add(12);
        list.add(34);
        list.add(4);
        list.add(56);
        System.out.println(list);

        fletteSort(list);

        System.out.println(list);

    }

    public static void fletteSort(ArrayList<Integer> list) {
        mergesort(list, 0, list.size() - 1);
    }

    private static void mergesort(ArrayList<Integer> list, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            mergesort(list, l, m);
            mergesort(list, m + 1, h);
            merge(list, l, m, h);
        }
    }

    // kombiner er realiseret ved fletteskabelonen
    private static void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> temp = new ArrayList<>();

        int counter1 = low;
        int counter2 = middle + 1;

        while (counter1 <= middle && counter2 <= high) {
            if (list.get(counter1) < list.get(counter2)) {
                temp.add(list.get(counter1));
                counter1++;
            } else {
                temp.add(list.get(counter2));
                counter2++;
            }
        }

        while (counter1 <= middle) {
            temp.add(list.get(counter1));
            counter1++;
        }

        while (counter2 <= high) {
            temp.add(list.get(counter2));
            counter2++;
        }

        for (int k = 0; k < temp.size(); k++) {
            list.set(k+low, temp.get(k));
        }
    }
}

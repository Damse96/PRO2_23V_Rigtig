package Opgave1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Mekaniker> mekanikers = new ArrayList<>();
        Mekaniker værkfører1 = new Værkfører("Mads","her nr 1",1996,250,37,2005,150);
        Mekaniker værkfører2 = new Værkfører("Rasmus","her nr 2",1998,200,37,2007,150);
        Mekaniker mekaniker1 = new Mekaniker("Mikkel", "Madsvej 1", 2005,150,37);
        Mekaniker mekaniker2 = new Mekaniker("Sebastian", "Ceresvej 2", 2010,200,37);
        Mekaniker mekaniker3 = new Mekaniker("Thor", "Ceresvej 3", 2020,200,37);

        mekanikers.add(mekaniker1);
        mekanikers.add(mekaniker2);
        mekanikers.add(mekaniker3);
        mekanikers.add(værkfører1);
        mekanikers.add(værkfører2);
        System.out.println(samletLoen(mekanikers));
    }

    public static double samletLoen(ArrayList<Mekaniker> list) {
        double sum = 0;
        for (Mekaniker mekaniker : list) {
            sum += mekaniker.beregnLoen();
        }
        return sum;
    }
}

package Mekanikervërksted;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Mekaniker m1 = new Mekaniker("Jens","Hansensvej 2", LocalDate.of(2000,10,10),100);
        Mekaniker m2 = new Mekaniker("Bo","Hansensvej 3", LocalDate.of(2000,10,10),100);
        Mekaniker m3 = new Mekaniker("Lars","Hansensvej 4", LocalDate.of(2000,10,10),100);;
        Synsmand s1 = new Synsmand("Mikkel","Jensensvej 20",LocalDate.of(2000,11,11),100,10);
        ArbejdsDreng ab1 = new ArbejdsDreng("Henning","Rasmussensvej",100);
        Værkfører v1 = new Værkfører("Jonas","Hansvej 33",100,LocalDate.of(1995,10,10),2000);


        ArrayList<Ansat> meki1 = new ArrayList<>();
        meki1.add(m1);
        meki1.add(m2);
        meki1.add(m3);
        meki1.add(s1);
        meki1.add(ab1);
        meki1.add(v1);

        System.out.println("Samlet løn er: " + samletLøn(meki1));


    }
    public static double samletLøn(ArrayList<Ansat> list){
        double samletLøn = 0;
        for (int i = 0; i < list.size(); i++) {
           samletLøn += list.get(i).beregnLøn();
            System.out.println(list.get(i).beregnLøn());
        }
        return samletLøn;
    }
}

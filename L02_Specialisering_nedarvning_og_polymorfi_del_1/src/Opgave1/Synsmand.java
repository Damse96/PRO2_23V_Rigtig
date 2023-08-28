package Opgave1;

import java.util.Timer;

public class Synsmand extends Mekaniker {
    private int syn;

    public Synsmand(String navn, String adresse, int svendeprøve, int timelønssats, int timer, int syn) {
        super(navn, adresse, svendeprøve, timelønssats, timer);
        this.syn = syn;
    }

    public int getSyn() {
        return syn;
    }

    public void setSyn(int syn) {
        this.syn = syn;
    }

   @Override
   public int beregnLoen(){
        int sum = 0;
        return sum = (super.getTimelønssats() * super.getTimer()) + synLoen();
    }
    public int synLoen() {
        int sum = 0;
        return sum = syn * 29;
    }



}

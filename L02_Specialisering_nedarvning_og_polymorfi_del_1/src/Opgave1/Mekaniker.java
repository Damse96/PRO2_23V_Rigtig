package Opgave1;

import java.util.ArrayList;

public class Mekaniker extends Person {
    private int svendeprøve;

    private int timelønssats;

    private int timer;


    public Mekaniker(String navn, String adresse, int svendeprøve, int timelønssats, int timer) {
        super(navn, adresse);
        this.svendeprøve = svendeprøve;
        this.timelønssats = timelønssats;
        this.timer = timer;
    }

    public int getSvendeprøve() {
        return svendeprøve;
    }

    public void setSvendeprøve(int svendeprøve) {
        this.svendeprøve = svendeprøve;
    }

    public int getTimelønssats() {
        return timelønssats;
    }

    public void setTimelønssats(int timelønssats) {
        this.timelønssats = timelønssats;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }



    public int beregnLoen(){
        int sum = 0;
        return sum = timelønssats * timer;
    }

    @Override
    public String toString() {
        return "Mekaniker{" +
                "svendeprøve=" + svendeprøve +
                ", timelønssats=" + timelønssats +
                ", timer=" + timer +
                '}';
    }
}

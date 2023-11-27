package Opgaver.Opgave2;

public class Counter {

    private int value = 0;
    private static Counter instans;

    private Counter() {}

    //Opretter en ny instance af Counter, hvis instans == null
    public static Counter getInstance() {
        if (instans == null) {
            instans = new Counter();
        }
        return instans;
    }
    //Tæller value op med 1
    public void count() {
        value++;
    }
    //Ganger value med 2
    public void times2() {
        value *= 2;
    }
    //Sætter value til 0
    public void zero() {
        value = 0;
    }
    //Returnerer value
    public int getValue() {
        return value;
    }

}

package Mekanikervërksted;

public abstract class Ansat extends Person{

    private double timeløn;
    public Ansat(String navn, String adresse, double timeløn) {
        super(navn, adresse);
        this.timeløn = timeløn;
    }
    public void setTimeløn(int timeløn) {
        this.timeløn = timeløn;
    }
    public abstract double beregnLøn();
    public double getTimeløn() {
        return timeløn;
    }
}

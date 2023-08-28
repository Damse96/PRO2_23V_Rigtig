package Opgave1;

public class Værkfører extends Mekaniker {
    private int værkførerAar;

    private int tillægPrUge;

    public Værkfører(String navn, String adresse, int svendeprøve, int timelønssats, int timer, int værkførerAar, int tillægPrUge) {
        super(navn, adresse, svendeprøve, timelønssats, timer);
        this.værkførerAar = værkførerAar;
        this.tillægPrUge = tillægPrUge;
    }

    public int getVærkførerAar() {
        return værkførerAar;
    }

    public void setVærkførerAar(int værkførerAar) {
        this.værkførerAar = værkførerAar;
    }

    public int getTillægPrUge() {
        return tillægPrUge;
    }

    public void setTillægPrUge(int tillægPrUge) {
        this.tillægPrUge = tillægPrUge;
    }

    @Override
    public String toString() {
        return "Værkfører{" +
                "værkførerAar=" + værkførerAar +
                ", tillægPrUge=" + tillægPrUge +
                '}';
    }
}

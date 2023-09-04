package Mekanikervërksted;

import java.time.LocalDate;

public class Værkfører extends Ansat{

    private LocalDate udnævntsÅr;
    private double tillæg;

    public Værkfører(String navn, String adresse, double timeløn, LocalDate udnævntsÅr, double tillæg) {
        super(navn, adresse, timeløn);
        this.udnævntsÅr = udnævntsÅr;
        this.tillæg = tillæg;
    }
    public LocalDate getUdnævntsÅr() {
        return udnævntsÅr;
    }

    public void setUdnævntsÅr(LocalDate udnævntsÅr) {
        this.udnævntsÅr = udnævntsÅr;
    }

    public double getTillæg() {
        return tillæg;
    }

    public void setTillæg(int tillæg) {
        this.tillæg = tillæg;
    }

    @Override
    public double beregnLøn() {
        return getTimeløn() * 37 + this.tillæg;
    }
}

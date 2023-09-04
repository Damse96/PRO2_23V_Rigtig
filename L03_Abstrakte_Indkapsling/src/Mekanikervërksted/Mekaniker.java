package Mekanikervërksted;

import java.time.LocalDate;

public class Mekaniker extends Ansat{

    private LocalDate svendeprøveÅr;

    public Mekaniker(String navn, String adresse, LocalDate svendeprøveÅr, double timeløn) {
        super(navn, adresse, timeløn);
        this.svendeprøveÅr = svendeprøveÅr;
    }

    public LocalDate getSvendeprøveÅr() {
        return svendeprøveÅr;
    }

    public void setSvendeprøveÅr(LocalDate svendeprøveÅr) {
        this.svendeprøveÅr = svendeprøveÅr;
    }

    @Override
    public double beregnLøn() {
        return getTimeløn() * 37;
    }
}

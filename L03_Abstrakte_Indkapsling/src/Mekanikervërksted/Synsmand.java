package Mekanikervërksted;

import java.time.LocalDate;

public class Synsmand extends Mekaniker{

    private int antalSyn;
    public Synsmand(String navn, String adresse, LocalDate svendeprøveÅr, double timeløn, int antalSyn) {
        super(navn, adresse, svendeprøveÅr, timeløn);
        this.antalSyn = antalSyn;
    }
    public int getAntalSyn() {
        return antalSyn;
    }
    public void setAntalSyn(int antalSyn) {
        this.antalSyn = antalSyn;
    }

    @Override
    public final double beregnLøn() {
        return super.beregnLøn() + this.antalSyn * 29;
    }
}

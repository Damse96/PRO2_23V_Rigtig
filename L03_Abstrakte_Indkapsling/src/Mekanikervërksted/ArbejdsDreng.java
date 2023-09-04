package Mekanikervërksted;

public class ArbejdsDreng extends Ansat{


    public ArbejdsDreng(String navn, String adresse, double timeløn) {
        super(navn, adresse, timeløn);
    }

    @Override
    public double beregnLøn() {
        return getTimeløn() * 25;
    }
}

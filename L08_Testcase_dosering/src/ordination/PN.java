package ordination;

import net.bytebuddy.agent.builder.AgentBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PN extends Ordination{
    private double antalEnheder;
    private List<LocalDate> givneDatoer = new ArrayList<>();

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double antalEnheder) {
        super(startDen, slutDen, laegemiddel);
        this.antalEnheder = antalEnheder;
    }

    // Tjekker om datoen er gyldig
    public boolean gyldigDato(LocalDate date) {
        return !date.isBefore(getStartDen()) && !date.isAfter(getSlutDen());
    }

    // Giver dosis hvis datoen er gyldig
    public boolean givDosis(LocalDate givesDen) {
        if (gyldigDato(givesDen)) {
            givneDatoer.add(givesDen);
            return true;
        }
        return false;
    }

    // Returnerer antal gange ordinationen er anvendt
    @Override
    public double samletDosis() {
        return antalEnheder * givneDatoer.size();
    }

    // Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
    @Override
    public double doegnDosis() {
        int antalDage = antalDage();
        if (antalDage == 0) {
            return 0;
        }
        return samletDosis() / antalDage();
    }

    // Returnerer ordinationstypen som en String
    @Override
    public String getType() {
        return "PN";
    }

    // Returnerer antal gange ordinationen er anvendt
    public int getAntalGangeGivet() {
        return givneDatoer.size();
    }

    // Returnerer antal enheder
    public String getAntalEnheder() {
        return antalEnheder + "";
    }
}

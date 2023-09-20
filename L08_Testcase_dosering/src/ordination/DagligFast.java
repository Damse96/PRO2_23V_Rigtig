package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {
    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, int morgenAntal, int middagAntal, int aftenAntal, int natAntal, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
            doser[0] = new Dosis(LocalTime.of(8, 0), morgenAntal);
            doser[1] = new Dosis(LocalTime.of(12, 0), middagAntal);
            doser[2] = new Dosis(LocalTime.of(18, 0), aftenAntal);
            doser[3] = new Dosis(LocalTime.of(22, 0), natAntal);
    }

    // Implementer metoder til beregning af døgndosis og den samlede dosis
    @Override
    public double samletDosis() {
        double samletDosis = 0;
        for (Dosis dosis : doser) {
            samletDosis += dosis.getAntal();
        }
        return samletDosis;
    }

    @Override
    public double doegnDosis() {
        return samletDosis() / antalDage();
    }

    @Override
    public String getType() {
        return "Daglig fast";
    }

    public Dosis[] getDoser() {
        return doser;
    }
}

package ordination;



public class Controller {
    private ordination.Storage storage;
    private static Controller controller;

    private Controller() {
        storage = new ordination.Storage();
    }

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    /**
     * For et givent vægtinterval og et givent lægemiddel, hentes antallet af
     * ordinationer.
     * Pre: laegemiddel er ikke null
     */
    public int antalOrdinationerPrVægtPrLægemiddel(double vægtStart, double vægtSlut, ordination.Laegemiddel laegemiddel) {
        int antal = 0;
        for (ordination.Patient patient : storage.getAllPatienter()) {
            if (patient.getVaegt() >= vægtStart && patient.getVaegt() <= vægtSlut) {
                for (ordination.Ordination ordination : patient.getOrdinationer()) {
                    if (ordination.getLaegemiddel().equals(laegemiddel)) {
                        antal++;
                    }
                }
            }
        }
        return antal;
    }
}

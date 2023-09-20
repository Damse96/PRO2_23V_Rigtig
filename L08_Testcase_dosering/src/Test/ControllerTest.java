package Test;

import controller.Controller;
import ordination.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    @Test
    void testOpretPNOrdination() {

        // Arrange (opret objekter, initialiser variabler, etc.)
        Controller controller = Controller.getTestController();
        LocalDate startDen = LocalDate.of(2021, 1, 1);
        LocalDate slutDen = LocalDate.of(2021, 1, 10);
        Patient patient = new Patient("123456-7890", "Test Patient", 70.0);
        Laegemiddel laegemiddel = new Laegemiddel("Test Lægemiddel", 0.1, 0.15, 0.2, "Styk");
        double antalEnheder = 5.0;

        // Act (udfør metoden)
        PN pnOrdination = controller.opretPNOrdination(startDen, slutDen, patient, laegemiddel, antalEnheder);

        // Assert (sammenlign forventet og faktisk resultat)
        assertNotNull(pnOrdination);
        assertEquals(startDen, pnOrdination.getStartDen());
        assertEquals(slutDen, pnOrdination.getSlutDen());
        assertEquals("123456-7890", patient.getCprnr()); // Anderledes test, da patienten ikke ligger på PN klassen
        assertEquals(laegemiddel, pnOrdination.getLaegemiddel());

        double expectedAntalEnheder = Double.parseDouble(String.valueOf(antalEnheder));
        double actualAntalEnheder = Double.parseDouble(pnOrdination.getAntalEnheder());
        assertEquals(expectedAntalEnheder, actualAntalEnheder);
    }

    @Test
    void testOpretDagligFastOrdination() {
        // Arrange (opret objekter, initialiser variabler, etc.)
        Controller controller = Controller.getTestController();
        LocalDate startDen = LocalDate.of(2021, 1, 1);
        LocalDate slutDen = LocalDate.of(2021, 1, 10);
        Patient patient = new Patient("123456-7890", "Test Patient", 70.0);
        Laegemiddel laegemiddel = new Laegemiddel("Test Lægemiddel", 0.1, 0.15, 0.2, "Styk");
        int morningDose = 1;
        int middayDose = 2;
        int eveningDose = 3;
        int nightDose = 4;

        Dosis[] expectedDoser = {
                new Dosis(LocalTime.of(8, 0), morningDose),
                new Dosis(LocalTime.of(12, 0), middayDose),
                new Dosis(LocalTime.of(18, 0), eveningDose),
                new Dosis(LocalTime.of(22, 0), nightDose)
            };

        // Act (udfør metoden)
        DagligFast dagligFastOrdination = controller.opretDagligFastOrdination(startDen, slutDen, patient, laegemiddel, morningDose, middayDose, eveningDose, nightDose);

        // Assert (sammenlign forventet og faktisk resultat)
        assertNotNull(dagligFastOrdination);
        assertEquals(startDen, dagligFastOrdination.getStartDen());
        assertEquals(slutDen, dagligFastOrdination.getSlutDen());
        assertEquals("123456-7890", patient.getCprnr()); // Anderledes test, da patienten ikke ligger på DagligFast klassen
        assertEquals(laegemiddel, dagligFastOrdination.getLaegemiddel());

        Dosis[] actualDoser = dagligFastOrdination.getDoser();
        for (int i = 0; i < expectedDoser.length; i++) {
            assertEquals(expectedDoser[i].getTid(), actualDoser[i].getTid());
            assertEquals(expectedDoser[i].getAntal(), actualDoser[i].getAntal());
        }
    }

    @Test
    void testOpretDagligSkaevOrdination() {

        // Arrange (opret objekter, initialiser variabler, etc.)
        Controller controller = Controller.getTestController();
        LocalDate startDen = LocalDate.of(2021, 1, 1);
        LocalDate slutDen = LocalDate.of(2021, 1, 10);
        Patient patient = new Patient("123456-7890", "Test Patient", 70.0);
        Laegemiddel laegemiddel = new Laegemiddel("Test Lægemiddel", 0.1, 0.15, 0.2, "Styk");
        LocalTime[] klokkeSlet = {
                LocalTime.of(6, 0),
                LocalTime.of(9, 0),
                LocalTime.of(12, 0),
                LocalTime.of(15, 0),
                LocalTime.of(18, 0),
                LocalTime.of(21, 0)
        };

        double[] expectedAntalEnheder = {1, 2, 6, 4, 5, 6};


        // Act (udfør metoden)
        DagligSkaev dagligSkaevOrdination = controller.opretDagligSkaevOrdination(startDen, slutDen, patient, laegemiddel, klokkeSlet, expectedAntalEnheder);

        for (int i = 0; i < klokkeSlet.length; i++) {
            dagligSkaevOrdination.opretDosis(klokkeSlet[i], expectedAntalEnheder[i]);
        }

        // Assert (sammenlign forventet og faktisk resultat)
        assertNotNull(dagligSkaevOrdination);
        assertEquals(startDen, dagligSkaevOrdination.getStartDen());
        assertEquals(slutDen, dagligSkaevOrdination.getSlutDen());
        assertEquals("123456-7890", patient.getCprnr()); // Anderledes test, da patienten ikke ligger på DagligSkaev klassen
        assertEquals(laegemiddel, dagligSkaevOrdination.getLaegemiddel());

        List<Dosis> actualAntalEnheder = List.of(dagligSkaevOrdination.getAntalEnheder());
        for (int i = 0; i < expectedAntalEnheder.length; i++) {
            assertEquals(expectedAntalEnheder[i], actualAntalEnheder.get(i).getAntal());
        }
    }
}

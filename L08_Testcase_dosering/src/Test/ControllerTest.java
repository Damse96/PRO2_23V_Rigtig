package Test;

import controller.Controller;
import pnOrdination.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    @Test
    void testOpretPNOrdination() {

        // Arrange (opret objekter, initialiser variabler, etc.)
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 10);
        LocalDate slutDen = LocalDate.of(2022, 1, 10);
        Patient patient = new Patient("123456-7890", "Test Patient", 99.9);
        Laegemiddel laegemiddel = new Laegemiddel(
                "Test Lægemiddel",
                0.1,
                0.15,
                0.2,
                "Styk");
        double antalEnheder = 1.0;

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
        Controller controller = Controller.getController();
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
        Controller controller = Controller.getController();
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

    @Test
    void testOrdinationPNAnvendt() {
        // Arrange (opret objekter, initialiser variabler, etc.)
        Controller controller = Controller.getController();
        LocalDate startDen = LocalDate.of(2021, 1, 1);
        LocalDate slutDen = LocalDate.of(2021, 1, 10);
        LocalDate gyldigDato = LocalDate.of(2021, 1, 5);
        Patient patient = new Patient("123456-7890", "Test Patient", 70.0);
        Laegemiddel laegemiddel = new Laegemiddel("Test Lægemiddel", 0.1, 0.15, 0.2, "Styk");
        double antalEnheder = 5.0;

        PN pnOrdination = controller.opretPNOrdination(startDen, slutDen, patient, laegemiddel, antalEnheder);

        // Act (udfør metoden)
        controller.ordinationPNAnvendt(pnOrdination, gyldigDato);

        // Assert (sammenlign forventet og faktisk resultat)
        assertTrue(pnOrdination.getDatoer().contains(gyldigDato));
    }

    @Test
    void testAnbefaletDosisPrDoegn() {
        // Arrange (opret objekter, initialiser variabler, etc.)
        Controller controller = Controller.getController();
        Patient letPatient = new Patient("123456-7890", "Let Patient", 20.0);
        Patient normalPatient = new Patient("987654-3210", "Normal Patient", 70.0);
        Patient tungPatient = new Patient("555555-5555", "Tung Patient", 130.0);
        Laegemiddel laegemiddel = new Laegemiddel("Test Lægemiddel", 0.1, 0.15, 0.2, "Styk");

        // Act (udfør metoden)
        double letPatientAnbefaletDosis = controller.anbefaletDosisPrDoegn(letPatient, laegemiddel);
        double normalPatientAnbefaletDosis = controller.anbefaletDosisPrDoegn(normalPatient, laegemiddel);
        double tungPatientAnbefaletDosis = controller.anbefaletDosisPrDoegn(tungPatient, laegemiddel);

        // Assert (sammenlign forventet og faktisk resultat)
        assertEquals(2, letPatientAnbefaletDosis);
        assertEquals(14, normalPatientAnbefaletDosis);
        assertEquals(39, tungPatientAnbefaletDosis);
    }

    @Test
    void testAntalOrdinationerPrVægtPrLægemiddel() {
        // Arrange (opret objekter, initialiser variabler, etc.)
        Controller controller = Controller.getController();
        Laegemiddel laegemiddel = new Laegemiddel("Test Lægemiddel", 0.1, 0.15, 0.2, "Styk");

        // Opret en række patienter
        Patient patient1 = controller.opretPatient("123456-7890", "Patient 1", 60.0);
        Patient patient2 = controller.opretPatient("123456-7891", "Patient 2", 60.0);
        Patient patient3 = controller.opretPatient("123456-7892", "Patient 3", 100.0);
        Patient patient4 = controller.opretPatient("123456-7893", "Patient 4", 100.0);

        // Opret en række PN ordinationer
        PN pnOrdination1 = controller.opretPNOrdination(LocalDate.of(2022, 12, 12), LocalDate.of(2022, 12, 13), patient1, laegemiddel, 5);
        PN pnOrdination2 = controller.opretPNOrdination(LocalDate.of(2022, 12, 12), LocalDate.of(2022, 12, 13), patient2, laegemiddel, 4);
        PN pnOrdination3 = controller.opretPNOrdination(LocalDate.of(2022, 12, 12), LocalDate.of(2022, 12, 13), patient3, laegemiddel, 3);
        PN pnOrdination4 = controller.opretPNOrdination(LocalDate.of(2022, 12, 12), LocalDate.of(2022, 12, 13), patient4, laegemiddel, 2);

        // Tilføj ordinationer til patienter
        patient1.tilføjOrdination(pnOrdination1);
        patient2.tilføjOrdination(pnOrdination2);
        patient3.tilføjOrdination(pnOrdination3);
        patient4.tilføjOrdination(pnOrdination4);

        // Act (udfør metoden)
        int antalOrdinationer = controller.antalOrdinationerPrVægtPrLægemiddel(50, 90, laegemiddel);

        // Assert (sammenlign forventet og faktisk resultat)
        assertEquals(2, antalOrdinationer);
    }
}

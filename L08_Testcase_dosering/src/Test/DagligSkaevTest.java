package Test;

import pnOrdination.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class DagligSkaevTest {

   @Test
   void testOpretDosis() {
       // Arrange (opret objekter, initialiser variabler, etc.)
       // Opret et lægemiddel
       Laegemiddel laegemiddel = new Laegemiddel(
                "Test Lægemiddel",
                0.1,
                0.15,
                0.2,
                "Styk");

       // Opret en daglig skæv ordination
       DagligSkaev dagligSkaev = new DagligSkaev(
               LocalDate.of(2022,12,12),
               LocalDate.of(2022, 12, 16),
               laegemiddel);

       // Tilføj dosis til ordinationen
       LocalTime tid = LocalTime.of(8, 0);
         double antal = 3;
       dagligSkaev.opretDosis(tid, antal);

       // Hent dosis fra ordinationen
       Dosis[] doser = dagligSkaev.getAntalEnheder();

       // Assert (sammenlign forventet og faktisk resultat)
       Dosis forventetDosis = new Dosis(tid, antal);

       // Kontroller om den første dosis i arrayet er den forventede dosis
       assertEquals(forventetDosis.getTid(), doser[0].getTid());
       assertEquals(forventetDosis.getAntal(), doser[0].getAntal(), 0.01); // Brug en toleranceværdi, f.eks. 0.01
   }

    @Test
    void testSamletDosis() {

        // Arrange (opret objekter, initialiser variabler, etc.)
        // Opret et lægemiddel
        Laegemiddel laegemiddel = new Laegemiddel(
                "Test Lægemiddel",
                0.1,
                0.15,
                0.2,
                "Styk");

        // Opret en daglig skæv ordination
        DagligSkaev dagligSkaev = new DagligSkaev(
                LocalDate.of(2022,12,12),
                LocalDate.of(2022, 12, 16),
                laegemiddel);

        // Tilføj dosis til ordinationen
        LocalTime tid1 = LocalTime.of(8, 0);
        double antal1 = 3;
        dagligSkaev.opretDosis(tid1, antal1);

        LocalTime tid2 = LocalTime.of(12, 0);
        double antal2 = 4;
        dagligSkaev.opretDosis(tid2, antal2);

        // Forventet samlet dosis
        double forventetSamletDosis = antal1 + antal2;

        // Act (udfør metoden)
        double faktiskSamletDosis = dagligSkaev.samletDosis();

        // Assert (sammenlign forventet og faktisk resultat)
        assertEquals(forventetSamletDosis, faktiskSamletDosis, 0.01); // Brug en toleranceværdi, f.eks. 0.01
    }

    @Test
    void testDoegnDosis() {

        // Arrange (opret objekter, initialiser variabler, etc.)
        // Opret et lægemiddel
        Laegemiddel laegemiddel = new Laegemiddel(
                "Test Lægemiddel",
                0.1,
                0.15,
                0.2,
                "Styk");

        // Opret en daglig skæv ordination
        DagligSkaev dagligSkaev = new DagligSkaev(
                LocalDate.of(2022,12,12),
                LocalDate.of(2022, 12, 16),
                laegemiddel);

        // Tilføj dosis til ordinationen
        LocalTime tid1 = LocalTime.of(8, 0);
        double antal1 = 2;
        dagligSkaev.opretDosis(tid1, antal1);

        LocalTime tid2 = LocalTime.of(12, 0);
        double antal2 = 3;
        dagligSkaev.opretDosis(tid2, antal2);

        // Beregn antal dage ordinationen er gyldig
        int antalDage = dagligSkaev.antalDage();

        // Forventet dosis pr. dag
        double forventetDoegnDosis = (antal1 + antal2) / antalDage;

        // Act (udfør metoden)
        double faktiskDoegnDosis = dagligSkaev.doegnDosis();

        // Assert (sammenlign forventet og faktisk resultat)
        assertEquals(forventetDoegnDosis, faktiskDoegnDosis, 0.01); // Brug en toleranceværdi, f.eks. 0.01
    }

    @Test
    void testGetAntalEnheder() {

        // Arrange (opret objekter, initialiser variabler, etc.)
        // Opret et lægemiddel
        Laegemiddel laegemiddel = new Laegemiddel(
                "Test Lægemiddel",
                0.1,
                0.15,
                0.2,
                "Styk");

        // Opret en daglig skæv ordination
        DagligSkaev dagligSkaev = new DagligSkaev(
                LocalDate.of(2022,12,12),
                LocalDate.of(2022, 12, 16),
                laegemiddel);

        // Tilføj dosis til ordinationen
        LocalTime tid1 = LocalTime.of(8, 0);
        double antal1 = 2;
        dagligSkaev.opretDosis(tid1, antal1);

        LocalTime tid2 = LocalTime.of(12, 0);
        double antal2 = 3;
        dagligSkaev.opretDosis(tid2, antal2);

        // Forventet array af doser
        Dosis[] forventetDoser = {
                new Dosis(tid1, antal1),
                new Dosis(tid2, antal2)
        };

        // Act (udfør metoden)
        Dosis[] faktiskeDoser = dagligSkaev.getAntalEnheder();

        // Assert (sammenlign forventet og faktisk resultat)
        assertEquals(forventetDoser.length, faktiskeDoser.length);
    }
}

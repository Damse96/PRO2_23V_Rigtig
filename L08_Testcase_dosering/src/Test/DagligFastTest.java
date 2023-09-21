package Test;

import pnOrdination.DagligFast;
import pnOrdination.Laegemiddel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DagligFastTest {

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

        // Opret en daglig fast ordination
        DagligFast dagligFast = new DagligFast(
                LocalDate.of(2022,12,12),
                LocalDate.of(2022, 12, 16),
                1, 2, 3, 4,
                laegemiddel);

        // Forventet samlet dosis (1 + 2 + 3 + 4) = 10
        double forventetSamletDosis = 10;

        // Act (udfør metoden)
        double faktiskSamletDosis = dagligFast.samletDosis();

        // Assert (sammenlign forventet og faktisk resultat)
        assertEquals(forventetSamletDosis, faktiskSamletDosis);
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

        // Opret en daglig fast ordination
        DagligFast dagligFast = new DagligFast(
                LocalDate.of(2022,12,12),
                LocalDate.of(2022, 12, 16),
                1, 2, 3, 4,
                laegemiddel);

        // Forventet antal dage inklusiv start- og slutdato = 5
        int forventetAntalDage = 5;

        // Samlet dosis (1 + 2 + 3 + 4) = 10
        double samletDosis = 10;

        // Forventet døgndosis (10 / 5) = 2
        double forventetDoegnDosis = samletDosis / forventetAntalDage;

        // Act (udfør metoden)
        double faktiskDoegnDosis = dagligFast.doegnDosis();

        // Assert (sammenlign forventet og faktisk resultat)
        assertEquals(forventetDoegnDosis, faktiskDoegnDosis, 0.01);
    }
}

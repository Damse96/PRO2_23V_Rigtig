package Test;

import pnOrdination.DagligFast;
import pnOrdination.Laegemiddel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class OrdinationTest {

    @Test
    void testAntalDage() {
        // Arrange (opret objekter, initialiser variabler, etc.)
        LocalDate startDato = LocalDate.of(2022, 1, 1);
        LocalDate slutDato = LocalDate.of(2022, 1, 5);
        int morgenAntal = 1;
        int middagAntal = 2;
        int aftenAntal = 1;
        int natAntal = 0;
        Laegemiddel laegemiddel = new Laegemiddel("Test Lægemiddel", 0.1, 0.15, 0.2, "Styk");
        DagligFast dagligFast = new DagligFast(startDato, slutDato, morgenAntal, middagAntal, aftenAntal, natAntal, laegemiddel);

        // Act (udfør metoden)
        int antalDage = dagligFast.antalDage();

        // Assert (sammenlign forventet og faktisk resultat)
        assertEquals(5, antalDage);
    }
}

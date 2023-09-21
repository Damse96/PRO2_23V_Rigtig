package Test;

import pnOrdination.Laegemiddel;
import pnOrdination.PN;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PNTest {

    @Test
    void testGyldigDato() {
        // Opret en PN ordination
        LocalDate startDen = LocalDate.of(2021, 1, 1);
        LocalDate slutDen = LocalDate.of(2021, 1, 10);
        Laegemiddel laegemiddel = new Laegemiddel("Test Lægemiddel", 0.1, 0.15, 0.2, "Styk");
        PN pnOrdination = new PN(startDen, slutDen, laegemiddel, 5.0);

        // Test en gyldig dato indenfor intervallet
        LocalDate gylidgDato = LocalDate.of(2021, 1, 5);
        assertTrue(pnOrdination.gyldigDato(gylidgDato), "Forventede en gyldig dato");

        // Test en dato før startdatoen
        LocalDate datoFoerStart = LocalDate.of(2020, 12, 31);
        assertFalse(pnOrdination.gyldigDato(datoFoerStart), "Forventede en ugyldig dato");

        // Test en dato efter slutdatoen
        LocalDate datoEfterSlut = LocalDate.of(2021, 1, 11);
        assertFalse(pnOrdination.gyldigDato(datoEfterSlut), "Forventede en ugyldig dato");
    }

    @Test
    void testGivDosis() {

        // Opret en PN ordination
        LocalDate startDen = LocalDate.of(2021, 1, 1);
        LocalDate slutDen = LocalDate.of(2021, 1, 10);
        Laegemiddel laegemiddel = new Laegemiddel("Test Lægemiddel", 0.1, 0.15, 0.2, "Styk");
        PN pnOrdination = new PN(startDen, slutDen, laegemiddel, 5.0);

        // Test en gyldig dato inden for intervallet
        LocalDate gyldigDato1 = LocalDate.of(2021, 1, 5);
        assertTrue(pnOrdination.givDosis(gyldigDato1), "Forventede at kunne give dosis for en gyldig dato");
        assertEquals(1, pnOrdination.getAntalGangeGivet(), "Forventede 1 dosis blev givet");

        // Test en ugyldig dato før startDen
        LocalDate datoFoerStart = LocalDate.of(2020, 12, 30);
        assertFalse(pnOrdination.givDosis(datoFoerStart), "Forventede ikke at kunne give dosis for en ugyldig dato før startDen");
        assertEquals(1, pnOrdination.getAntalGangeGivet(), "Antal doser skal stadig være 1");

        // Test en ugyldig dato efter slutDen
        LocalDate datoEfterSlut = LocalDate.of(2021, 1, 11);
        assertFalse(pnOrdination.givDosis(datoEfterSlut), "Forventede ikke at kunne give dosis for en ugyldig dato efter slutDen");
        assertEquals(1, pnOrdination.getAntalGangeGivet(), "Antal doser skal stadig være 1");
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

        // Opret en PN ordination
        PN pnOrdination = new PN(
                LocalDate.of(2022,12,12),
                LocalDate.of(2022, 12, 16),
                laegemiddel,
                5.0);

        // Tilføj dosis til ordinationen
        LocalDate dato1 = LocalDate.of(2022, 12, 12);
        pnOrdination.givDosis(dato1);

        LocalDate dato2 = LocalDate.of(2022, 12, 13);
        pnOrdination.givDosis(dato2);

        // Forventet samlet dosis
        double forventetSamletDosis = 10.0;

        // Act (udfør metoden)
        double faktiskSamletDosis = pnOrdination.samletDosis();

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

        // Opret en PN ordination
        PN pnOrdination = new PN(
                LocalDate.of(2022,12,12),
                LocalDate.of(2022, 12, 16),
                laegemiddel,
                5.0);

        // Tilføj dosis til ordinationen
        LocalDate dato1 = LocalDate.of(2022, 12, 12);
        pnOrdination.givDosis(dato1);

        LocalDate dato2 = LocalDate.of(2022, 12, 13);
        pnOrdination.givDosis(dato2);

        // Beregn forventet dosis
        double forventetDoegnDosis = pnOrdination.samletDosis() / pnOrdination.antalDage();

        // Act (udfør metoden)
        double faktiskDoegnDosis = pnOrdination.doegnDosis();

        // Assert (sammenlign forventet og faktisk resultat)
        assertEquals(forventetDoegnDosis, faktiskDoegnDosis, 0.01); // Brug en toleranceværdi, f.eks. 0.01
    }
}

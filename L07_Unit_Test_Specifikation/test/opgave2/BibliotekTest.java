package opgave2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BibliotekTest {

    @Test
    void beregnBøde_1dag_Barn() {


        //Arrange

        LocalDate beregnetDato = LocalDate.of(2023, 6, 1);
        LocalDate faktiskDato = LocalDate.of(2023, 6, 2);
        boolean voksen = false;

        Bibliotek bib = new Bibliotek();
        int forventetBøde = 10;

        //act

        int faktiskBøde = bib.beregnBøde(beregnetDato, faktiskDato, voksen);


        //assert
        assertEquals(forventetBøde, faktiskBøde);
    }


}
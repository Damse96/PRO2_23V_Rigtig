package opgave1_UdenSync;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilForsikringTest {

    @Test
    void beregnPraemie() {


        //Arrange

        BilForsikring bilforsikring = new BilForsikring();
        bilforsikring.setGrundpaemie(1100);

        int alder = 120;
        boolean isKvinde = true;
        int skadeFrieAar = 3;

        //Act
        double praemie = bilforsikring.beregnPraemie(alder, isKvinde, skadeFrieAar);

        //Assert
        assertEquals(888.25, praemie);
    }

}
package Opgaver.Opgave3;

import static org.junit.jupiter.api.Assertions.*;

class PersonAdminstratorTest {

    @org.junit.jupiter.api.Test
    void getInstance() {
        //Arrange
        PersonAdminstrator x = PersonAdminstrator.getInstance();
        PersonAdminstrator y = PersonAdminstrator.getInstance();
        PersonAdminstrator z = PersonAdminstrator.getInstance();

        assertEquals(PersonAdminstrator.getInstance(), x);
        assertEquals(PersonAdminstrator.getInstance(), y);
        assertEquals(PersonAdminstrator.getInstance(), z);


    }
}
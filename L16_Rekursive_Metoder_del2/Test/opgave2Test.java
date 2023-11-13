package Test;

import opgaver.opgave2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class opgave2Test {

    @Test
    void test_palindrom_valid() {
        //arrange
        String pal1 = "bob";
        String pal2 = "abba";
        String pal3 = "aa";



        //act and assert
        Assertions.assertTrue(opgave2.palindrom(pal1));
        assertTrue(opgave2.palindrom(pal2));
        assertTrue(opgave2.palindrom(pal3));
    }

    @Test
    void test_palindrom_invalid() {
        //arrange
        String pal1 = "sovs";
        String pal2 = "banan";
        String pal3 = "esben";


        //act and assert
        assertFalse(opgave2.palindrom(pal1));
        assertFalse(opgave2.palindrom(pal2));
        assertFalse(opgave2.palindrom(pal3));
    }
}
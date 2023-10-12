package opgave2;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SkoleTest {

    //opretSkole


    Studerende studerende1 = new Studerende(1, "Studerende1", List.of(10,10));
    Studerende studerende2 = new Studerende(2, "Studerende2", List.of(12,12));

    Skole skole1 = new Skole("Skole1", List.of(studerende1, studerende2));




    @org.junit.jupiter.api.Test
    void gennemsnit() {
    }

    @org.junit.jupiter.api.Test
    void findStuderende() {
    }
}
package stacktest;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import stack.Validator;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    @Order(1)
    void validateBrackets1() {
        //Arrange
        Validator validator = new Validator();
        String string = "{HEJ BENJAMIN} ";


        //Act
        boolean aktuel = validator.validateBrackets(string);

        //Assert
        assertTrue(aktuel);

    }
    @Test
    @Order(2)
    void validateBrackets2() {
        //Arrange
        Validator validator = new Validator();
        String string = "(HEJ BENJAMIN( ";

        //Act
        boolean aktuel = validator.validateBrackets(string);

        //Assert
        assertTrue(aktuel);

    }
}
package cannibal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularCannibalMealTest {
    private CircularCannibalMeal circularCannibalMeal;

    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private Person person6;
    private Person person7;
    private Person person8;
    private Person person9;
    private Person person10;



    @BeforeEach
    void setUp() throws Exception{
        //Arrange
        this.circularCannibalMeal = new CircularCannibalMeal();

        person1 = new Person("Anders");
        person2 = new Person("Bo");
        person3 = new Person("Christian");
        person4 = new Person("Ditte");
        person5 = new Person("Eva");
        person6 = new Person("Freja");
        person7 = new Person("Gert");
        person8 = new Person("Hans");
        person9 = new Person("Ida");
        person10 = new Person("Jonas");


    }

    @Test
    @Order(0)
    void addPerson_Eat_Person() {
        //Assemble
        circularCannibalMeal.addPerson(person1);
        circularCannibalMeal.addPerson(person2);
        circularCannibalMeal.addPerson(person3);
        circularCannibalMeal.addPerson(person4);
        circularCannibalMeal.addPerson(person5);
        circularCannibalMeal.addPerson(person6);
        circularCannibalMeal.addPerson(person7);
        circularCannibalMeal.addPerson(person8);
        circularCannibalMeal.addPerson(person9);
        circularCannibalMeal.addPerson(person10);

        Person randomPerson = null;
        Person nextPerson = null;

        int size =10;
        //Assert
        assertEquals(circularCannibalMeal.size(),size);
        randomPerson = circularCannibalMeal.eatRandomPerson();
        size =9;
        assertEquals(circularCannibalMeal.size(),size);
        nextPerson =circularCannibalMeal.eatNextPerson(5);
        size = 8;
        assertEquals(circularCannibalMeal.size(), size);
        nextPerson = circularCannibalMeal.eatNextPerson(5);
        size = 7;
        assertEquals(circularCannibalMeal.size(), size);
        nextPerson = circularCannibalMeal.eatNextPerson(5);
        size = 6;
        assertEquals(circularCannibalMeal.size(), size);
        nextPerson = circularCannibalMeal.eatNextPerson(5);
        size = 5;
        assertEquals(circularCannibalMeal.size(), size);
        nextPerson = circularCannibalMeal.eatNextPerson(5);
        size = 4;
        assertEquals(circularCannibalMeal.size(), size);
        nextPerson = circularCannibalMeal.eatNextPerson(5);
        size = 3;
        assertEquals(circularCannibalMeal.size(), size);
        nextPerson = circularCannibalMeal.eatNextPerson(5);
        size = 2;
        assertEquals(circularCannibalMeal.size(), size);
        nextPerson = circularCannibalMeal.eatNextPerson(5);
        size = 1;
        assertEquals(circularCannibalMeal.size(), size);
        nextPerson = circularCannibalMeal.eatNextPerson(5);
        size = 0;
        assertEquals(circularCannibalMeal.size(), size);


        circularCannibalMeal.printPersons();
    }







    @Test
    void isEmpty(){
        assertTrue(circularCannibalMeal.isEmpty());
    }
}
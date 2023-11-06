package cannibal;

public class App {
    public static void main(String[] args) {
        CircularCannibalMeal circularCannibalMeal = new CircularCannibalMeal();

        Person p1 = new Person("A");
        Person p2 = new Person("B");
        Person p3 = new Person("C");
        Person p4 = new Person("D");
        Person p5 = new Person("E");
        Person p6 = new Person("F");
        Person p7 = new Person("G");
        Person p8 = new Person("H");
        Person p9 = new Person("I");


        circularCannibalMeal.addPerson(p1);
        circularCannibalMeal.addPerson(p2);
        circularCannibalMeal.addPerson(p3);
        circularCannibalMeal.addPerson(p4);
        circularCannibalMeal.addPerson(p5);
        circularCannibalMeal.addPerson(p6);
        circularCannibalMeal.addPerson(p7);
        circularCannibalMeal.addPerson(p8);
        circularCannibalMeal.addPerson(p9);
        circularCannibalMeal.printPersons();
        System.out.println();
        System.out.println(circularCannibalMeal.eatRandomPerson().getNavn());
        System.out.println();

        circularCannibalMeal.printPersons();
        System.out.println();
        circularCannibalMeal.eatNextPerson(5);
        System.out.println();
        circularCannibalMeal.printPersons();
        System.out.println();


    }
}

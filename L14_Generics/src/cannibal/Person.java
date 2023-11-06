package cannibal;

public class Person {
    private Person next;
    private String navn;


    public Person(String navn) {
        this.navn = navn;
    }

    public void setNext(Person next) {
        this.next = next;
    }

    public Person getNext() {
        return next;
    }

    public String getNavn() {
        return navn;
    }
}

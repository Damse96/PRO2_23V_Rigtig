package Opgaver.Opgave3;

public class Person {
    private String navn;

    public Person(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return navn;
    }
}

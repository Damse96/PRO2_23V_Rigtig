package opgave1;

import java.util.Iterator;
import java.util.function.Consumer;

public class PersonIterator implements Iterator<Person> {

    private final Person[] people;

    private Integer index = 0;


    public PersonIterator(Person[] people) {
        this.people = people;
    }



    @Override
    public boolean hasNext() {
        return index < people.length && people[index] != null;
    }

    @Override
    public Person next() {
        Person p = people[index];
        index ++;
        return p;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer<? super Person> action) {
       throw new UnsupportedOperationException();
    }
}

package Opgaver.Opgave3;

import java.util.HashSet;
import java.util.Set;

public class PersonAdminstrator {
    Set<Person> set = new HashSet<>();

    private static PersonAdminstrator instans;

    private PersonAdminstrator() {}

    public static PersonAdminstrator getInstance() {
        if (instans == null) {
            instans = new PersonAdminstrator();
        }
        return instans;
    }

    public void add(Person p) {
        set.add(p);
    }

    public Set<Person> getSet() {
        return set;
    }

    public void remove(Person p) {
        set.remove(p);
    }
}

package opgave2;

import java.util.ArrayList;
import java.util.List;

public class Skole {
    private String navn;

    private final List<Studerende> studerendes;

    public Skole(String navn, List<Studerende> studerendes) {
        this.navn = navn;
        this.studerendes = studerendes;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

public List<Studerende> getStuderendes() {
        return studerendes;
    }

    public void addStuderende(Studerende studerende) {
        if (!studerendes.contains(studerende)) {
            studerendes.add(studerende);
        }
    }
    public void removeStuderende(Studerende studerende) {
        if (!studerendes.contains(studerende)) {
            studerendes.remove(studerende);
        }
    }

    public double gennemsnit() {
        double sum = 0;
        for (Studerende studerende : studerendes) {
            sum += studerende.getKarakterergns();
        }
        return sum / studerendes.size();
    }

    public Studerende findStuderende(int studieNr) {
        for (Studerende studerende : studerendes) {
            if (studerende.getStudieNr() == studieNr) {
                return studerende;
            }
        }
        return null;
    }

}

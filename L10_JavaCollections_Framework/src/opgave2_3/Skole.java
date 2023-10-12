package opgave2_3;

import opgave2.Studerende;


import java.util.HashMap;
import java.util.Map;


public class Skole {
    private String navn;

    private final Map<Integer, Studerende> studerendes = new HashMap<>();


    public Skole(String navn) {
        this.navn = navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public Map<Integer, Studerende> getStuderendes() {
        return studerendes;
    }

    public void addStuderende(Studerende studerende) {

        studerendes.put(studerende.getStudieNr(), studerende);
    }

    public void removeStuderende(Studerende studerende) {
            studerendes.remove(studerende);
    }

    public double gennemsnit() {
        double sum = 0;
        for (Studerende studerende : studerendes.values()) {
            sum += studerende.getKarakterergns();
        }
        return sum / studerendes.size();
    }

    public Studerende findStuderende(int studieNr) {
        for (Studerende studerende : studerendes.values()) {
            if (studerende.getStudieNr() == studieNr) {
                return studerende;
            }
        }
        return null;
    }

}

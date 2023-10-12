package opgave2;

import java.util.ArrayList;
import java.util.List;

public class Studerende {
    private int studieNr;
    private String navn;

   private List<Integer> karakterer;




    public Studerende(int studieNr, String navn, List<Integer> karakterer) {
        this.studieNr = studieNr;
        this.navn = navn;
        this.karakterer = karakterer;
    }

    public int getStudieNr() {
        return studieNr;
    }

    public String getNavn() {
        return navn;
    }

    public List<Integer> getKarakterer() {
        return karakterer;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }


    public void addKarakter(int karakter) {
        if (!karakterer.contains(karakter)) {
            karakterer.add(karakter);
        }
    }

    @Override
    public String toString() {
        return "Studerende{" +
                "studieNr=" + studieNr +
                ", navn='" + navn + '\'' +
                ", karakterer=" + karakterer +
                '}';
    }


    public double getKarakterergns() {
        double sum = 0;
        for (int karakter : karakterer) {
            sum += karakter;
        }
        return sum / karakterer.size();
    }
}

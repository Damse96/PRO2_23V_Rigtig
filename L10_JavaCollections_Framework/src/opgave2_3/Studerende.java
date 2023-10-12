package opgave2_3;

import java.util.HashSet;

public class Studerende {
    private int studieNr;
    private String navn;

   private HashSet<Integer> karakterer;




    public Studerende(int studieNr, String navn, HashSet<Integer> karakterer) {
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

    public HashSet<Integer> getKarakterer() {
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

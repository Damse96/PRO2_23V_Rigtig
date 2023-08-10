public class opgave2 {

    //Har nissen ret, og hvor mange øl kan man i øvrigt få for 8000 kr.?

    //

    //1333 øl

    private double prisPRDåse = 7;
    private double pantPRDåse = 1;

    public static void main(String[] args) {

        System.out.println(købØl(8000, 8000));
        System.out.println(1142 + 164 + 23 + 3 + 1);
    }


    public static int købØl(int antalDåser, int pengeAtKøbeFor) {
        int antalØl = 0;
        if (pengeAtKøbeFor + antalØl > 7){
            return 0;
        }
        antalØl = (pengeAtKøbeFor + antalDåser)/7;
        int pengeTilbage = pengeAtKøbeFor%7;
        antalØl = købØl(pengeTilbage, antalØl);
        return antalØl;
    }

    1142,85714 (6)
    164
    23,4285714 (3)
    3 (5)
    1 (1)







}

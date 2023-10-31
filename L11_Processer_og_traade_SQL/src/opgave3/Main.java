package opgave3;

public class Main {
    public static void main(String[] args) {
        //del 1.
        //Generere X tilfældige lottorækker og indsætte disse i en collection (X sættes til
        //10.000.000)
        int X = 10000000;
        Lottoraek[] lottoraekker = new Lottoraek[X];
        for (int i = 0; i < X; i++) {
            lottoraekker[i] = new Lottoraek();
        }
        //del 2.
        //Generere en tilfældig lottorække. Denne lottorække skal symbolisere trækningen (dvs.
        //de 7 rigtige lottotal)
        Lottoraek trakning = new Lottoraek();
        //del 3.
        //Kontrollere de X lottorækker og tælle hvor mange rækker der er med 0, 1, .. 7 rigtige.
        //Dette step skal være omkranset af en tidsmåling, så man kan se, hvor lang tid dette
        //step tager.
        int[] antalRigtige = new int[8];
        long start = System.currentTimeMillis();

        //del 4.
        //Der udskriver hvor mange rækker der er med 0, 1...7 rigtige. Der udskrives det sam-
        //lede antal kontrollerede rækker (skal være sum af ovenstående tal). Resultatet af
        //tidsmålingen fra step 3 udskrives også
        for (int i = 0; i < X; i++) {
            int rigtige = lottoraekker[i].antalrigtige(trakning);
            antalRigtige[rigtige]++;
        }
        long end = System.currentTimeMillis();
        for (int i = 0; i < antalRigtige.length; i++) {
            System.out.println("Der er " + antalRigtige[i] + " rækker med " + i + " rigtige");
        }

        System.out.println("Der er i alt " + X + " rækker");
        System.out.println("Det tog " + (end - start) + " millisekunder at køre programmet");
        System.out.println("Det tog " + (end - start) / 1000 + " sekunder at køre programmet");
    }
}

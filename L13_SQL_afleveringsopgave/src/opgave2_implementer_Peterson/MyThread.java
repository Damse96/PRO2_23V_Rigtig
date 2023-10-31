package opgave2_implementer_Peterson;

public class MyThread extends Thread {
    private String navn;

   private Faelles faelles;

    public MyThread(String navn, Faelles faelles) {
        this.navn = navn;
        this.faelles = faelles;
    }

    public void run() {
        int i = 0;
        while (i < 100){
            faelles.tagerRandomTid(10);
            Main.setFlag(0, true);
            Main.setTurn(1);
            while (Main.getFlag(1) && Main.getTurn() == 1) {
                // busy wait
            }
            faelles.kritiskSection(10);
            Main.setFlag(0, false);
            i++;

        }
        System.out.println("den fælles tæller " + faelles.getGlobal());
    }
}
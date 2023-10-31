package opgave2_implementer_Peterson;

public class MyThread2 extends Thread{

    private String navn;

    private Faelles faelles;

    public MyThread2(String navn, Faelles faelles) {
        this.navn = navn;
        this.faelles = faelles;
    }

    public void run() {
        int i = 0;
        while (i< 100){
            faelles.tagerRandomTid(10);
            Main.setFlag(1, true);
            Main.setTurn(0);
            while (Main.getFlag(0) && Main.getTurn() == 0) {
                // busy wait
            }
            faelles.kritiskSection(10);
            Main.setFlag(1, false);
            i++;
        }
        System.out.println("den fælles tæller" + faelles.getGlobal());
    }


}


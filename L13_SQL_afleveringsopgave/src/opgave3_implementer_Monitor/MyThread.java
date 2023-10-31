package opgave3_implementer_Monitor;

public class MyThread extends Thread {
    private String navn;

    Faelles faelles;

    public MyThread(String navn, Faelles faelles) {
        this.navn = navn;
        this.faelles = faelles;
    }

    public void run() {
        for (int j = 0; j < 100; j++) {
            faelles.kritiskSection(100);
            faelles.tagerRandomTid(100);
        }
        System.out.println("den fælles tæller" + faelles.getGlobal());
    }
}
package opgave4_implementer_Semafor;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Faelles {

    private Semaphore semafor = new Semaphore(1);
    private int global = 0;

    public Faelles() {
        this.global = 0;
    }

    public void tagerRandomTid(int max) {
        Random r = new Random();
        int nyMax = Math.abs(r.nextInt()) % max + 1;
        for (int i = 0; i < nyMax; i++) {
            for (int j = 0; j < nyMax; j++) {
                int t = r.nextInt() * r.nextInt();
            }
        }
    }


    public void kritiskSection(int max) {
        try {
            semafor.acquire();
        int temp;
        temp = global;
        tagerRandomTid(100);
        global = temp + 1;
        semafor.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getGlobal() {
        return global;
    }
}

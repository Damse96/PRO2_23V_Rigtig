package opgave3_implementer_Monitor;

import java.util.Random;

public class  Faelles {
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


    public synchronized void kritiskSection(int max) {
        int temp;
        temp = global;
        tagerRandomTid(100);
        global = temp + 1;
    }

    public int getGlobal() {
        return global;
    }
}

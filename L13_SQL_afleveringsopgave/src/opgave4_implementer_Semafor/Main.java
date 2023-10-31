package opgave4_implementer_Semafor;

public class Main {
    public static void main(String[] args) {
        Faelles f = new Faelles();
        MyThread t1 = new MyThread("tråd 1", f);
        MyThread t2 = new MyThread("tråd 2", f);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tæller: " + f.getGlobal());

    }
}

package Opgaver.Opgave2;

public class AnvendCounter {

    public static void main(String[] args) {
        Counter.getInstance().count();
        System.out.println(Counter.getInstance().getValue());
        Counter.getInstance().times2();
        System.out.println(Counter.getInstance().getValue());
        Counter.getInstance().zero();
        System.out.println(Counter.getInstance().getValue());
    }
}

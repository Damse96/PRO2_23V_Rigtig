package opgaver;

public class opgave4 {
    public static void flyt(int n, int fra, int til){
        int ringe = 0;
        if (n==1) {
            System.out.println("Flyt fra " +fra +" til " + til);

        }
        else {
            int temp = 6 - fra - til;
            flyt(n-1,fra,temp);
            System.out.println("Flyt fra " + fra +" til " + til);
            flyt(n-1,temp,til);
        }
    }

    // det skal give en formel der hedder 2^n - 1
    public static void main(String[] args) {
        flyt(4,1,3);

    }
}

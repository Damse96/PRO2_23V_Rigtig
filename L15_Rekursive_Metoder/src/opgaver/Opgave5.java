package opgaver;

public class Opgave5 {

    public static void main(String[] args) {
        System.out.println(sfd(6, 10));
    }
    public static int sfd(int a, int b){
        int result = 0;
        if (b <= a && a % b == 0){
            result = b;
        } else if (a < b){
            result = sfd(b,a);
        } else {
            result = sfd(b, a%b);
        }
        return result;
    }
}

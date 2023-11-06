package opgaver;

import java.security.DrbgParameters;

public class opgave2 {

    public static void main(String[] args) {
        System.out.println("2^3 = " + power(2,3));
        System.out.println("2^3 = " + power2(2,3));
    }
    public static int power(int n, int p){
        int result = 0;
        if (p == 0) {
            result = 1;
        } else {
            result = n * power(n, p-1);
        }
        return result;
    }


    public static int power2(int n, int p){
        int result = 0;
        if (p == 0){
            result = 1;
        } else if (p % 2 == 0){
            result = power2(n * n , p/2);
        } else {
            result = n * power2(n, p-1);
        }
        return result;
    }
}

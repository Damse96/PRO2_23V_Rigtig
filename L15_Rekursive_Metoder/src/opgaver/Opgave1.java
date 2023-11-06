package opgaver;

public class Opgave1 {
    public static int factorial(int n){
        int result = 0;
        if (n == 0) {
            result = 1;
        } else {
            result = n * factorial(n-1);
        }
        return result;
    }
}

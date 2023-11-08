package opgaver;

public class opgave6 {
    // måden opgave 6 løses er ved fibunacci rekursion
    // så formlen bliver fib(n) = fib(n-1) + fib(n-2)

    public static int domino(int n) {
        int result = 0;
        if (n <= 2) {
            result = n;
        } else {
            result = domino(n - 1) + domino(n - 2);
        }
        return result;
    }
}

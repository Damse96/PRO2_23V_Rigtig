package opgaver;

public class Opgave3 {

    public static void main(String[] args) {
        System.out.println("2*3 = " + product(19,3));
        System.out.println("2*3 = " + productRus(3,19));
    }
    public static int product(int a, int b){
        int result = 0;
        if (a == 0){
            result = 0;
        } else {
            result = b + product(a - 1,b);
        }
        return result;
    }


    public static int productRus(int a, int b){
        int result = 0;
        if (a == 0){
            result = 0;
        } else if(a % 2 == 0) {
            result = productRus(a / 2 , b+b);
        } else {
            result = productRus(a-1,b) + b;
        }
        return result;
    }
}

package opgaver;

public class opgave4 {

    public static void main(String[] args) {
        System.out.println(reverse("RANSLIRPA"));
    }
    public static String reverse(String s){
        String result = "";
        if (s.isEmpty()){
            result = "";
        } else{
            result = String.valueOf(s.charAt((s.length()-1))) + reverse(s.substring(0, s.length() - 1));
        }
        return result;
    }
}

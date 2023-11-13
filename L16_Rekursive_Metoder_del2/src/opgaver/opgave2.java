package opgaver;

public class opgave2 {


    public static boolean palindrom(String tekst) {
        return palindrom(tekst.toCharArray(),0,tekst.length()-1);
    }


    private static boolean palindrom(char[] tekst, int start, int slut) {
        if (slut - start < 1){
            return true;
        } else if (tekst[start] == tekst[slut]){
            return palindrom(tekst,start + 1, slut - 1 );
        }
        return false;
    }


}

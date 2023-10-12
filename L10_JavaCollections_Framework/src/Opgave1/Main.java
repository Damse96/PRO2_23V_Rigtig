package Opgave1;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //1)Tilføj til main erklæring og oprettelse af en mængde baseret på et HashSet.
        //        Mængden skal indeholde heltal.

        HashSet<Integer> heltTal = new HashSet<Integer>();

        heltTal.add(32);
        heltTal.add(12);
        heltTal.add(23);
        heltTal.add(45);
        heltTal.add(67);
        heltTal.add(34);
        heltTal.add(98);


        System.out.println(heltTal);

        heltTal.add(23);

        System.out.println(heltTal);

        heltTal.remove(67);

        System.out.println(heltTal);

        System.out.println(heltTal.size());
        //2) Indsæt tallene 34,12,23,45,67,34,98 i mængden.
        //3) Udskriv indholdet af mængden.
        //4) Indsæt tallet 23 i mængden.
        //5) Udskriv indholdet af mængden.
        //6) Fjern elementet 67 fra mængden.
        //7) Udskriv indholdet af mængden.
        //8) Undersøg om mængden indeholder elementet 23
        //9) Udskriv hvor mange elementer der er i mængden
    }
}

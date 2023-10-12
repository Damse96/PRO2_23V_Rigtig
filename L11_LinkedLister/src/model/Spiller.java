package model;

import java.util.ArrayList;

public class Spiller {
    private String navn;
    private String uddannelse;

    private final ArrayList<Booking> bookinger = new ArrayList<>();

    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    public String getNavn() {
        return navn;
    }

    public String getUddannelse() {
        return uddannelse;
    }

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }

    public void removeBooking(Booking booking) {
        if (bookinger.contains(booking)) {
            bookinger.remove(booking);
        }
    }

    public int samletPris(Kategori kategori) {
            int sum = 0;
            for (Booking booking : bookinger) {
                sum += kategori.getPrisKrDouble()+ kategori.getPrisKrSingle();
            }
            return sum;

    }

}

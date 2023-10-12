package storage;

import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Spiller> spillere = new ArrayList<>();
    private static ArrayList<Bane> baner = new ArrayList<>();
    private static ArrayList<Kategori> kategorier = new ArrayList<>();

    private static ArrayList<Booking> bookinger = new ArrayList<>();

    public static ArrayList<Spiller> getSpillere() {
        return spillere;
    }

    public static ArrayList<Bane> getBaner() {
        return baner;
    }

    public static ArrayList<Kategori> getKategorier() {
        return kategorier;
    }

    public static ArrayList<Booking> getBookinger() {
        return bookinger;
    }

    public static void addSpiller(Spiller spiller) {
        spillere.add(spiller);
    }

    public static void addBane(Bane bane) {
        baner.add(bane);
    }

    public static void addKategori(Kategori kategori) {
        kategorier.add(kategori);
    }

    public static void addBooking(Booking booking) {
        bookinger.add(booking);
    }

}

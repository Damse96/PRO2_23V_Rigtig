package controller;

import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Spiller opretSpiller(String navn, String uddannelse) {

        Spiller spiller = new Spiller(navn, uddannelse);

        Storage.addSpiller(spiller);

        return spiller;
    }

    public static ArrayList<Spiller> getSpillere() {
        return Storage.getSpillere();
    }

    public static Kategori opretKategori(String navn, int prisKrSinge, int prisKrDouble) {

        Kategori kategori = new Kategori(navn, prisKrSinge, prisKrDouble);

        Storage.addKategori(kategori);

        return kategori;
    }

    public static ArrayList<Kategori> getKategorier() {
        return Storage.getKategorier();
    }

    public static Bane opretBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {

        Bane bane = new Bane(nummer, inde, førsteTid, sidsteTid, kategori);

        Storage.addBane(bane);

        return bane;
    }

    public static ArrayList<Bane> getBaner() {
        return Storage.getBaner();
    }

    public static Booking opretBooking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller, Bane bane) {

        Booking booking = new Booking(dato, tid, single, spiller, bane);

        Storage.addBooking(booking);

        return booking;
    }

    public static ArrayList<Booking> getBookinger() {
        return Storage.getBookinger();
    }

    public static void initStorage() {

        Kategori luksus = Controller.opretKategori("Luksus", 100, 200);
        Kategori mellem = Controller.opretKategori("Mellem", 50, 100);
        Kategori begynder = Controller.opretKategori("Begynder", 25, 50);

        Bane bane1 = Controller.opretBane(1, true, LocalTime.of(9, 0), LocalTime.of(17, 0), luksus);
        Bane bane2 = Controller.opretBane(2, true, LocalTime.of(9, 0), LocalTime.of(17, 0), luksus);
        Bane bane3 = Controller.opretBane(3, true, LocalTime.of(9, 0), LocalTime.of(17, 0), mellem);
        Bane bane4 = Controller.opretBane(4, false, LocalTime.of(9, 0), LocalTime.of(17, 0), mellem);
        Bane bane5 = Controller.opretBane(5, false, LocalTime.of(9, 0), LocalTime.of(17, 0), begynder);
        Bane bane6 = Controller.opretBane(6, false, LocalTime.of(9, 0), LocalTime.of(17, 0), begynder);

        Spiller spiller1 = Controller.opretSpiller("Andreas", "DMU");
        Spiller spiller2 = Controller.opretSpiller("Petra", "DMU");
        Spiller spiller3 = Controller.opretSpiller("Henrik", "ITA");
        Spiller spiller4 = Controller.opretSpiller("Ulla", "ITA");

        Booking booking1 = Controller.opretBooking(LocalDate.of(2023, 6, 20), LocalTime.of(10, 0), true, spiller1, bane3);
        Booking booking2 = Controller.opretBooking(LocalDate.of(2023, 6, 22), LocalTime.of(10, 0), false, spiller1, bane2);
        Booking booking3 = Controller.opretBooking(LocalDate.of(2023, 6, 20), LocalTime.of(11, 0), false, spiller3, bane3);
        Booking booking4 = Controller.opretBooking(LocalDate.of(2023, 6, 20), LocalTime.of(16, 0), false, spiller4, bane3);
        Booking booking5 = Controller.opretBooking(LocalDate.of(2023, 6, 23), LocalTime.of(17, 0), true, spiller4, bane5);

    }


    }


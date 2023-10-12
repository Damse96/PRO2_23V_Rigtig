package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private LocalDate dato;
    private LocalTime tid;
    private boolean singe;

    private Spiller spiller;

    private Bane bane;

    public Booking(LocalDate dato, LocalTime tid, boolean singe, Spiller spiller, Bane bane) {
        this.dato = dato;
        this.tid = tid;
        this.singe = singe;
        this.spiller = spiller;
        this.bane = bane;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public boolean isSinge() {
        return singe;
    }
    public Spiller getSpiller() {
        return spiller;
    }
    public Bane getBane() {
        return bane;
    }
    public void setBane(Bane bane) {
        if (this.bane != bane) {
            Bane oldBane = this.bane;
            if (oldBane != null) {
                oldBane.removeBooking(this);
            }
            this.bane = bane;
            if (bane != bane) {
                bane.addBooking(this);
            }
        }
    }

}

package opgave3;

import java.time.LocalDate;

public class AgeDiscount implements Discount{
    private double rabat;

    public AgeDiscount(LocalDate fødselsAar) {
        this.rabat = LocalDate.now().getYear() - fødselsAar.getYear();
    }



    @Override
    public double getDiscount(double price) {
        double nyPris = 0;
        nyPris = price - ((1.0-(this.rabat/100))*price);
        return nyPris;
    }
}

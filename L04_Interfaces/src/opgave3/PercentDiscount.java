package opgave3;

public class PercentDiscount implements Discount {
    private int discountPercent;

    public PercentDiscount(int discountPercent) {
        //super();
        this.discountPercent = discountPercent;
    }

    @Override
    public double getDiscount(double price) {
        return price * discountPercent / 100;
    }
}

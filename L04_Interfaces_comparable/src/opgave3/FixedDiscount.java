package opgave3;

public class FixedDiscount implements Discount {
    private int fixedDiscount;
    private int discountLimit;

    public FixedDiscount(int fixedDiscount, int discountLimit) {
        //super();
        this.fixedDiscount = fixedDiscount;
        this.discountLimit = discountLimit;
    }

    @Override
    public double getDiscount(double price) {
        if (price > discountLimit) {
            return fixedDiscount;
        } else {
            return 0;
        }
    }
}

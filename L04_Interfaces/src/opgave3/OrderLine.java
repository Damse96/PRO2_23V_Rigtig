package opgave3;

public class OrderLine {
    private int lineNumber;
    private int count;
    // Oneway Association -> *..1 Product
    private Product product;

    public OrderLine(int lineNumber, int count, Product product) {
        this.lineNumber = lineNumber;
        this.count = count;
        this.product = product;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getCount() {
        return this.count;
    }

    public Product getProduct() {
        return product;
    }

    public double getOrderLinePrice() {
        return count * product.getUnitPrice();
    }
}

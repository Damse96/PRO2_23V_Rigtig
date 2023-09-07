package opgave3;

public class Product {
    private int number;
    private String name;
    private double unitPrice;

    public Product(int number, String name, double unitPrice) {
        this.number = number;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public void setName() {
        this.name = name;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}

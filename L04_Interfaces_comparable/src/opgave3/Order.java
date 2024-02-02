package opgave3;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    // Oneway Association -> 0..* OrderLine
    private ArrayList<OrderLine> orderLines = new ArrayList<>();

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.orderLines = new ArrayList<>();
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void createOrderLine(int count, Product product) {
        OrderLine orderLine = new OrderLine(orderLines.size() + 1, count, product);
        orderLines.add(orderLine);
    }

    public ArrayList<OrderLine> getOrderLines() {
        return new ArrayList<OrderLine>(orderLines); // Returnerer en reference til ArrayListen
    }

    public double getOrderPrice() {
        double orderPrice = 0;
        for (OrderLine orderLine : orderLines) {
            orderPrice += orderLine.getOrderLinePrice();
        }
        return orderPrice;
    }
}

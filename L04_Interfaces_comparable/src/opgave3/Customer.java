package opgave3;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    private String name;
    private LocalDate birthDate;
    // Oneway Association -> 0..* Order
    private ArrayList<Order> orders = new ArrayList<>();

    public Customer(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public ArrayList<Order> getOrders() {
        return new ArrayList<Order>(orders); // Returnerer en reference til ArrayListen
    }

    public void addOrder(Order order) {
        if (!orders.contains(order)) {
            orders.add(order);
        }
    }

    public void removeOrder(Order order) {
        if (orders.contains(order)) {
            orders.remove(order);
        }
    }

    public double totalBuy() {
        double totalBuy = 0;
        for (Order order : orders) {
            totalBuy += order.getOrderPrice();
        }
        return totalBuy;
    }

    public double totalBuyWithDiscount(Discount discount) {

        double discountAmount = discount.getDiscount(totalBuy());

        return totalBuy() - discountAmount;
    }
}

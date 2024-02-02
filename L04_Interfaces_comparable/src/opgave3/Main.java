package opgave3;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        Customer customer1 = new Customer("John", LocalDate.of(1990, 1, 1));
        Customer customer2 = new Customer("Jane", LocalDate.of(1995, 1, 1));

        customers.add(customer1);
        customers.add(customer2);

        Product product1 = new Product(1, "Bread", 10);
        Product product2 = new Product(2, "Milk", 15);
        Product product3 = new Product(3, "Butter", 20);
        Product product4 = new Product(4, "Cheese", 25);
        Product product5 = new Product(5, "Ham", 30);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        Order order1 = new Order(1);

        order1.createOrderLine(1, product1);
        order1.createOrderLine(2, product2);

        Order order2 = new Order(2);

        order2.createOrderLine(3, product3);
        order2.createOrderLine(4, product4);

        Order order3 = new Order(3);

        order3.createOrderLine(5, product5);
        order3.createOrderLine(6, product1);

        Order order4 = new Order(4);

        order4.createOrderLine(7, product2);
        order4.createOrderLine(8, product3);

        Order order5 = new Order(5);

        order5.createOrderLine(9, product4);
        order5.createOrderLine(10, product5);

        Order order6 = new Order(6);

        order6.createOrderLine(11, product1);
        order6.createOrderLine(12, product2);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);

        customer1.addOrder(order1);
        customer1.addOrder(order2);

        customer2.addOrder(order3);
        customer2.addOrder(order4);
        customer2.addOrder(order5);
        customer2.addOrder(order6);

        Discount percentDiscount = new PercentDiscount(15); // 15% rabat
        Discount fixedDiscount = new FixedDiscount(250, 1000); // 250 kr. rabat ved køb over 1000 kr// .
        AgeDiscount ageDiscount = new AgeDiscount(LocalDate.ofYearDay(1996, 21));

        System.out.println("Customer 1 total buy without discount: " + customer1.totalBuy());
        System.out.println("Customer 1 total buy with 15% discount: " + customer1.totalBuyWithDiscount(percentDiscount));
        System.out.println();
        System.out.println("Customer 2 total buy without discount: " + customer2.totalBuy());
        System.out.println("Customer 2 total buy with fixed discount of 250: " + customer2.totalBuyWithDiscount(fixedDiscount));
        System.out.println(customer2.totalBuyWithDiscount(ageDiscount));
    }
}

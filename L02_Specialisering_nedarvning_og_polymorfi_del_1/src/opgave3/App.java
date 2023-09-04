package opgave3;

import Opgave1.Main;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        Product product1 = new Product(2,"Anders", 200);
        Product product2 = new Product(1,"mads",10);
        Product product3 = new Product(3,"Minik", 50);
        Product product4 = new Product(4,"Thor",300);
        Product product5 = new Product(5,"Majken", 15);
        Customer customer1 = new Customer("Madser", LocalDate.of(2020,9,21));
        Customer customer2 = new Customer("Anne-Sophie", LocalDate.of(2000,8,15));

    }
}

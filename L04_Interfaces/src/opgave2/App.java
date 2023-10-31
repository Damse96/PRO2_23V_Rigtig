package opgave2;

import java.util.*;

public class App {
    public static void main(String[] args) {


        Customer[] customers = new Customer[5];

        Customer c1 = new Customer("Anders", "Dam", 26);
        Customer c2 = new Customer("Caroline", "Madsen", 23);
        Customer c3 = new Customer("Mette", "Andersen", 22);
        Customer c4 = new Customer("Minik", "jensen", 30);
        Customer c5 = new Customer("Anders", "Klejnstrup", 27);

        customers[0] = c1;
        customers[1] = c2;
        customers[2] = c3;
        customers[3] = c4;
        customers[4] = c5;


        List list = Arrays.asList(customers);
        Collections.sort(list);
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public static Customer lastCustomer(Customer[] customers) {
        Customer c = customers[0];
        for (int i = 1; i < customers.length; i++) {
            if (customers[i].compareTo(c) > 0) {
                c = customers[i];
            }

        }
        return c;

    }

    public static Customer[] afterCustomer(Customer[] Listcustomers,
                                           Customer customer) {
        Customer[] customers = null;
        Customer temp = customer;
        int størreEndAntal = 0;
        for (int i = 0; i <customers.length ; i++) {
            if (Listcustomers[i].compareTo(customer) > 0){
                størreEndAntal++;
            }
        }
        customers = new Customer[størreEndAntal];
        for (int i = 0; i < customers.length; i++) {
            if (Listcustomers[i].compareTo(customer) > 0){
                customers[i] =Listcustomers[i];
                System.out.println(Listcustomers[i].compareTo(customer));
            }
        }
        return customers;
    }
}

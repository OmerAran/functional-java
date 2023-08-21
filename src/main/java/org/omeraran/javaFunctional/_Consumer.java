package org.omeraran.javaFunctional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        Customer customer = new Customer("Maria", 555_444_33_22L);
        // Normal Java Function
        greetingCustomer(customer);
        // Consumer Function
        greetingCustomerConsumer.accept(customer);
        //BiConsumer Function
        greetingCustomerConsumerV2.accept(customer, false);
    }

    static void greetingCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", Your Phone Number is : " + customer.phoneNumber);
    }

    static Consumer<Customer> greetingCustomerConsumer =
            customer -> System.out.println("Hello " + customer.customerName +
                    ", Your Phone Number is : " + customer.phoneNumber);

    static BiConsumer<Customer, Boolean> greetingCustomerConsumerV2 =
            (customer, showCustomerPhoneNumber) -> System.out.println("Hello " + customer.customerName +
                    ", Your Phone Number is : " + (showCustomerPhoneNumber ? customer.phoneNumber : "**********"));

    static class Customer {
        private String customerName;
        private Long phoneNumber;

        public Customer(String customerName, Long phoneNumber) {
            this.customerName = customerName;
            this.phoneNumber = phoneNumber;
        }
    }
}

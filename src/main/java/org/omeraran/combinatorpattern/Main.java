package org.omeraran.combinatorpattern;

import java.time.LocalDate;

import static org.omeraran.combinatorpattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "omeraran@omeraran.co",
                "05554443322",
                LocalDate.of(2001, 11, 10));

        CustomerRegistrationValidator.ValidationResult validationResult = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);
        System.out.println(validationResult);

        if (validationResult != SUCCESS) {
            throw new IllegalStateException(validationResult.name());
        }

    }
}

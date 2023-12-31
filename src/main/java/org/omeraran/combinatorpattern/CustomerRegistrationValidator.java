package org.omeraran.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static org.omeraran.combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator
        extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> (customer.getPhoneNumber().startsWith("0")
                            && customer.getPhoneNumber().length() == 11) ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAnAdult() {
        return customer -> Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears() >= 18 ?
                SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
          ValidationResult result = this.apply(customer);
          return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        EMAIL_NOT_VALID,
        PHONE_NUMBER_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}

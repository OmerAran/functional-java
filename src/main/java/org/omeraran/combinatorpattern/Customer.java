package org.omeraran.combinatorpattern;

import java.time.LocalDate;

public class Customer {

    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    public Customer(String email, String phoneNumber, LocalDate dateOfBirth) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}

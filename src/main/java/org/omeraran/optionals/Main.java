package org.omeraran.optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional.ofNullable("hello")
                .ifPresent(System.out::println);

        Optional.ofNullable("omeraranofficial@gmail.com")
                .ifPresentOrElse(mail -> System.out.println("sending mail to " + mail), ()-> System.out.println("Cannot send mail"));
    }
}

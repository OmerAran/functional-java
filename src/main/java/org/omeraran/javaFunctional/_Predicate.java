package org.omeraran.javaFunctional;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        //Normal Java Functions
        System.out.println(isPhoneNumberValidAndContains3("05555555553"));
        //Java Functional Interface : Predicate
        System.out.println(isPhoneNumberValidPredicate.and(isContains3).test("05555555555"));
    }
    public static boolean isPhoneNumberValidAndContains3(String phoneNumber) {
        return ((phoneNumber.startsWith("05") && phoneNumber.length()==11) && phoneNumber.contains("3"));
    }

    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> ((phoneNumber.startsWith("05") && phoneNumber.length()==11) && phoneNumber.contains("3"));

    static Predicate<String> isContains3 = phoneNumber -> phoneNumber.contains("3");
}

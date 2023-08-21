package org.omeraran.streams;

import java.util.List;
import java.util.stream.Collectors;

import static org.omeraran.streams._Stream.Gender.*;


public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Ömer", MALE),
                new Person("Güneş", FEMALE),
                new Person("Azer", MALE),
                new Person("Theo", MALE),
                new Person("İlyas", PREFER_NOT_TO_SAY)
        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        boolean allPeopleFemale = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));
        System.out.println(allPeopleFemale);

        boolean isThereAnyPreferNotToSayGender = people.stream()
                .anyMatch(person -> PREFER_NOT_TO_SAY.equals(person.gender));
        System.out.println(isThereAnyPreferNotToSayGender);


    }


    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}

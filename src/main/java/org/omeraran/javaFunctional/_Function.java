package org.omeraran.javaFunctional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        // Function  : it takes a parameter and produces a result.
        int number = 1;
        int increment = incrementByOne(number);
        System.out.println(increment);

        int incrementByFunction = incrementByOneFunction.apply(number);
        System.out.println(incrementByFunction);

        Function<Integer, Integer> addOneThanMultiplyBy10 = incrementByOneFunction.andThen(multiplytBy10Function);
        System.out.println(addOneThanMultiplyBy10.apply(number));

        // BiFunction  : it takes two parameters and produces a result.
        System.out.println(incrementOneAndMultiplyBiFunction.apply(number, 5)); //output : 10;
        System.out.println(incrementOneAndMultiply(number, 5)); // normal way

    }

    static int incrementByOne(int number) {
        return number+1;
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> multiplytBy10Function = number -> number * 10;

    static int incrementOneAndMultiply(int number, int multiplyBy) {
        return (number + 1) * multiplyBy;
    }
    static BiFunction<Integer, Integer, Integer> incrementOneAndMultiplyBiFunction =
            (number, numberToMultiplyBy) ->
                    (number + 1) * numberToMultiplyBy;

}
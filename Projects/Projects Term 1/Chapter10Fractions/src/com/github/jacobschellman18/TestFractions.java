package com.github.jacobschellman18;

import com.github.jacobschellman18.utils.Fraction;

/**
 * This is a test class for the com.github.jacobschellman18.utils.Fraction class
 * Author: Blair
 */

public class TestFractions {
    private static void testConstructors() {
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction(7);
        Fraction f3 = new Fraction(12, -20);
        Fraction f4 = new Fraction(f3);

        System.out.println("f1 = " + f1); //auto invokes .toString()
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);
        System.out.println("f4 = " + f4);
        System.out.println();
    }

    private static void testArithmetic() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction f3 = new Fraction(4, 5);
        Fraction f4 = new Fraction(2, 5);

        Fraction sum = f1.add(f2); //F1 (this) is implicit, F2 (other) is explicit.
        System.out.println(f1 + " + " + f2 + " = " + sum);

        sum = f1.add(30);
        System.out.println(f1 + " + 30 = " + sum);

        Fraction difference = f3.subtract(f4);
        System.out.println(f3 + " - " + f4 + " = " + difference);

        difference = f1.subtract(30);
        System.out.println(f1 + " - 30 = " + difference);

        Fraction product = f1.multiply(f2);
        System.out.println(f1 + " * " + f2 + " = " + product);

        product = f1.multiply(30);
        System.out.println(f1 + " * 30 = " + product);

        Fraction quotient = f3.divide(f4);
        System.out.println(f3 + " / " + f4 + " = " + quotient);

        quotient = f3.divide(30);
        System.out.println(f3 + " / 30 = " + quotient);

        System.out.println();
    }

    private static void testValues() {
        Fraction f = new Fraction(2, 3);
        System.out.println(f + " = " + f.getValue());
        System.out.println();
    }

    public static void main(String[] args) {
        testConstructors();
        testArithmetic();
        testValues();
    }
}

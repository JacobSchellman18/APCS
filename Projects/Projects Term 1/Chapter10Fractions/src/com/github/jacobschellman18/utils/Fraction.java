package com.github.jacobschellman18.utils;

/**
 * This is an example of a robust class - something that doesn't break
 *
 * Represents a fraction with an int numerator and int denominator
 * and provides methods for adding and multiplying fractions.
 * <p>
 * Author: Alex
 */

public class Fraction {

    /******************  Instance variables  ******************/

    private int num;
    private int denom;

    /*********************  Constructors  *********************/

    public Fraction() { // default no-args constructor
        num = 0;
        denom = 1;
    }
    public Fraction(int n) {
        num = n;
        denom = 1;
    }
    public Fraction(int n, int d) {
        if (d != 0) {
            num = n;
            denom = d;
            reduce();
        } else {
            throw new IllegalArgumentException("com.github.jacobschellman18.utils.Fraction construction error: denominator is 0");
        }
    }
    public Fraction(Fraction other) { // copy constructor
        num = other.num;
        denom = other.denom;
    }

    /********************  Public methods  ********************/

    public Fraction add(Fraction other) {
        // Returns the sum of this fraction and other
        int newNum = num * other.denom + denom * other.num;
        int newDenom = denom * other.denom;
        return new Fraction(newNum, newDenom);
    }
    public Fraction add(int m) {
        // Returns the sum of this fraction and m
        return new Fraction(num + m * denom, denom);
    }
    public Fraction subtract(Fraction other) {
        // Returns the difference of this fraction and other
        int newNum = num * other.denom - denom * other.num;
        int newDenom = denom * other.denom;
        return new Fraction(newNum, newDenom);
    }
    public Fraction subtract(int m) {
        // Returns the sum of this fraction and m
        return new Fraction(num - m * denom, denom);
    }
    public Fraction multiply(Fraction other) {
        // Returns the product of this fraction and other
        int newNum = num * other.num;
        int newDenom = denom * other.denom;
        return new Fraction(newNum, newDenom);
    }
    public Fraction multiply(int m) {
        // Returns the product of this fraction and m
        return new Fraction(num * m, denom);
    }
    public Fraction divide(Fraction other) {
        // Returns the product of this fraction and other
        int newNum = num / other.num;
        int newDenom = denom / other.denom;
        return new Fraction(newNum, newDenom);
    }
    public Fraction divide(int m) {
        // Returns the product of this fraction and m
        return new Fraction(num / m, denom);
    }
    public double getValue() {
        // Returns the value of this fraction as a double
        return (double) num / (double) denom;
    }
    public String toString() {
        // Returns a string representation of this fraction
        // @Override
        return num + "/" + denom;
    }

    /*******************  Private methods  ********************/

    private void reduce() {
        // Reduces this fraction by the gcf and makes denom > 0

        if (num == 0) {
            denom = 1;
            return;
        }

        if (denom < 0) {
            num = -num;
            denom = -denom;
        }

        int q = gcf(Math.abs(num), denom);
        num /= q;
        denom /= q;
    }
    private int gcf(int n, int d) {
        /* Returns the greatest common factor of two positive integers
        Check gcf explication */
        if (n <= 0 || d <= 0) {
            throw new IllegalArgumentException("gcf precondition failed: " + n + ", " + d);
        }

        while (d != 0) { // While the denominator isn't 0
            int temp = d; // create a temporary variable = to d
            d = n % d; // set d = to the remainder of numerator / denominator
            n = temp; // set n equal to temp (which is equal to d before it was updated)
        }
        return n;
    }
}

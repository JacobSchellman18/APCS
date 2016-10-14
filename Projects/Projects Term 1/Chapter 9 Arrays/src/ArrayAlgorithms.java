import java.io.*;
import java.util.Scanner;

/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own - JCS
 * Date of Completion:  eg. 9/27/2016
 * Assignment:  egs. Ch9 Arrays
 *
 * Attribution: Evan McKenna, Patrick Rahiya, Paul Plaia
 *
 * General Description: This code changes and returns arrays in a number of different ways.
 *
 * Advanced:
 *  A user input system that checks for invalid inputs
 *  An output system that displays the data in a easily readable format
 *  The use of a lot of built in Java API methods to more efficiently handle a few arrays (with the original solution next to them)
 *
 * Errata:
 *  I changed some of the return types (void -> int[]) on some methods for easier output.
 **/

public class ArrayAlgorithms {
    /**
     * Pre: The array is not null
     * Post: All array slots are filled with numbers from 1-100
     * @param a an int array that will be filled with random integers from 1-100
     * @return An int array filled with random numbers
     **/
    private static int[] fillRandom(int[] a) {
        for (int i = 0; i < a.length; i++) a[i] = (int) ((Math.random() * 100) + 1);
        return a;
    }
    /**
     * Pre: The array is not null
     * Post: All array slots are filled in ascending order from 0 to length-1
     * @param a an int array that will be filled with integers from 0 to length-1 in ascending order
     * @return An int array that is filled in ascending order from 0 to length-1
     **/
    private static int[] fillInOrder(int[] a) {
        for (int i = 0; i < a.length; i++) a[i] = i;
        return a;
    }
    /**
     * Pre: The array is not null
     * Post: All array slots are filled in ascending order from 0 to length-1 + x
     * @param a an int array that will be filled with integers from 0 to length-1 + x in ascending order
     * @param x an integer that will be added to each array slot
     * @return An int array that is filled in ascending order from 0 to length-1 + x
     **/
    private static int[] fillInOrder(int[] a, int x) {
        for (int i = 0; i < a.length; i++) a[i] = i + x;
        return a;
    }
    /**
     * Pre: The array is not null
     * @param a an int array to be translated into a string
     * @return A string that represents the original array but formatted nicely
     **/
    private static String arrayToString(int[] a) {
        String s = "[";
        for (int i = 0; i < a.length - 1; i++) s = s + a[i] + ", ";
        s = s + a[a.length - 1] + "]";
        return s;
    }
    /**
     * Pre: The array is not null
     * @param a an int array that will be added to one integer
     * @return An int that represents the summation of the entire array
     **/
    private static int sum(int[] a) {
        int s = 0;
        for (int i : a) s += i;
        return s;
    }
    /**
     * Pre: The array is not null
     * @param a an int array that will be searched for any targets
     * @param target an int representing the number to be found in the array
     * @return An int the position of the target in the array, -1 if not found
     **/
    private static int find(int[] a, int target) {
        for (int i = 0; i < a.length; i++) if (a[i] == target) return i;
        return -1;
    }
    /**
     * Pre: The array is not null
     * @param a an int array to be analysed
     * @return An int that represents the smallest number in the array
     **/
    private static int min(int[] a) {
        int min = a[0];
        for (int i : a) if (i < min) min = i;
        return min;
    }
    /**
     * Pre: The array is not null
     * @param a an int array to be analysed
     * @return An int that represents the largest number in the array
     **/
    private static int max(int[] a) {
        int max = a[0];
        for (int i : a) if (i > max) max = i;
        return max;
    }
    /**
     * Pre: The array is not null
     * @param a an int array that will be analysed for odd numbers
     * @return An int that represents the number of odds in the array
     **/
    private static int countOdds(int[] a) {
        int numOdds = 0;
        for (int i : a) if (i % 2 != 0) numOdds++;
        return numOdds;
    }
    /**
     * Pre: The array is not null
     * @param  a an int array that will be shifted 1 item to the right
     * @return An int array that is the old array shifted one item to the right
     **/
    private static int[] shift(int[] a) {
        int f = a[a.length - 1];
        System.arraycopy(a, 0, a, 1, a.length - 1);
        //for (int i = a.length - 1; i > 0; i--) a[i] = a[i - 1];
        a[0] = f;
        return a;
    }
    /**
     * Pre: The array is not null
     * @param  a an int array that will be shifted n item(s) to the right
     * @return An int array that is the old array shifted n item(s) to the right
     **/
    private static int[] shift(int[] a, int n) {
        for (int i = 0; i < n; i++) shift(a);
        return a;
    }
    /**
     * Pre: The array is not null
     * @param a an int array to be analysed
     * @return An boolean that is true if the array is increasing, false otherwise
     **/
    private static boolean isIncreasing(int[] a) {
        for (int i = a.length - 1; i > 0; i--) if (a[i] < a[i - 1]) return false;
        return true;
    }
    /**
     * Pre: The array is not null
     * @param a an int array to have items swapped
     * @param x an int representing the position of the item to be swapped
     * @param y an int to be put in place of the item at x
     **/
    private static void swap(int[] a, int x, int y) {
        //
        if (x > 0 && x < a.length) a[x] = y;
    }
    /**
     * Pre: The array is not null
     * @param a an int array that will be segregated into odds and then evens
     * @return An int array that is the old array but segregated into odds first then evens.
     **/
    private static int[] split(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            for (;a[i] % 2 != 0 && i < j;) i++;
            for (;a[j] % 2 == 0 && i < j;) j--;
            int t = a[i];
            a[i] = a[j]; a[j] = t;
        }
        return a;
    }
    /**
     * Pre: The array is not null
     * @param a an int array to be sorted into ascending order
     * @return An int array separated in order, smallest to largest
     **/
    private static int[] sort(int[] a) {
        for (int i = a.length; i >= 0; i--)
            for (int j = i; j < a.length - 1; j++)
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
        return a;
    }
    /**
     * Pre: The array is not null
     * @param a an int array that will be freed of all integers > filter
     * @param filter an int that each item will be compared to.
     * @return An int array with all items greater than filter as 0's
     **/
    private static int[] filter(int[] a, int filter) {
        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i]) > filter) a[i] = 0;
        }
        return a;
    }
    /**
     * Pre: The array is not null
     * @param list an int array to be searched for subList
     * @param subList an int array to search for inside of list
     * @return An int that represents the position of subList inside of list, -1 if not found
     **/
    private static int match(int[] list, int[] subList) {
        if (subList.length <= list.length)
            for (int i = 0; i < list.length - (subList.length - 1); i++)
                if (list[i] == subList[0])
                    for (int j = 0; j < subList.length; j++)
                        if (list[i + j] == subList[j])
                            if (j == subList.length - 1) return i;
                        else break;
        return -1;
    }
    /**
     * Pre: The array is not null
     * @param a An array to be summed at the ends
     * @return An int array where each slot represents the summation of i and it's corresponding j
     **/
    private static int[] sumEnds(int[] a) {
        int[] r = new int[a.length / 2];
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            r[i] = Math.abs(a[i]) + Math.abs(a[j]);
        }
        return r;
    }
    /**
     * Pre: The arrays are not null
     * @param a an int array to be copied from
     * @param b an int array to be copied to
     * @return An int array that is a copy of a
     **/
    private static int[] copyArray(int[] a, int[] b) {
        System.arraycopy(a, 0, b, 0, a.length);
        return b;
    }

    public static void main(String[] args) throws IOException {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an output filename: ");
        String fileName = s.nextLine().trim() + ".txt";

        System.out.print("Enter length of array (>= 2): ");
        do {
            try {
                n = Integer.parseInt(s.nextLine());
                if (n >= 2) {
                    break;
                } else throw new Exception();
            } catch (Exception e) {
                System.out.print("Enter length of array (> 2): ");
            }
        }
        while (true);

        System.out.println("Running...");

        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos), stdOut = System.out;
        System.setOut(ps);

        int[] a = new int[n], b = new int[n];
        fillRandom(a);
        b = copyArray(a, b);

        System.out.println(arrayToString(a));
        System.out.println(arrayToString(b) + "\n");

        System.out.println("fillInOrder: " + arrayToString(fillInOrder(a))); a = copyArray(b, a);
        System.out.println("fillInOrder(OVR): " + arrayToString(fillInOrder(a, 5))); a = copyArray(b, a);
        System.out.println("sum: " + sum(a)); a = copyArray(b, a);
        System.out.println("find: " + find(a, 5)); a = copyArray(b, a);
        System.out.println("min: " + min(a)); a = copyArray(b, a);
        System.out.println("max: " + max(a)); a = copyArray(b, a);
        System.out.println("countOdds: " + countOdds(a)); a = copyArray(b, a);
        System.out.println("shift: " + arrayToString(shift(a))); a = copyArray(b, a);
        System.out.println("shift(OVR): " + arrayToString(shift(a, 3))); a = copyArray(b, a);
        System.out.println("isIncreasing: " + String.valueOf(isIncreasing(a))); a = copyArray(b, a);
        System.out.println("swap: [NULL]"); swap(a, 1, 1); a = copyArray(b, a);
        System.out.println("split: " + arrayToString(split(a))); a = copyArray(b, a);
        System.out.println("sort: " + arrayToString(sort(a))); a = copyArray(b, a);
        System.out.println("filter: " + arrayToString(filter(a, 50))); a = copyArray(b, a);
        System.out.println("sumEnds: " + arrayToString(sumEnds(a))); a = copyArray(b, a);

        System.out.println("\nAutoGenerating new match array...");
        int[] c = new int[a.length / 2];
        c = fillRandom(c);
        System.out.println(arrayToString(c) + "\n");

        System.out.println("match 100%: " + match(a, b));
        System.out.println("match: " + match(a, c));

        System.setOut(stdOut);
        System.out.println("Check output file.");
    }
}
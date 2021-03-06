import java.util.Arrays;
import java.util.Scanner;

/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Signed: Jacob Schellman
 *
 * @author JacobSchellman18
 *         Date of Completion:  eg. 9/13/2016
 *         Assignment:  Splitter Method
 *         <p>
 *         Attribution: None except this stackoverflow link telling me how to print an array without a for loop
 *         http://stackoverflow.com/questions/10904911/how-to-convert-an-int-array-to-string-with-tostring-method-in-java
 *         <p>
 *         General Description:
 *         This code will take a string and a deliminator and return an array of strings with each of the original strings
 *         that were seperated by a deliminator. Also, the numDelims method returns the number of times a deliminator (or
 *         any string for that matter) appears in another string.
 *         <p>
 *         Advanced:
 *         Exception handling
 *         Format of output
 *         The ability for a user to customize the Splitter input from a keyboard input
 *         <p>
 *         Errata:
 *         If given an invalid input or a null deliminator, the compiled code will either crash or result in an inifite
 *         loop. The program does not check if there is an invalid input in the custom area either, so it could be very
 *         easy to crash.
 */

public class Splitter {
    /**
     * This method receives a String and produces an array of all those tokens
     * or substrings that appear in str seperated by the given delimeter.
     * <p>
     * For example, "Fred, Josie, Fritz, Anna, Carla, Joe" with delimeter ", " would
     * yield the array of Strings: ["Fred","Josie", "Fritz", "Anna", "Carla", "Joe"]
     * <p>
     * If two delimeters appear immediately next to one another, an empty String will
     * be stored at the required position of the output array.
     *
     * @param input - the String given to be tokenized or parsed
     * @param delim - the marker, possibly longer than 1, seperating tokens from
     *              one another
     * @return an array of Strings equal in length to one more than the number of
     * delimeters in str containing the individual tokens
     */
    private static String[] splitter(String input, String delim) {
        int numOfDelim = numDelims(input, delim);
        String[] returnArray = new String[numOfDelim + 1];
        System.out.println("number of deliminators: " + numOfDelim + " and number of words: " + (numOfDelim + 1));

        String scannable = input;
        System.out.println("length of return array: " + returnArray.length + " and the scannable string is '" + scannable + "'");

        int lastDelim = 0, indexDelim = input.indexOf(delim);
        System.out.println("the indexOf delim = " + indexDelim + "\n");

        if (indexDelim == -1) {
            System.out.println("the delim didn't appear, returning original string");
            returnArray[0] = "\"" + input + "\"";
            return returnArray;
        }

        for (int i = 0; i < numOfDelim + 1; i++) {
            try {
                System.out.println("now " + (i + 1) + " iteration(s)\n");

                returnArray[i] = "\"" + scannable.substring(lastDelim, indexDelim) + "\"";
                System.out.println("adding '" + returnArray[i] + "' to the array.");

                if (i != (numOfDelim)) {
                    scannable = scannable.substring(indexDelim + delim.length());
                    System.out.println("this is now the scannable string: '" + scannable + "'");

                    indexDelim = scannable.indexOf(delim);
                    if (indexDelim == -1) indexDelim = scannable.length();
                    System.out.println("lastDelim is at " + lastDelim + " and indexDelim is at " + indexDelim);
                } else {
                    System.out.println("no need to update variables as they won't be used again");
                }

                System.out.println("the total array right now is at " + returnArray.length + " and contains " + Arrays.toString(returnArray) + "\n");
            } catch (Exception e) {
                System.out.println("There was an error: " + e.getMessage() + "\n");
            }
        }
        return returnArray;
    }

    /**
     * This method returns the number of times a delim (or any string for that matter)
     * appears in a string.
     *
     * @param input - the String given to judged
     * @param delim - the String to be found in this array
     * @return the number of times the delim appears in input.
     */
    private static int numDelims(String input, String delim) {
        int lastOccurance = 0, numDelims = 0;

        do {
            lastOccurance = input.indexOf(delim, lastOccurance);

            if (lastOccurance != -1) {
                lastOccurance += delim.length();
                numDelims++;
            }
        } while (lastOccurance != -1);

        return numDelims;
    }

    /**
     * @param args used in command line to adjust the way the program runs - if it's setup, right?
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a string and a delim in this format: \"Example[delim]Example[delim]Example;[delim]\"");
        System.out.println("Enter nothing for the preset");
        String str = keyboard.nextLine();

        if (str.isEmpty()) {
            System.out.println("Using the preset\n");
            System.out.println(Arrays.toString(splitter("Fred, Josie, Fritz, Anna, Carla, Joe", ", ")));
        } else {
            System.out.println("Using your custom input\n");
            String input = str.substring(0, str.indexOf(';')), delim = str.substring(str.indexOf(';') + 1);
            /*System.out.println(Arrays.toString(*/
            splitter(input, delim);/*));*/
        }
    }
}
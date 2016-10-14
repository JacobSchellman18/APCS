
/**
 * HONOR PLEDGE: "All work here is honestly obtained and is my own."  Signed:  Paul Plaia IV
 * @author pplaia
 * Date of Completion:  eg. 8/27/2016
 * Assignment: APCS WarmUpAssignment
 *
 * Attribution: Include group members or helpers that assisted you in completing your work: Jacob Schelmann and Patrick Rahiya (Required)
 * 				Include URLs for helpful web site sources used: http://stackoverflow.com/questions/13942701/take-a-char-input-from-the-scanner,
 * 			        https://docs.oracle.com/javase/7/docs/api/, http://stackoverflow.com/questions/1816673/how-do-i-check-if-a-file-exists-in-java,
 * 			        http://stackoverflow.com/questions/3005124/writing-to-an-already-existing-file-using-filewriter-java (Required)
 * 				Include Textbook chapters and page numbers you used.  (Optional for personal organization.)
 *
 * General Description:   (Include purpose of the code, special uses of this code,  list of accomplished features.) The purpose of this assignment is to
 * reorient the programmer with java syntax and code structure. The code asks the user for several inputs, creates variables of different types for each,
 * and write these inputs to a file. The code does all of this, and in addition asks the user for inputs until they quit, leaving potential for long
 * lists of inputs.
 *
 *
 * Advanced:  What features or approaches did you introduce that were not part of the required assignment?
 * 				(List by method and describe your goals and successful features. A bullet point list is sufficient.)
 * 			- implemented a while loop that asks the user for inputs until they quit
 *
 * Errata:  What required components from the rubric or lab are NOT implemented?
 * 			What is not yet correctly implemented in this file?
 * 				(List by method and describe the errors you are encountering as you have tested your code.)
 * 			- the program works as the rubric specifies, but there is no exception handling. If the user were to enter a String for age, the program
 * 		      would crash
 * 		    - additionally, the lack of exception handling allows users to type things like Z for their projected grade, 100005 for age, and 37.8 for
 * 		      APCS excitement
 *
 */

import java.io.*;
import java.util.Scanner;


public class WarmUpAssignment {

    public static void main(String[] args) throws IOException {
        // create a new scanner to read user input
        Scanner reader = new Scanner(System.in);

        // Sout + tab shortcut, prints text to console
        System.out.print("\nEnter an output File Name.");
        // Get user response, trim any spaces, and give it to fileName
        String fileName = reader.nextLine().trim();

        // Create a new printWriter object called outputFile to write to the output file
        PrintWriter outputFile =
                new PrintWriter(new FileWriter(fileName));

        // loop that runs as long as more users and lines of data are being created (Is this bad form?)
        /*
         * 8/27/2016, changed while(true) as it was bad style and did not notify the reader as to the conditions in which the loop
         * continues
         */
        boolean stopped = false;
        do {
            /*System.out.println("Press 1 to quit, or anything else to continue: ");
            if (reader.nextLine().equals("1")) {
                reader.close(); // close reader and output file writer, then terminate the loop
                outputFile.close();
                break;
            }*/

            // create new user object
            User newUser = new User();

            System.out.println("\nPlease enter your first and last name: ");
            String name = reader.nextLine();
            newUser.setName(name);

            System.out.println("\nPlease enter your age: ");
            int age = Integer.parseInt(reader.nextLine()); // Integer.parseInt converts String to int
            newUser.setAge(age);

            System.out.println("\nEnter how excited you are for AP CS, on a scale from 0-10 with decimals: ");
            double excitement = Double.parseDouble(reader.nextLine()); // Double.parseDouble converts String to double
            newUser.setExcitement(excitement);

            System.out.println("\nEnter the grade you want in this class(the program will detect the first letter you type): ");
            char grade = reader.nextLine().trim().charAt(0); // Grab the first letter user types by trimming String input and locating char at first spot
            newUser.setGoal(grade);

            System.out.println("\nIs Harambe our Lord and Savior? Type yes or no: ");
            boolean hSavior = false; // Initialize to be false
            if (reader.nextLine().equals("yes")) {
                hSavior = true; // hSavior is ONLY true if the user typed yes
            }
            newUser.setSavior(hSavior);

            // test: System.out.println(name + age + excitement + grade + String.valueOf(hSavior));
            /*
             * Test used to determine if variables were initialized and working properly, then
             */

            System.out.println("\nPress 1 to quit, anything else to add another user");
            if (reader.nextLine().equals("1")) { // always use .equals() when comparing String
                stopped = true;
            }

            /*
            format variables with Strings to look professional and readable to the user
            removed as with objects, we can simply use the toString() method. Already built in!
            outputFile.println("Name: " + name + ", Age: " + age + ", Excitement for AP CS: " + excitement + ", Goal: " + grade + ", Devotion to Harambe: " + hSavior);
            */
            outputFile.println(newUser.toString()); // use toString() method, taking advantage of OO programming

        } while (!stopped); // loop runs under condition that it is not stopped

        outputFile.close(); // close scanners and output files before finishing!
        reader.close();
    }

}

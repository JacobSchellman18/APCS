/**
 * This program prompts the user to enter his or her
 * first name and last name and displays a greeting message.
 * Author: Maria Litvin
 */

import java.util.Scanner;

public class Greetings2
{
  public static void main(String[] args)
  {
    int[] integerArray = new int[100];
    Scanner kboard = new Scanner(System.in);

    System.out.print("Enter your first name: ");
    String firstName = kboard.nextLine();

    System.out.print("Enter your last name: ");
    String lastName = kboard.nextLine();

    System.out.println("Hello, " + firstName + " " + lastName);
    System.out.println("Welcome to Java!");

    for (int i = 0; i < 100; i++) {
      System.out.println(i + " For");
      integerArray[i] = i;
    }

    System.out.println("");

    for(int i : integerArray) {
        System.out.println(i + " For Each");
    }

    kboard.close();
  }
}

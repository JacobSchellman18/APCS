import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This file serves as an example of accessing a textfile and placing
 * information in a new textfile.  It is meant to model File Input & Output
 * for possible use throughout the year.
 */

/**
 * @author yoderr
 *
 */
public class TextFileTester {
	public static void main(String[] args) throws IOException
	  {
	    Scanner keyboard = new Scanner(System.in);
	    String fileName;

	    // Obtain a fileName and open input file:
	    System.out.print("\nEnter input file name: ");
	    fileName = keyboard.nextLine().trim();


	    BufferedReader inputFile =
	                 new BufferedReader(new FileReader(fileName), 1024);

	    // Obtain a fileName and create output file:

	    System.out.print("\nEnter output file name: ");
	    fileName = keyboard.nextLine().trim();

	    PrintWriter outputFile =
	                 new PrintWriter(new FileWriter(fileName));

	    // Process the file as you read from it (common idiom in java):
	    String line;
	    int lineNum = 0;
	    while ((line = inputFile.readLine()) != null)
	    {
	      lineNum++;
	      /** 
	       * do something important or interesting?
	       * this example reads each line in and creates a new
	       * file with all of the lines numbered 
	       **/
	      outputFile.println("" + lineNum + " - " + line);
	    }



	    // Finish or Clean Up:

	    inputFile.close();
	    outputFile.close();
	    keyboard.close();
	    System.out.println("Done.");
	  }
}

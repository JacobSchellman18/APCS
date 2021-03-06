import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;

/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Signed: Jacob Schellman
 * @author JacobSchellman18
 * Date of Completion:  eg. 9/13/2016
 * Assignment:  String Test Part 2
 *
 * Attribution: My entire group(s) over the term of the last week or so - Paul Plaia, Patrick Rahiya, Liam Mullican,
 *      Maggie D'Amaro.
 *
 * General Description:
 *       This code will take a strings and either change them in some way or will judge them on some parameters and return
 *       true or false.
 *
 * Advanced:
 *       Most advanced work went into Splitter, but one small advanced piece would be that #20 uses a for loop rather
 *       than just a hard coded solution.
 *
 * Errata:
 *       Many of these methods can be broken easily by giving invalid inputs.
 */
public class StringTestPart2 {

    /**
     * Ch08 #12 Implementation of String class indexOf(ch,fromPos):
     *
     * @param ch
     * @param fromPos
     * @return pos of ch, if it occurs in String at or after fromPos;
     * -1 if not in String
     */
    public static int indexOf(char ch, int fromPos) {
        String str = "testingstring";
        for (int i = fromPos; i < (str.length()); i++) {
            if (str.charAt(i) == ch)
                return i;
        }
        return -1;
    }

    /**
     * Ch08 #15
     *
     * @param str - given String object
     * @return true, if only digits appear within str; false otherwise
     */
    public static boolean hasOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            // This wouldn't work as it would check if it has any characters...
            //    for (int j = 0; j < 10; j++) {
            //        if (str.charAt(i) == (char) j) return false;
            //    }
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    /**
     * Ch08 #18a
     * Palindrome are spelled the same backwards and forwards.
     *
     * @param word
     * @return true, if word is a Palindrome; false otherwise
     */
    public static boolean isPalindrome(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) return false;
        }
        return true;
    }

    /**
     * Ch08 #20  pg. 233 JMAP
     *
     * @param isbn
     * @return true, if isbn is valid according to the guidelines
     */
    public static boolean isValidISBN(String isbn) {
        int[] d = new int[isbn.length()];
        for (int i = 0; i < d.length; i++) {
            d[i] = Character.digit(isbn.charAt(i), 10);
        }
        int s = 0;
        for (int i = 0; i < d.length - 1; i += 2) {
            s += (d[i] + 3 * d[i + 1]);
        }
        s+= d[12];
        return s % 10 == 0;
    }

    /**
     * Ch08 #22  Shuffle rearranges all of the characters in
     * word in random order. The method uses the StringBuffer
     * class to assist in this process and Math.random().
     *
     * @param word
     * @return
     */
    public static String shuffle(String word) {
        int n = word.length() - 1;
        StringBuffer stringBuffer = new StringBuffer(word);
        while (n > 1) {
            int randomPlaceholder = (int)(Math.random() * n);
            char randomChar = stringBuffer.charAt(randomPlaceholder);
            stringBuffer.setCharAt(randomPlaceholder, stringBuffer.charAt(n));
            stringBuffer.setCharAt(n, randomChar);
            n--;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        // TODO Obtain input and test functions.
        Scanner keyboard = new Scanner(System.in);
        String str;

        System.out.println("StringMethods Part 2:  loops and static! ");

        System.out.println();
        System.out.print("Enter a string: ");
        str = keyboard.nextLine();

        //Do "cool"? stuffs...
        System.out.println(shuffle(str));
    }
}
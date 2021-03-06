/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own.
 *              Signed:  Jacob Schellman
 * @author JacobSchellman18
 * Date of Completion:  eg. 9/8/2016
 * Assignment:  CH 08: Strings
 *
 * Attribution: Liam Mullican, Evan Mckinna, and Ally Denton all assisted me in the development of this assingment.
 *              We all worked together to complete #10 and some of #14, and Evan and I worked together to finish #14.
 *
 * General Description: This code contains many different methods that all involve changing or reading information about
 *              Strings. Some of these methods are from the problems 1-7, 10, 11, 13, and 14 from the Java Methods text,
 *              yet others are from Coding Bat.
 *
 * Advanced:
 *      - Although perhaps not 'advanced', the use of .contains, .replaceAll, etc. demonstrate the use of new
 *      methods and further exploration of the String datatype.
 *      - Problems 8 & 9 were completed.
 *      - Use of ternary operators.
 *
 * Errata:
 *      - Nearly all of these methods can be broken simply by typing out of the specified format.
 *      - Whenever a method requires two arguments, the program relies on the user to know that they
 *      - need to seperate the arguments with a ';' and also have two arguments in the first place.
 *      - Some methods return a blank space with their output - although it is not usually noticable.
 *
 */

/* These are Imports statements. They allow us to reference other methods and classes from other libraries. */
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

/* Initialize the GUI and class. */
public class StringTest extends JFrame implements ActionListener {
    private JTextField input, result;

    /* Set up the GUI. */
    public StringTest() {
        super("String test");
        Box box1 = Box.createVerticalBox();
        box1.add(Box.createVerticalStrut(20));
        box1.add(new JLabel("Input:"));
        box1.add(Box.createVerticalStrut(20));
        box1.add(new JLabel("Result:"));

        input = new JTextField(20);
        input.setBackground(Color.YELLOW);
        input.addActionListener(this);
        input.selectAll();

        result = new JTextField(20);
        result.setBackground(Color.WHITE);
        result.setEditable(false);

        Box box2 = Box.createVerticalBox();
        box1.add(Box.createVerticalStrut(20));
        box2.add(input);
        box2.add(Box.createVerticalStrut(20));
        box2.add(result);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(box1);
        c.add(box2);
        input.requestFocus();
    }

    //Problem 1
        // The problem here is that the author used a single \ as opposed to \\.
        // This would cause the compiler to search for a special phrase, and the program might not compile.
    //Problem 2
    /**
     * Pre: Nothing is assumed before this method runs - it accounts for empty strings, and if there is something
     * not accounted for, it just returns false.
     * Post: This method returns true or false and does not require anything to be in a certain order to run.
     * @param str The original string to be judged
     * @return true or false based on whether the string's last character is *
     */
    public boolean starString(String str) {
        if (!str.isEmpty() && str.indexOf("*") == str.length() - 1) { return true; }
        return false;
    }
    /**
     * Pre: Nothing is assumed before this method runs - it accounts for string length, and if there is something
     * not accounted for, it just returns false.
     * Post: This method returns true or false and does not require anything to be in a certain order to run.
     * @param str The original string to be judged
     * @return true or false based on whether the string's last characters are **
     */
    public boolean starString2(String str) {
        if (str.length() >= 2  && str.indexOf("**") == str.length() -2) { return true; }
        return false;
    }
    //Problem 3
    /**
     * Pre: This method assumes there are hyphens in the string and also assumes the string is at least 2
     * characters long.
     * Post: There are no post conditions.
     * @param str The original string to be judged
     * @return the concatenation of the strings separated by hyphens.
     */
    public String eliminateDashes(String str) {
        //return str.replaceAll("-", "");
        //Yet also doable by:
          //str.deleteCharAt(3);
          //str.deleteCharAt(6);
          //return str;
        //Still, also doable by:
        String part1 = str.substring(0, str.indexOf("-"));
        String part2 = str.substring(str.indexOf("-") + 1, str.lastIndexOf("-"));
        String part3 = str.substring(str.lastIndexOf("-") + 1);
        System.out.println(part1 + " " + part2 + " " + part3);
        return part1 + part2 + part3;
        //Which is what I think you wanted to see, although it is a bit less efficient.
    }
    //Problem 4
    /**
     * Pre: This method assumes that the user has provided '/' (forward slashes) and that the string is at least 5
     * characters long.
     * Post: There are no post conditions.
     * @param str The original string to be judged
     * @return the concatenation of the strings separated by hyphens as well as a 0 if the day String is less than 2
     * characters long.
     */
    public String makeDateCooler(String str) {
        //I didn't use replaceAll or other String methods as I don't see them applying to this lesson.
        String month = str.substring(0, str.indexOf("/"));
        String day = str.substring(str.indexOf("/") + 1, str.lastIndexOf("/"));
        String year = str.substring(str.lastIndexOf("/") + 1);

        //Part 2 here
        if (day.length() == 1) { day = "0" + day; }

        System.out.println(month + " "  + day + " " + year);
        return day + "-" + month + "-" + year;

        //I wasn't actually sure what part 3 (c) was asking me to do, so I'll put it in errata.
    }
    //Problem 5
    /**
     * Pre: This method assumes that the user has provided a string with at least 6 characters in it.
     * Post: There are no post conditions.
     * @param str The original string to be judged
     * @return the original string, as per the request of Java Methods.
     */
    public String creditCardFun(String str) {
        String last4 = str.substring(str.length() - 4, str.length());
        String last5 = str.substring(str.length() - 6 /* remember there's a space */, str.length());
        return str;
    }
    //Problem 6
    /**
     * Pre: This method assumes that the user has provided a string with at least 2 characters in it.
     * Post: There are no post conditions.
     * @param str The original string to be judged
     * @return the original string with the first character moved to the back of the string.
     */
    public String scroll(String str) {
        //Comment so it doesn't wrap @IntelliJ
        return str.substring(1, str.length()) + str.charAt(0);
    }
    //Problem 7
    /**
     * Pre: This method assumes that there is a comma in the provided string and that the string is at least 2
     * characters long.
     * Post: There are no post conditions.
     * @param str The original string to be judged
     * @return the original string switched from 'last, first' to 'first last' without a comma.
     */
    public String convertName(String str) {
        String firstName = str.substring(str.indexOf(",") + 1).trim();
        String lastName = str.substring(0, str.indexOf(",")).trim();

        return firstName + " " + lastName;
    }
    //Problem 8
    /**
     * Pre: This method assumes it is only 0's and 1's
     * Post: There are no post conditions.
     * @param str The original string to be judged
     * @return the original string switched 0's and 1's.
     */
    public String negativeZerosAndOnes(String str) {
        //Please don't wrap intellij
        str = str.replaceAll("0", "2");
        str = str.replaceAll("1", "0");
        str = str.replaceAll("2", "1");
        return str;
    }
    //Problem 9
    /**
     * Pre: This method assumumes nothing
     * Post: There are no post conditions.
     * @param str The original string to be judged
     * @return This method returns true or false based on whether the string is homogenous or not.
     */
    public boolean isSame(String str) {
        if (str.equals(str.substring(1, str.length()) + str.charAt(0))) {
            return true;
        }
        return false;
    }
    //Problem 10
    /**
     * Pre: This method assumes that the user has provided a string with at least a length of 4 characters.
     * Post: There are no post conditions.
     * @param str The original string to be judged
     * @return the original string, or, if the requirements are met, the text not including the comment (/* & *backslash)
     */
    public String eliminateComment(String str) {
        if (str.contains("*/") && str.contains("/*") && str.indexOf("/*") < str.indexOf("*/")) {
            str = str.substring(0, str.indexOf("/*")) + str.substring(str.indexOf("*/") + 2);
        }
        return str;
    }
    //Problem 11
    /**
     * Pre: This method assumes nothing and will return the original string if conditions aren't met.
     * Post: There are no post conditions.
     * @param str The original string to be judged
     * @param remove The string to be removed from the original string
     * @return the original string, or the original string minus the string to be removed.
     */
    public String cutOut(String str, String remove) {
        if (str.contains(remove)) {
            return str.substring(str.indexOf(remove), remove.length());
        }
        return str;
    }
    //Problem 13
    /**
     * Pre: This method assumes nothing.
     * Post: There are no post conditions.
     * @param str The original string to be judged
     * @param prefix The string to check if is at the beginning of the original string
     * @return true or false based on whether or not the prefix is at the beginning of the string or not.
     */
    public boolean startsWith(String str, String prefix) {
        System.out.println(str + " , " + prefix);

        if (str.indexOf(prefix) == 0) {
            return true;
        }
        return false;
    }
    /**
     * Pre: This method assumes nothing.
     * Post: There are no post conditions.
     * @param str The original string to be judged
     * @param suffix The string to check if is at the end of the original string.
     * @return True or False based on whether or not the suffix is at the end of the String.
     */
    public boolean endsWith(String str, String suffix) {
        System.out.println(str + " , " + suffix);

        if (str.lastIndexOf(suffix) == str.length() - suffix.length()) {
            return true;
        }
        return false;
    }
    //Problem 14
    /**
     * Pre: This method assumes that the user had provided a string formatted correctly; however, it does check for
     *  some discrepencies (whether or not it contains alligators and whether they're at the beginning or not).
     * Post: There are no post conditions.
     * @param str The original string to be judged.
     * @return the original string, or, if the requirements are met, the text inside of the HTML tag.
     */
    public String removeTags(String str) {
        if (str.contains("<") && str.contains(">") && str.contains("/")) {
            if (str.indexOf("<") == 0) {
                String tag = str.substring(1, str.indexOf(">"));
                String tag2 = "</" + tag + ">";

                System.out.println(tag + " " + tag2);

                if (str.lastIndexOf(tag2) == str.length() - tag2.length()) {
                    return str.substring(tag.length() + 2, str.length() - tag2.length());
                }
            }
        }
        return str;
    }

    //CodingBat
    /**
     * Pre: This method assumes nothing.
     * Post: There are no post conditions
     * @param name is a string representative of a name.
     * @return "Hello Jacob!", just a concatenation of a greeting.
     */
    public String helloName(String name) {
        return "Hello " + name + "!";
    }
    /**
     * Pre: This method assumes nothing.
     * Post: This method requires nothing after being run.
     * @param out the string to be inserted into
     * @param word the string to insert
     * @return this method returns a new string with the first half of out, then word, then the last half of out.
     */
    public String makeOutWord(String out, String word) {
        return out.substring(0, out.length() / 2) + word + out.substring(out.length() / 2);
    }
    /**
     * Pre: This method assumes nothing
     * Post: This method requires no conditions be met.
     * @param str the given string
     * @return This method returns the first half of the given string.
     */
    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }
    /**
     * Pre: This method assumes neither string is empty.
     * Post: This method requires no conditions be met.
     * @param a The first String
     * @param b The second String
     * @return This method returns a + b minus both of their first characters.
     */
    public String nonStart(String a, String b) {
        return (a.substring(1, a.length()) + b.substring(1, b.length()));
    }
    /**
     * Pre: this method assumes that the given string is at least 2 characters
     * Post: this method requires no conditions be met.
     * @param str the given string
     * @return this method returns a string containing the last two letters of the original string repeated 3 times.
     */
    public String extraEnd(String str) {
        String tempString = str.substring(str.length() - 2);
        return tempString + tempString + tempString;
    }
    /**
     * Pre: this method requires the original string to be 3 characters at least.
     * Post: this method requires no conditions be met.
     * @param str is the original string.
     * @return This method returns the original string, but with the last two letters moved to the back.
     */
    public String left2(String str) {
        return str.substring(2) + str.substring(0,2);
    }
    /**
     * Pre: this method assumes nothing
     * Post: this method requires no conditions be met.
     * @param str the given string to judge.
     * @return true or false based off of whether the conditions are met or not.
     */
    public boolean frontAgain(String str) {
        if (str.length() > 1 && str.substring(0, 2).equals(str.substring(str.length() - 2))) {
            return true;
        }
        return false;
    }
    /**
     * Pre: this method requires that the string is at least 2 characters long
     * Post: this method requires no conditions be met.
     * @param str the given string
     * @return this returns the first two letters of a string
     */
    public String firstTwo(String str) {
        if (str.length() < 2) { return str; }
        return str.substring(0 ,2);
    }
    /**
     * Pre: this method requires that the given string is at least 2 characters
     * Post: this method requires no conditions be met.
     * @param str the given string
     * @return This method moves the back two characters to the very front.
     */
    public String right2(String str) {
        return str.substring(str.length() - 2, str.length()) + str.substring(0, str.length() -2);
    }

    /**
     * This is a provided method. It seems to be triggered on ENTER.
     * I don't really know where that was specified though.
     */
    public void actionPerformed(ActionEvent e) {
        String str = input.getText();

        //String str = input.getText().substring(0, input.getText().indexOf(";")).trim();
        //String arg2 = input.getText().substring(input.getText().indexOf(";") + 1).trim();

        //str = ([METHOD HERE](str)) ? "true" : "false";

        //str = [METHOD HERE](str);

        result.setText(str);
        input.selectAll();
    }

    public static void main(String[] args) {
        StringTest window = new StringTest();
        window.setBounds(100, 100, 360, 160);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);

        // Program that provides many different methods to experiment with for Strings.
        // Has a given GUI, but the actionlistener event must be modified in order for it to work with every
        // Problem.
    }
}
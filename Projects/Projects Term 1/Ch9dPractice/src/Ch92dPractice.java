import java.util.Arrays;

/**
 * All work here is honestly obtained and is my own. JCS
 *
 * Author: Jacob Schellman
 *
 * Assignment:
 *  Write the code for these methods. Due 10/14/16, completed 10/13/16
 *
 * Attribution:
 *  I used this site to check my answers: http://wims.unice.fr/wims/wims.cgi
 *
 *  Advanced:
 *  I used a foreach loop to print the matrices.
 *  I implemented exception handling to more efficiently process output.
 *
 * Errata:
 *  The code works as intended.
 */
public class Ch92dPractice {

    /**
     * Generates and returns a matrix representing the sum
     * of the 2 given matrices, if possible.  Returns null for invalid
     * operations.
     * Pre: The two arrays are the same dimensions
     *
     * @param a a 2D int array to be added to b
     * @param b a 2D int array to be added to a
     * @return 2D array representing a+b
     */
    private static int[][] sum(int[][] a, int[][] b) {
        int[][] returnArray = new int[a.length][a[0].length];
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                try {
                    returnArray[r][c] = a[r][c] + b[r][c];
                } catch (ArrayIndexOutOfBoundsException e) {
                    return null;
                }
            }
        }
        return returnArray;
    }

    /**
     * Generates and returns a matrix representing the product
     * of the 2 given matrices, if possible. Returns null for invalid
     * operations.
     * Pre: a is the array in which the number of columns equal the number of rows
     *
     * @param a a 2D int array to be multiplied; we will use this one's columns
     * @param b a 2D int array to be multiplied; we will use this one's rows
     * @return 2D array representing a*b.
     */
    private static int[][] product(int[][] a, int[][] b) {
        int[][] returnArray = new int[b.length][b[0].length];
        if (a[0].length != b.length) {
            System.out.println(a.length + "");
            System.out.println(b[0].length + "");
            return null;
        }
        printMatrix(a);
        System.out.println();
        printMatrix(b);
        System.out.println();
        for (int r = 0; r < b.length; r++) {
            for (int c = 0; c < b[r].length; c++) {
                int t = 0;
                for (int v = 0, h = 0; v < b.length && h < a[0].length; v++, h++) {
                    System.out.println("a[" + r + "][" + h + "] is: " + a[r][h]);
                    System.out.println("b[" + v + "][" + c + "] is: " + b[v][c]);
                    System.out.println("v is now " + v + " and h is now " + h);
                    t += (a[r][h] * b[v][c]);
                    System.out.println("t is now " + t + " after " + a[r][h] + " * " + b[v][c]);
                }
                returnArray[r][c] = t;
                System.out.println("returnArray[" + r + "][" + c + "] now equals " + returnArray[r][c] + "\n");
            }
        }
        return returnArray;
    }

    /**
     * Outputs a given matrix to the screen in row-major order.
     *
     * @param m int[][] to be printed
     */
    private static void printMatrix(int[][] m) {
        if (m == null) {
            System.out.println("NULL");
            return;
        }
        for (int[] r : m) {
            System.out.println(Arrays.toString(r));
        }
    }

    /**
     * @param args are unused
     */
    public static void main(String[] args) {
        int[][] m1 = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] m2 = new int[][]{
                {4, 2, 1,},
                {4, 2, 1},
                {4, 2, 1}
        };

        printMatrix(product(m1, m2));
        System.out.println();

        m1 = new int[][]{
                {12, 8, 10, 17, 11},
                {17, 42, 33, 58, 9},
                {82, 48, 72, 6, 80},
                {90, 52, 9, 11, 72},
                {93, 58, 99, 11, 3}
        };
        m2 = new int[][]{
                {49, 21, 54},
                {81, 22, 13},
                {17, 27, 33},
                {9, 0, 1011},
                {13, 47, 92}
        };

        printMatrix(product(m1, m2));

        m1 = new int[][]{
                {12, 82, 10},
                {17, 42, 33},
                {82, 48, 72},
                {90, 52, 91},
                {93, 58, 99}
        };
        m2 = new int[][]{
                {49, 21, 54},
                {81, 22, 13},
                {17, 27, 33},
                {9, 0, 1011},
                {13, 47, 92}
        };

        System.out.println("\nSum");
        printMatrix(sum(m1, m2));
    }
}
import java.util.Arrays;

public class PascalTriangle {
    //Fields
    private int length;
    private int[][] triangle;

    //Constructor
    private PascalTriangle(int n) {
        length = n;
        triangle = new int[length][];
        for (int r = 0; r < n; r++) {
            triangle[r] = new int[r + 1];
            for (int c = 0; c < triangle[r].length; c++) {
                try {
                    triangle[r][c] = triangle[r - 1][c - 1] + triangle[r - 1][c];
                } catch (ArrayIndexOutOfBoundsException e) {
                    triangle[r][c] = 1;
                }
            }
        }
    }

    //Main
    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle(25);
        pascalTriangle.arrayToString();
    }

    //Methods
    private void arrayToString() {
        for (int r = 0; r < length; r++) {
            System.out.println(Arrays.toString(triangle[r]));
        }
    }

    //Accessors
}

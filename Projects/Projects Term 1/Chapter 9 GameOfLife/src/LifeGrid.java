/**
 * HONOR PLEDGE: All work here is honestly obtained and is my own. JCS
 * Date of Completion:  eg. 10/10/16
 * Assignment:  Ch9 Conway's Game of Life
 *
 * Attribution:
 *          Mr. Yoder, for helping with GUI issues
 *          Jordan Secret for inspiration and help reformatting inefficient code
 *          Paul Plaia for emotional support
 *
 * General Description:
 *          This program is an accurate simulate of Conway's Game of Life.
 *          It comes equipped with a few buttons, check boxes, and other objects that assist with tinkering.
 *
 * Advanced:
 *          Gui Improvements
 *          Auto Generated Lifeforms
 *          Wrapping
 *
 * Errata:
 */
class LifeGrid {
    //number of rows in grid
    private int rows = 0;
    //number of columns in grid
    private int columns = 0;
    //2d array of life
    private int[][] grid;
    //boolean that will tell us whether the grid should wrap around or remain static
    private static boolean wrap = false;

    /**
     * @param r an int representing the number of rows in the grid
     * @param c an int representing the number of columns in the grid
     */
    LifeGrid(int r, int c) {
        rows = r;
        columns = c;
        grid = new int[rows][columns];
    }

    /**
     * @return an int that represents the number of rows in an instance of a grid
     */
    public int getNumRows() {
        //
        return rows;
    }
    /**
     * @return an int that represents the number of columns in an instance of a grid
     */
    public int getNumCols() {
        //
        return columns;
    }
    /**
     * @param x an int representing the row in which to look in the grid
     * @param y an int representing the column in which to look in the grid
     * @return an int that represents the state of a cell (1 = alive, 0 = dead)
     */
    public int getCell(int x, int y) {
        try {
            return grid[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            if (wrap) {
                if (x < 0) {
                    x = grid.length - 1;
                }
                if (x > grid.length - 1) {
                    x = 0;
                }
                if (y < 0) {
                    y = grid[0].length - 1;
                }
                if (y > grid.length - 1) {
                    y = 0;
                }
                return grid[x][y];
            }
            return 0;
        }
    }
    /**
     * @param x an int that represents the row in which a cell will be swapped
     * @param y an int that represents the column in which a cell will be swapped
     * @param z an int representing the state of the cell
     */
    public void setCell(int x, int y, int z) {
        //
        grid[x][y] = z;
    }
    /**
     * @return a boolean telling us whether the grid wraps or not
     */
    public boolean getWrap() { return wrap; }
    /**
     * @param b a boolean that will be assigned to wrap
     */
    public void setWrap(boolean b) {
        wrap = b;
    }

    /**
     * Pre: The grid is rectangular.
     * Post: The grid is entirely 0's or 1's.
     */
    public void evolve() {
        int[][] tGrid = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (checkRules(r, c)) {
                    tGrid[r][c] = 1;
                } else {
                    tGrid[r][c] = 0;
                }
            }
        }
        grid = tGrid;
    }
    /**
     * @param x an int representing the row in which to look in the grid
     * @param y an int representing the column in which to look in the grid
     * @return a boolean that determines whether the cell at x, y will live or die.
     */
    private boolean checkRules(int x, int y) {
        int neighborCount = 0;
        for (int r = (x - 1); r < (x + 2); r++) {
            for (int c = (y - 1); c < (y + 2); c++) {
                if (getCell(r, c) == 1) {
                    neighborCount++;
                }
            }
        }
        neighborCount -= grid[x][y];

        if (grid[x][y] == 1) {
            return (neighborCount > 1 && neighborCount < 4);
        } else {
            return (neighborCount == 3);
        }
    }
    /**
     * Post: the grid is devoid of life
     */
    public void clearGrid() {
        System.out.println("Clearing Grid");
        grid = new int[rows][columns];
    }
    /**
     * Post: the grid is filled with a random assortment of life
     */
    public void fillRandom() {
        System.out.println("Fill Grid Randomly");
        grid = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (Math.random() < .5) {
                    grid[r][c] = 1;
                }
            }
        }
    }
    /**
     * Post: the grid is empty except for a gosper glider gun un the upper lefthand corner
     */
    public void createGGG() {
        grid = new int[rows][columns];
        Position[] points = new Position[36];
        for(int i = 0; i < points.length; i++) {
            points[i] = new Position();
        }
        points[0].x = 0; points[0].y = 24;
        points[1].x = 1; points[1].y = 22;
        points[2].x = 1; points[2].y = 24;
        points[3].x = 2; points[3].y = 12;
        points[4].x = 2; points[4].y = 13;
        points[5].x = 2; points[5].y = 20;
        points[6].x = 2; points[6].y = 21;
        points[7].x = 2; points[7].y = 34;
        points[8].x = 2; points[8].y = 35;
        points[9].x = 3; points[9].y = 11;
        points[10].x = 3; points[10].y = 15;
        points[11].x = 3; points[11].y = 20;
        points[12].x = 3; points[12].y = 21;
        points[13].x = 3; points[13].y = 34;
        points[14].x = 3; points[14].y = 35;
        points[15].x = 4; points[15].y = 0;
        points[16].x = 4; points[16].y = 1;
        points[17].x = 4; points[17].y = 10;
        points[18].x = 4; points[18].y = 16;
        points[19].x = 4; points[19].y = 20;
        points[20].x = 4; points[20].y = 21;
        points[21].x = 5; points[21].y = 0;
        points[22].x = 5; points[22].y = 1;
        points[23].x = 5; points[23].y = 10;
        points[24].x = 5; points[24].y = 14;
        points[25].x = 5; points[25].y = 16;
        points[26].x = 5; points[26].y = 17;
        points[27].x = 5; points[27].y = 22;
        points[28].x = 5; points[28].y = 24;
        points[29].x = 6; points[29].y = 10;
        points[30].x = 6; points[30].y = 16;
        points[31].x = 6; points[31].y = 24;
        points[32].x = 7; points[32].y = 11;
        points[33].x = 7; points[33].y = 15;
        points[34].x = 8; points[34].y = 12;
        points[35].x = 8; points[35].y = 13;

        for (int i = 0; i < points.length; i++) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 36; c++) {
                    if (points[i].x == r) {
                        if (points[i].y == c) {
                            grid[c][r] = 1;
                        }
                    }
                }
            }
        }
    }
    /**
     * Post: the grid is empty except for an acorn in the middle.
     */
    public void createAcorn() {
        grid = new int[rows][columns];
        Position[] points = new Position[7];
        for(int i = 0; i < points.length; i++) {
            points[i] = new Position();
        }
        points[0].x = 1; points[0].y = 2;
        points[1].x = 2; points[1].y = 4;
        points[2].x = 3; points[2].y = 1;
        points[3].x = 3; points[3].y = 2;
        points[4].x = 3; points[4].y = 5;
        points[5].x = 3; points[5].y = 6;
        points[6].x = 3; points[6].y = 7;

        for (int i = 0; i < points.length; i++) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 36; c++) {
                    if (points[i].x == r) {
                        if (points[i].y == c) {
                            grid[c + (columns / 2)][r + (rows / 2)] = 1;
                        }
                    }
                }
            }
        }
    }
    /**
     * Post: the grid is marked with a cross
     * ProTip: run with wrap enabled
     */
    public void stressTest() {
        grid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            grid[i][columns / 2] = 1;
        }
        for (int i = 0; i < columns; i++) {
            grid[rows / 2][i] = 1;
        }
    }
}
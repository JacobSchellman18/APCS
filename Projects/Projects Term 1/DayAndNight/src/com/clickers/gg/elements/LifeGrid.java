package com.clickers.gg.elements;

public class LifeGrid {
    private int rows = 0;
    private int columns = 0;
    private int[][] grid;
    private boolean wrap = false;

    public LifeGrid(int r, int c) {
        rows = r;
        columns = c;
        grid = new int[rows][columns];
    }

    public int[][] getGrid() {
        return grid;
    }
    public int getNumRows() {
        //
        return rows;
    }
    public int getNumCols() {
        //
        return columns;
    }
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
    public void setCell(int x, int y, int z) {
        //
        grid[x][y] = z;
    }
    public boolean getWrap() {
        //
        return wrap; }
    public void setWrap(boolean b) {
        //
        wrap = b;
    }

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
    public void clearGrid() {
        System.out.println("Clearing Grid");
        grid = new int[rows][columns];
    }
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
}
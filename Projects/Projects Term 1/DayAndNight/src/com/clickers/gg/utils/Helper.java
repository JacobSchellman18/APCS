package com.clickers.gg.utils;

import java.io.IOException;
import java.util.Arrays;

public class Helper {
    public static void printArray(int[][] ints) {
        for (int[] i : ints) {
            System.out.println(Arrays.toString(i).replaceAll("0", " ").replaceAll("|","").replaceAll("\\[", "").replaceAll("]", "").replaceAll(",", "").replaceAll("1", "█"));
        }
    }

    public static void printArray(int[] ints) {
        //
        System.out.println(Arrays.toString(ints));
    }

    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {/**/}
        System.out.println("\nWould've cleared.");
    }
}

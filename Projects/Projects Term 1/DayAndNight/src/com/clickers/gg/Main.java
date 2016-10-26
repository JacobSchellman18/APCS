package com.clickers.gg;

import com.clickers.gg.elements.LifeGrid;
import com.clickers.gg.elements.UI;
import com.clickers.gg.listener.KeyboardListener;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    //Fields
    private static LifeGrid lifeGrid;
    private static boolean isRunning = true;
    private static int dimensionX = 5, dimensionY = 5;

    //Accessors and Modifiers
    public void setIsRunning(boolean isRunning) {
        //
        this.isRunning = isRunning;
    }
    public void setDimensions(int dimension) {
        dimensionX = dimension;
        dimensionY = dimension;
    }
    public boolean getIsRunning() {
        //
        return isRunning;
    }
    public int getDimensionX() {
        //
        return dimensionX;
    }
    public int getDimensionY() {
        //
        return dimensionY;
    }
    public LifeGrid getLifeGrid() {
        //
        return lifeGrid;
    }
    public void setLifeGrid() {
        //
        lifeGrid = new LifeGrid(dimensionX, dimensionY);
    }

    //Main
    public static void main(String[] args) {
        LogManager.getLogManager().reset();
        Logger.getLogger(GlobalScreen.class.getPackage().getName()).setLevel(Level.OFF);

        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new KeyboardListener());
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        lifeGrid = new LifeGrid(dimensionX, dimensionY);
        lifeGrid.fillRandom();

        UI ui = new UI();
        ui.run();
    }
}
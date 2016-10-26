package com.clickers.gg.listener;

import com.clickers.gg.Main;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyboardListener implements NativeKeyListener {
    Main main = new Main();

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {}

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        if (e.getKeyCode() == 41) {
            main.setIsRunning(!main.getIsRunning());
            System.out.println("set is running to " + main.getIsRunning());
        }
        //TODO: Implement keycodes as keyChars do not work.
        if (e.getKeyChar() == 'w') {
            main.getLifeGrid().setWrap(!main.getLifeGrid().getWrap());
        }
        if (e.getKeyChar() == 'r') {
            main.setLifeGrid();
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {}
}

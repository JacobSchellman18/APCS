package com.clickers.gg.elements;

import com.clickers.gg.Main;
import com.clickers.gg.utils.Helper;

public class UI extends Thread{
    @Override
    public void run() {
        Main main = new Main();

        sleep(5);
        while (true){
            if (main.getIsRunning()) {
                Helper.printArray(main.getLifeGrid().getGrid());
                main.getLifeGrid().evolve();
                sleep(1000);
                Helper.clrscr();
            }
        }
    }

    private void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {/**/}
    }
}
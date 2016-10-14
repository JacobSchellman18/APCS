
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * I changed some things to allow the project to start in a paused state
 * I changed the starting size of the project
 * I changed the way a few of the methods work, namely the next method
 * I created the startT method as Start appears to cause problems and is executed immediately after the code is compiled.
 */
public class GameOfLife extends JApplet implements ActionListener

{
    private static int generations = 0;
    private LifeCanvas display;
    private LifeControls controls;
    private Timer t;
    private int timeStep;
    private boolean isRunning;

    public void setSpeed(int millisecs) {
        timeStep = millisecs;
        t.setDelay(timeStep);
    }

    public void next() {
        generations++;
        controls.setGeneration(generations);

        display.next();
        repaint();
    }

    public void startT() {
        t.start();
        isRunning = true;
    }

    public void stop() {
        t.stop();
        isRunning = false;
    }

    /**
     * Is the applet running?
     *
     * @return true: applet is running
     */
    public boolean isRunning() {
        return isRunning;
    }

    public void init() {
        isRunning = false;
        display = new LifeCanvas(this);
        display.setBackground(Color.CYAN);
        controls = new LifeControls(this);

        Container c = getContentPane();
        c.add(display, BorderLayout.CENTER);
        c.add(controls, BorderLayout.SOUTH);

        this.setSize(1000, 950);

        timeStep = 100;
        t = new Timer(timeStep, this);

        t.stop();
        stop();
        controls.stop();
    }

    /* Timer Event */
    public void actionPerformed(ActionEvent e) {
        generations++;
        controls.setGeneration(generations);
        next();
    }


}

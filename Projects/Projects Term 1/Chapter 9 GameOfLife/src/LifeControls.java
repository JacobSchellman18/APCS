import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * I added quite a few buttons and a check box.
 * This was mainly a clone of the code that already existed.
 */
public class LifeControls extends JPanel
        implements KeyListener {
    private JLabel genLabel;
    private static final String genLabelText = "Generations: ";
    private final String slow = "Slow";
    private final String fast = "Fast";
    private final String hyper = "Hyper";
    private final String nextLabelText = "Next";
    private final String startLabelText = "Start";
    private final String stopLabelText = "Stop";
    private final String clearLabelText = "Clear";
    private final String randomLabelText = "Random";
    private final String gggLabelText = "Create GGG";
    private final String wrapLabelText = "Wrap Around?";
    private final String acornLabelText = "Acorn";
    private final String stressTestLabelText = "Stress Test";
    private JButton stressTest;
    private JButton acorn;
    private JCheckBox wrap;
    private JButton random;
    private JButton ggg;
    private JButton go;
    private JButton clear;
    private JButton nextButton;
    private GameOfLife app;
    LifeCanvas lifeCanvas = new LifeCanvas(app);

    public LifeControls(GameOfLife app) {
        this.app = app;

        // pulldown menu with speeds
        Choice speedChoice = new Choice();

        // add speeds
        speedChoice.addItem(slow);
        speedChoice.addItem(fast);
        speedChoice.addItem(hyper);

        // when item is selected
        speedChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String arg = (String) e.getItem();
                if (slow.equals(arg)) // slow
                    getGameOfLife().setSpeed(100);
                else if (fast.equals(arg)) // fast
                    getGameOfLife().setSpeed(50);
                else if (hyper.equals(arg)) // hyperspeed
                    getGameOfLife().setSpeed(1);
            }
        });

        // stressTest button
        stressTest = new JButton(stressTestLabelText);

        // acorn button
        acorn = new JButton(acornLabelText);

        // wrap checkbox
        wrap = new JCheckBox(wrapLabelText);

        // ggg button
        ggg = new JButton(gggLabelText);

        // number of generations
        genLabel = new JLabel(genLabelText + "0             ");

        // clear button
        clear = new JButton(clearLabelText);

        // random button
        random = new JButton(randomLabelText);

        // when stressTest button is clicked
        stressTest.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) { stressTestButtonClicked(); }
                }
        );

        // when acorn button is clicked
        acorn.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) { acornButtonClicked(); }
                }
        );

        // when wrap checkbox is clicked
        wrap.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) { wrapCheckboxClicked(); }
                }
        );

        // when clear button is clicked
        clear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) { clearButtonClicked(); }
                }
        );

        // when random button is clicked
        random.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) { randomButtonClicked(); }
                }
        );

        // when ggg button is clicked
        ggg.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) { gggButtonClicked(); }
                }
        );

        // start and stop button
        go = new JButton(stopLabelText);

        // when start/stop button is clicked
        go.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        startStopButtonClicked();
                    }
                }
        );

        // next generation button
        nextButton = new JButton(nextLabelText);

        // when next button is clicked
        nextButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        getGameOfLife().next();
                    }
                }
        );

        // create panel with controls
        this.add(stressTest);
        this.add(acorn);
        this.add(ggg);
        this.add(clear);
        this.add(random);
        this.add(nextButton);
        this.add(go);
        this.add(speedChoice);
        this.add(genLabel);
        this.add(wrap);
        this.validate();
    }


    /**
     * Implement KeyListener interface:
     */
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_ENTER:

                break;

            case KeyEvent.VK_SPACE:

                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_KP_UP:

                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_KP_DOWN:

                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_KP_LEFT:

                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_KP_RIGHT:

                break;

            case KeyEvent.VK_S:
                break;

            case KeyEvent.VK_F:

                break;
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    /**
     * Set the number of generations in the control bar.
     *
     * @param generations number of generations
     */
    public void setGeneration(int generations) {
        genLabel.setText(genLabelText + generations);
    }

    /**
     * Change the label of the start/stop-button to "Stop".
     */
    public void start() {
        go.setText(stopLabelText);
    }

    /**
     * Change the label of the start/stop-button to "Start".
     */
    public void stop() {
        go.setText(startLabelText);
    }

    /**
     * Called when the start/stop-button is clicked.
     */
    public void startStopButtonClicked() {
        if (app.isRunning()) {
            app.stop();
            stop();
        } else {
            start();
            app.startT();
            app.next();
        }
    }

    /**
     * Return GameOfLife applet object.
     *
     * @return GameOfLife applet object
     */
    public GameOfLife getGameOfLife() {
        return app;
    }

    /**
     * Called when the ggg button is clicked
     */
    public void gggButtonClicked() {
        lifeCanvas.ggg();
        app.next();
    }

    /**
     * Called when the clear button is clicked.
     */
    public void clearButtonClicked() {
        System.out.println("Pressed clear button");
        lifeCanvas.clearGrid();
        app.next();
    }

    /**
     * Called when the random button is clicked.
     */
    public void randomButtonClicked() {
        System.out.println("Random button clicked");
        lifeCanvas.fillRandom();
        app.next();
    }

    /**
     * Called when the acorn button is clicked
     */
    public void acornButtonClicked() {
        lifeCanvas.acorn();
        app.next();
    }

    /**
     * Called when the wrap checkbox is clicked
     */
    public void wrapCheckboxClicked() {
        System.out.println("clicked");
        lifeCanvas.wrap();
    }

    /**
     * Called when the stressTest button is clicked
     */
    public void stressTestButtonClicked() {
        lifeCanvas.stressTest();
        app.next();
    }

    /**
     * Control panel's drawing method
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

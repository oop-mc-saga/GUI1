package simpleTimer;

import java.awt.Color;
import java.util.Calendar;
import javax.swing.JLabel;

/**
 * Showing time duration from the beginning
 * 
 * Extension of JLabel
 *
 * @author tadaki
 */
public final class Timer extends JLabel implements Runnable {

    private Calendar startDate = null;
    private int max = 80;
    private volatile boolean running = false;
    private Color foregroundNormal = Color.BLACK;
    private Color foregroundOver = Color.RED;

    /**
     * Constructor
     */
    public Timer() {
        setMax(max);
        setHorizontalAlignment(JLabel.CENTER);
        setForeground(foregroundNormal);
    }

    @Override
    public void run() {
        while (running) {
            setTime();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }

    /**
     * Start this timer
     */
    public void start() {
        startDate = Calendar.getInstance();//store the beginning
        setVisible(true);
        running = true;
        setForeground(foregroundNormal);
    }

    /**
     * Stop this timer
     */
    public void stop() {
        setVisible(true);
        running = false;
    }

    /**
     * Set limit for timer
     *
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
        setTimeString(0);
    }

    /**
     * Convert seconds to string
     *
     * @param d
     * @return
     */
    private String mkTimeStr(int d) {
        int m = d / 60;
        int s = d % 60;
        StringBuilder b = new StringBuilder();
        if (m > 0) {
            b.append(m).append(" min ");
        }
        b.append(s).append(" sec");
        return b.toString();
    }

    /**
     * Show time string at this
     *
     * @param d
     */
    private void setTimeString(int d) {
        StringBuilder b = new StringBuilder();
        b.append(mkTimeStr(d));
        b.append("(max:").append(mkTimeStr(max)).append(")");
        setText(b.toString());
    }

    /**
     * Set timer
     *
     * @return If exceed, return false
     */
    public boolean setTime() {
        Calendar c = Calendar.getInstance();
        //Get duration (sec) from the beginning
        int d = (int) (c.getTimeInMillis() - startDate.getTimeInMillis()) / 1000;
        setTimeString(d);
        if (d >= max) {//Exceed the limit
            setForeground(foregroundOver);
            return false;
        }
        setVisible(true);
        return true;
    }

    public void setForegroundNormal(Color foregroundNormal) {
        this.foregroundNormal = foregroundNormal;
    }

    public void setForegroundOver(Color foregroundOver) {
        this.foregroundOver = foregroundOver;
    }

}

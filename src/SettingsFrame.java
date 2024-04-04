import javax.swing.*;

public class SettingsFrame extends JFrame implements Runnable {

    private DrawPanel p;
    private Thread windowThread;

    public SettingsFrame(String display) {
        super(display);
        int frameWidth = 300;
        int frameHeight = 300;
        p = new DrawPanel();
        this.add(p);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(1100, 100);
        this.setVisible(true);
        startThread();

    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public void run() {
        while (true) {
            p.repaint();
        }
    }
}

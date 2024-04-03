
import javax.swing.JFrame;

public class MainFrame extends JFrame implements Runnable {

    private DrawPanel p;
    private Thread windowThread;

    public MainFrame(String display, int width, int height, int x, int y, int closingOperation) {
        super(display);
        int frameWidth = width;
        int frameHeight = height;
        p = new DrawPanel();
        this.add(p);
        this.setDefaultCloseOperation(closingOperation);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(x, y);
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

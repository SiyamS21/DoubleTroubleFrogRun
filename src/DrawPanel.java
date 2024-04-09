
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

class DrawPanel extends JPanel implements MouseListener {
    private Rectangle settingsButton;
    private BufferedImage settingsImage;



    public DrawPanel() {
        this.addMouseListener(this);
        settingsButton = new Rectangle(440, 420, 30, 30);
        try {
            settingsImage = ImageIO.read(new File("images/gear.png"));
        }
        catch (IOException e) {
            System.out.println(e);
            settingsImage = null;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("look", 100, 100);
        g.drawRect((int)settingsButton.getX(), (int)settingsButton.getY(), (int)settingsButton.getWidth(), (int)settingsButton.getHeight());
        g.drawImage(settingsImage, (int)settingsButton.getX(), (int)settingsButton.getY(), null);
    }

    public void mousePressed(MouseEvent e) {
        Point clicked = e.getPoint();
        SettingsFrame settings = null;

        if (e.getButton() == 1) {
            if (settingsButton.contains(clicked) && settings == null) {
                settings = new SettingsFrame("Settings");
            }
        }
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}

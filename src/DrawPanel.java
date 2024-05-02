
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
    private BufferedImage helpImage;
    private BufferedImage closeImage;
    private BufferedImage greenFrogImage;
    private BufferedImage yellowFrogImage;
    private BufferedImage blueFrogImage;
    private BufferedImage redFrogImage;
    private BufferedImage playImage;
    private Rectangle selectGreenButton;
    private Rectangle selectYellowButton;
    private Rectangle selectBlueButton;
    private Rectangle selectRedButton;
    private Rectangle playButton;
    private Rectangle helpButton;
    private Rectangle closeButton;
    private Rectangle tutorialButton;
    private enum STATE {
        MENU,
        LEVELSELECT,
        GAME,
        SETTINGS,
        HELP
    }
    private STATE currentState = STATE.MENU;



    public DrawPanel() {
        this.addMouseListener(this);
        settingsButton = new Rectangle(440, 420, 32, 32);
        playButton = new Rectangle(200, 200, 100, 45);
        helpButton = new Rectangle(400, 420, 32, 32);
        closeButton = new Rectangle(10, 10, 32, 32);
        tutorialButton = new Rectangle(200, 200, 30, 30);
        selectGreenButton = new Rectangle(20, 100, 75, 75);
        selectYellowButton = new Rectangle(20, 295, 75, 75);
        selectBlueButton = new Rectangle(100, 100, 75, 75);
        selectRedButton = new Rectangle(100, 295, 75, 75);
        try {
            settingsImage = ImageIO.read(new File("images/gear.png"));
        } catch (IOException e) {
            System.out.println(e);
            settingsImage = null;
        }
        try {
            helpImage = ImageIO.read(new File("images/help.png"));
        } catch (IOException e) {
            System.out.println(e);
            helpImage = null;
        }
        try {
            closeImage = ImageIO.read(new File("images/close.png"));
        } catch (IOException e) {
            System.out.println(e);
            closeImage = null;
        }
        try {
            greenFrogImage = ImageIO.read(new File("frogs/frog_green.png"));
        } catch (IOException e) {
            System.out.println(e);
            greenFrogImage = null;
        }
        try {
            yellowFrogImage = ImageIO.read(new File("frogs/frog_yellow.png"));
        } catch (IOException e) {
            System.out.println(e);
            yellowFrogImage = null;
        }
        try {
            blueFrogImage = ImageIO.read(new File("frogs/frog_blue.png"));
        } catch (IOException e) {
            System.out.println(e);
            blueFrogImage = null;
        }
        try {
            redFrogImage = ImageIO.read(new File("frogs/frog_red.png"));
        } catch (IOException e) {
            System.out.println(e);
            redFrogImage = null;
        }
        try {
            playImage = ImageIO.read(new File("images/play.png"));
        } catch (IOException e) {
            System.out.println(e);
            playImage = null;
        }
    }



    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        if (currentState == STATE.MENU) {
            g.drawRect((int)settingsButton.getX(), (int)settingsButton.getY(), (int)settingsButton.getWidth(), (int)settingsButton.getHeight());
            g.drawImage(settingsImage, (int)settingsButton.getX(), (int)settingsButton.getY(), null);
            g.drawRect((int)helpButton.getX(), (int)helpButton.getY(), (int)helpButton.getWidth(), (int)helpButton.getHeight());
            g.drawImage(helpImage, (int)helpButton.getX(), (int)helpButton.getY(), null);
            g.drawRect((int)playButton.getX(), (int)playButton.getY(), (int)playButton.getWidth(), (int)playButton.getHeight());
            g.drawImage(playImage, (int)playButton.getX(), (int)playButton.getY(), null);
        }
        if (currentState == STATE.SETTINGS || currentState == STATE.HELP || currentState == STATE.LEVELSELECT || currentState == STATE.GAME) {
            g.drawRect((int)closeButton.getX(), (int)closeButton.getY(), (int)closeButton.getWidth(), (int)closeButton.getHeight());
            g.drawImage(closeImage, (int)closeButton.getX(), (int)closeButton.getY(), null);
        }
        if (currentState == STATE.LEVELSELECT) {
            g.drawRect((int)tutorialButton.getX(), (int)tutorialButton.getY(), (int)tutorialButton.width, (int)tutorialButton.height);
            g.drawString("T", 210, 220);
        }
        if (currentState == STATE.SETTINGS) {
            g.drawRect((int)selectGreenButton.getX(), (int)selectGreenButton.getY(), (int)selectGreenButton.getWidth(), (int)selectGreenButton.getHeight());
            g.drawImage(greenFrogImage, (int)selectGreenButton.getX(), (int)selectGreenButton.getY(), null);
            g.drawRect((int)selectYellowButton.getX(), (int)selectYellowButton.getY(), (int)selectYellowButton.getWidth(), (int)selectYellowButton.getHeight());
            g.drawImage(yellowFrogImage, (int)selectYellowButton.getX(), (int)selectYellowButton.getY(), null);
            g.drawRect((int)selectBlueButton.getX(), (int)selectBlueButton.getY(), (int)selectBlueButton.getWidth(), (int)selectBlueButton.getHeight());
            g.drawImage(blueFrogImage, (int)selectBlueButton.getX(), (int)selectBlueButton.getY(), null);
            g.drawRect((int)selectRedButton.getX(), (int)selectRedButton.getY(), (int)selectRedButton.getWidth(), (int)selectRedButton.getHeight());
            g.drawImage(redFrogImage, (int)selectRedButton.getX(), (int)selectRedButton.getY(), null);
        }
    }

    public void mousePressed(MouseEvent e) {
        Point clicked = e.getPoint();

        if (e.getButton() == 1) {
            if (settingsButton.contains(clicked) && currentState == STATE.MENU) {
                currentState = STATE.SETTINGS;
                System.out.println("settings button pressed");
            }
            else if (helpButton.contains(clicked) && currentState == STATE.MENU) {
                currentState = STATE.HELP;
                System.out.println("help button pressed");
            }
            else if (closeButton.contains(clicked) && (currentState == STATE.SETTINGS || currentState == STATE.HELP || currentState == STATE.LEVELSELECT || currentState == STATE.GAME)) {
                currentState = STATE.MENU;
                System.out.println("close button pressed");
            }
            else if (playButton.contains(clicked) && currentState == STATE.MENU) {
                currentState = STATE.LEVELSELECT;
                System.out.println("play button pressed");
            }
            else if (tutorialButton.contains(clicked) && currentState == STATE.LEVELSELECT) {
                currentState = STATE.GAME;
                System.out.println("tutorial button pressed");
            }
        }
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}

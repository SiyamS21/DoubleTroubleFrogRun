
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

class DrawPanel extends JPanel implements MouseListener, KeyListener {
    private Rectangle settingsButton;
    private BufferedImage settingsImage;
    private BufferedImage helpImage;
    private BufferedImage closeImage;
    private BufferedImage greenFrogImage;
    private BufferedImage yellowFrogImage;
    private BufferedImage blueFrogImage;
    private BufferedImage redFrogImage;
    private BufferedImage playImage;
    private BufferedImage background;
    private Rectangle selectGreenButton;
    private Rectangle selectYellowButton;
    private Rectangle selectBlueButton;
    private Rectangle selectRedButton;
    private Rectangle playButton;
    private Rectangle helpButton;
    private Rectangle closeButton;
    private Rectangle tutorialButton;
    private String firstFrogColor;
    private String secondFrogColor;
    private Frog firstFrog;
    private Frog secondFrog;
    private char firstFrogKey;
    private char secondFrogKey;
    private Level currentLevel;
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
        this.addKeyListener(this);
        settingsButton = new Rectangle(440, 420, 32, 32);
        playButton = new Rectangle(200, 200, 80, 40);
        helpButton = new Rectangle(400, 420, 32, 32);
        closeButton = new Rectangle(10, 10, 32, 32);
        tutorialButton = new Rectangle(200, 200, 30, 30);
        selectGreenButton = new Rectangle(20, 100, 75, 75);
        selectYellowButton = new Rectangle(20, 295, 75, 75);
        selectBlueButton = new Rectangle(100, 100, 75, 75);
        selectRedButton = new Rectangle(100, 295, 75, 75);
        firstFrogColor = "green";
        secondFrogColor = "yellow";
        firstFrogKey = 'z';
        secondFrogKey = 'x';
        currentLevel = null;
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
        try {
            background = ImageIO.read(new File("images/background.jpg"));
        } catch (IOException e) {
            System.out.println(e);
            background = null;
        }
        try {
            firstFrog = new Frog(true, firstFrogColor, ImageIO.read(new File("frogs/frog_" + firstFrogColor + ".png")));
        } catch (IOException e) {
            System.out.println(e);
            firstFrog = null;
        }
        try {
            secondFrog = new Frog(false, secondFrogColor, ImageIO.read(new File("frogs/frog_" + secondFrogColor + ".png")));
        } catch (IOException e) {
            System.out.println(e);
            secondFrog = null;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        if (currentState == STATE.MENU) {
            g.drawImage(settingsImage, (int)settingsButton.getX(), (int)settingsButton.getY(), null);
            g.drawImage(helpImage, (int)helpButton.getX(), (int)helpButton.getY(), null);
            g.drawImage(playImage, (int)playButton.getX() - 9, (int)playButton.getY() - 3, null);
        }
        if (currentState == STATE.SETTINGS || currentState == STATE.HELP || currentState == STATE.LEVELSELECT || currentState == STATE.GAME) {
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
            g.setFont(new Font("Courier New", Font.BOLD, 15));
            g.drawString("Left click to choose the color of your first frog." , 10, 60);
            g.drawString("Right click to choose the color of your second frog.", 10, 80);
            g.setFont(new Font("Courier New", Font.BOLD, 20));
            if (firstFrogColor.equals("green")) {
                g.drawString("first", (int)selectGreenButton.getX(), (int)selectGreenButton.getY());
            }
            else if (firstFrogColor.equals("yellow")) {
                g.drawString("first", (int)selectYellowButton.getX(), (int)selectYellowButton.getY());
            }
            else if (firstFrogColor.equals("blue")) {
                g.drawString("first", (int)selectBlueButton.getX(), (int)selectBlueButton.getY());
            }
            else if (firstFrogColor.equals("red")) {
                g.drawString("first", (int)selectRedButton.getX(), (int)selectRedButton.getY());
            }
            if (secondFrogColor.equals("green")) {
                g.drawString("second", (int)selectGreenButton.getX(), (int)selectGreenButton.getY());
            }
            else if (secondFrogColor.equals("yellow")) {
                g.drawString("second", (int)selectYellowButton.getX(), (int)selectYellowButton.getY());
            }
            else if (secondFrogColor.equals("blue")) {
                g.drawString("second", (int)selectBlueButton.getX(), (int)selectBlueButton.getY());
            }
            else if (secondFrogColor.equals("red")) {
                g.drawString("second", (int)selectRedButton.getX(), (int)selectRedButton.getY());
            }
        }
        if (currentState == STATE.GAME) {
            g.drawImage(firstFrog.getImage(), firstFrog.getCurrentX(), firstFrog.getCurrentY(), null);
            g.drawImage(secondFrog.getImage(), secondFrog.getCurrentX(), secondFrog.getCurrentY(), null);
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
                currentLevel = new Level("tutorial");
            }
            else if (selectGreenButton.contains(clicked) && currentState == STATE.SETTINGS && !secondFrogColor.equals("green")) {
                firstFrogColor = "green";
                firstFrog.setColor("green");
                firstFrog.setImage(greenFrogImage);
            }
            else if (selectYellowButton.contains(clicked) && currentState == STATE.SETTINGS && !secondFrogColor.equals("yellow")) {
                firstFrogColor = "yellow";
                firstFrog.setColor("yellow");
                firstFrog.setImage(yellowFrogImage);
            }
            else if (selectBlueButton.contains(clicked) && currentState == STATE.SETTINGS && !secondFrogColor.equals("blue")) {
                firstFrogColor = "blue";
                firstFrog.setColor("blue");
                firstFrog.setImage(blueFrogImage);
            }
            else if (selectRedButton.contains(clicked) && currentState == STATE.SETTINGS && !secondFrogColor.equals("red")) {
                firstFrogColor = "red";
                firstFrog.setColor("red");
                firstFrog.setImage(redFrogImage);
            }
        }
        else if (e.getButton() == 3) {
            if (selectGreenButton.contains(clicked) && currentState == STATE.SETTINGS && !firstFrogColor.equals("green")) {
                secondFrogColor = "green";
                secondFrog.setColor("green");
                secondFrog.setImage(greenFrogImage);
            }
            else if (selectYellowButton.contains(clicked) && currentState == STATE.SETTINGS && !firstFrogColor.equals("yellow")) {
                secondFrogColor = "yellow";
                secondFrog.setColor("yellow");
                secondFrog.setImage(yellowFrogImage);
            }
            else if (selectBlueButton.contains(clicked) && currentState == STATE.SETTINGS && !firstFrogColor.equals("blue")) {
                secondFrogColor = "blue";
                secondFrog.setColor("blue");
                secondFrog.setImage(blueFrogImage);
            }
            else if (selectRedButton.contains(clicked) && currentState == STATE.SETTINGS && !firstFrogColor.equals("red")) {
                secondFrogColor = "red";
                secondFrog.setColor("red");
                secondFrog.setImage(redFrogImage);
            }
        }
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        if (currentState == STATE.GAME) {
            if (key == firstFrogKey) {
                firstFrog.move();
                System.out.println("moved f");
            }
            if (key == secondFrogKey) {
                secondFrog.move();
                System.out.println("moved s");
            }
        }
    }
}

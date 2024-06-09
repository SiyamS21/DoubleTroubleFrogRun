
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
    private BufferedImage greenTileImage;
    private BufferedImage yellowTileImage;
    private BufferedImage blueTileImage;
    private BufferedImage redTileImage;
    private BufferedImage playImage;
    private BufferedImage background;
    private BufferedImage background2;
    private Rectangle selectGreenButton;
    private Rectangle selectYellowButton;
    private Rectangle selectBlueButton;
    private Rectangle selectRedButton;
    private Rectangle playButton;
    private Rectangle helpButton;
    private Rectangle closeButton;
    private Rectangle tutorialButton;
    private Rectangle levelOneButton;
    private Rectangle levelTwoButton;
    private Rectangle levelThreeButton;
    private Rectangle selectFirstButton;
    private Rectangle selectSecondButton;
    private String firstFrogColor;
    private String secondFrogColor;
    private String firstTileColor;
    private String secondTileColor;
    private BufferedImage firstTileImage;
    private BufferedImage secondTileImage;
    private Frog firstFrog;
    private Frog secondFrog;
    private char firstFrogKey;
    private char secondFrogKey;
    private Level currentLevel;
    private int currentOffset;
    private enum STATE {
        MENU,
        LEVELSELECT,
        GAME,
        SETTINGS,
        HELP,
        FIRSTLETTERSELECT,
        SECONDLETTERSELECT,
        END,
        LOSS
    }
    private STATE currentState = STATE.MENU;



    public DrawPanel() {
        AudioPlayer.loopMusic("music");
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        settingsButton = new Rectangle(440, 420, 32, 32);
        playButton = new Rectangle(200, 200, 80, 40);
        helpButton = new Rectangle(400, 420, 32, 32);
        closeButton = new Rectangle(10, 10, 32, 32);
        tutorialButton = new Rectangle(200, 200, 30, 30);
        levelOneButton = new Rectangle(200, 245, 30, 30);
        levelTwoButton = new Rectangle(200, 290, 30, 30);
        levelThreeButton = new Rectangle(200, 335, 30, 30);
        selectGreenButton = new Rectangle(20, 100, 75, 75);
        selectYellowButton = new Rectangle(20, 295, 75, 75);
        selectBlueButton = new Rectangle(100, 100, 75, 75);
        selectRedButton = new Rectangle(100, 295, 75, 75);
        selectFirstButton = new Rectangle(245, 180, 30, 30);
        selectSecondButton = new Rectangle(245, 330, 30, 30);
        firstFrogColor = "green";
        secondFrogColor = "yellow";
        firstTileColor = "green";
        secondTileColor = "yellow";
        firstFrogKey = 'z';
        secondFrogKey = 'x';
        currentLevel = null;
        currentOffset = 0;
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
            greenTileImage = ImageIO.read(new File("tiles/tile_green.png"));
        } catch (IOException e) {
            System.out.println(e);
            greenTileImage = null;
        }
        try {
            yellowTileImage = ImageIO.read(new File("tiles/tile_yellow.png"));
        } catch (IOException e) {
            System.out.println(e);
            yellowTileImage = null;
        }
        try {
            blueTileImage = ImageIO.read(new File("tiles/tile_blue.png"));
        } catch (IOException e) {
            System.out.println(e);
            blueTileImage = null;
        }
        try {
            redTileImage = ImageIO.read(new File("tiles/tile_red.png"));
        } catch (IOException e) {
            System.out.println(e);
            redTileImage = null;
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
            background2 = ImageIO.read(new File("images/background2.jpg"));
        } catch (IOException e) {
            System.out.println(e);
            background2 = null;
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
        firstTileImage = greenTileImage;
        secondTileImage = yellowTileImage;
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
        if (currentState == STATE.SETTINGS || currentState == STATE.HELP || currentState == STATE.LEVELSELECT || currentState == STATE.END || currentState == STATE.LOSS) {
            g.drawImage(closeImage, (int)closeButton.getX(), (int)closeButton.getY(), null);
        }
        if (currentState == STATE.LEVELSELECT) {
            g.drawRect((int)tutorialButton.getX(), (int)tutorialButton.getY(), (int)tutorialButton.width, (int)tutorialButton.height);
            g.drawString("T", (int)tutorialButton.getX() + 10, (int)tutorialButton.getY() + 20);
            g.drawRect((int)levelOneButton.getX(), (int)levelOneButton.getY(), (int)levelOneButton.width, (int)levelOneButton.height);
            g.drawString("1", (int)levelOneButton.getX() + 10, (int)levelOneButton.getY() + 20);
            g.drawRect((int)levelTwoButton.getX(), (int)levelTwoButton.getY(), (int)levelTwoButton.width, (int)levelTwoButton.height);
            g.drawString("2", (int)levelTwoButton.getX() + 10, (int)levelTwoButton.getY() + 20);
            g.drawRect((int)levelThreeButton.getX(), (int)levelThreeButton.getY(), (int)levelThreeButton.width, (int)levelThreeButton.height);
            g.drawString("3", (int)levelThreeButton.getX() + 10, (int)levelThreeButton.getY() + 20);
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
            g.drawString("Click to choose the key", 225, 150);
            g.drawString("for your first frog:", 225, 165);
            g.drawString("Click to choose the key", 225, 300);
            g.drawString("for your second frog:", 225, 315);
            g.drawRect((int)selectFirstButton.getX(), (int)selectFirstButton.getY(), (int)selectFirstButton.getWidth(), (int)selectFirstButton.getHeight());
            g.drawString(String.valueOf(firstFrogKey).toUpperCase(), (int)selectFirstButton.getX() + 10, (int)selectFirstButton.getY() + 20);
            g.drawRect((int)selectSecondButton.getX(), (int)selectSecondButton.getY(), (int)selectSecondButton.getWidth(), (int)selectSecondButton.getHeight());
            g.drawString(String.valueOf(secondFrogKey).toUpperCase(), (int)selectSecondButton.getX() + 10, (int)selectSecondButton.getY() + 20);
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
            g.drawImage(background2, 0, 0, null);
            g.drawImage(closeImage, (int)closeButton.getX(), (int)closeButton.getY(), null);
            ArrayList<ArrayList<Tile>> currentLevelLayout = currentLevel.getLayout();
            int currentYLevel = 400;
            for (int r = currentLevelLayout.size() - 1; r >= 0; r--) {
                for (int c = 0; c < 3; c++) {
                    if (currentLevelLayout.get(r).get(c).getColor().equals("f")) {
                        g.drawImage(firstTileImage, 150 + (c * 80), currentYLevel + currentOffset, null);
                    }
                    else if (currentLevelLayout.get(r).get(c).getColor().equals("s")) {
                        g.drawImage(secondTileImage, 150 + (c * 80), currentYLevel + currentOffset, null);
                    }
                }
                currentYLevel -= 70;
            }
            for (int r = currentLevelLayout.size() - 1; r >= 0; r--) {
                int frogR = 0;
                for (int c = 0; c < 3; c++) {
                    if (currentLevelLayout.get(r).get(c).getColor().equals("f")) {
                        if (currentLevelLayout.get(r).get(c).hasFirstFrog()) {
                            g.drawImage(firstFrog.getImage(), (150 + (firstFrog.getCurrentX() * 80) - 13), 400 - (firstFrog.getCurrentY() * 70) + currentOffset - 18, null);
                            if (!firstFrog.beenInitialized()) {
                                System.out.println(c);
                                System.out.println(frogR);
                                firstFrog.setCurrentCoords(c, frogR);
                                firstFrog.flipInitialized();
                            }
                        }
                    }
                    else if (currentLevelLayout.get(r).get(c).getColor().equals("s")) {
                        if (currentLevelLayout.get(r).get(c).hasSecondFrog()) {
                            g.drawImage(secondFrog.getImage(), (150 + (secondFrog.getCurrentX() * 80) - 13), 400 - (secondFrog.getCurrentY() * 70) + currentOffset - 18, null);
                            if (!secondFrog.beenInitialized()) {
                                System.out.println(c);
                                System.out.println(frogR);
                                secondFrog.setCurrentCoords(c, frogR);
                                secondFrog.flipInitialized();
                            }
                        }
                    }
                    frogR++;
                }
            }
        }
        if (currentState == STATE.FIRSTLETTERSELECT || currentState == STATE.SECONDLETTERSELECT) {
            g.drawString("Press the key you would like to select", 13, 220);
        }
        if (currentState == STATE.END) {
            g.drawString("Congratulations! You won the level!", 50, 200);
        }
        if (currentState == STATE.LOSS) {
            g.drawString("You lost! Try again!", 70, 200);
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
            else if (closeButton.contains(clicked) && (currentState == STATE.SETTINGS || currentState == STATE.HELP || currentState == STATE.LEVELSELECT || currentState == STATE.GAME || currentState == STATE.END || currentState == STATE.LOSS)) {
                if (currentState == STATE.GAME) {
                    firstFrog.reset();
                    secondFrog.reset();
                    firstFrog.flipInitialized();
                    secondFrog.flipInitialized();
                }
                currentState = STATE.MENU;
                System.out.println("close button pressed");
            }
            else if (playButton.contains(clicked) && currentState == STATE.MENU) {
                currentState = STATE.LEVELSELECT;
                System.out.println("play button pressed");
            }
            else if (currentState == STATE.LEVELSELECT) {
                currentState = STATE.GAME;
                if (tutorialButton.contains(clicked)) {
                    System.out.println("tutorial button pressed");
                    currentLevel = new Level("tutorial");
                }
                else if (levelOneButton.contains(clicked)) {
                    System.out.println("one button pressed");
                    currentLevel = new Level("one");
                }
                else if (levelTwoButton.contains(clicked)) {
                    System.out.println("two button pressed");
                    currentLevel = new Level("two");
                }
                else if (levelThreeButton.contains(clicked)) {
                    System.out.println("three button pressed");
                    currentLevel = new Level("three");
                }
            }
            else if (selectGreenButton.contains(clicked) && currentState == STATE.SETTINGS && !secondFrogColor.equals("green")) {
                firstFrogColor = "green";
                firstTileColor = "green";
                firstTileImage = greenTileImage;
                firstFrog.setColor("green");
                firstFrog.setImage(greenFrogImage);
            }
            else if (selectYellowButton.contains(clicked) && currentState == STATE.SETTINGS && !secondFrogColor.equals("yellow")) {
                firstFrogColor = "yellow";
                firstTileColor = "yellow";
                firstTileImage = yellowTileImage;
                firstFrog.setColor("yellow");
                firstFrog.setImage(yellowFrogImage);
            }
            else if (selectBlueButton.contains(clicked) && currentState == STATE.SETTINGS && !secondFrogColor.equals("blue")) {
                firstFrogColor = "blue";
                firstTileColor = "blue";
                firstTileImage = blueTileImage;
                firstFrog.setColor("blue");
                firstFrog.setImage(blueFrogImage);
            }
            else if (selectRedButton.contains(clicked) && currentState == STATE.SETTINGS && !secondFrogColor.equals("red")) {
                firstFrogColor = "red";
                firstTileColor = "red";
                firstTileImage = redTileImage;
                firstFrog.setColor("red");
                firstFrog.setImage(redFrogImage);
            }
            else if (selectFirstButton.contains(clicked) && currentState == STATE.SETTINGS) {
                currentState = STATE.FIRSTLETTERSELECT;
            }
            else if (selectSecondButton.contains(clicked) && currentState == STATE.SETTINGS) {
                currentState = STATE.SECONDLETTERSELECT;
            }
        }
        else if (e.getButton() == 3) {
            if (selectGreenButton.contains(clicked) && currentState == STATE.SETTINGS && !firstFrogColor.equals("green")) {
                secondFrogColor = "green";
                secondTileColor = "green";
                secondTileImage = greenTileImage;
                secondFrog.setColor("green");
                secondFrog.setImage(greenFrogImage);
            }
            else if (selectYellowButton.contains(clicked) && currentState == STATE.SETTINGS && !firstFrogColor.equals("yellow")) {
                secondFrogColor = "yellow";
                secondTileColor = "yellow";
                secondTileImage = yellowTileImage;
                secondFrog.setColor("yellow");
                secondFrog.setImage(yellowFrogImage);
            }
            else if (selectBlueButton.contains(clicked) && currentState == STATE.SETTINGS && !firstFrogColor.equals("blue")) {
                secondFrogColor = "blue";
                secondTileColor = "blue";
                secondTileImage = blueTileImage;
                secondFrog.setColor("blue");
                secondFrog.setImage(blueFrogImage);
            }
            else if (selectRedButton.contains(clicked) && currentState == STATE.SETTINGS && !firstFrogColor.equals("red")) {
                secondFrogColor = "red";
                secondTileColor = "red";
                secondTileImage = redTileImage;
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
        char key = e.getKeyChar();

        if (currentState == STATE.GAME) {
            if (key == firstFrogKey) {
                try {
                    firstFrog.move(currentLevel.findNextMove(true, firstFrog.getCurrentX(), firstFrog.getCurrentY()));
                    if (firstFrog.getCurrentY() > secondFrog.getCurrentY() && firstFrog.getCurrentY() > 4) {
                        currentOffset += 70;
                    }
                } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    firstFrog.reset();
                    secondFrog.reset();
                    firstFrog.flipInitialized();
                    secondFrog.flipInitialized();
                    currentOffset = 0;
                    currentState = STATE.END;
                }
                /*if (currentState == STATE.GAME && !currentLevel.getLayout().get(firstFrog.getCurrentX()).get(firstFrog.getCurrentY()).getColor().equals("f")) {
                    firstFrog.reset();
                    secondFrog.reset();
                    firstFrog.flipInitialized();
                    secondFrog.flipInitialized();
                    currentOffset = 0;
                    AudioPlayer.playMusic("loss");
                    currentState = STATE.LOSS;
                }*/
                System.out.println("moved f to (" + firstFrog.getCurrentX() + ", " + firstFrog.getCurrentY() + ")");
            }
            if (key == secondFrogKey) {
                try {
                    secondFrog.move(currentLevel.findNextMove(true, secondFrog.getCurrentX(), secondFrog.getCurrentY()));
                    if (secondFrog.getCurrentY() > firstFrog.getCurrentY() &&  secondFrog.getCurrentY() > 4) {
                        currentOffset += 70;
                    }
                } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    firstFrog.reset();
                    secondFrog.reset();
                    firstFrog.flipInitialized();
                    secondFrog.flipInitialized();
                    currentOffset = 0;
                    currentState = STATE.END;
                }
                /*if (currentState == STATE.GAME && !currentLevel.getLayout().get(secondFrog.getCurrentX()).get(secondFrog.getCurrentY()).getColor().equals("s")) {
                    firstFrog.reset();
                    secondFrog.reset();
                    firstFrog.flipInitialized();
                    secondFrog.flipInitialized();\
                    currentOffset = 0;
                    AudioPlayer.playMusic("loss");
                    currentState = STATE.LOSS;
                }*/
                System.out.println("moved s to (" + secondFrog.getCurrentX() + ", " + secondFrog.getCurrentY() + ")");
            }
        }
        else if (currentState == STATE.FIRSTLETTERSELECT) {
            if (key != firstFrogKey && key != secondFrogKey) {
                firstFrogKey = key;
                currentState = STATE.SETTINGS;
            }
        }
        else if (currentState == STATE.SECONDLETTERSELECT) {
            if (key != firstFrogKey && key != secondFrogKey) {
                secondFrogKey = key;
                currentState = STATE.SETTINGS;
            }
        }
        if (key == 'o') {
            firstFrog.setCurrentCoords(0, 4);
            System.out.println(firstFrog.getCurrentX() + ", " + firstFrog.getCurrentY());
        }
        if (key == 'p') {
            secondFrog.setCurrentCoords(1, 2);
            System.out.println(secondFrog.getCurrentX() + ", " + secondFrog.getCurrentY());
        }
        if (key == 'q') {
            System.out.println(firstFrog.getCurrentX() + ", " + firstFrog.getCurrentY());
        }
        if (key == 'w') {
            System.out.println(secondFrog.getCurrentX() + ", " + secondFrog.getCurrentY());
        }
        if (key == '-') {
            currentState = STATE.END;
        }
    }

    public void keyTyped(KeyEvent e) {
    }
}

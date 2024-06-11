import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Frog {
    private boolean first;
    private String color;
    private int currentX;
    private int currentY;
    private BufferedImage image;
    private boolean initialized;
    private boolean isAboveOther;

    public Frog(boolean f, String c, BufferedImage i) {
        first = f;
        color = c;
        image = i;
        currentX = 0;
        currentY = 0;
        initialized = false;
        isAboveOther = false;
    }

    public void move(int move) {
        currentY++;
        if (move == 0) {
            currentX--;
        }
        else if (move == 2) {
            currentX++;
        }
        AudioPlayer.playMusic("dink");
    }

    public void reset() {
        currentY = 0;
        currentX = 0;
    }

    public boolean isFirst() {
        return first;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String c) {
        color = c;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage i) {
        image = i;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentX(int x) {
        currentX = x;
    }

    public void setCurrentY(int y) {
        currentY = y;
    }

    public void setCurrentCoords(int x, int y) {
        currentX = x;
        currentY = y;
    }

    public boolean beenInitialized() {
        return initialized;
    }

    public void flipInitialized() {
        initialized = !initialized;
    }

    public void setAboveOther(boolean choice) {
        isAboveOther = choice;
    }

    public boolean getAboveOther() {
        return isAboveOther;
    }
}

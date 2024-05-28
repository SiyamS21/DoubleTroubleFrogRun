import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Frog {
    private boolean first;
    private String color;
    private int currentX;
    private int currentY;
    private BufferedImage image;

    public Frog(boolean f, String c, BufferedImage i) {
        first = f;
        color = c;
        image = i;
        currentX = 0;
        currentY = 0;
    }

    public void move(int move) {
        currentY++;
        if (move == 0) {
            currentX--;
        }
        else if (move == 2) {
            currentX++;
        }
    }

    public void reset() {
        currentY = 400;
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
}

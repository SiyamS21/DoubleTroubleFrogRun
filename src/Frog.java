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
        if (f) {
            currentX = 100;
        }
        else {
            currentX = 200;
        }
        currentY = 400;
    }

    public void move() {
        currentY -= 50;
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
}

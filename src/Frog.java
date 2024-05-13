import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Frog {
    private boolean first;
    private String color;
    private int currentX;
    private int currentY;
    private BufferedImage image;

    public Frog(boolean f, String c, int x, int y, BufferedImage i) {
        first = f;
        color = c;
        currentX = x;
        currentY = y;
        image = i;
    }

    public void move() {

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
}

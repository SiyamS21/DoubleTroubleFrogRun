public class Frog {
    private boolean first;
    private String color;
    private int currentX;
    private int currentY;

    public Frog(boolean f, String c, int x, int y) {
        first = f;
        color = c;
        currentX = x;
        currentY = y;
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
}

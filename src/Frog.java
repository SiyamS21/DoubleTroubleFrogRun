public class Frog {
    private boolean first;
    private String color;

    public Frog(boolean f, String c) {
        first = f;
        color = c;
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

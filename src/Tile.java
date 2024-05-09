public class Tile {
    private int lane;
    private String color;

    public Tile(int l, String c) {
        lane = l;
        color = c;
    }

    public int getLane() {
        return lane;
    }

    public String getColor() {
        return color;
    }
}

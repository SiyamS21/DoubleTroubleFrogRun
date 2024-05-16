public class Tile {
    private int lane;
    private String info;

    public Tile(int l, String i) {
        lane = l;
        info = i;
    }

    public String getInfo() {
        return info;
    }

    public int getLane() {
        return lane;
    }

    public String getColor() {
        return info.substring(0, 1);
    }

    public boolean isEnd() {
        if (info.length() == 1) {
            return false;
        }
        else if (info.substring(1, 2).equals("E")) {
            return true;
        }
        return false;
    }

    public boolean hasFirstFrog() {
        if (info.length() == 1) {
            return false;
        }
        else if (info.substring(1, 2).equals("F")) {
            return true;
        }
        return false;
    }

    public boolean hasSecondFrog() {
        if (info.length() == 1) {
            return false;
        }
        else if (info.substring(1, 2).equals("S")) {
            return true;
        }
        return false;
    }
}

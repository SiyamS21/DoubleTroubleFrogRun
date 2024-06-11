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
        /*System.out.println("no end");*/
        if (info.length() == 1) {
            return false;
        }
        else if (info.substring(1, 2).equals("E")) {
            /*System.out.println("end is " + info.substring(1, 2));*/
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

    public void removeFirstFrog() {
        if (hasFirstFrog()) {
            info = getColor();
        }
    }

    public void removeSecondFrog() {
        if (hasSecondFrog()) {
            info = getColor();
        }
    }

    public void addFirstFrog() {
        if (!hasFirstFrog() && !isEnd()) {
            info = info + "F";
        }
    }

    public void addSecondFrog() {
        if (!hasSecondFrog() && !isEnd()) {
            info = info + "S";
        }
    }
}

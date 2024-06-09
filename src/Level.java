import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {
    private ArrayList<ArrayList<Tile>> layout;
    private String name;

    public Level(String n) {
        name = n;
        layout = new ArrayList<ArrayList<Tile>>();
        File f = null;
        String leftTile = "";
        String middleTile = "";
        String rightTile = "";
        try {
            f = new File("levels/level_" + name);
            Scanner s = new Scanner(f);
            int r = 0;
            while (s.hasNextLine()) {
                layout.add(new ArrayList<Tile>());
                String currentLine = s.nextLine();
                leftTile = currentLine.substring(1, currentLine.indexOf("]"));
                currentLine = currentLine.substring(currentLine.indexOf("]") + 1);
                middleTile = currentLine.substring(currentLine.indexOf("[") + 1, currentLine.indexOf("]"));
                currentLine = currentLine.substring(currentLine.indexOf("]") + 1);
                rightTile = currentLine.substring(currentLine.indexOf("[") + 1, currentLine.indexOf("]"));
                layout.get(r).add(0, new Tile(0, leftTile));
                layout.get(r).add(1, new Tile(1, middleTile));
                layout.get(r).add(2, new Tile(2, rightTile));
                r++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Level not found");
        }
        for (int r = 0; r < layout.size(); r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print("[" + layout.get(r).get(c).getColor() + "]");
            }
            System.out.println("");
        }
    }

    // 0 = forward and left
    // 1 = forward
    // 2 = forward and right
    public int findNextMove(boolean first ,int currentX, int currentY) {
        boolean zero = true;
        boolean one = true;
        boolean two = true;

        if (currentX == 0) {
            zero = false;
        }
        else if (currentX == 2) {
            two = false;
        }

        if (first) {
            System.out.println("first");
            System.out.println(currentX + ", " + currentY);
            if (zero && (layout.get(currentY + 1).get(currentX - 1).getColor().equals("x") || layout.get(currentY + 1).get(currentX - 1).getColor().equals("s"))) {
                System.out.println("zero");
                zero = false;
            }
            if (layout.get(currentY + 1).get(currentX).getColor().equals("x") || layout.get(currentY + 1).get(currentX).getColor().equals("s")) {
                one = false;
            }
            if (two && (layout.get(currentY + 1).get(currentX + 1).getColor().equals("x") || layout.get(currentY + 1).get(currentX).getColor().equals("s"))) {
                two = false;
            }
        }
        else {
            System.out.println("second");
            System.out.println(currentX + ", " + currentY);
            if (zero && (layout.get(currentY + 1).get(currentX - 1).getColor().equals("x") || layout.get(currentY + 1).get(currentX - 1).getColor().equals("f"))) {
                System.out.println("zero");
                zero = false;
            }
            if (layout.get(currentY + 1).get(currentX).getColor().equals("x") || layout.get(currentY + 1).get(currentX).getColor().equals("f")) {
                System.out.println("one");
                one = false;
            }
            if (two && (layout.get(currentY + 1).get(currentX + 1).getColor().equals("x") || layout.get(currentY + 1).get(currentX).getColor().equals("f"))) {
                System.out.println("two");
                two = false;
            }
        }
        if (zero) {
            if (first) {
                layout.get(currentY).get(currentX).removeFirstFrog();
                layout.get(currentY + 1).get(currentX - 1).addFirstFrog();
            }
            else {
                layout.get(currentY).get(currentX).removeSecondFrog();
                layout.get(currentY + 1).get(currentX - 1).addSecondFrog();
            }
            return 0;
        }
        else if (one) {
            if (first) {
                layout.get(currentY).get(currentX).removeFirstFrog();
                layout.get(currentY + 1).get(currentX).addFirstFrog();
            }
            else {
                layout.get(currentY).get(currentX).removeSecondFrog();
                layout.get(currentY + 1).get(currentX).addSecondFrog();
            }
            return 1;
        }
        else if (two){
            if (first) {
                layout.get(currentY).get(currentX).removeFirstFrog();
                layout.get(currentY + 1).get(currentX + 1).addFirstFrog();
            }
            else {
                layout.get(currentY).get(currentX).removeSecondFrog();
                layout.get(currentY + 1).get(currentX + 1).addSecondFrog();
            }
            return 2;
        }
        else {
            zero = true;
            two = true;

            if (currentX == 0) {
                zero = false;
            }
            else if (currentX == 2) {
                two = false;
            }

            if (zero && (layout.get(currentY + 1).get(currentX - 1).getColor().equals("f") || layout.get(currentY + 1).get(currentX - 1).getColor().equals("s"))) {
                return 0;
            }
            if (layout.get(currentY + 1).get(currentX).getColor().equals("f") || layout.get(currentY + 1).get(currentX).getColor().equals("s")) {
                return 1;
            }
            if (two && (layout.get(currentY + 1).get(currentX + 1).getColor().equals("f") || layout.get(currentY + 1).get(currentX + 1).getColor().equals("s"))) {
                return 2;
            }

            return 10;
        }
    }

    public ArrayList<ArrayList<Tile>> getLayout() {
        return layout;
    }

    public void moveFrog(boolean first) {
        if (first) {

        }
    }
}

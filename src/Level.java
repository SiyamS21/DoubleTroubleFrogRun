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
        System.out.println(layout.get(3).get(0).getColor());
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
            if (zero && layout.get(currentX + 1).get(currentY - 1).getColor().equals("x") || layout.get(currentX + 1).get(currentY - 1).getColor().equals("s")) {
                zero = false;
            }
            if (layout.get(currentX + 1).get(currentY).getColor().equals("x") || layout.get(currentX + 1).get(currentY).getColor().equals("s")) {
                one = false;
            }
            if (two && layout.get(currentX + 1).get(currentY + 1).getColor().equals("x") || layout.get(currentX + 1).get(currentY).getColor().equals("s")) {
                one = false;
            }
        }
        else {
            if (zero && layout.get(currentX + 1).get(currentY - 1).getColor().equals("x") || layout.get(currentX + 1).get(currentY - 1).getColor().equals("f")) {
                zero = false;
            }
            if (layout.get(currentX + 1).get(currentY).getColor().equals("x") || layout.get(currentX + 1).get(currentY).getColor().equals("f")) {
                one = false;
            }
            if (two && layout.get(currentX + 1).get(currentY + 1).getColor().equals("x") || layout.get(currentX + 1).get(currentY).getColor().equals("f")) {
                one = false;
            }
        }
        if (zero) {
            return 0;
        }
        else if (one) {
            return 1;
        }
        else {
            return 2;
        }
    }
}

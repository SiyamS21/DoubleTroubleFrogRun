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
                layout.get(r).add(0, new Tile(0, leftTile.substring(0, 1)));
                layout.get(r).add(1, new Tile(1, middleTile.substring(0, 1)));
                layout.get(r).add(2, new Tile(2, rightTile.substring(0, 1)));
                r++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Level not found");
        }
        for (int r = layout.size() - 1; r >= 0; r--) {
            for (int c = 0; c < 3; c++) {
                System.out.print("[" + layout.get(r).get(c).getColor() + "]");
            }
            System.out.println("");
        }
    }
}

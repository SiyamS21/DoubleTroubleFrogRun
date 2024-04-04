import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame("Double Trouble Frog Run");
        File f = null;
        try {
            f = new File("levels/level_tutorial");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();

            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
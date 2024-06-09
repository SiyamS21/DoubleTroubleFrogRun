import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class AudioPlayer {

    public static void playMusic(String audio) {
        try {
            File musicPath = new File("audios/" + audio + ".wav");

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
            else {
                System.out.println("Can't find audio file!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void loopMusic(String audio) {
        try {
            File musicPath = new File("audios/" + audio + ".wav");

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Integer.MAX_VALUE);
            }
            else {
                System.out.println("Can't find audio file!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Map {

    private Scanner m;
    public String Map[] = new String[999];
    private Image grass, wall, finish;

    public Map(int double_rows, int double_cols) {

        ImageIcon img = new ImageIcon();
        try {
            img = new ImageIcon(this.getClass().getResource("/grass.png"));
            grass = img.getImage();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            img = new ImageIcon(this.getClass().getResource("/wall.png"));
            wall = img.getImage();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            img = new ImageIcon(this.getClass().getResource("/finish.gif"));
            finish = img.getImage();
        } catch (Exception e) {
            System.out.println(e);
        }

        openFile();
        readFile(double_rows);
        closeFile();
        delFile();
    }

    public Image getGrass() {
        return grass;
    }

    public Image getWall() {
        return wall;
    }

    public Image getFinish() {
        return finish;
    }

    public String getMap(int x, int y) {
        String index = Map[y].substring(x, x + 1);
        return index;
    }

    public void openFile() {
        try {
            m = new Scanner(Paths.get("Maze.map"));
            System.out.println("Load map");
        } catch (Exception e) {
            System.out.println("Error loading map");
        }
    }

    public void readFile(int double_rows) {
        try {
            while (m.hasNext()) {
                for (int i = 0; i < double_rows; i++) {
                    Map[i] = m.next();
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading map");
        }
    }

    public void closeFile() {
        m.close();
    }

    public void delFile() {
        try {
            Files.delete(Paths.get("Maze.map"));
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}


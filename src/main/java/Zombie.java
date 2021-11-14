import javax.swing.*;
import java.awt.*;

public class Zombie {

    private int tileX, tileY;
    private Image zombie;

    public Zombie() {

        try {
            ImageIcon img = new ImageIcon(this.getClass().getResource("/zombie2.gif"));
            zombie = img.getImage();
        } catch (Exception e) {
            System.out.println(e);
        }

        tileX = 23;
        tileY = 23;
    }

    public Image getZombie() {
        return zombie;
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileX(int x) {
        tileX = x;
    }

    public void setTileY(int y) {
        tileY = y;
    }

    public void move(int dx, int dy) {
        tileX += dx;
        tileY += dy;
    }

}



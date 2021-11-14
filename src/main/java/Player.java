import javax.swing.*;
import java.awt.*;

public class Player {

    private int tileX, tileY, vector;
    private Image player;

    public Player(){

        tileX = 1;
        tileY = 1;

        try {
            ImageIcon img = new ImageIcon(this.getClass().getResource("/player.gif"));
            player = img.getImage();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Image getPlayer(){
        return player;
    }

    public int getTileX(){
        return tileX;
    }

    public int getTileY(){
        return tileY;
    }

    public void move(int dx, int dy){

        tileX += dx;
        tileY += dy;

    }

}

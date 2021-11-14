//https://forum.shelek.ru/index.php/topic,30238.0.html
//https://www.youtube.com/user/ChillinWithTym/videos

import javax.swing.*;
import java.awt.*;

public class Maze {

    int ROWS;
    int COLS;

    public Maze(int nROWS, int nCOLS){

        ROWS = nROWS;
        COLS = nCOLS;

        JFrame f = new JFrame("Maze Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(ROWS*64+48,COLS*64+71);
        f.setLayout(new BorderLayout());
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.add(new Board(ROWS, COLS));
        f.setVisible(true);

//        JOptionPane.showMessageDialog(null, "Привет");
    }
}
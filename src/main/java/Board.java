import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Map m;
    private Player p;
    private Zombie z;
    public int double_rows, double_cols;
    double angleInDegrees;
    private boolean win = false;
    private String message =" ";
    private Font font = new Font("Serif", Font.BOLD, 48);

    public Board(int rows, int cols) {
        double_rows = rows * 2 + 1;
        double_cols = cols * 2 + 1;

        m = new Map(double_rows, double_cols);
        p = new Player();
        z = new Zombie();

        addKeyListener(new Al());
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(m.getMap(p.getTileX(), p.getTileY()).equals("f")){
            message = "Win!";
            win = true;
        }

        zombieMove();
        repaint();
        revalidate();
    }

    public void zombieMove(){

//        ThreadSleep s = new ThreadSleep();
//
//        s.ThreadSleep(2000);


        int x = rnd(-1,1);
        int y = rnd(-1,1);

        if(m.getMap(z.getTileX() + x, z.getTileY() + y).equals("g")){
            z.move(x, y);
        }
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g2 = (Graphics2D) graphics;

        if(!win) {
            for (int y = 0; y < double_rows; y++) {
                for (int x = 0; x < double_cols; x++) {
                    if (m.getMap(x, y).equals("f")) {
                        g2.drawImage(m.getWall(), x * 32, y * 32, null);
                        g2.drawImage(m.getFinish(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("s")) {
                        g2.drawImage(m.getWall(), x * 32, y * 32, null);
                        g2.drawImage(m.getFinish(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("g")) {
                        g2.drawImage(m.getGrass(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("w")) {
                        g2.drawImage(m.getWall(), x * 32, y * 32, null);
                    }
                }
            }

//            double angleInDegrees = 45.0; // Угол поворота в градусах
//            double angleInRadians = Math.toRadians(angleInDegrees);
//            double locationX = 16;
//            double locationY = 16;
//            AffineTransform tx = AffineTransform.getRotateInstance(angleInRadians, locationX, locationY);
//            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
//
//            AffineTransform trans = new AffineTransform();
//            trans.getRotateInstance(Math.toRadians(angleInDegrees), 64, 64);
//            trans.se
//            trans.setTransform(identity);
//            trans.rotate(Math.toRadians(angleInDegrees));

//            Image img = op.filter(p.getPlayer(), null);
//            g2.drawImage(img, new AffineTransform(1f, 0f, 0f, 1f, x, y), null);
//
//            g2.drawImage(p.getPlayer(), trans, null);
            g2.drawImage(p.getPlayer(), p.getTileX()*32, p.getTileY()*32,null);
            g2.drawImage(z.getZombie(), z.getTileX()*32, z.getTileY()*32, null);
        }else{
            g2.setColor(Color.orange);
            g2.setFont(font);
            g2.drawString(message, 50, 50);
        }
    }

    public int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public class Al extends KeyAdapter {

        public void keyPressed(KeyEvent e){

            int keycode = e.getKeyCode();

            if(keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP){
                angleInDegrees = -45.0;
                if(!m.getMap(p.getTileX(), p.getTileY()-1).equals("w")) {
                    p.move(0, -1);
                }
            }
            if(keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT){
                angleInDegrees = 0.0;
                if(!m.getMap(p.getTileX()+1, p.getTileY()).equals("w")) {
                    p.move(1, 0);
                }
            }
            if(keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN){
                angleInDegrees = 45.0;
                if(!m.getMap(p.getTileX(), p.getTileY()+1).equals("w")) {
                    p.move(0, 1);
                }
            }
            if(keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT){
                angleInDegrees = 90.0;
                if(!m.getMap(p.getTileX()-1, p.getTileY()).equals("w")) {
                    p.move(-1, 0);
                }
            }
        }

        public void keyRelased(KeyEvent e){
            //
        }

        public void keyTyped(KeyEvent e){
            //
        }
    }
}
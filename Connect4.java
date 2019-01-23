import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class connect4 extends JApplet implements KeyListener, MouseListener
{
    boolean turn = false;
     int x = 10, y = 10;
     int space = 0;
     int w = 0;
     int[][] b = {
             {0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0}
         };
     public void init()
     {
         setFocusable(true);
         addKeyListener(this);
         addMouseListener(this);
     }
     public void paint(Graphics g) {
         //drop
         //black is turn true and 1
         //red is turn false and 2
          
         //board drawing
         g.setColor(Color.cyan);
         g.fillRect(10, 10, 285, 240);
         g.setColor(Color.black);
         g.drawString("Press Space to reset the board", 10, 280);

         if(space == 1){
             for(int i = 0; i < b.length; i++){
                for(int j = 0; j < b[0].length; j++){
                    b[i][j] = 0;
                }
             }
             space = 0;
             w = 0;
             g.setColor(Color.white);
             g.fillRect(10, 290, 200, 100);
         }
         
         
         for(int i = 0; i < b.length; i++){
             for(int j = 0; j < b[0].length; j++){
                 if(b[i][j] == 0){
                        g.setColor(Color.white);
                        g.fillOval(x+ (40*j), y + (40*i), 40, 40);
                 }
                 if(b[i][j] == 1){
                     g.setColor(Color.black);
                     g.fillOval(x+ (40*j), y+(40*i), 40, 40);

                 }
                  if(b[i][j] == 2){
                        g.setColor(Color.red);
                        g.fillOval(x+(40*j), y+(40*i), 40, 40);
                  }
             }
             
         }
         
         if(win()){
            if(w == 1){
                g.setColor(Color.black);
                g.drawString("Player 2 (black) wins!", 10, 310);
            }
            if(w == 2){
                g.setColor(Color.red);
                g.drawString("Player 1 (red) wins!", 10, 310);
            }
         }
         
         
     }
     //drop fills all of the column. add second for loop
     public boolean drop(int c){
         if(b[0][c] == 0){
          
             for(int i = b.length-1; i >= 0; i--){
                     if(b[i][c] == 0){
                         if(turn == true){
                             b[i][c] = 1;
                             break;
                         }
                         if(!turn){
                          b[i][c] = 2;
                          break;
                         }
                     }
               
            }
                return true;
            }
            return false;
        }   

    public boolean win () {
        for (int i = 5; i > -1; i--) {
            for (int j = 0; j < b[0].length; j++) {
                if (j + 3 < 7 && b[i][j] == 1 && b[i][j + 1] == 1 && b[i][j + 2] == 1 && b[i][j + 3] == 1) {
                    w = 1;
                    return true;
                }
                if (i + 3 < 6 && b[i][j] == 1 && b[i + 1][j] == 1 && b[i + 2][j] == 1 && b[i + 3][j] == 1) {
                    w = 1;
                    return true;
                }
                if (i - 3 >= 0 && j + 3 < b[0].length && b[i][j] == 1 && b[i - 1][j + 1] == 1 && b[i - 2][j + 2] == 1 && b[i -3][j + 3] == 1) {
                    w = 1;
                    return true;
                }
                if (i - 3 > -1 && j - 3 > -1 && b[i][j] == 1 && b[i - 1][j - 1] == 1 && b[i - 2][j - 2] == 1 && b[i -3][j - 3] == 1) {
                    w = 1;
                    return true;
                }
                if (j + 3 < 7 && b[i][j] == 2 && b[i][j + 1] == 2 && b[i][j + 2] == 2 && b[i][j + 3] == 2) {
                    w = 2;
                    return true;
                }
                if (i + 3 < 6 && b[i][j] == 2 && b[i + 1][j] == 2 && b[i + 2][j] == 2 && b[i + 3][j] == 2) {
                    w = 2;
                    return true;
                }
                if (i - 3 >= 0 && j + 3 < b[0].length && b[i][j] == 2 && b[i - 1][j + 1] == 2 && b[i - 2][j + 2] ==2 && b[i -3][j + 3] == 2) {
                    w = 2;
                    return true;
                }
                if (i - 3 > -1 && j - 3 > -1 && b[i][j] == 2 && b[i - 1][j - 1] == 2 && b[i - 2][j - 2] == 2 && b[i -3][j - 3] == 2) {
                    w = 2;
                    return true;
                }
            }        
        }
        return false;
    }

        
    public void mouseClicked(MouseEvent e){
        int col = (e.getX() - 10)/40;
        if(col >= 0 && col <= 6 ){
            drop(col);
            turn = !turn;
        }
        repaint();
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
        
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == ' '){
            space = 1;
        }
        repaint();

    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
        
}

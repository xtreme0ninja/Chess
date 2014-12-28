/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Riley
 */
public class Chess extends JFrame {

    private JLabel[][] labelArray = new JLabel[8][8];
    private Background[][] imageArray = new Background[8][8];

    public void Chess() { //Board currentState was previous arguement

        JFrame frame = new JFrame("Chess");
        frame.setBackground(Color.DARK_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Background ui = new Background();
        frame.add(ui);
        frame.setSize(600, 600);
        frame.setVisible(true);

        // drawBoard(currentState.currentBoard);

    }

    private void drawBoard(Piece[][] board) {
        for (int s = 0; s < board.length; s++) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[s][i] != null) {
                    Piece currentPiece = board[s][i];
                    labelArray[s][i].setIcon(currentPiece.getImage());
                }

            }
        }
    }

    class Background extends JPanel {

        private Image image;

        /**
         * Default constructor used to set the image for the background for the
         * instance
         */
        public Background() { //Image img previous arguements
            //image = img;
        }

        @Override
        protected void paintComponent(Graphics g) {
            //draws image to background to scale of frame
            drawSquares(g);
            
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(40, 40, 520, 40);
            g.drawLine(40, 40, 40, 520);
            g.drawLine(520, 40, 520, 520);
            g.drawLine(520, 520, 40, 520);
            
            //g.fillRect(10,10,20,20);

        }

        private void drawSquares(Graphics g) {
            int x = 40;
            int y = 40;
            for (int j = 0; j < 8; j++) {
                for (int i = 0; i < 4; i++) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x, y, 60, 60);
                    x += 120;
                }
                y += 60;
                if (j % 2 == 0) {
                    x = 100;
                } else {
                    x = 40;
                }
            }

        }
    }

    //oh my god look at her butt
    //Create move(piece, Position) not sure which class its going into
    //Call check legal move to make sure move is allowed to Position
    //If Legal
    //If peice at target location
    //Add piece to removed list (Where is removed list going)
    //Replace refrence at Postion with the Piece we're moving
    //Set old location to null
    //Update board state
    //If note legal
    //Thorw new IllegalMoveException
    public static void main(String[] args) {
        new Chess().Chess();
        //Start
        //Set up Board
        //Call move medhod



    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

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
    


public void Chess(Board currentState){
    
    
    drawBoard(currentState.currentBoard);

}

private void drawBoard(Piece[][] board){
    for (int s = 0; s < board.length; s++) {
        for(int i = 0; i < board[0].length; i++){
            if(board[s][i] != null){
               Piece currentPiece=board[s][i];
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
        public Background(Image img) {
            image = img;
        }

        @Override
        protected void paintComponent(Graphics g) {
            //draws image to background to scale of frame
            g.drawImage(image, 0, 0, null);
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
        //Start
        //Set up Board
        //Call move medhod
        
        
        
}
}

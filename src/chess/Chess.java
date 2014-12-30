/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Riley
 */
public class Chess extends JFrame {

    public void Chess() { //Board currentState was previous arguement

        JFrame frame = new JFrame("Chess");
        frame.setBackground(Color.DARK_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Board currentBoard = new Board();
        
        Background ui = new Background(currentBoard);
        frame.add(ui);
        frame.setSize(600, 600);
        frame.setVisible(true);

        // drawBoard(currentState.currentBoard);

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

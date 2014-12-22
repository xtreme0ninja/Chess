/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Riley
 */
public class Piece {
    
    private boolean isWhite;
    private Position location;
    
    public Position[] getLegalMoves(Board state){
        //this will be overridden in each method
        return null;
    }
    
    public final boolean isLegalMove(Position pos,Player current){
         //If player is on correct team
         //call Legal Moves
         //Check if position is in that list
        return false;
    }
    
    public ImageIcon getImage(){
        
        return null;
    }
    
    
}

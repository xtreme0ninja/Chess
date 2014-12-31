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
    private Image image;
    
  
    
    public Position[] getLegalMoves(Board state, Position pieceLocation){
        //this will be overridden in each method
        return null;
    }
    
    public boolean isWhite(){   //Need to do this better
        return isWhite;
    }
    
    /*
     * False is black, true is white
     */
   
    public void setColourToWhite(boolean white){
        isWhite = white;
    }
    
    public final boolean isLegalMove(Position pos,Player current){
         //If player is on correct team
         //call Legal Moves
         //Check if position is in that list
        return false;
    }
    
    public Image getImage(){
        
        return image;
    }
    
    public void setImage(Image toSet){
        image = toSet;
    }
    
    
}

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
public class Pawn extends Piece{
    private Image image;
    
    
    public Pawn(boolean isWhite){
       Image chessImage;
       chessImage = new ImageIcon("pawn.png").getImage();
       this.image = chessImage;
       this.setColourToWhite(isWhite);
    }
    
   
    
    @Override
    public Image getImage(){
        
        return image;
    }
    
    //if row = last then promotion
}

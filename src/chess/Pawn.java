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
    
    
    
    public Pawn(boolean isWhite){
       
       
       super.setColourToWhite(isWhite);
        Image chessImage;
        if (super.isWhite() == true){
            chessImage = new ImageIcon("WhitePawn.png").getImage();
        }else{
            chessImage = new ImageIcon("BlackPawn.png").getImage();
        }
        super.setImage(chessImage);
    }
    
   
    
   
    
    //if row = last then promotion
}

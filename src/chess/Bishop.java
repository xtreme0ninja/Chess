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
public class Bishop extends Piece{
    
    public Bishop(boolean isWhite){
        super.setColourToWhite(isWhite);
        Image chessImage;
        if (super.isWhite() == true){
            chessImage = new ImageIcon("WhiteBishop.png").getImage();
        }else{
            chessImage = new ImageIcon("BlackBishop.png").getImage();
        }
        
        super.setImage(chessImage);
    }
    
}

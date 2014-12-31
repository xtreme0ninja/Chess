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
        Image chessImage = new ImageIcon("Bishop.png").getImage();  //Currently only does one colour, need to set to change based on white or black team
        super.setImage(chessImage);
    }
    
}

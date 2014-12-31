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
public class Queen extends Piece{
    
    public Queen(Boolean isWhite){
        super.setColourToWhite(isWhite);
        Image chessImage;
        if (super.isWhite() == true){
            chessImage = new ImageIcon("WhiteQueen.png").getImage();
        }else{
            chessImage = new ImageIcon("BlackQueen.png").getImage();
        }
        super.setImage(chessImage);
    }
    
}

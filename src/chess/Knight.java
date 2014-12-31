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
public class Knight extends Piece{
    
    public Knight (Boolean isWhite){
        super.setColourToWhite(isWhite);
        Image chessImage;
        if (super.isWhite() == true){
            chessImage = new ImageIcon("WhiteKnight.png").getImage();
        }else{
            chessImage = new ImageIcon("BlackKnight.png").getImage();
        }
        super.setImage(chessImage);
    }
    
}

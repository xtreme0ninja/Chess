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
public class Rook extends Piece{
    
    public Rook(Boolean isWhite){
        super.setColourToWhite(isWhite);
        Image chessImage;
        if (super.isWhite() == true){
            chessImage = new ImageIcon("WhiteRook.png").getImage();
        }else{
            chessImage = new ImageIcon("BlackRook.png").getImage();
        }
        super.setImage(chessImage);
    }
    //include something for castling
    
}

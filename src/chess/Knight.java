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
    
    @Override
    public Position[] getLegalMoves(Board state, Position pieceLocation){
        Position[] moves = new Position[8];
        int currentX = pieceLocation.x;
        int currentY = pieceLocation.y;
        
        if(currentX >= 2 && currentY >= 1){
            moves[0] = new Position(currentX-2, currentY-1);
        }
        
        if(currentX >=1 && currentY >= 2){
            moves[1] = new Position(currentX-1, currentY-2);
        }
        
        if(currentX <= 6 && currentY >= 2){
            moves[2] = new Position(currentX+1, currentY-2);
        }
        
        if(currentX <= 5 && currentY >= 1){
            moves[3] = new Position(currentX+2, currentY-1);
        }
        
        if(currentX <= 5 && currentY <= 6){
            moves[4] = new Position(currentX+2, currentY+1);
        }
        
        if(currentX <= 6 && currentY <= 5){
            moves[5] = new Position(currentX+1, currentY+2);
        }
        
        if(currentX >= 1 && currentY <= 5){
            moves[6] = new Position(currentX-1, currentY+2);
        }
        
        if(currentX >= 2 && currentY <= 6){
            moves[7] = new Position(currentX-2, currentY+1);
        }
        
        return moves;
    }
}

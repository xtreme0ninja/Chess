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
public class King extends Piece {

    public boolean hasMoved = false; // For castling

    public King(boolean isWhite) {

        super.setColourToWhite(isWhite);

        Image chessImage;
        if (isWhite == true) {
            chessImage = new ImageIcon("WhiteKing.png").getImage();
        } else {
            chessImage = new ImageIcon("BlackKing.png").getImage();
        }
        super.setImage(chessImage);
        ;
    }

    @Override
    public Position[] getLegalMoves(Board state, Position pieceLocation) {


        // int currentIndex = 0; //For organizing moves
        // Position[] moves = new Position[10];

        /*if (player.canCastle){  //Some way to tell if castling is allowed
         if(isWhite == true){    //Only account for teams, not which casteling move is allowed
         moves[currentIndex] = new Position(7,2);   //Castle top left
         currentIndex++;
         moves[currentIndex] = new Position(7,6);   //Castle top right
         currentIndex++;
         }
         else{
         moves[currentIndex] = new Position(0,2);   //Castle bottom left
         currentIndex++;
         moves[currentIndex] = new Position(0,6);   //Castle bottom right
         currentIndex++;
         }
         }*/

        //find the kings position
        Position currentPosition = pieceLocation; // temp setting of current position
        int currentX = currentPosition.x;
        int currentY = currentPosition.y;

        Position[] movesToCheck = new Position[8];


        movesToCheck[0] = new Position(currentX - 1, currentY);        //These are all the possible moves of the king
        movesToCheck[1] = new Position(currentX - 1, currentY - 1);
        movesToCheck[2] = new Position(currentX, currentY - 1);
        movesToCheck[3] = new Position(currentX + 1, currentY - 1);
        movesToCheck[4] = new Position(currentX + 1, currentY);
        movesToCheck[5] = new Position(currentX + 1, currentY + 1);
        movesToCheck[6] = new Position(currentX, currentY + 1);
        movesToCheck[7] = new Position(currentX - 1, currentY + 1);


        /* Position[] resultsInCheck = getActiveSpaces(); // This will get every space that the enemy can hit (To elimate moving into check)
     
         for(int j = 0 ; j < moves.length ; j++){
         for(int k = 0 ; k < resultsInCheck.length ; k++){
         if(moves[j] == resultsInCheck[k]){
         moves[j] = null;    //Set spaces that would result in check to null
         }
         }
         }*/

        return movesToCheck;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author Riley
 */
public class Board {
    
    public Piece[][] currentBoard;
    private int cost; //cost of the board state? Some fitness shit neede bro
    private Piece[] captured;//The captured peices avalible for promotion?
    
    
    
    public Board(){
        
    }
    
    public Piece getPiece(Position location){
        
        if(currentBoard[location.x][location.y] != null){
            return currentBoard[location.x][location.y];
        }
        
        return null;
    }
    
}

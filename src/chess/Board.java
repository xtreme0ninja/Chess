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
    public int numPieces ; //The number of pieces currently in the game, used to draw every peice so we know how many there are
    private int numCaptured = 0;
    
    
    
    public Board(){
        
        
        makeStartBoard(); //Just does pawns now;
        captured = new Piece[32];
        
    }
    
    private void makeStartBoard(){
        
        currentBoard = new Piece[8][8];
        numPieces = 0;
        boolean isWhite = true;
        for(int i = 0; i < 8 ; i++){
            if(i==2){i=6;isWhite = false;}
            for (int j = 0 ; j < 8 ; j++){
                currentBoard[i][j] = new King(isWhite); //Change this to test different pieces on the board
                numPieces++;
            }
        }
       
        
        
    }
    
    public void storeCapturedPieceForPromotion(Piece toBeStored){
        captured[numCaptured] = toBeStored;
        numCaptured++;
    }
    
    public Piece getPiece(Position location){
        
        if(currentBoard[location.x][location.y] != null){
            return currentBoard[location.x][location.y];
        }
        
        return null;
    }
    
}

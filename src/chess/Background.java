/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Riley
 */
public class Background extends JPanel implements MouseListener, MouseMotionListener {

    private int x1 = 40, y1 = 40;
    private Image image;
    private Board currentState;
    private boolean pieceSelected = false;
    private Piece selectedPiece;
    private Graphics p;
    private Position selectedPieceLocation, selectedPieceNewLocation; //THis may ause issues, saved where the selected peices location was

    /**
     * Default constructor used to set the image for the background for the
     * instance
     */
    public Background(Board state) { //Image img previous arguements
        this.addMouseListener(this);
        this.currentState = state;
        selectedPieceNewLocation = new Position(0, 0); //THis is bad, setting the new location , but needed so we can get the new location of the peice (where it moved too)
    }

    @Override
    protected void paintComponent(Graphics g) {
        p = g;
        //draws image to background to scale of frame
        super.paintComponent(g);

        drawSquares(g);

        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(40, 40, 520, 40);
        g.drawLine(40, 40, 40, 520);
        g.drawLine(520, 40, 520, 520);
        g.drawLine(520, 520, 40, 520);

        drawBoard(g);

        Image pic = currentState.getPiece(selectedPieceNewLocation).getImage();
        Position drawSpot = whereToDraw(x1, y1);
        g.drawImage(pic, drawSpot.x, drawSpot.y, this);
    }

    private void drawBoard(Graphics g) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (currentState.currentBoard[i][j] != null) {
                    Image pic = currentState.getPiece(new Position(i, j)).getImage();
                    Position drawSpot = getLocationOnScreenByBoardPosition(i, j);
                    g.drawImage(pic, drawSpot.x, drawSpot.y, this);
                }
            }
        }

    }

    private Position getLocationOnScreenByBoardPosition(int x, int y) {
        int currentSpaceX = 40; //The positions 
        int currentSpaceY = 40;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == x && j == y) {
                    return new Position(currentSpaceX, currentSpaceY);
                }
                currentSpaceX += 60;
            }
            currentSpaceX = 40;
            currentSpaceY += 60;
        }
        return null;



    }

    /*
     * Draws the grey squares (Dark ones) -- i think this is backwards? Like top right should be white
     */
    private void drawSquares(Graphics g) {
        int x = 40;
        int y = 40;
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 4; i++) {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x, y, 60, 60);
                x += 120;
            }
            y += 60;
            if (j % 2 == 0) {
                x = 100;
            } else {
                x = 40;
            }
        }

    }

    //THis method similar to where was clicked, can probably make more efficient
    //Returns where to draw the picture, so the pictures are cenetered in the square
    private Position whereToDraw(int x, int y) {
        int currentSpaceX = 40; //The positions 
        int currentSpaceY = 40;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (x >= currentSpaceX && y >= currentSpaceY && x <= currentSpaceX + 60 && y <= currentSpaceY + 60) {
                    return new Position(currentSpaceX, currentSpaceY);
                }
                currentSpaceX += 60;
            }
            currentSpaceX = 40;
            currentSpaceY += 60;
        }
        return null;
    }

    /*
     * Returns the clicked location as a Position  -- This is similar to thr above method
     */
    private Position whereWasClicked(int x, int y) {

        int currentSpaceX = 40;
        int currentSpaceY = 40;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (x >= currentSpaceX && y >= currentSpaceY && x <= currentSpaceX + 60 && y <= currentSpaceY + 60) {
                    System.out.println("i =" + i + " j =" + j);
                    return new Position(i, j);
                }
                currentSpaceX += 60;
            }
            currentSpaceX = 40;
            currentSpaceY += 60;
        }
        return null;
    }

    private void drawAtPosition(Piece pieceToDraw, int x, int y) {
        //Image pic = currentState.getPiece(selectedPieceLocation).getImage();
        //p.drawImage(pic, x, y, this);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (pieceSelected == false) { //If we arent currently selecting a peice
            selectNewPiece(e);
        } else if (pieceSelected == true) {
            x1 = e.getX();
            y1 = e.getY();
            Position clicked = whereWasClicked(x1, y1);
            if (clicked.x != selectedPieceLocation.x || clicked.y != selectedPieceLocation.y) {
                
                Piece pieceAtTargetLocation = currentState.getPiece(clicked);   //Gets the piece at the location where we want ot move too
                
                if (pieceAtTargetLocation == null) {    //If the location we want to move it to has nothing, move it
                    
                    Position[] legalMoves = selectedPiece.getLegalMoves(currentState,selectedPieceLocation);
                    
                    if (isLegalMove(legalMoves,clicked)){   //If the move they want to do is a legal one, then do it
                    moveSelectedPiece(clicked,false);
                    }
                    
                } else if (selectedPiece.isWhite() == pieceAtTargetLocation.isWhite()) {  //If same colour then select that piece instead
                    boolean a =selectedPiece.isWhite();
                    boolean b =pieceAtTargetLocation.isWhite();
                    selectNewPiece(e);

                }else if(!selectedPiece.isWhite() == pieceAtTargetLocation.isWhite()){//If enemy Piece
                    
                    moveSelectedPiece(clicked,true);
                    
                }else{
                    //Shouldnt happen
                
                }
            }


        }
    }
    
    public boolean isLegalMove(Position[] legalMoves, Position currentMove){
        
        for(int i = 0 ; i < legalMoves.length ; i++){
            if(legalMoves[i].x == currentMove.x && legalMoves[i].y == currentMove.y ){
                return true;
            }
        }
        
        return false;
    }

    public void selectNewPiece(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        selectedPieceLocation = whereWasClicked(x1, y1);
        Piece currentPiece = currentState.getPiece(selectedPieceLocation);
        if (currentPiece != null) { //If we clicked a peice
            pieceSelected = true;
            selectedPiece = currentPiece;

        }
    }

    /*
     * Move a selected piece to a new location and update the board accordingly
     * 
     * @clicked - Position on the board where you are moving the selected piece to
     * @isCapturingPiece - If you moved on top of an opponents piece, we need to update the removal of said opponts piece
     */
    
    
    public void moveSelectedPiece(Position clicked, boolean isCapturingPiece) {
        
        if(isCapturingPiece == true){
            Piece capturedPiece = currentState.currentBoard[clicked.x][clicked.y];
            currentState.numPieces--;
            currentState.storeCapturedPieceForPromotion(capturedPiece);
        }
        drawAtPosition(selectedPiece, x1, y1);
        currentState.currentBoard[clicked.x][clicked.y] = selectedPiece;    //Move the peice to the new position
        currentState.currentBoard[selectedPieceLocation.x][selectedPieceLocation.y] = null; //Set old location to null
        selectedPieceLocation = null;
        selectedPiece = null;
        pieceSelected = false;
        selectedPieceNewLocation = clicked;
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

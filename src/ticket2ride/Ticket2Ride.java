
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket2ride;

import model.*;

import java.util.List;

/**
 *
 * @author PC1
 */
public class Ticket2Ride {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Ticket To Ride!");

        // Get all the sets of train pieces
        TrainPieces t = new TrainPieces();
        List<TrainPiece> black = t.getPieces(TrainPieces.COLOR.BLACK);
        List<TrainPiece> blue = t.getPieces(TrainPieces.COLOR.BLUE);
        List<TrainPiece> green = t.getPieces(TrainPieces.COLOR.GREEN);
        List<TrainPiece> red = t.getPieces(TrainPieces.COLOR.RED);
        List<TrainPiece> yellow = t.getPieces(TrainPieces.COLOR.YELLOW);

        List<TrainPiece> wrong = t.getPieces(TrainPieces.COLOR.BLACK);

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket2ride;

/* Edit - DS */

// Include all the classes from the model package
import model.*;

/* End Edit - DS */

/**
 *
 * @author PC1
 * @author dsalazar10
 */
public class Ticket2Ride {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* Edit - DS */

        // MARK - Variables
        Board usaBoard = new Board();
        Player player1 = new Player("Player 1", TrainPieces.COLOR.RED),
                player2 = new Player("Player 2", TrainPieces.COLOR.YELLOW),
                player3 = new Player("Player 3", TrainPieces.COLOR.BLUE);

        /* End Edit - DS */
    }

}

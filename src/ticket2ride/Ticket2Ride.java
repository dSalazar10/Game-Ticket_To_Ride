/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket2ride;

/* Edit - DS */

// Include all the classes from the model package
import model.*;

import java.util.List;

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

    /* Edit - DS */

    /*
     * @param    The action chosen by the player:
     *           1. Draw Action (Get 2 Train Car Cards)
     *           2. Claim a route
     *           3. Draw Action (Get 3 Destination Ticket Cards)
     */
    public void takeTurn(Board board, int action) {
        if(action == 1)
            board.claimRoute(board);
        else
            drawAction(board, action);
    }

    /*
     * @param    The action chosen by the player:
     *           1. Get 2 Train Car Cards
     *           2. (Claim a route)
     *           3. Get 3 Destination Ticket Cards
     * @return
     */
    private List<TrainCard> drawAction(Board board, int action) {
        if(action < 1) {
            List<TrainCard> trainCards = board.get2TrainCards();
            return trainCards;
        } else {
            List<TrainCard> destCards = board.get3DestCards();
            return destCards;
        }
    }

    /* End Edit - DS */
}

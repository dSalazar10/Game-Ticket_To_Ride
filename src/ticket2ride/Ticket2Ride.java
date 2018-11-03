/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *  Each round, each of the players (2-5) will take one turn.
 *  One turn consists of a player choosing one of the following actions:
 *  1) Get 2 Face Up Cards or Face down cards  (Faceup Locomotive counts as 2 cards)
 *  2) Claim a Route - requires X number of train cards matching the color and
 *  3) Draw a destination card
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
        player1.addBoard(usaBoard);
        player2.addBoard(usaBoard);
        player3.addBoard(usaBoard);

        /* End Edit - DS */
    }

    /* Edit - DS */

    /*
     *  If a player claims a route and their train pieces pile is less than 3 pieces, each player gets one last turn.
     *  Once the last turns are over, the game is over.
     *  @param    action
     *           The action chosen by the player:
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
     * @param    action
     *           The action chosen by the player:
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
            List<TrainCard> destCards = board.get2TrainCards();
            return destCards;
        }
    }

    /* End Edit - DS */
}

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
        Board b = new Board();
        b.print();
    }
}

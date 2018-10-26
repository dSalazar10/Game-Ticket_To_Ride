/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket2ride;

/**
 *
 * @author PC1
 */
public class Ticket2Ride {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize the Board

        // Initialize the Player
    }

}

/*
*
1)Initialize the Board (1)
    1. Init/Shuffle Train Cards (3.1)
    2. Init/Shuffle Destination Ticket Cards (3.3)
    3. Init Face Up Set (8)
        1. Get 5 Train Car Cards (3.1)
            1. Get 5 Train Car Cards (6)
                1. Set 5 Train Car Cards (5.1) in Face Up Set (8)
                2. if(3 out of 5 cards are Locomotive Train Cards)
                    1. Set all Face Up Set Cards (8) into Discard Pile (7)
                    2. Return to 5
    4. Set 1 Longest Path Card
        1. Get 1 Longest Continuation Path Bonus Card (3.4)
            1. Set 1 Longest Continuation Path Bonus Card (3.4) face up
2) Initialize Player:
1. Get 45 Train Pieces in their Color (2)
2. Get 4 Train Car Cards (3.1)
3. (Secret) Get 3 Destination Ticket Cards (3.3)
    1. Return 2, 1, or 0 Cards to bottom of Destination Ticket Cards Deck
4. Get 1 Score Marker in their Color (4)
5. Set Scoring Marker on Start
*/
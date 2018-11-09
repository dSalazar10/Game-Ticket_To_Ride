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

import java.util.ArrayList;
import java.util.List;

/* End Edit - DS */

/**
 *
 * @author PC1
 * @author dsalazar10
 * @author Nasario S
 */
public class Ticket2Ride {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean claimroute = false;
        boolean drawDestCards = false;
        boolean playable = true;
        int player = 1;
        ArrayList<TrainCard> drawingCards;
        ArrayList<DestinationCard> destCards;
        /* Edit - NS */

        // MARK - Variables
        Board usaBoard = new Board();
        // usaBoard.print();
        Player[] p = new Player[3];
        p[0] = new Player("Player 1", TrainPieces.COLOR.RED);
        p[1] = new Player("Player 2", TrainPieces.COLOR.YELLOW);
        p[2] = new Player("Player 3", TrainPieces.COLOR.BLUE);
        p[0].addBoard(usaBoard);
        p[1].addBoard(usaBoard);
        p[2].addBoard(usaBoard);
        int iter = 0;
        int turn = 0;
        /*
         * Will loop and take one players turn at a time, then checks if a player has 3 or less
         * Train Pieces if so each player will take one more turn else keep taking turns
         * Without user input (User input is marked) it loops forever and Draws 2 cards from TrainCarDeck
         * until TrainCardDeck is empty then just loops.
         */
        do {
            player = 1;
            /*
            Start SudoTurn
             */
            while (player < 4) {
                if(turn == player)
                    System.out.println("Player " + player + " Draw Train Cards");
                drawingCards = usaBoard.trainDeck.Draw();
                while (iter < drawingCards.size()) {
                    p[player - 1].insertTrainCar(drawingCards.get(iter));
                    iter++;
                }
                iter = 0;

                System.out.println("PLayer " + player + " Do you want to Draw Destination Cards?");
                // userInput
                if (drawDestCards) {
                    destCards = usaBoard.destDeck.Draw();
                    while (iter < destCards.size()) {
                        drawDestCards = false;
                        System.out.println("Player" + player + " Do you want to keep this card?");
                        // userInput
                        if (drawDestCards)
                            p[player - 1].insertDestTixCard(destCards.get(iter));
                        else
                            p[player - 1].removeDestTixCard(p[player - 1].getSizeofDest() - 1);
                        iter++;
                    }
                    iter = 0;
                }
                System.out.println("Player " + player + " Do you want to claim a route?");
                // userInput
                if (claimroute == true) {
                    claimRoute(p, player - 1);
                }
                if (p[(player - 1)].getPeicesLeft() < 3){
                    playable = false;
                    turn = player;
                }
                player++;
            /*
            End of Sudo Turn
             */
            }
        } while (playable);
        /* End Edit - NS */
        player = 1;
            /*
            Start of Final SudoTurn
             */
        while (player < 4) {
            if(turn == player) {

                System.out.println("Player " + player + " Draw Train Cards");
                drawingCards = usaBoard.trainDeck.Draw();
                while (iter < drawingCards.size()) {
                    p[player - 1].insertTrainCar(drawingCards.get(iter));
                    iter++;
                }
                iter = 0;
                System.out.println("PLayer " + player + " Do you want to Draw Destination Cards?");
                // userInput
                if (drawDestCards == true) {
                    destCards = usaBoard.destDeck.Draw();
                    while (iter < destCards.size()) {
                        drawDestCards = false;
                        System.out.println("Player" + player + " Do you want to keep this card?");
                        // userInput

                        if (drawDestCards)
                            p[player - 1].insertDestTixCard(destCards.get(iter));
                        else
                            p[player - 1].removeDestTixCard(p[player - 1].getSizeofDest() - 1);
                        iter++;
                    }
                    iter = 0;
                }
                System.out.println("Player " + player + " Do you want to claim a route?");
                // userInput
                if (claimroute == true) {
                    claimRoute(p, player - 1);
                }
            }
            player++;
            /*
            End of Final Sudo Turn
             */
        }
    }
    public static void claimRoute (Player[]p,int turn){

    }

}
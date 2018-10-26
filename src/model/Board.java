
/*
 * Board.java
 * Version 0.2.0    : Game Turn
 * Programmer       : Daniel Salazar
 * Due Date         : 11/07/18
 * Last Modified    : 10/26/18 01:20
 *
 * This class represents the game board. It will get cards and pieces placed on it. Players will interact with those
 * cards and pieces placed on the board.
 */

package model;

public class Board {

    // Variables
    TrainCardDeck trainDeck;
    DestinationTicketSet destDeck;
    TrainPieces trainPieces;
    String routes[] = new String[] {"Vancouver","Calgary","Winnipeg","Seattle","Portland","Helena","Salt Lake City",
            "Denver","San Francisco","Las Vegas","Santa Fe","Los Angeles","Phoenix","El Paso","Oklahoma City",
            "Duluth","Omaha","Kansas City","Dallas","Houston","Chicago","Saint Louis","Little Rock","New Orleans",
            "Nashville","Toronto","Pittsburgh","Atlanta","Miami","Charleston","Washington","Raleigh","New York",
            "Boston","Montreal","Sault Ste. Marie"};

    /* *
     * Class Constructor
     */
    public Board() {
        trainDeck = new TrainCardDeck();
        destDeck = new DestinationTicketSet();
        trainPieces = new TrainPieces();
    }

    /* *
    * This method allows the Player to draw a card during their turn
    *
    * @return The TrainCard located at the top of the deck.
    */
    private TrainCard drawTrainCard() {
        return this.trainDeck.Draw(true);
    }

    /* *
     * This method allows the Player to draw a card during their turn
     *
     * @return The TrainCard chose by Player
     */
    private TrainCard faceUpDraw(int at) {
        return this.trainDeck.fromTable(at);
    }

    /*
    * @param    The action chosen by the player:
    *           1. Draw Action (Get 2 Train Car Cards)
    *           2. Claim a route
    *           3. Draw Action (Get 3 Destination Ticket Cards)
    */
    public void takeTurn(int action) {
        if(action == 1)
            claimRoute();
        else
            drawAction(action);

    }

    /*
     * @param    The action chosen by the player:
     *           1. Get 2 Train Car Cards
     *           2. (Claim a route)
     *           3. Get 3 Destination Ticket Cards
     */
    private void drawAction(int action) {
        if(action < 1)
            get2TrainCards();
        else
            get3DestCards();

    }

    // Get 2 Train Car Cards
    private void get2TrainCards() {}
    // Claim a route
    private void claimRoute() {}
    // Get 3 Destination Ticket Cards
    private void get3DestCards() {}

}

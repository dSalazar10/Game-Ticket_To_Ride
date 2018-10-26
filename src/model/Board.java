
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

import java.util.ArrayList;
import java.util.List;

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

    // Get 2 Train Car Cards
    public List<TrainCard> get2TrainCards() {
        // TODO: Get 2 Train Cards
        /*
        // A list of one or two cards
        List<TrainCard> cards = new ArrayList<>();

        // Either draw a card from the dest deck
        cards.add(drawTrainCard());

        // Or draw a card from the table
        int FarLeft = 0;
        cards.add(faceUpDraw(FarLeft));

        // return card(s)
        return cards;
        */
        return null;
    }
    // Claim a route
    public Boolean claimRoute(Board board) {
        // TODO: Claim a route from the Board's route list
        return null;
    }
    // Get 3 Destination Ticket Cards
    public List<TrainCard> get3DestCards() {
        // TODO: Get 3 Destination Cards
        return null;
    }

    /* *
     * This method allows the Player to draw a card during their turn
     * <p>
     * @return The TrainCard located at the top of the deck.
     */
    private TrainCard drawTrainCard() {
        return this.trainDeck.Draw(true);
    }

    /* *
     * This method allows the Player to draw a card during their turn
     * <p>
     * @return The TrainCard chose by Player
     */
    private TrainCard faceUpDraw(int at) {
        return this.trainDeck.fromTable(at);
    }

}

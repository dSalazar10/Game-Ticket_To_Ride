
/*
 * Board.java
 * Version 0.2.0    : Game Turn
 * Programmer       : Daniel Salazar
 * Due Date         : 11/05/18
 * Last Modified    : 11/02/18 08:42
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
    String routes[] = new String[] {"Vancouver", "Calgary", "Seattle", "Winnipeg", "Helena", "Portland",
            "Sault Ste. Marie", "Duluth", "Omaha", "San Francisco", "Salt Lake City", "Montreal", "Toronto", "Chicago",
        "Kansas City", "Oklahoma City", "Santa Fe", "Los Angeles", "Denver", "New York", "Pittsburgh", "Saint Louis",
            "Little Rock", "Dallas", "El Paso", "Las Vegas", "Boston", "Phoenix", "Washington", "Raleigh", "Nashville",
        "New Orleans", "Houston", "Charleston", "Atlanta", "Miami"};

    List<Route> routes;
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
    /* TODO: Finish the Design and Generate an Algorithm
    * Route A to Route B will have some number of trains connecting them
    * In order to claim a route, the player is required to have the exact number of cards matching the color
    * and they also have to posses the exact number of Train Pieces.
    * The route claimed does not have to be connected to any other route.
    * */
    public int claimRoute() {
        // TODO: Claim a route from the Board's route list
        return null;
    }

}

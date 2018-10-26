
/*
 * Board.java
 * Version 0.1.4    : Setup
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : 10/25/18 23:13
 *
 * This class represents the game board. It will get cards and pieces placed on it. Players will interact with those
 * cards and pieces placed on the board.
 */

package model;

public class Board {

    // Fake prototypes
    private class Longest_Path {
    }

    // Variables
    TrainCardDeck trainDeck;
    DestinationTicketSet destDeck;
    TrainPieces trainPieces;
    String routes[] = new String[] {"Vancouver","Calgary","Winnipeg","Seattle","Portland","Helena","Salt Lake City",
            "Denver","San Francisco","Las Vegas","Santa Fe","Los Angeles","Phoenix","El Paso","Oklahoma City",
            "Duluth","Omaha","Kansas City","Dallas","Houston","Chicago","Saint Louis","Little Rock","New Orleans",
            "Nashville","Toronto","Pittsburgh","Atlanta","Miami","Charleston","Washington","Raleigh","New York",
            "Boston","Montreal","Sault Ste. Marie"};

    // Default Constructor
    public Board() {

        // Fake prototypes
        Init_Longest_Path_Card();

        // Variables
        trainDeck = new TrainCardDeck();
        destDeck = new DestinationTicketSet();
        trainPieces = new TrainPieces();


    }

    // Fake prototypes
    private void Init_Longest_Path_Card() {
        Longest_Path lp = new Longest_Path();
    }
}

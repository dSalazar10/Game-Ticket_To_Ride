
/*
 * Board.java
 * Version 0.1.4    : Setup
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */

package model;

class Board {

    private class Destination_Ticket_Deck {
        private void Shuffle() {}
    }
    private class Train_Car_Discard {
    }
    private class Train_Car_Faceup {
    }
    private class Longest_Path {
    }

    String routes[] = new String[] {"Vancouver","Calgary","Winnipeg","Seattle","Portland","Helena","Salt Lake City",
            "Denver","San Francisco","Las Vegas","Santa Fe","Los Angeles","Phoenix","El Paso","Oklahoma City",
            "Duluth","Omaha","Kansas City","Dallas","Houston","Chicago","Saint Louis","Little Rock","New Orleans",
            "Nashville","Toronto","Pittsburgh","Atlanta","Miami","Charleston","Washington","Raleigh","New York",
            "Boston","Montreal","Sault Ste. Marie"};

    // Default Constructor
    Board() {
        // Fake prototypes
        Init_Destination_Cards();
        Init_Discard_Cards();
        Init_Face_Up_Cards();
        Init_Longest_Path_Card();

        // Variables
        initTrainCardCards();
    }

    // Fake prototypes
    private void Init_Destination_Cards() {
        // Fake prototypes for cards
        Destination_Ticket_Deck dtd = new Destination_Ticket_Deck();
        dtd.Shuffle();
    }
    private void Init_Discard_Cards() {

        Train_Car_Discard tcd = new Train_Car_Discard();
    }
    private void Init_Face_Up_Cards() {
        // 5 cards
        Train_Car_Faceup tcf = new Train_Car_Faceup();
    }
    private void Init_Longest_Path_Card() {
        // 1 card
        Longest_Path lp = new Longest_Path();
    }

    // Initialize the Train Car Card Deck and Shuffle
    private void initTrainCardCards() {
        // Variables
        TrainCardDeck trainCarDeck = new TrainCardDeck();
        //trainCarDeck.Shuffle();
    }


}
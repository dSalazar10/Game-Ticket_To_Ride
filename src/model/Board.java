
/*
 * Board.java
 * Version 0.2.1    : Game Turn
 * Programmer       : Daniel Salazar
 * Due Date         : 11/05/18
 * Last Modified    : 11/02/18 23:00
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


    Route board;
    /* *
     * Class Constructor
     */
    public Board() {
        trainDeck = new TrainCardDeck();
        destDeck = new DestinationTicketSet();
        trainPieces = new TrainPieces();

        // List of Routes
        int[][] children;
        children = new int[][]{
                // root
                {1},
                // 1 → 2, 3
                {2, 3},
                // 2 → 4,5
                {4, 5},
                // 3 → 2, 5, 6
                {2, 5, 6},
                // 4 → 7, 8
                {7, 8},
                // 5 → 4, 8, 9, 11, 19
                {4, 8, 9, 11, 19},
                // 6 → 10, 11
                {10, 11},
                // 7 → 12, 13
                {12, 13},
                // 8 → 7, 13, 14
                {7, 13,14},
                // 9 → 8, 14, 15
                {8, 14, 15},
                // 10 → 11, 18
                {11, 18},
                // 11 → 19, 26
                {19, 26},
                // 12 → 27, 20
                {27, 20},
                // 13 → 21
                {21},
                // 14 → 13, 21, 22
                {13, 21, 22},
                // 15 → 22
                {22},
                // 16 → 15, 23, 24
                {15, 23, 24},
                // 17 → 16, 25
                {16, 25},
                // 18 → 26, 28, 25
                {26, 28, 25},
                // 19 → 9, 15, 16, 17
                {9, 15, 16, 17},
                // 20 → 27, 29
                {27, 29},
                // 21 → 20, 29, 30
                {20, 29, 30},
                // 22 → 21, 31
                {21, 31},
                // 23 → 31, 32
                {31, 32},
                // 24 → 33
                {33},
                // 25 → 24, 33
                {24, 33},
                // 26 → NULL
                {},
                // 27 → NULL
                {},
                // 28 → 17, 25
                {17, 25},
                // 29 → NULL
                {},
                // 30 → 34
                {34},
                // 31 → 35
                {35},
                // 32 → 35, 36
                {35, 36},
                // 33 → 32
                {32},
                // 34 → 36
                {36},
                // 35 → 34, 36
                {34, 36},
                // 36 → NULL
                {}
        };
        // Initialize the board
        board = new Route(0, 5);
        Route node = board;
        // Set all the nodes
        for(int i = 0; i < children.length; ++i) {
            node = board.getNode(i);
            node.setchildren(children[i]);
        }

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
        return -1;
    }

    public void print() {
        Route.print(board);
    }
}

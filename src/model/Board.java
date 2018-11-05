
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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Board {

    // Variables
    public TrainCardDeck trainDeck;
    public DestinationTicketSet destDeck;
    public TrainPieces trainPieces;


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

        // TODO: initilize the Board's RouteCosts
        // ArrayList<ArrayList<RouteCost>> counts = new ArrayList<ArrayList<RouteCost>>(36);
        // counts.add(new ArrayList<RouteCost>());

        int[][][] trains;
        trains = new int[][][]{
                // root
                {{0}},
                // Vancouver = {Calgary (3 Gray), Seattle (1 Gray / 1 Gray)}
                {{3}, {1, 1}},
                // Calgary = {Winnipeg (6 White), Helena (4 Gray)}
                {{6}, {4}},
                // Seattle = {Calgary (4 Gray), Helena  (6 Yellow), Portland (1 Gray / 1 Gray)}
                {{4}, {6}, {1, 1}},
                // Winnipeg = {Sault St. Marie (6 Gray), Duluth (4 Black)}
                {{6}, {4}},
                // Helena = {Winnipeg (4 Blue), Duluth (6 Orange), Omaha (5 Red), Denver (4 Green), Salt Lake City (3 Pink)}
                {{4}, {6}, {5}, {4}, {3}},
                // Portland = {San Francisco (5 Green / 5 Pink), Salt Lake City (6 Blue)}
                {{5, 5}, {6}},
                // Sault St. Marie = {Montreal (5 Black), Toronto (2 Gray)}
                {{5}, {2}},
                // Duluth = {Sault St. Marie (3 Gray), Toronto (6 Pink), Chicago (3 Red)}
                {{3}, {6}, {3}},
                // Omaha = {Duluth (2 Gray / 2 Gray), Chicago (4 Blue), Kansas City (1 Gray / 1 Gray)}
                {{2, 2}, {4}, {1, 1}},
                // San Francisco = { (5 Orange / 5 White), Los Angeles (3 Yellow / 3 Pink)}
                {{5, 5}, {3, 3}},
                // Salt Lake City = {Denver (3 Red / 3 Yellow), Las Vegas (3 Orange)}
                {{3, 3}, {3}},
                // Montreal = {Boston (2 Gray / 2 Gray), New York (3 Blue)}
                {{2, 2}, {3}},
                // Toronto = {Pittsburgh (2 Gray)}
                {{2}},
                // Chicago = {Toronto (4 White), Pittsburgh (3 Orange / 3 Black), Saint Louis  (2 Green / 2 White)}
                {{4}, {3, 3}, {2, 2}},
                // Kansas City = {Saint Louis (2 Blue / 2 Pink)}
                {{2, 2}},
                // Oklahoma City = {Kansas City (2 Gray / 2 Gray), Little Rock (2 Gray), Dallas (2 Gray)}
                {{2, 2}, {2}, {2}},
                // Sante Fe = {Oklahoma City (3 Blue), El Paso (2 Gray)}
                {{3}, {2}},
                // Los Angeles = {Las Vegas (2 Gray), Phoenix (3 Gray), El Paso (6 Black)}
                {{2}, {3}, {6}},
                // Denver = {Omaha (4 Pink), Kansas City (4 Black / 4 Orange), Oklahoma City (4 Red), Sante Fe (2 Gray)}
                {{4}, {4, 4}, {4}, {2}},
                // New York = {Boston (2 Yellow / 2 Red), Washington (2 Orange / 2 Black)}
                {{2, 2}, {2, 2}},
                // Pittsburgh = {New York (2 White / 2 Green), Washington (2 Gray), Raleigh (2 Gray)}
                {{2, 2}, {2}, {2}},
                // Saint Louis = {Pittsburgh (5 Green), Nashville (2 Gray)}
                {{5}, {2}},
                // Little Rock = {Nashville (3 White), New Orleans (3 Green)}
                {{3}, {3}},
                // Dallas = {Houston (1 Gray / 1 Gray)}
                {{1, 1}},
                // El Paso = {Dallas (4 Red), Houston (6 Green)}
                {{4}, {6}},
                // Las Vegas = {empty}
                {},
                // Boston = {empty}
                {},
                // Phoenix = {Sante Fe (3 Gray), El Paso (3 Gray)}
                {{3}, {3}},
                // Washington = {empty}
                {},
                // Raleigh = {Charleston (2 Gray)}
                {{2}},
                // Nashville = {Atlanta (1 Gray)}
                {{1}},
                // New Orleans = {Atlanta (4 Yellow / 4 Orange), Miami (6 Red)}
                {{4, 4}, {6}},
                // Houston = {New Orleans (2 Gray)}
                {{2}},
                // Charleston = {Miami (4 Pink)}
                {{4}},
                // Atlanta = {Charleston (2 Gray), Miami (5 Blue)}
                {{2}, {5}},
                // Miami = {empty}
                {}
        };




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
    /*
    * Parameters:
    * id is an array of two ints that represent the Route's id field
    * cards is an array of cards that the Player is using to claim the Route
    * tp is a list of train pieces that the player puts on the board
    * Output:
    * Returns the awarded points (0, 1, 2, 4, 7, 10, 15)
    * */
    public int claimRoute(int id[], ArrayList<TrainCard> cards, List<TrainPiece> tp) {
        // If illegal Route IDs, exit
        if((id[0] < 1 || id[0] > 36) || (id[1] < 1 || id[1] > 36))
            return 0;
        // RouteA and RouteB
        Route a = board.getNode(id[0]), b = null;
        // List of Children Routes
        ArrayList<Route> c = a.getChildren();
        // List of Path costs for each Child Route
        ArrayList<RouteCost> cost = new ArrayList<RouteCost>();
        // If no children connected, exit
        if(c.isEmpty())
            return 0;
        // Itterate through the children nodes
        for(int i = 0; i < c.size(); b = c.get(i++)) {
            // If the matching child node is found
            if(b.getId() == id[1]) {
                // Get the cost to claim Route. If it is empty, exit
                if((cost = a.getCost(i)).isEmpty())
                    return 0;
            }
        }
        // Get the main color of the cards
        TrainColor color = TrainColor.RAINBOW;
        for(TrainCard card : cards) {
            if(card.getColor() != TrainColor.RAINBOW) {
                color = card.getColor();
                break;
            }
        }
        // If there are two paths, pick the one that matches the color
        RouteCost path = cost.get(0);
        if(cost.size() > 1) {
            path = (cost.get(0).getColor().equals(color)) ? (cost.get(0)) : (cost.get(1));
        }
        // Check if the claim is legal
        if(trainDeck.canClaim(cards, path.getColor(), path.getCount())) {
            // Put the Train Pieces on the board
            path.setTrainPieces(tp);
            // return the points awarded
            return path.getPoints();
        }
        return 0;
    }

    public void print() {
        Route.print(board);
    }
}

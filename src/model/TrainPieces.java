
/*
 * TrainPieces.java
 * Version 0.1.4    : Setup
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 *
 * This class represents the pieces that will be placed by the players on the board
 * to cover up the routes from one city to another. There are 5 colors: Blue, Red,
 * Green, Yellow, and Black. There is enough for up to 5 players, which is the max
 * number of players allowed in this game.
 */

package model;
import java.util.ArrayList;
import java.util.List;

class TrainPieces {

    // This list will be exactly 240 elements: 5 rows and 45 columns
    // Each row represents the colors
    // Each column represents the number of pieces
    private List<List<TrainPiece>> pieces;

    // A list of flags to check if the peieces are available
    private Boolean isAvailable[];

    // An enum to represent the different types of colors
    public enum COLOR {
        BLUE, RED, GREEN, YELLOW, BLACK
    }

    // Default constructor
    TrainPieces() {
        // Initialize the list (empty)
        pieces = new ArrayList<>();

        // Create new lists, one for each color
        List<TrainPiece> blue = new ArrayList<>();
        List<TrainPiece> red = new ArrayList<>();
        List<TrainPiece> green = new ArrayList<>();
        List<TrainPiece> yellow = new ArrayList<>();
        List<TrainPiece> black = new ArrayList<>();

        // Create 45 pieces of each color and add them to their respective lists
        for(int i = 0; i < 45; ++i) {
            blue.add(new TrainPiece("blue"));
            red.add(new TrainPiece("red"));
            green.add(new TrainPiece("green"));
            yellow.add(new TrainPiece("yellow"));
            black.add(new TrainPiece("black"));
        }

        // Add the lists of pieces to the pieces list
        pieces.add(blue);
        pieces.add(red);
        pieces.add(green);
        pieces.add(yellow);
        pieces.add(black);

        // Make all the pieces available
        isAvailable = new  Boolean[] { true, true, true, true, true };
    }

    // Removes the requested list of pieces
    public List<TrainPiece> getPieces(COLOR color) {
        int i;
        switch(color) {
            case BLUE: i = 0; break;
            case RED: i = 1; break;
            case GREEN: i = 2; break;
            case YELLOW: i = 3; break;
            case BLACK: i = 4; break;
            // failed to provide a proper color
            default: i = -1;
        }
        if(i > 0 && isAvailable[i]) {
            isAvailable[i] = false;
            return pieces.get(i);
        }
        return null;
    }
}

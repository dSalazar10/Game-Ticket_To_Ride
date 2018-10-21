
/*
 * TrainPiece.java
 * Version 0.1.4    : Setup
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : 10/21/18 10:25
 *
 * This class represents one of 240 total Train Pieces divided into five colors.
 * Colors: Blue, Red, Green, Yellow, and Black.
 */

package model;
public class TrainPiece {

    // Variables
    private String color;

    // Default Constructor
    TrainPiece(String color) {
        this.color = color;
    }

    // Get the Train Piece's color
    public String GetColor() { return this.color; }
}


/*
 * TrainPiece.java
 * Version 0.2.0    : Game Turn
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : 11/01/18 15:30
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

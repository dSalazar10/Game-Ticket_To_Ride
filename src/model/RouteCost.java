/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class RouteCost {
    private int count;
    private TrainColor color;
    private List<TrainPiece> trainPieces;

    public RouteCost(TrainColor color, int count) {
        this.color = color;
        this.count = count;
        this.trainPieces = new ArrayList<>(count);
    }

    public TrainColor getColor() {
        return color;
    }

    public int getCount() {
        return count;
    }

    public List<TrainPiece> getTrainPieces() { return trainPieces; }

    public void setTrainPieces(List<TrainPiece> tp) { this.trainPieces = tp; }

    public int getPoints() {
        switch(this.count) {
            case 1: return 1;
            case 2: return 2;
            case 3: return 4;
            case 4: return 7;
            case 5: return 10;
            case 6: return 15;
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return "RouteCost{" +
                "count=" + count +
                ", color=" + color +
                ", trainPieces=" + trainPieces +
                '}';
    }
}

/*
 * Player skeleton class
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adam Hennefer
 */
public class Player {
    List<TrainPieces> pieces;
    List<TrainCar> carCards;
    int points;
    public player(){
        pieces = new ArrayList<>();
        carCards = new ArrayList<>();
        points = 0;
    }
    public TrainPieces getTrainPieces(){
        //tbd
    }
    public boolean insertTrainPiece(){
        //tbd
    }
    public boolean removeTrainPiece(){
        //tbd
    }
    public TrainCar getTrainCar(){
        //tbd
    }
    public boolean insertTrainCar(){
        //tbd
    }
    public boolean removeTrainCar(){
        //tbd
    }
    public DestTixCard getDestTixCard(){
        //tbd
    }
    public boolean insertDestTixCard(){
        //tbd
    }
    public boolean removeDestTixCard(){
        //tbd
    }
    public boolean addPoints(int a){
        points += a;
    }
    public boolean subPoints(int s){
        points -= s;
    }
    public boolean turn(){
        //tbd 
    }
}

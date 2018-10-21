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
    List<TrainCard> carCards;
    int points;

    public void player(){
        pieces = new ArrayList<>();
        carCards = new ArrayList<>();
        points = 0;
    }
    
    public TrainPieces getTrainPieces(){
        return pieces.get(0); 
        //tbd
    }
    
    public boolean insertTrainPiece(){
        //tbd
        return false;
    }
    public boolean removeTrainPiece(){
        //tbd
        return false;
    }
    
    public TrainCard getTrainCar(){
        return carCards.get(0);
        //tbd
    }
    
    public boolean insertTrainCar(){
        //tbd
        return false;
    }
    public boolean removeTrainCar(){
        //tbd
        return false;
    }
    /*
    public DestTixCard getDestTixCard(){
        //tbd
    }
    */
    public boolean insertDestTixCard(){
        //tbd
        return false;
    }
    public boolean removeDestTixCard(){
        //tbd
        return false;
    }
    public boolean addPoints(int a){
        int oldpoints = points;
        points += a;
        if (points > oldpoints) return true;
        else return false;
    }
    public boolean subPoints(int s){
        int oldpoints = points;
        points -= s;
        if (points < oldpoints) return true;
        else return false;
    }
    public boolean turn(){
        //tbd
        return false;
    }
}
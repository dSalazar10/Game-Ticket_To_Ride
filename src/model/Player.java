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
    private List<TrainPieces> pieces;
    private List<TrainCard> carCards;
    private int points;
    
    public void player(){
        pieces = new ArrayList<>();
        carCards = new ArrayList<>();
        points = 0;
    }
    /*
    public TrainPieces getTrainPieces(){
        //tbd
    }
    */
    public boolean insertTrainPiece(){
        //tbd
        return false;
    }
    public boolean removeTrainPiece(){
        //tbd
        return false;
    }
    /*
    public TrainCar getTrainCar(){
        //tbd
    }
    */
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
        return points > oldpoints;
    }
    public boolean subPoints(int s){
        int oldpoints = points;
        points -= s;
        return points < oldpoints;
    }
    public boolean turn(){
        //tbd 
        return false;
    }
}

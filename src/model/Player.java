/*
 * Player.java
 * Version 0.1.1    : Setup
 * Programmer       : Adam Hennefer
 * Due Date         : 10/24/18
 * Last Modified    : 10/23/18 12:30
 *
 * This class represents the a player.
 *  
 */
package model;

import java.util.ArrayList;

public class Player {
    private ArrayList<TrainPieces> pieces;
    private ArrayList<TrainCard> carCards;
    private ArrayList<DestinationCard> destCards;
    private int points;

    public void player(){
        this.pieces = new ArrayList<>(); 
            TrainPieces tPieces = null;
            //initialize ArrayList of forty five train pieces
            while(pieces.size() < 44){
               // pieces.add(tPieces.getPieces(TrainPieces.COLOR.BLACK));
            }
            
        this.carCards = new ArrayList<>();
            //initialize ArrayList of four traincar cards
            TrainCardDeck deck = null;
            while(carCards.size() < 3){
                carCards.add(deck.Draw(Boolean.TRUE));
            }
        this.destCards = new ArrayList<>();
            //initialize ArrayList of three destination cards
            DestinationTicketSet dCard = null;
            while(destCards.size() < 2){
                // waiting for draw method.
               // destCards.add(dCard.Draw());
            }
        //initial points set to zero    
        this.points = 0;
    }
    
    public ArrayList<TrainPieces> getTrainPieces(){
        return this.pieces; 
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
    
    public ArrayList<TrainCard> getTrainCar(){
        return this.carCards;
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
    
    public ArrayList<DestinationCard> getDestTixCard(){
        //tbd
        return this.destCards;
    }
    
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
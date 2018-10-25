/*
 * Player.java
 * Version 0.1.2    : Setup
 * Programmer       : Adam Hennefer
 * Due Date         : 10/24/18
 * Last Modified    : 10/23/18 9:45
 *
 * This class represents the a player.
 *  
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<TrainPiece> pieces;
    private ArrayList<TrainCard> carCards;
    private ArrayList<DestinationCard> destCards;
    private int points;
    private String name;
    private Board board;
    
    
    // construct player object
    public Player(String n, TrainPieces.COLOR c){
        //set players name
        name = n;
        //initialize ArrayList of forty five train pieces with players color
        pieces = new TrainPieces().getPieces(c); 
        //initialize ArrayList of four traincar cards
        
//        carCards = new ArrayList<>();
//            TrainCardDeck deck = null;
//            while(carCards.size() < 3){
//                carCards.add(deck.Draw(Boolean.TRUE));
//            }
//        //initialize ArrayList of three destination cards    
//        destCards = new ArrayList<>();
//            DestinationTicketSet dCard = null;
//            while(destCards.size() < 2){
//                // waiting for draw method.
//               // destCards.add(dCard.Draw());
//            }
        //initialize points set to zero    
        points = 0;
    }
    
    public List<TrainPiece> getTrainPieces(){
        return this.pieces; 
        //tbd
    }
    
    public boolean insertTrainPiece(TrainPiece tp){
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
    @Override
	public boolean equals(Object x){
		if(!(x instanceof Player)){ 
                    return false; 
                }
		Player y = (Player)x;
                //&& this.pieces == y.pieces
		return this.name.equals(y.name);
	}
}
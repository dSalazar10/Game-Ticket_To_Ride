/*
 * Player.java
 * Version 0.1.6    : Setup
 * Programmer       : Adam Hennefer
 * Due Date         : 11/9/18
 * Last Modified    : 11/8/18 2:52
 *
 * This class represents a player.
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
    private TrainPieces.COLOR pColor;
    private boolean turn = false;
    
// construct player object
    public Player(String n, TrainPieces.COLOR c){
        //set player's name
        name = n;
        
        //set player's colors
        pColor = c;
        
        //initialize ArrayList of forty five train pieces with player's color
        pieces = new TrainPieces().getPieces(c); 
 
        //initialize points set to zero    
        points = 0;      
    }
    public boolean addBoard(Board b){
        board = b;
        carCards =  b.trainDeck.toPlayer();
        destCards = b.destDeck.toPlayer();
        return(board == b && carCards ==  b.trainDeck.toPlayer() && destCards == b.destDeck.toPlayer());
    }
    public TrainPiece getTrainPiece(int p){
        return pieces.get(p);
    }
//    // insert a TrainPiece into a newly claimed route
//    public boolean insertTrainPiece(DestinationCard dc){
//        // if the DestinationCard route(s) are claimed or we don't have enough train pieces then return false
////        if(board.claimRoute(dc.getRouteA()) && board.claimRoute(dc.getRouteB()) || pieces.size() < dc.getPts()){
////            return false; }
////        else we are going to claim the route and throw out an equivlent amount of train pieces
////         to the routes path (aka pts)
////        else{
////          if(board.claimRoute(dc.getRouteA()){
////                     
////            board.claimRoute(dc.getRouteA());
////            int i = 0;
////            while(i < dc.getPts()){
////                pieces.remove(i);
////            }    
////        }
//        return true;
//    }
    //retrives a train piece of the players list of train pieces
    public void removeTrainPiece(int p){
        pieces.remove(p);
    }
    //retrieves a train car from the player's list of train cards 
    public TrainCard getTrainCar(int c){
        return carCards.get(c);
    }
    // adds a train car card to player's list of train cars
    public boolean insertTrainCar(TrainCard tc){
        return carCards.add(tc); 
    }
    // removes a train car card from player's list of train cars
    public boolean removeTrainCar(int tc){
        TrainCard temp = carCards.get(tc);
        return carCards.remove(temp);
    }
    // returns the players current list destination cards
    public ArrayList<DestinationCard> getDestTixCard(){
        return this.destCards;
    }
    // returns the players current list car train cards
    public ArrayList<TrainCard> getTrainCards(){
        return this.carCards;    
    }
    // add a destination card to the players list of destination cards
    public boolean insertDestTixCard(DestinationCard dc){
        return destCards.add(dc);
    }
    // removes a destinatoin card from the player's list of destination cards
    public boolean removeDestTixCard(int cNum){
        DestinationCard temp = destCards.get(cNum);
        destCards.remove(cNum);
        board.destDeck.retunTo(temp);
        return true;
    }
    
    //add player points
    public boolean addPoints(int a){
        int oldpoints = points;
        points += a;
        return points > oldpoints;
    }
    // subtract player points
    public boolean subPoints(int s){
        int oldpoints = points;
        points -= s;
        return points < oldpoints;
    }
    // get player points
    public int getPoints(){
        return points;
    }
    // check players turn
    public boolean getTurn(){
        return turn;
    }
    // change players turn
    public void setTurn(){
        turn = !turn;
    }
    // get the number of remaining train pieces 
    public int getPeicesLeft(){ 
        return pieces.size(); 
    }
    // get number of destination cards
    public int getSizeofDest(){ 
        return destCards.size(); 
    }
    // override for testing 
    @Override
	public boolean equals(Object x){
            if(!(x instanceof Player)){ return false; }
            Player y = (Player)x;
            return this.name.equals(y.name) && this.pColor == y.pColor;
	}
}

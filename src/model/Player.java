/*
 * Player.java
 * Version 0.1.8    : Setup
 * Programmer       : Adam Hennefer
 * Due Date         : 11/9/18
 * Last Modified    : 11/14/18 11:54
 *
 * This class represents a player.
 *  
 */
package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {
    private List<TrainPiece> pieces;
    private ArrayList<TrainCard> carCards;
    private ArrayList<DestinationCard> destCards;
    private int points;
    private String name;
    public Board board;
    private TrainPieces.COLOR pColor;
    private boolean turn = false;
    private boolean lastTurn = false;
    public List<String> claimedRoutes[];
    //iterator for addClaimedRoute() method
    private int it = 0;
    
// construct player object
    public Player(String n, TrainPieces.COLOR c){
        //set player's name
        name = n;
        
        //set player's colors
        pColor = c;
        
        //initialize points set to zero    
        points = 0; 
    }
    public boolean addBoard(Board b){
        //assign a player to the board
        board = b;
        //initialize ArrayList of player's train car cards
        carCards =  b.trainDeck.toPlayer();
        //initialize ArrayList of player's destination cards
        destCards = b.destDeck.toPlayer();
        //initialize ArrayList of forty five train pieces with player's color
        pieces = b.trainPieces.getPieces(pColor);
        //initialize an empty list of claimed routes
        claimedRoutes = new LinkedList[46];
        // return true if constructed
        return(board == b && carCards ==  b.trainDeck.toPlayer() && 
                destCards == b.destDeck.toPlayer() && pieces == b.trainPieces.getPieces(pColor));
    }
    // create and get adjacency list 
    public List<String>[] getAdjacentcyList(){
        List<String> adjList[] = new LinkedList[36];
            for (int i=0; i<36; i++) adjList[i] = new LinkedList<>();
                adjList[0].add("Vancouver"); adjList[0].add("Calgary"); adjList[0].add("Seattle");
                adjList[1].add("Calgary"); adjList[1].add("Winnipeg"); adjList[1].add("Seattle"); adjList[1].add("Helena");
                adjList[2].add("Winnipeg"); adjList[2].add("Sault St. Marie"); adjList[2].add("Calgary"); 
                    adjList[2].add("Sault St. Marie"); adjList[2].add("Helena"); adjList[2].add("Duluth");
                adjList[3].add("Sault St. Marie"); adjList[3].add("Winnipeg");  adjList[3].add("Duluth");  
                    adjList[3].add("Toronto");  adjList[3].add("Montreal");
                adjList[4].add("Montreal");  adjList[4].add("Sault St. Marie");  adjList[4].add("Toronto");  
                    adjList[4].add("New York"); adjList[4].add("Boston");
                adjList[5].add("Seattle"); adjList[5].add("Portland"); adjList[5].add("Helena"); adjList[5].add("Calgary");
                adjList[6].add("Helena"); adjList[6].add("Seattle"); adjList[6].add("Calgary"); adjList[6].add("Winnipeg");
                    adjList[6].add("Duluth"); adjList[6].add("Omaha"); adjList[6].add("Denver"); adjList[6].add("Salt Lake");
                adjList[7].add("Duluth"); adjList[7].add("Helena"); adjList[7].add("Winnipeg"); adjList[8].add("Sault St. Marie");
                    adjList[7].add("Toronto"); adjList[7].add("Chicago"); adjList[7].add("Omaha");
                adjList[8].add("Toronto");  adjList[8].add("Duluth");  adjList[8].add("Sault St. Marie");  
                    adjList[8].add("Montreal");  adjList[8].add("Pittsburg");  adjList[8].add("Chicago");
                adjList[9].add("Boston"); adjList[9].add("Montreal"); adjList[9].add("New York");  
                adjList[10].add("Portland"); adjList[10].add("Seattle"); adjList[10].add("Salt Lake City"); 
                    adjList[10].add("San Francisco");
                adjList[11].add("Salt Lake City"); adjList[11].add("Portland"); adjList[11].add("Helena"); 
                    adjList[11].add("Denver"); adjList[11].add("Las Vegas"); adjList[11].add("San Francisco");
                adjList[12].add("Denver"); adjList[12].add("Salt Lake City"); adjList[12].add("Helena"); 
                    adjList[12].add("Omaha"); adjList[12].add("Kansas City"); adjList[12].add("Oklahoma City");
                    adjList[12].add("Santa Fe"); adjList[12].add("Phoenix");
                adjList[13].add("Omaha"); adjList[13].add("Denver"); adjList[13].add("Helena");
                    adjList[13].add("Duluth"); adjList[13].add("Chicago"); adjList[13].add("Kansas City");
                adjList[14].add("Chicago"); adjList[14].add("Omaha"); adjList[14].add("Duluth"); 
                    adjList[14].add("Toronto"); adjList[14].add("Pittsburgh"); adjList[14].add("Saint Louis"); 
                adjList[15].add("Pittsburg"); adjList[15].add("Chicago"); adjList[15].add("Toronto"); 
                    adjList[15].add("New York"); adjList[15].add("Washington"); adjList[15].add("Raleigh"); 
                    adjList[15].add("Nashville"); adjList[15].add("Saint Louis");
                adjList[16].add("New York"); adjList[16].add("Pittsburg"); adjList[16].add("Montreal"); 
                    adjList[16].add("Boston"); adjList[16].add("Washington");
                adjList[17].add("San Francisco"); adjList[17].add("Portland"); adjList[17].add("Salt Lake City"); 
                    adjList[17].add("Los Angeles");
                adjList[18].add("Las Vegas"); adjList[18].add("Los Angeles"); adjList[18].add("Salt Lake City");
                adjList[19].add("Kanas City"); adjList[19].add("Denver"); adjList[19].add("Omaha"); 
                    adjList[19].add("Saint Louis");  adjList[19].add("Oklahoma City");   
                adjList[20].add("Saint Louis"); adjList[20].add("Kansas City");  adjList[20].add("Chicago"); 
                    adjList[20].add("Pittsburg");  adjList[20].add("Nashville");  adjList[20].add("Little Rock");
                adjList[21].add("Nashville"); adjList[21].add("Saint Louis"); adjList[21].add("Pittsburg"); 
                    adjList[21].add("Raliegh"); adjList[21].add("Atlanta"); adjList[21].add("Little Rock");
                adjList[22].add("Raleigh"); adjList[22].add("Nashville"); adjList[22].add("Pittsburg");
                    adjList[22].add("Washington");adjList[22].add("Charleston"); adjList[22].add("Atlanta");
                adjList[23].add("Washington"); adjList[23].add("Raleigh"); adjList[23].add("Pittsburg"); 
                    adjList[23].add("New York");
                adjList[24].add("Los Angeles"); adjList[24].add("San Francisco"); adjList[24].add("Las Vegas"); 
                    adjList[24].add("Phoenix"); adjList[24].add("El Paso");
                adjList[25].add("Phoenix"); adjList[25].add("Los Angeles"); adjList[25].add("Denver"); 
                    adjList[25].add("Santa Fe"); adjList[25].add("El Paso");
                adjList[26].add("Santa Fe"); adjList[26].add("Phoenix"); adjList[26].add("Denver"); 
                    adjList[26].add("Oklahoma City"); adjList[26].add("El Paso");
                adjList[27].add("Oklahoma City"); adjList[27].add("Santa Fe"); adjList[27].add("Denver"); 
                    adjList[27].add("Kansas City"); adjList[27].add("Little Rock"); adjList[27].add("Dallas");
                    adjList[27].add("El Paso");
                adjList[28].add("Little Rock"); adjList[28].add("Oklahoma City"); adjList[28].add("Saint Louis");
                    adjList[28].add("Nashville");adjList[28].add("New Orleans");adjList[28].add("Dallas");
                adjList[29].add("Atlanta");  adjList[29].add("Nashville"); adjList[29].add("Raleigh"); 
                    adjList[29].add("Charleston");  adjList[29].add("Miami"); adjList[29].add("New Orleans");
                adjList[30].add("Charleston");adjList[30].add("Atlanta");adjList[30].add("Miami");
                adjList[31].add("El Paso"); adjList[31].add("Los Angeles");adjList[31].add("Phoenix");
                    adjList[31].add("Santa Fe");adjList[31].add("Oklahoma City");adjList[31].add("Dallas");
                    adjList[31].add("Houston");
                adjList[32].add("Dallas"); adjList[32].add("El Paso");adjList[32].add("Oklahoma City");
                    adjList[32].add("Little Rock");adjList[32].add("Houston");
                adjList[33].add("Houston"); adjList[33].add("El Paso"); adjList[33].add("Dallas"); 
                    adjList[33].add("New Orleans");
                adjList[34].add("New Orleans");adjList[34].add("Houston");adjList[34].add("Little Rock");
                    adjList[34].add("Atlanta");adjList[34].add("Miami");
                adjList[35].add("Miami"); adjList[35].add("New Orleans"); adjList[35].add("Atlanta");
                    adjList[35].add("Charleston");
            
        return adjList;
    }
    // test adjacent routes  
    public boolean isAdjacent(String s1, String s2){
        if(s1 == s2) return false;
        List<String>[] temp = getAdjacentcyList();
        for (int i=0; i< temp.length; i++){
            if (temp[i].contains(s1) && temp[i].contains(s2)) return true;
        }
        return false;
    }
    // add routes to player's claimed route list
    public boolean addClaimedRoute(String s1, String s2){
        if(s1 == s2) return false;
        claimedRoutes[it] = new LinkedList<>();
        return claimedRoutes[it].add(s1) && claimedRoutes[it].add(s2) && iter_it();        
    }
    // iterator function for class member int it.
    private boolean iter_it(){
        int iter = it;
        it++;
        return iter+1 == it;
    }
    //retrives a specific train piece
    public TrainPiece getTrainPiece(int p){
        return pieces.get(p);
    }
    //removes a train piece from the player's list of train pieces
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
    //subtract remaing destination cards
    public int remaingDestCards(){
        int i = 0;
        int deductedPoints = 0;
        while(i < destCards.size()){
            deductedPoints =+ destCards.get(i).getPts();
        }    
        return deductedPoints;
    }
    //longest route bonus
    public boolean longestRouteBonus(){
        // TODO : check longest continuous path
        int pts = points;
        points =+ 10; 
        return pts+10 == points;
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
    // set player's final turn
    public boolean setFinalTurn(){
        lastTurn = true;
        return lastTurn;
    }
    // check for player's final turn
    public boolean getFinalTurn(){
        return lastTurn;
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

/*
 * Player.java
 * Version 0.1.9    : Setup.scoring
 * Programmer       : Adam Hennefer
 * Due Date         : 11/9/18
 * Last Modified    : 11/21/18 3:03
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
    private TrainPieces.COLOR pColor;
    private boolean turn = false;
    private boolean lastTurn = false;
    //iterator for addClaimedRoute method
    private int it = 0;
    private List<Path> adjList[];
    
    public List<String> claimedRoutes[];
    public Board board;  
    
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
        claimedRoutes = new LinkedList[36];
        //create adjacentcy list
        adjList = adjacentcyList();
        // return true if constructed
        return(board == b && carCards ==  b.trainDeck.toPlayer() && 
                destCards == b.destDeck.toPlayer() && pieces == b.trainPieces.getPieces(pColor));
    }

    // create adjacentcy list
    private List<Path>[] adjacentcyList(){    
        List<Path> adjList[] = new LinkedList[36];
            for (int i=0; i<36; i++) adjList[i] = new LinkedList<>();
                adjList[0].add(new Path("Vancouver",0)); adjList[0].add(new Path("Calgary",3 )); adjList[0].add(new Path("Seattle", 1));
                adjList[1].add(new Path("Calgary", 0)); adjList[1].add( new Path("Winnipeg", 6)); adjList[1].add(new Path("Seattle", 4)); adjList[1].add(new Path("Helena", 4));
                adjList[2].add(new Path("Winnipeg",0)); adjList[2].add(new Path("Sault St. Marie", 6)); adjList[2].add(new Path("Calgary", 6)); adjList[2].add(new Path("Helena", 4)); adjList[2].add(new Path("Duluth", 4));            
                adjList[3].add(new Path("Sault St. Marie", 0)); adjList[3].add(new Path("Winnipeg",6 ));  adjList[3].add(new Path("Duluth", 3)); adjList[3].add(new Path("Toronto", 2)); adjList[3].add(new Path("Montreal", 5));
                adjList[4].add(new Path("Montreal", 0));  adjList[4].add(new Path("Sault St. Marie", 5));  adjList[4].add(new Path("Toronto", 3)); adjList[4].add(new Path("New York", 3)); adjList[4].add(new Path("Boston", 2));
                adjList[5].add(new Path("Seattle", 0)); adjList[5].add(new Path("Portland",1)); adjList[5].add(new Path("Helena",6)); adjList[5].add(new Path("Calgary", 4));
                adjList[6].add(new Path("Helena", 0)); adjList[6].add(new Path("Seattle", 6)); adjList[6].add(new Path("Calgary", 4)); adjList[6].add(new Path("Winnipeg",4 )); adjList[6].add(new Path("Duluth", 6)); adjList[6].add(new Path("Omaha", 5)); adjList[6].add(new Path("Denver", 4)); adjList[6].add(new Path("Salt Lake", 3));
                adjList[7].add(new Path("Duluth",0)); adjList[7].add(new Path("Helena",6)); adjList[7].add(new Path("Winnipeg", 4)); adjList[8].add(new Path("Sault St. Marie", 3)); adjList[7].add(new Path("Toronto", 6)); adjList[7].add(new Path("Chicago", 3)); adjList[7].add(new Path("Omaha", 2));
                adjList[8].add(new Path("Toronto", 0));  adjList[8].add(new Path("Duluth",6));  adjList[8].add(new Path("Sault St. Marie", 2)); adjList[8].add(new Path("Montreal", 3));  adjList[8].add(new Path("Pittsburgh",2)); adjList[8].add(new Path("Chicago", 4));
                adjList[9].add(new Path("Boston",0)); adjList[9].add(new Path("Montreal",2)); adjList[9].add(new Path("New York", 2));  
                adjList[10].add(new Path("Portland",0)); adjList[10].add(new Path("Seattle", 1)); adjList[10].add(new Path("Salt Lake City",6));adjList[10].add(new Path("San Francisco", 5));
                adjList[11].add(new Path("Salt Lake City",0)); adjList[11].add(new Path("Portland", 6)); adjList[11].add(new Path("Helena", 3)); adjList[11].add(new Path("Denver",3)); adjList[11].add(new Path("Las Vegas",3)); adjList[11].add(new Path("San Francisco",5));
                adjList[12].add(new Path("Denver",0)); adjList[12].add(new Path("Salt Lake City", 3)); adjList[12].add(new Path("Helena",4 )); adjList[12].add(new Path("Omaha",1)); adjList[12].add(new Path("Kansas City",4 )); adjList[12].add(new Path("Oklahoma City", 4)); adjList[12].add(new Path("Santa Fe",2)); adjList[12].add(new Path("Phoenix", 5));
                adjList[13].add(new Path("Omaha",0)); adjList[13].add(new Path("Denver",4)); adjList[13].add(new Path("Helena", 5));adjList[13].add(new Path("Duluth", 2)); adjList[13].add(new Path("Chicago", 4)); adjList[13].add(new Path("Kansas City",1 ));
                adjList[14].add(new Path("Chicago",0)); adjList[14].add(new Path("Omaha",4)); adjList[14].add(new Path("Duluth", 3));adjList[14].add(new Path("Toronto", 4)); adjList[14].add(new Path("Pittsburgh", 3)); adjList[14].add(new Path("Saint Louis",2)); 
                adjList[15].add(new Path("Pittsburgh",0)); adjList[15].add(new Path("Chicago",3)); adjList[15].add(new Path("Toronto",2)); adjList[15].add(new Path("New York",2)); adjList[15].add(new Path("Washington", 2)); adjList[15].add(new Path("Raleigh", 2)); adjList[15].add(new Path("Nashville", 4)); adjList[15].add(new Path("Saint Louis", 5));
                adjList[16].add(new Path("New York",0)); adjList[16].add(new Path("Pittsburgh",2)); adjList[16].add(new Path("Montreal",3)); adjList[16].add(new Path("Boston", 2)); adjList[16].add(new Path("Washington",2));
                adjList[17].add(new Path("San Francisco",0)); adjList[17].add(new Path("Portland",5)); adjList[17].add(new Path("Salt Lake City",5)); adjList[17].add(new Path("Los Angeles",3));
                adjList[18].add(new Path("Las Vegas", 0)); adjList[18].add(new Path("Los Angeles", 2)); adjList[18].add(new Path("Salt Lake City", 3));
                adjList[19].add(new Path("Kanas City",0)); adjList[19].add(new Path("Denver",4)); adjList[19].add(new Path("Omaha",1));adjList[19].add(new Path("Saint Louis",2));  adjList[19].add(new Path("Oklahoma City",2));  
                adjList[20].add(new Path("Saint Louis",0)); adjList[20].add(new Path("Kansas City",2));  adjList[20].add(new Path("Chicago",2)); adjList[20].add(new Path("Pittsburgh",5));  adjList[20].add(new Path("Nashville", 2));  adjList[20].add(new Path("Little Rock",2 ));
                adjList[21].add(new Path("Nashville",0)); adjList[21].add(new Path("Saint Louis",2)); adjList[21].add(new Path("Pittsburgh", 4)); adjList[21].add(new Path("Raliegh", 3)); adjList[21].add(new Path("Atlanta", 1)); adjList[21].add(new Path("Little Rock", 3));
                adjList[22].add(new Path("Raleigh",0)); adjList[22].add(new Path("Nashville",3)); adjList[22].add(new Path("Pittsburgh",2)); adjList[22].add(new Path("Washington",2));adjList[22].add(new Path("Charleston",2)); adjList[22].add(new Path("Atlanta",2));
                adjList[23].add(new Path("Washington",0)); adjList[23].add(new Path("Raleigh",2)); adjList[23].add(new Path("Pittsburgh", 2)); adjList[23].add(new Path("New York",2));
                adjList[24].add(new Path("Los Angeles",0)); adjList[24].add(new Path("San Francisco",3)); adjList[24].add(new Path("Las Vegas",2)); adjList[24].add(new Path("Phoenix", 3)); adjList[24].add(new Path("El Paso",6));
                adjList[25].add(new Path("Phoenix", 0)); adjList[25].add(new Path("Los Angeles", 3)); adjList[25].add(new Path("Denver",5)); adjList[25].add(new Path("Santa Fe",3)); adjList[25].add(new Path("El Paso",3));
                adjList[26].add(new Path("Santa Fe",0)); adjList[26].add(new Path("Phoenix",3)); adjList[26].add(new Path("Denver",2)); adjList[26].add(new Path("Oklahoma City",3 )); adjList[26].add(new Path("El Paso",2));
                adjList[27].add(new Path("Oklahoma City",0)); adjList[27].add(new Path("Santa Fe",3)); adjList[27].add(new Path("Denver",4)); adjList[27].add(new Path("Kansas City",2)); adjList[27].add(new Path("Little Rock", 2)); adjList[27].add(new Path("Dallas",2));adjList[27].add(new Path("El Paso",5));
                adjList[28].add(new Path("Little Rock",0)); adjList[28].add(new Path("Oklahoma City",2)); adjList[28].add(new Path("Saint Louis",2));adjList[28].add(new Path("Nashville",3));adjList[28].add(new Path("New Orleans", 3));adjList[28].add(new Path("Dallas", 2));
                adjList[29].add(new Path("Atlanta",0));  adjList[29].add(new Path("Nashville",1)); adjList[29].add(new Path("Raleigh",2)); adjList[29].add(new Path("Charleston", 2));  adjList[29].add(new Path("Miami",5)); adjList[29].add(new Path("New Orleans", 4));
                adjList[30].add(new Path("Charleston",0));adjList[30].add(new Path("Atlanta",2));adjList[30].add(new Path("Raleigh",2)); adjList[30].add(new Path("Miami",4));
                adjList[31].add(new Path("El Paso",0)); adjList[31].add(new Path("Los Angeles",6));adjList[31].add(new Path("Phoenix",3)); adjList[31].add(new Path("Santa Fe",2));adjList[31].add(new Path("Oklahoma City",5));adjList[31].add(new Path("Dallas",4)); adjList[31].add(new Path("Houston",6));
                adjList[32].add(new Path("Dallas",0 )); adjList[32].add(new Path("El Paso",4));adjList[32].add(new Path("Oklahoma City",2));adjList[32].add(new Path("Little Rock",2));adjList[32].add(new Path("Houston",1));
                adjList[33].add(new Path("Houston",0)); adjList[33].add(new Path("El Paso", 6)); adjList[33].add(new Path("Dallas",1)); adjList[33].add(new Path("New Orleans",2));
                adjList[34].add(new Path("New Orleans",0));adjList[34].add(new Path("Houston",2));adjList[34].add(new Path("Little Rock",3));adjList[34].add(new Path("Atlanta",4));adjList[34].add(new Path("Miami", 6));
                adjList[35].add(new Path("Miami",0)); adjList[35].add(new Path("New Orleans",6)); adjList[35].add(new Path("Atlanta",5)); adjList[35].add(new Path("Charleston",4));
     
        return adjList;
    }
    // get adjacency list 
    public List<Path>[] getAdjacentcyList(){
        return adjList;
    }
    // test if cities are adjacent
    // recieves two city names
    public boolean isAdjacent(String s1, String s2){
        if(s1 == s2) return false;
        int index1, index2 = 0;
        List<Path>[] temp = getAdjacentcyList();
        Path c1 = new Path(s1,0);
        Path c2 = new Path(s2,0);
        for (int i=0; i< temp.length; i++){
            if (temp[i].contains(c1) && temp[i].contains(c2)){ 
                index1 = temp[i].indexOf(c1);
                index2 = temp[i].indexOf(c2);
                if (index1 == 0 || index2 == 0) return true;
            }
        }
        return false;
    }
    // add route to player's claimed routes list
    public boolean addClaimedRoute(String s1, String s2){
        if(s1 == s2) return false;
        claimedRoutes[it] = new LinkedList<>();               
        return claimedRoutes[it].add(s1) && claimedRoutes[it].add(s2) && iter_it();        
    }
    // iterator incrementor for addClamiedRoute method
    private boolean iter_it(){
        int iter = it;
        it++;
        return iter+1 == it;
    }
    // receive's two city names and adds the points
    public boolean calcPoints(String s1, String s2){
        if(s1 == s2) return false;
        int index1, index2 = 0;
        List<Path>[] temp = getAdjacentcyList();
        Path c1 = new Path(s1,0);
        Path c2 = new Path(s2,0);
        for (int i=0; i< temp.length; i++){
            if (temp[i].contains(c1) && temp[i].contains(c2)){
                index1 = temp[i].indexOf(c1);
                index2 = temp[i].indexOf(c2);
                if (index1 == 0 || index2 == 0){ 
                    c1 = temp[i].get(index1);
                    c2 = temp[i].get(index2);
                    points += c1.getDist()+ c2.getDist();
                    return true;
                }
            }
        }
        return false;
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

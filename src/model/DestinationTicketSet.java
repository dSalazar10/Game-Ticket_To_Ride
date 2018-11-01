/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Nasario Sylvester
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */
package model;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
public class DestinationTicketSet{
    private LinkedList<DestinationCard> Set;

    /*
     * Makes  destTicket deck (Accordance to what is provided
     * With the game, and shuffles the cards
     */
    public DestinationTicketSet() {
        Set = new LinkedList<DestinationCard>();
        Set.add(new DestinationCard("Denver", "El Paso", 4));
        Set.add(new DestinationCard("Kansas City", "Houston", 5));
        Set.add(new DestinationCard("New York", "Atlanta", 6));
        Set.add(new DestinationCard("Chicago", "New Orleans", 7));
        Set.add(new DestinationCard("Calgary", "Salt Lake City", 7));
        Set.add(new DestinationCard("Helena", "Los Angeles", 8));
        Set.add(new DestinationCard("Duluth", "Houston", 8));
        Set.add(new DestinationCard("Sault Ste. Marie", "Nashville", 8));
        Set.add(new DestinationCard("Montreal", "Atlanta", 9));
        Set.add(new DestinationCard("Sault Ste. Marie", "Oklahoma City", 9));
        Set.add(new DestinationCard("Seattle", "Los Angeles", 9));
        Set.add(new DestinationCard("Chicago", "Santa Fe", 9));
        Set.add(new DestinationCard("Duluth", "El Paso", 10));
        Set.add(new DestinationCard("Toronto", "Miami", 10));
        Set.add(new DestinationCard("Portland", "Phoenix", 11));
        Set.add(new DestinationCard("Dallas", "New York City", 11));
        Set.add(new DestinationCard("Denver", "Pittsburgh", 11));
        Set.add(new DestinationCard("Winnipeg", "Little Rock", 11));
        Set.add(new DestinationCard("Winnipeg", "Houston", 12));
        Set.add(new DestinationCard("Boston", "Miami", 12));
        Set.add(new DestinationCard("Vancouver", "Santa Fe", 13));
        Set.add(new DestinationCard("Calgary", "Phoenix", 13));
        Set.add(new DestinationCard("Montreal", "New Orleans", 13));
        Set.add(new DestinationCard("Los Angeles", "Chicago", 16));
        Set.add(new DestinationCard("San Francisco", "Atlanta", 17));
        Set.add(new DestinationCard("Portland", "Nashville", 17));
        Set.add(new DestinationCard("Vancouver", "Montréal", 20));
        Set.add(new DestinationCard("Los Angeles", "Miami", 20));
        Set.add(new DestinationCard("Los Angeles", "New York City", 21));
        Set.add(new DestinationCard("Seattle", "New York", 22));

        Collections.shuffle(Set);
    }

    /*
     * Returns a list of 3 cards to the user
     */
    public ArrayList<DestinationCard> Draw(ArrayList<DestinationCard> draw){
        draw = new ArrayList<DestinationCard>();
        if(Set.isEmpty()){
            return draw;
        }
        for(int i= 0; i < 3; i++){
            if(Set.isEmpty())
                return draw;
            draw.add(Set.pop());
        }
        return draw;
    }
    public void RemoveCard(){

    }

    public DestinationCard getDestCard(){
        return Set.peek();
    }
    public void returnTo(DestinationCard toBottom){
        // note add appends the element at the end of the list/deck
        Set.add(toBottom);
    }

}
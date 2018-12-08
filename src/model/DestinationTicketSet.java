/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Nasario Sylvester
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */
package model;
import java.io.File;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DestinationTicketSet{
    private LinkedList<DestinationCard> Set;

    /*
     * Makes  destTicket deck (Accordance to what is provided
     * With the game, and shuffles the cards
     */
    public DestinationTicketSet() throws Exception {
        Set = new LinkedList<DestinationCard>();
        File desttix = new File("src\\resources\\TextFiles\\DestCards.txt");
        Scanner cardReader = new Scanner(desttix).useDelimiter(",");
        String from;
        String to;
        int points;
        while(cardReader.hasNext()) {
            from = cardReader.next();
            to = cardReader.next();
            points = cardReader.nextInt();
            Set.add(new DestinationCard(from, to, points));
        }
        Collections.shuffle(Set);
    }

    /*
     * Returns a list of 3 cards to the user
     */
    public ArrayList<DestinationCard> Draw(){
        ArrayList<DestinationCard> draw = new ArrayList<DestinationCard>();
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
    public ArrayList<DestinationCard> toPlayer(){
        ArrayList<DestinationCard> forPlayer = new ArrayList<DestinationCard>();
        for(int i = 0; i < 3; i++){
            forPlayer.add(Set.pop());
        }
        return forPlayer;
    }

    public DestinationCard getDestCard(){
        return Set.peek();
    }
    public void retunTo(DestinationCard toBottom){
        // note add appends the element at the end of the list/deck
        Set.add(toBottom);
    }
    public boolean checkRoute(ArrayList<Route> routes, DestinationCard card){
        if(true)
            return true;
        else
            return false;
    }

}
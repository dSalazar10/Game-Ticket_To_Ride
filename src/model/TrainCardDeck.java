package model;
import java.util.*;


public class TrainCardDeck{
	//deck
	private ArrayList<TrainCard> trainDeck;
	//discard pile
	private LinkedList<TrainCard> trainDiscard;
	//cards on the table
	private LinkedList<TrainCard> tableCards;
	//placeholder for now
	private TrainCard card;
	//contruusttor will t
	TrainCardDeck(){
		/*trainDeck.Shuffle();*/
	}
	private void Shuffle() {
	
}
	//test if player wants cards from deck or table and takes the action
	public TrainCard Draw(Boolean t) {
		/*if(t)
		    return trainDiscard.addFrist(trainDeck.pop());
		else
			return this.toTable(int pos);*/
		return null;
	}
	// giving the player a card the card they want from the table
	public TrainCard TrainCarCard(int pos) {
		return card;
	}
	
}
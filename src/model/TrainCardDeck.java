import java.util.*;
package model;

public class TrainCardDeck{
	//deck
	private ArrayList<TrainCarCard> trainDeck;
	//discard pile
	private LinkedList<TrainCarCard> trainDiscard;
	//cards on the table
	private LinkedList<TrainCarCard> tableCards;
	//placeholder for now
	private TrainCarCard card;
	//contruusttor will t
	TrainCardDeck(){
		trainDeck.Shuffle();
	}
	private void Shuffle() {

	}
	//test if player wants cards from deck or table and takes the action
	public TrainCarCard Draw(Boolean t) {
		if(t)
			return trainDiscard.addFrist(trainDeck.pop());
		else
			return this.toTable(int pos);
	}
	// giving the player a card the card they want from the table
	public TrainCarCard(int pos) {
		return card;
	}

}
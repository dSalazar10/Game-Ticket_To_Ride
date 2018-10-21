package model;
import java.util.LinkedList;



public class TrainCardDeck {
	//deck
	private LinkedList<TrainCard> trainDeck;
	//discard pile
	private LinkedList<TrainCard> trainDiscard;
	//cards on the table
	private LinkedList<TrainCard> tableCards;
	//placeholder for now
	private TrainCard card;

	//contruusttor will t
	TrainCardDeck() {
		trainDeck = new LinkedList<TrainCard>();
		int i = 0;
		// creates the locomotive cards
		// and adds them to the end of the deck
		while(i < 14){
			trainDeck.add(new TrainCard(0));
			i++;
		}
		i = 0;
		int j = 0;
		// Creates all cards and add them to the deck end of the deck

		while(j < 8){
			while(i < 12){
				trainDeck.add(new TrainCard(j));
				i++;
			}
			j++;
		}
		this.Shuffle();
	}

	private void Shuffle() {

	}

	//test if player wants cards from deck or table and takes the action
	public TrainCard Draw(Boolean t) {
		if (t)
			return trainDeck.pop();
		else
			return this.toTable(1);
	}

	// giving the player a card the card they want from the table
	public TrainCard fromTable(int pos) {
		return tableCards.get(pos);
	}


	public TrainCard toTable(int pos) {
		return new TrainCard(1);
	}
}
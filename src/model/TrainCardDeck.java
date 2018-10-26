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


public class TrainCardDeck {
	//deck
	private LinkedList<TrainCard> trainDeck;
	//discard pile
	private LinkedList<TrainCard> trainDiscard;
	//cards on the table
	private ArrayList<TrainCard> tableCards;

	// constructor makes deck and shuffles cards
	public TrainCardDeck() {
		trainDeck = new LinkedList<TrainCard>();
		int i = 0;
		// creates the locomotive cards
		// and adds them to the end of the deck
		while (i < 14) {
			trainDeck.add(new TrainCard(0));
			i++;
		}
		i = 0;
		int j = 0;
		// Creates all cards and add them to the deck end of the deck

		while (j < 8) {
			while (i < 12) {
				trainDeck.add(new TrainCard(j));
				i++;
			}
			j++;
		}
		Collections.shuffle(trainDeck);
		// 5 cards to the table
		for(int k = 0; k < 5; k++){

			tableCards.add(trainDeck.pop());
		}
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
	// returns 4 cards to the player;
	public ArrayList<TrainCard> Deal() {
	ArrayList<TrainCard> toPlayer = new ArrayList<TrainCard>();
	for(int i = 0; i < 4; i++){
		toPlayer.add(this.trainDeck.pop());
	}
	return toPlayer;
	}
}
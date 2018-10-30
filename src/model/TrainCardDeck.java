/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Nasario Sylvester
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */
package model;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;


public class TrainCardDeck {
	/*
	 * deck
	 */
	private LinkedList<TrainCard> trainDeck;
	/*
	 * discard pile
	 */
	private LinkedList<TrainCard> trainDiscard;
	/*
	 * cards on the table
	 */
	private ArrayList<TrainCard> tableCards;
	/*
	 * locomotive card to check during drawing
	 */
	private TrainCard locomotive;

	/*
	 * Constructor makes all decks and shuffles cards
	 */
	public TrainCardDeck() {
		locomotive = new TrainCard(0);
		trainDeck = new LinkedList<TrainCard>();
		tableCards = new ArrayList<TrainCard>();
		trainDiscard = new LinkedList<TrainCard>();

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
		// Shuffle Cards
		Collections.shuffle(trainDeck);
		// 5 cards to the table
		do {
			if(this.checkTable())
				this.discardToDeck();

			for (int k = 0; k < 5; k++) {

				tableCards.add(trainDeck.pop());
			}
		}while(this.checkTable());
	}

	/*
	 * test if player wants cards from deck or table and takes the action
	 * checks to see if card from table is locomotive, if so return
	 * if not get a second card
	 * if second time in taking a card from table the player tris to get
	 * a locomotive, the game will not go on until player chooses a non-locmotive card
	 */
	public ArrayList<TrainCard> Draw() {
		boolean t = true;
		int x = 0;
		TrainCard testCard;
		ArrayList draw = new ArrayList<TrainCard>();
		for (int i = 0; i < 2; i++) {
			if (trainDeck.isEmpty()) {
				this.discardToDeck();
			}
			if (t)
				draw.add(trainDeck.pop());
			else {
				if (i == 1) {
					do {
						testCard = this.peak(x);

					} while (testCard.equals(locomotive));
				}
				draw.add(0, this.fromTable(x));
				if (draw.get(0).equals(locomotive)) ;
				{
					return draw;
				}
			}
		}
		return draw;
	}

	/*
	  * giving the player a card the card they want from the table
	  */
	private TrainCard fromTable(int pos) {
		TrainCard forPlayer = tableCards.get(pos);
		this.toTable(pos);
		return forPlayer;
	}
	/*
	 * Checks a pos in TrainCard
	 */
	private TrainCard peak(int pos) {
		return this.tableCards.get(pos);
	}

	/*
	 * adds a card to the table and check if there are 3 or more locomtives
	 * face-up
	 */
	private void toTable(int pos) {
		if(trainDeck.isEmpty())
			this.discardToDeck();

		tableCards.add(pos, trainDeck.pop());

		while (this.checkTable()) {
				addToDiscard(tableCards);
				tableCards.clear();

				for (int it = 0; it < 5; it++) {

					if(trainDeck.isEmpty())
						this.discardToDeck();

					tableCards.add(trainDeck.pop());
				}
		}
	}
		/*
		 * returns 4 cards to the player;
		 */
		public ArrayList<TrainCard> toPlayer () {

			ArrayList<TrainCard> toPlayer = new ArrayList<TrainCard>();
			for (int i = 0; i < 4; i++) {
				toPlayer.add(this.trainDeck.pop());
			}
			return toPlayer;
		}
		/*
		 * Add cards to discard pile
		*/
		public void addToDiscard (ArrayList < TrainCard > discard) {
			for (int i = 0; i < discard.size(); i++) {
				trainDiscard.add(discard.get(i));
			}
		}
		//shuffles discard pile and shuffle then add to
		// main deck
		private void discardToDeck () {
			Collections.shuffle(trainDiscard);
			for (int i = 0; i < trainDiscard.size(); i++) {
				trainDeck.add(trainDiscard.get(i));
			}
			trainDiscard.clear();
		}
		/*
		 * Checks to see if there are 3 or more locomotive cards
		 * are face-up
		 */
		private boolean checkTable(){
			int locoOnTable = 0;
			for (int i = 0; i < 5; i++) {
				if (tableCards.get(i).equals(locomotive)) {
					locoOnTable++;
				}
			}
			if(locoOnTable > 2)
				return true;

			return false;
		}
		// for test method
		public TrainCard getTopofDeck(){
			return trainDeck.pop();
		}
	}

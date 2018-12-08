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
	public ArrayList<TrainCard> tableCards;
	/*
	 * locomotive card to check during drawing
	 */
	private TrainCard locomotive;
	/*
	 * Constructor makes all decks and shuffles cards
	 */
	public TrainCardDeck() throws Exception {
		String type, color;
		int amount;
	    locomotive = new TrainCard(0);
		trainDeck = new LinkedList<TrainCard>();
		tableCards = new ArrayList<TrainCard>();
		trainDiscard = new LinkedList<TrainCard>();
		File cardType = new File("src\\resources\\TextFiles\\CardType.txt");
		File cardNum = new File("src\\resources\\TextFiles\\CardNum.txt");
		File cardColor = new File("src\\resources\\TextFiles\\CardColor.txt");
        Scanner cardNReader = new Scanner(cardNum);
		Scanner cardTReader = new Scanner(cardType);
		Scanner cardCReader = new Scanner(cardColor);
		int i;
        while(cardNReader.hasNext() && cardTReader.hasNext()){
            amount = Integer.parseInt(cardNReader.nextLine());
            i = 0;
            type = cardTReader.nextLine();
            color = cardCReader.nextLine();
            while(i < amount){
                trainDeck.add(new TrainCard(type, color));
                i++;
            }
        }
		// Shuffle Cards
		Collections.shuffle(trainDeck);
		// 5 cards to the table

		do {
			int k = 0;
			while (k < 5) {
				TrainCard temp = trainDeck.get(k);
				trainDeck.remove(k);
				tableCards.add(temp);
				k++;
			}

			if(this.checkTable())
				this.discardToDeck();
		}while(this.checkTable());

	}

	/*
	 * test if player wants cards from deck or table and takes the action
	 * checks to see if card from table is locomotive, if so return
	 * if not get a second card
	 * if second time in taking a card from table the player tris to get
	 * a locomotive, the game will not go on until player chooses a non-locmotive card
	 */
	public ArrayList<TrainCard> Draw(boolean t,int x) {
		// temp vars
		TrainCard testCard;
		ArrayList draw = new ArrayList<TrainCard>();

		    if(trainDeck.isEmpty() && trainDiscard.isEmpty())
		        return draw;
            if (trainDeck.isEmpty()) {
				this.discardToDeck();
			if (t)
				draw.add(trainDeck.pop());
			else {
					do {
						testCard = this.peak(x);

					} while (testCard.equals(locomotive));

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

					if (trainDeck.isEmpty())
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
		public void addToDiscard (ArrayList <TrainCard> discard) {
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
			int i = 0;
			while(i < 5) {
				if (tableCards.get(i).equals(locomotive)) {
					locoOnTable++;
				}
				i++;
			}
			if(locoOnTable > 2)
				return true;

			return false;
		}
		// for test method
		public TrainCard getTopofDeck(){
			return trainDeck.pop();
		}
		/*
		 * Determines if this is a legal claim
		 * takes a list of cards, a train card or color and the length of the route
		 */
		public boolean canClaim(ArrayList<TrainCard> claim,  Object routeColor, int len){
		   TrainCard train;
		    if(routeColor instanceof TrainColor ){
		        TrainColor color = (TrainColor) routeColor;
		        train = new TrainCard(color.ordinal());
           }else if(!(routeColor instanceof TrainCard))
               return false;
		   else
		       train = (TrainCard) routeColor;
		    int i = 0;
		    if(claim.size() != len)
		        return false;
		    while(i < claim.size()){
		        if(!train.equals(claim.get(i)) && !locomotive.equals(claim.get(i)))
		            return false;
		        i++;
            }
            return true;
        }

	}

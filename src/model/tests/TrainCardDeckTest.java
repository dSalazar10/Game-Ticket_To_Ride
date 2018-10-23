/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Nasario Sylvester
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */

package model.tests;
import static org.junit.Assert.*;
import org.junit.Test;
import model.TrainCard;
import model.TrainCardDeck;

public class TrainCardDeckTest{
    TrainCardDeck x = new TrainCardDeck();
    TrainCard card1 = x.Draw(true);
    TrainCard card2 = new TrainCard(0);

    @Test
    public void trainDeckTest(){
        assertEquals(card1, card2);
    }
}

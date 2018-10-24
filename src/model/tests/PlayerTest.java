/*
 * PlayerTest.java
 * Version 0.1.4    : Setup
 * Programmer       : Adam Hennefer
 * Due Date         : 10/24/18
 * Last Modified    : 10/23/18 9:45
 */
package model.tests;

import model.Player;
import model.TrainPieces;
import static model.TrainPieces.COLOR.BLACK;
import static model.TrainPieces.COLOR.BLUE;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player p1, p2;
    private TrainPieces.COLOR black;
    private TrainPieces.COLOR blue;
        
    @Before
    public void playerTest() {
        String alice = "Alice";
        String bob = "Bob";
        black = TrainPieces.COLOR.BLACK;
        blue = TrainPieces.COLOR.BLUE;
        p1 = new Player(alice, black );
        p2 = new Player(bob, blue);
    }

    @Test
    public void testPlayer() {
        assertEquals(p1, p2);

    }
}
    
}

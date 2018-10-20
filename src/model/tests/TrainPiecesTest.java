/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : 10/20/18 00:11
 *
 * This tests the initialization of the TrainPieces 2D List.
 */

package model.tests;

import model.TrainPiece;
import model.TrainPieces;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrainPiecesTest {

    // Variables
    private TrainPieces t = new TrainPieces();
    private List<TrainPiece> black;
    private List<TrainPiece> blue;
    private List<TrainPiece> green;
    private List<TrainPiece> red;
    private List<TrainPiece> yellow;
    private List<TrainPiece> wrong;

    @Before
    public void setUp() {

        // Set all the sets of train pieces
        black = t.getPieces(TrainPieces.COLOR.BLACK);
        blue = t.getPieces(TrainPieces.COLOR.BLUE);
        green = t.getPieces(TrainPieces.COLOR.GREEN);
        red = t.getPieces(TrainPieces.COLOR.RED);
        yellow = t.getPieces(TrainPieces.COLOR.YELLOW);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testTrainPieces() {

        /* Test Duplicates */
        wrong = t.getPieces(TrainPieces.COLOR.BLACK);
        if(wrong.isEmpty())
            fail();

    }
}
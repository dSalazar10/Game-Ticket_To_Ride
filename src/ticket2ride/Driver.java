/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */

package ticket2ride;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import model.*;
import view.*;

import java.util.ArrayList;

public class Driver extends Application {
    private ArrayList<TrainCard> tCards;
    private ArrayList<DestinationCard> dCards;
    private Board usaBoard;
    private Player []p;

    public static void main(String[] args) {


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        usaBoard = new Board();

        p = new Player[3];
        p[0] = new Player("Player 1",TrainPieces.COLOR.RED);
        p[1] = new Player("Player 2", TrainPieces.COLOR.YELLOW);
        p[2] = new Player("Player 3", TrainPieces.COLOR.BLUE);

        for(int i = 0; i < 3; i++)
            p[i].addBoard(usaBoard);
        ArrayList<Cards> ima = new ArrayList();

        int i = 0;
        int player = 0;

        tCards = p[player].getTrainCards();


        Button []box = new Button[tCards.size()];

        while(i < tCards.size()){
            ima.add(new Cards(tCards.get(i)));
            box[i] = ima.get(ima.size() - 1).button;
            i++;
        }

        HBox hbox = new HBox();
        hbox.getChildren().addAll(box);

        Stage Player1 = new Stage();
        Player1.setTitle("Player 1");
        Player1.setScene(new Scene(hbox, 1024, 342));

        Stage Player2 = new Stage();
        Player2.setTitle("Player 2");

        Stage Player3 = new Stage();
        Player3.setTitle("Player 3");

        primaryStage.setScene(new Scene(BoardView.getBoard(), 1024, 683));
        primaryStage.setTitle("Ticket_To_Ride");
        primaryStage.show();
        Player1.show();
    }
}

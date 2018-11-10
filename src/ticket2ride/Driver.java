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


        int i = 0;
        int player = 0;


        Button p1c[] = new Button[4];
        Button p2c[] = new Button[4];
        Button p3c[] = new Button[4];

        while(i < 4){

            p1c[i] = Cards.bCards(p[0].getTrainCards().get(i));
            p2c[i] = Cards.bCards(p[1].getTrainCards().get(i));
            p3c[i] = Cards.bCards(p[2].getTrainCards().get(i));
            i++;
        }

        HBox p1box = new HBox();
        p1box.getChildren().addAll(p1c);

        HBox p2box = new HBox();
        p2box.getChildren().addAll(p2c);

        HBox p3box = new HBox();
        p3box.getChildren().addAll(p3c);

        Stage Player1 = new Stage();
        Player1.setTitle("Player 1");
        Player1.setScene(new Scene(p1box, 1024, 342));

        Stage Player2 = new Stage();
        Player2.setTitle("Player 2");
        Player2.setScene(new Scene(p2box, 1024, 342));

        Stage Player3 = new Stage();
        Player3.setTitle("Player 3");
        Player3.setScene(new Scene(p3box, 1024, 342));

        primaryStage.setScene(new Scene(BoardView.getBoard(), 1024, 683));
        primaryStage.setTitle("Ticket_To_Ride");
        primaryStage.show();
        Player1.show();
        Player2.show();
        Player3.show();
    }
}

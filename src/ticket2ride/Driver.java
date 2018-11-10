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
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import model.*;
import view.*;

import java.util.ArrayList;

public class Driver extends Application {
    private ArrayList<TrainCard> tCards;
    private ArrayList<DestinationCard> dCards;
    private Board usaBoard;
    private Player []p;
    //Global Vars
    public static GridPane p1box;
    public static GridPane p2box;
    public static GridPane p3box;
    public static Stage Player1;
    public static Stage Player2;
    public static Stage Player3;
    private static int trainPos = 0;
    private static int tixPos = 0;
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


        Button p1c[] = new Button[8];
        Button p2c[] = new Button[8];
        Button p3c[] = new Button[8];

        while(i < 4){
            p1c[i] = Cards.bCards(p[0].getTrainCards().get(i), trainPos);
            p2c[i] = Cards.bCards(p[1].getTrainCards().get(i), trainPos);
            p3c[i] = Cards.bCards(p[2].getTrainCards().get(i), trainPos);
            trainPos += (3*85);
            i++;
        }
        while(i < 7){

            p1c[i] = Tix.tCards(p[0].getDestTixCard().get(i-4), tixPos);
            p2c[i] = Tix.tCards(p[1].getDestTixCard().get(i-4), tixPos);
            p3c[i] = Tix.tCards(p[2].getDestTixCard().get(i-4),tixPos);
            tixPos += (2*60);
            i++;
        }
        p1c[7] = Next.bn1(p[1]);
        p2c[7] = Next.bn2();
        p3c[7] = Next.bn3();

        Button next = new Button();
        next.setText("Draw");

        p1box = new GridPane();
        p1box.getChildren().addAll(p1c);

        p2box = new GridPane();
        p2box.getChildren().addAll(p2c);

        p3box = new GridPane();
        p3box.getChildren().addAll(p3c);

        Player1 = new Stage();
        Player1.setTitle("Player 1");
        Player1.setScene(new Scene(p1box, 1024, 342));

        Player2 = new Stage();
        Player2.setTitle("Player 2");
        Player2.setScene(new Scene(p2box, 1024, 342));

        Player3 = new Stage();
        Player3.setTitle("Player 3");
        Player3.setScene(new Scene(p3box, 1024, 342));

        primaryStage.setScene(new Scene(BoardView.getBoard(), 1024, 683));
        primaryStage.setTitle("Ticket_To_Ride");
        primaryStage.show();
        Player1.show();
    }
}

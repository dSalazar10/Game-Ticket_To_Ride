/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */

package view;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Board;
import javafx.scene.control.Button;
import javafx.event.*;
import model.TrainCard;
import model.TrainCardDeck;

import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;


public class TrainDeck {
    public static Button button;
    public static void draw(Board b) throws FileNotFoundException {
        Stage stage = new Stage();
        int trainPos = 0;
        Button bnt = DrawingCards.bCards("CardBack", trainPos);
        trainPos += (3*85);
        Button []tCards = new Button[6];
        for(int i = 0; i<5; i++){
            tCards[i] = Cards.bCards(b.trainDeck.tableCards.get(i), trainPos);
            trainPos += (3*85);
        }
        tCards[5] = bnt;
        tCards[5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TrainCardDeck.t = true;
                stage.close();
            }
        });
        tCards[0].setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                TrainCardDeck.t = false;
                TrainCardDeck.x = 1;
                stage.close();
            }
        });
        tCards[1].setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                TrainCardDeck.t = false;
                TrainCardDeck.x = 2;
                stage.close();
            }
        });
        tCards[2].setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                TrainCardDeck.t = false;
                TrainCardDeck.x = 3;
                stage.close();
            }
        });
        tCards[3].setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                TrainCardDeck.t = false;
                TrainCardDeck.x = 4;
                stage.close();
            }
        });
        tCards[4].setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                TrainCardDeck.t = false;
                TrainCardDeck.x = 5;
                stage.close();
            }
        });
        GridPane pane = new GridPane();
        pane.getChildren().addAll(tCards);
        stage.setTitle("Deck");
        stage.setScene(new Scene(pane, 1028, 683));
        stage.show();
    }
}

/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */

package view;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.*;
public class Draw {
    public static void top(Player p){
        Stage stage = new Stage();
        Stage stage2 = new Stage();
        Button btn = new Button();
        btn.setText("Draw From\nTop\nOf Deck");
        btn.setAlignment(Pos.CENTER);
        btn.setTranslateX(100);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               p.board.trainDeck.Draw(true, 0);
               stage.hide();
            }
        });
        Button btn1 = new Button();
        btn1.setText("Draw From\nTable");
        btn1.setAlignment(Pos.CENTER);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            stage2.show();
            stage.hide();
            }
        });
        GridPane grid2 = new GridPane();
        Button []b = new Button[5];
        for(int i = 0; i < 5; i++){
            b[i] = new Button();
            b[i].setText(p.board.trainDeck.tableCards.get(i).toString());
            b[i].setTranslateX(i*(120));

        }
        b[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage2.hide();
                p.board.trainDeck.Draw(false, 0);
            }
        });
        b[1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage2.hide();
                p.board.trainDeck.Draw(false, 1);
            }
        });
        b[2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage2.hide();
                p.board.trainDeck.Draw(false, 2);
            }
        });
        b[3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage2.hide();
                p.board.trainDeck.Draw(false, 3);
            }
        });
        b[4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage2.hide();
                p.board.trainDeck.Draw(false, 4);
            }
        });
        GridPane grid = new GridPane();
        GridPane g2 = new GridPane();

        g2.getChildren().addAll(b);
        grid.getChildren().addAll(btn,btn1);
        stage.setScene(new Scene(grid, 500, 250));
        stage2.setScene(new Scene(g2, 1024, 342));
        stage.show();
    }
}

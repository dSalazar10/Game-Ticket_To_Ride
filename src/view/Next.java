/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */

package view;

import javafx.scene.control.Button;
import javafx.event.*;
import model.Board;
import model.*;
import model.TrainCardDeck;
import ticket2ride.Driver;

import java.io.FileNotFoundException;

public class Next {
    public static Button bn1(Player p) {
        Button btn = new Button();
        btn.setText("Next");
        btn.setTranslateY(150);
        btn.setTranslateX(150);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Driver.Player1.hide();
                Driver.Player2.show();

            }
        });
        return btn;

    }
    public static Button bn2() {
        Button btn = new Button();
        btn.setText("Next");
        btn.setTranslateY(150);
        btn.setTranslateX(150);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Driver.Player2.hide();
                Driver.Player3.show();

            }
        });
        return btn;

    }
    public static Button bn3() {
        Button btn = new Button();
        btn.setText("Next");
        btn.setTranslateY(150);
        btn.setTranslateX(150);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Driver.Player1.show();
                Driver.Player3.hide();

            }
        });
        return btn;

    }
}


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
import javafx.scene.image.*;
import model.TrainCard;
import java.io.FileInputStream;
import javafx.scene.control.Button;
import java.io.FileNotFoundException;

public class Cards{
    //takes a TrainCard and makes a button with that TrainCard on it
    static Image image;
    public static Button button;
    public static Button bCards (TrainCard card, int x)throws FileNotFoundException {
        image = new Image(new FileInputStream("TrainCardImages\\" + card.getType() + ".jpg"));
        button = new Button(card.toString() + " Card");
        button.setStyle("-fx-font-family: papyrus");
        button.setGraphic(new ImageView(image));
        button.setTranslateX(x);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(card.toString());
            }
        });
        return button;

    }
}


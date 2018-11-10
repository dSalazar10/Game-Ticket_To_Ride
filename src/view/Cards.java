/*
 * FileName.java
 * Version 0.1.4    : Setup
 * Programmer       : Daniel Salazar
 * Due Date         : 10/24/18
 * Last Modified    : MM/DD/YY HH:HH
 */

package view;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;
import model.TrainCard;
import java.io.FileInputStream;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.FileNotFoundException;

public class Cards{
    //takes a TrainCard and makes a button with that TrainCard on it
    static Image image;
    public static Button button;
    public static int i = 0;

    public static Button bCards (TrainCard card)throws FileNotFoundException {
        image = new Image(new FileInputStream("TrainCardImages\\" + card.getType() + ".jpg"));

        button = new Button(card.toString() + " Card");
        button.setStyle("-fx-font-family: papyrus");
        button.setGraphic(new ImageView(image));
        button.setTranslateX(i);
        button.setTranslateY(0);
        i+=10;
        return button;
    }
}


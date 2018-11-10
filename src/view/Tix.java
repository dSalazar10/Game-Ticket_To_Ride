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
import javafx.scene.text.Font;
import model.DestinationCard;
import javafx.scene.control.Button;
import java.io.FileNotFoundException;

public class Tix{

public static Button button;
public static Button tCards (DestinationCard card, int x)throws FileNotFoundException {
        button = new Button(card.toString());
        button.setFont(Font.font("Impact", 15));
        button.setTranslateY(90);
        button.setAlignment(Pos.CENTER);
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

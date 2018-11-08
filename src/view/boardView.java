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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class boardView {

    public HBox getBoard() {

        HBox cities = new HBox();
        // TODO: Chage this to use the board model
        Button[] buttonList = new Button[3];
        // TODO: Add positions for all cities
        double X[] = {105.0, 240.0, 465.0};
        double Y[] = {105.0, 85.0, 95.0};

        for (int i = 0; i < buttonList.length; i++) {
            buttonList[i] = new Button();

            // city ID will match the board model's list of routes
            buttonList[i].setId(Integer.toString(i));
            // change the button into a circle to overlap with the board image
            double r=1.5;
            buttonList[i].setShape(new Circle(r));
            buttonList[i].setMinSize(10*r, 10*r);
            buttonList[i].setMaxSize(10*r, 10*r);

            buttonList[i].setTranslateX(X[i]);
            buttonList[i].setTranslateY(Y[i]);

            buttonList[i].setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Hello World!");
                }
            });
        }
        cities.getChildren().addAll(buttonList);

        ImageView boardImg = new ImageView();
        boardImg.setImage(new Image("/resources/board.jpg",1024,683, false, false));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(boardImg, cities);

        HBox board = new HBox();
        board.getChildren().add(stackPane);
        return board;
    }
}

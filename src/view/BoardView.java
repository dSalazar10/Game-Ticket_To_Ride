
/*
 * BoardView.java
 * Version 0.3.0    : GUI
 * Programmer       : Daniel Salazar
 * Due Date         : 11/09/18
 * Last Modified    : 11/09/18 16:40
 */

package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class BoardView {

    // returns a Stack Pane containing an Image View of resources/board.jpg and a Grid Plane containing a list of Buttons
    public static StackPane getBoard() {
        // Hard coded coordinates of the red circles on the board's image
        // Origin is in the Top-Left corner
        // First number is the x-coordinate (Left/Right)
        // Second number is the y-coordinate (Up/Down)
        double pos[][] = {
                //Vancouver
                {103.0, 98.0},
                // Calgary
                {233.0, 79.0},
                // Seattle
                {99.0, 152.0},
                // Winnipeg
                {457.0, 90.0},
                // Helena
                {333.0, 212.0},
                // Portland
                {77.0, 203.0},
                // Sault Ste. Marie
                {698.0, 141.0},
                // Duluth
                {570.0, 205.0},
                // Omaha
                {540.0, 298.0},
                //San Francisco
                {63.0, 400.0},
                // Salt Lake City
                {262.0, 336.0},
                // Montreal
                {890.0, 75.0},
                // Toronto
                {808.0, 162.0},
                // Chicago
                {693.0, 268.0},
                //Kansas City
                {561.0, 349.0},
                // Oklahoma City
                {541.0, 436.0},
                // Santa Fe
                {385.0, 459.0},
                // Los Angeles
                {141.0, 505.0},
                // Denver
                {392.0, 367.0},
                // New York
                {908.0, 208.0},
                // Pittsburgh
                {824.0, 254.0},
                // Saint Louis
                {647.0, 349.0},
                //Little Rock
                {631.0, 441.0},
                // Dallas
                {561.0, 525.0},
                // El Paso
                {379.0, 548.0},
                // Las Vegas
                {206.0, 446.0},
                // Boston
                {961.0, 134.0},
                // Phoenix
                {261.0, 511.0},
                // Washington
                {918.0, 298.0},
                // Raleigh
                {859.0, 366.0},
                // Nashville
                {741.0, 389.0},
                //New Orleans
                {695.0, 552.0},
                // Houston
                {602.0, 564.0},
                // Charleston
                {886.0, 431.0},
                // Atlanta
                {792.0, 425.0},
                // Miami
                {918.0, 590.0}
        };

        // Board Image
        ImageView board = new ImageView();
        board.setImage(new Image("resources/board.jpg",1024,683, false, false));

        // City buttons
        Button[] buttonList = new Button[pos.length];
        for (int i = 0; i < buttonList.length; i++) {
            buttonList[i] = new Button();
            // Button ID matches the City ID (1-36)
            buttonList[i].setId(Integer.toString(i+1));
            // Turn the button into a Circle
            double radius = 1.5;
            buttonList[i].setShape(new Circle(radius));
            buttonList[i].setMinSize(10 * radius, 10 * radius);
            buttonList[i].setMaxSize(10 * radius, 10 * radius);
            // Use pos array to move button to specific coordinates
            buttonList[i].setTranslateX(pos[i][0]);
            buttonList[i].setTranslateY(pos[i][1]);
            buttonList[i].setOnAction(new EventHandler<ActionEvent>() {
                // Prints the ID to console for debugging
                @Override
                public void handle(ActionEvent event) {
                    Button btn = (Button) event.getSource();
                    String id = btn.getId();
                    System.out.println(id);
                }
            });
        }

        // Put all the city buttons in the Grid Pane
        GridPane cities = new GridPane();
        cities.getChildren().addAll(buttonList);

        // Put the board and the cities in a Stack Pane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(board, cities);

        return stackPane;
    }
}

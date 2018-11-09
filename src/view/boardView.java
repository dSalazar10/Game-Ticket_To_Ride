package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class boardView extends Application {

    double pos[][] = {
            // Vancouver
            {103.0, 98.0},
            // Calgary
            {218.0, 80.0},
            // Seattle
            {69.0, 152.0},
            // Winnipeg
            {413.0, 90.0},
            // Helena
            {273.0, 212.0},
            // Portland
            {2.0, 202.0},
            // Sault Ste. Marie
            {607.0, 140.0},
            // Duluth
            {466.0, 206.0},
            // Omaha
            {420.0, 299.0},
            // San Francisco
            {-72.0, 400.0},
            // Salt Lake City
            {112.0, 335.0},
            // Montreal
            {724.0, 75.0},
            // Toronto
            {627.0, 162.0}
    };

    public int MAX = 13;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(getBoard(), 1024, 683));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public HBox getBoard() {
        // City buttons
        HBox hbox = new HBox();
        Button[] buttonList = new Button[MAX];

        for (int i = 0; i < buttonList.length; i++) {
            buttonList[i] = new Button();

            // city ID
            buttonList[i].setId(Integer.toString(i+1));
            // Circle
            double r=1.5;
            buttonList[i].setShape(new Circle(r));
            buttonList[i].setMinSize(10*r, 10*r);
            buttonList[i].setMaxSize(10*r, 10*r);

            buttonList[i].setTranslateX(pos[i][0]);
            buttonList[i].setTranslateY(pos[i][1]);

            buttonList[i].setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    Button btn = (Button) event.getSource();
                    String id = btn.getId();
                    System.out.println(id);
                }
            });
        }
        hbox.getChildren().addAll(buttonList);

        ImageView iv1 = new ImageView();
        iv1.setImage(new Image("/sample/board.jpg",1024,683, false, false));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(iv1, hbox);

        HBox board = new HBox();
        board.getChildren().add(stackPane);
        return board;
    }

    private void selectImage(MouseEvent event)
    {

    }
}

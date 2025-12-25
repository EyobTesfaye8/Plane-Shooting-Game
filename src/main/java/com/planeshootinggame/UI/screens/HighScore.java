package com.planeshootinggame.UI.screens;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class HighScore {

    public Scene getScene(Stage stage) {
        Label title = new Label("High Scores");
        title.getStyleClass().add("title");

        ListView<String> scores = new ListView<>();
        scores.getItems().addAll(
            "1. 1500",
            "2. 1100",
            "3. 800"
        );

        Button back = new Button("Back");
        back.getStyleClass().add("menu-button");

        VBox layout = new VBox(20, title, scores, back);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 800, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        return scene;
    }
}
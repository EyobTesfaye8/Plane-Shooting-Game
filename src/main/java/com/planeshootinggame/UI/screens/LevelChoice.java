package com.planeshootinggame.UI.screens;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class LevelChoice {

    public Scene getScene(Stage stage) {
        Label title = new Label("Select Difficulty");
        title.getStyleClass().add("title");

        Button easy = new Button("Easy");
        Button medium = new Button("Medium");
        Button hard = new Button("Hard");

        easy.getStyleClass().add("menu-button");
        medium.getStyleClass().add("menu-button");
        hard.getStyleClass().add("menu-button");

        VBox layout = new VBox(20, title, easy, medium, hard);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 800, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        return scene;
    }
}
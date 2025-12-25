package com.planeshootinggame.UI.screens;

import com.planeshootinggame.App;
import com.planeshootinggame.GameEngine;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class MainMenu {

    public Scene getScene(Stage stage) {
        Label title = new Label("Plane Shooting Game");
        title.getStyleClass().add("title");

        Button play = new Button("Play");
        Button settings = new Button("Settings");
        Button exit = new Button("Exit");

        play.getStyleClass().add("menu-button");
        settings.getStyleClass().add("menu-button");
        exit.getStyleClass().add("menu-button");

        exit.setOnAction(e -> stage.close());

        VBox layout = new VBox(20, title, play, settings, exit);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 800, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        play.setOnAction(e -> {
            stage.setScene(App.gameScene);
            App.g.startGame();
        });

        return scene;
    }
}
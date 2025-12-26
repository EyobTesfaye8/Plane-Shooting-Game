package com.planeshootinggame.UI.screens;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import com.planeshootinggame.App;

import javafx.geometry.Pos;

public class GameOver {
    public Scene getScene(Stage stage, int score) {
        Label title = new Label("Game Over");
        title.getStyleClass().add("title");

        Label scoreLabel = new Label("Score: " + score);
        scoreLabel.getStyleClass().add("label-text");

        Button retry = new Button("Retry");
        Button menu = new Button("Main Menu");

        retry.setOnAction(e -> {
            stage.setScene(App.gameScene);
            App.g.changeGameOverStatus();
            App.g.startGame(stage);
        });
        
        menu.setOnAction(e -> {
            MainMenu menuMain = new MainMenu();
            Scene menuScene = menuMain.getScene(stage);
            stage.setScene(menuScene);
        });
        
        retry.getStyleClass().add("menu-button");
        menu.getStyleClass().add("menu-button");
        
        VBox layout = new VBox(20, title, scoreLabel, retry, menu);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout,App.sWidth,App.sHeight);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        return scene;
    }
}

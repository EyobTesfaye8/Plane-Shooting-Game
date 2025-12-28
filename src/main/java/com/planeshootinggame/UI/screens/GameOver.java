package com.planeshootinggame.UI.screens;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import com.planeshootinggame.App;
import com.planeshootinggame.HighScoreManager;

import javafx.geometry.Pos;

public class GameOver {
    public Scene getScene(Stage stage, int score) {
        Label title = new Label("Game Over");
        title.getStyleClass().add("title");

        Label scoreLabel = new Label("Score: " + score);
        scoreLabel.getStyleClass().add("label-text");

        Label newHighscore = new Label();
        newHighscore.setText((score>HighScoreManager.getScores()[0])?"New HighScore":"");
        newHighscore.getStyleClass().add("label-text");

        Button retry = new Button("Retry");
        Button menu = new Button("Main Menu");

        retry.setOnAction(e -> {
            App.showGame();
            App.g.init_player();
            App.g.turnONGame();
            App.g.startGame();
            if(!App.assets.mute) App.assets.click.play();
        });
        
        menu.setOnAction(e -> {
            App.showMenu();
            if(!App.assets.mute) App.assets.click.play();
        });
        
        retry.getStyleClass().add("menu-button");
        menu.getStyleClass().add("menu-button");
        
        VBox layout = new VBox(20, title, scoreLabel, newHighscore, retry, menu);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout,App.sWidth,App.sHeight);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        return scene;
    }
}

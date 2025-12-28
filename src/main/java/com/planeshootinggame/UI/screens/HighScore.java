package com.planeshootinggame.UI.screens;

import com.planeshootinggame.App;
import com.planeshootinggame.HighScoreManager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HighScore {

    public Scene createHighScoreScene(Stage stage) {
        int[] scores = HighScoreManager.getScores();
        
        Label title = new Label("High Scores");
        title.getStyleClass().add("title");

        Label firstPlace = new Label("1st");
        firstPlace.getStyleClass().add("label-text");

        Label firstScore = new Label(String.valueOf(scores[0]));
        firstScore.getStyleClass().add("label-text");

        HBox firstRow = new HBox(30, firstPlace, firstScore);
        firstRow.setAlignment(Pos.CENTER);

        Label secondPlace = new Label("2nd");
        secondPlace.getStyleClass().add("label-text");

        Label secondScore = new Label(String.valueOf(scores[1]));
        secondScore.getStyleClass().add("label-text");

        HBox secondRow = new HBox(30, secondPlace, secondScore);
        secondRow.setAlignment(Pos.CENTER);

        Label thirdPlace = new Label("3rd");
        thirdPlace.getStyleClass().add("label-text");

        Label thirdScore = new Label(String.valueOf(scores[2]));
        thirdScore.getStyleClass().add("label-text");

        HBox thirdRow = new HBox(30, thirdPlace, thirdScore);
        thirdRow.setAlignment(Pos.CENTER);

        Button backButton = new Button("Back");
        backButton.getStyleClass().add("menu-button");
        backButton.setOnAction(e -> {
            App.showMenu();
            if(!App.assets.mute) App.assets.click.play();
        });

        VBox layout = new VBox(25,title,firstRow,secondRow,thirdRow,backButton);

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.getStyleClass().add("root");

        Scene scene = new Scene(layout, App.sWidth, App.sHeight);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        return scene;
    }
}

package com.planeshootinggame.UI.screens;

import com.planeshootinggame.App;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class MainMenu {
    
    public Pane getRoot() {
        Label title = new Label("Plane Shooting Game");
        title.getStyleClass().add("title");
        
        Button play = new Button("Play");
        Button settings = new Button("Settings");
        Button exit = new Button("Exit");

        play.getStyleClass().add("menu-button");
        settings.getStyleClass().add("menu-button");
        exit.getStyleClass().add("menu-button");
        
        play.setOnAction(e -> {
            App.getScene().setRoot(App.getEngine().getRoot());
            App.getEngine().startGame();
        });
        
        exit.setOnAction(e -> System.exit(0));
        
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        layout.getChildren().addAll(title,play,settings,exit);

        return layout;
    }
}
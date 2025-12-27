package com.planeshootinggame.UI.screens;

import com.planeshootinggame.App;
import com.planeshootinggame.GameEngine;
import com.planeshootinggame.UI.overlays.HUD;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class MainMenu {

    public Scene getScene() {
        Label title = new Label("Plane Shooting Game");
        title.getStyleClass().add("title");

        Button play = new Button("Play");
        Button settings = new Button("Settings");
        Button exit = new Button("Exit");

        play.getStyleClass().add("menu-button");
        settings.getStyleClass().add("menu-button");
        exit.getStyleClass().add("menu-button");

        exit.setOnAction(e -> System.exit(0));

        VBox layout = new VBox(20, title, play, settings, exit);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, App.sWidth,App.sHeight);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        play.setOnAction(e -> {
            App.showGame();
            HUD.resume();
            System.out.println(App.g.getRoot().getChildren().contains(App.hudLayer));
            // App.g.init_player_again();
            App.g.turnONGame();
            App.g.init_player();
            App.g.startGame();
        });

        return scene;
    }
}
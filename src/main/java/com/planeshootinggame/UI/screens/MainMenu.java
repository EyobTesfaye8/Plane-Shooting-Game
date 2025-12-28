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

        Button playBtn = new Button("Play");
        Button hiscoreBtn = new Button("Highscore");
        Button settingsBtn = new Button("Settings");
        Button exitBtn = new Button("Exit");

        playBtn.getStyleClass().add("menu-button");
        hiscoreBtn.getStyleClass().add("menu-button");
        settingsBtn.getStyleClass().add("menu-button");
        exitBtn.getStyleClass().add("menu-button");

        
        VBox layout = new VBox(20, title, playBtn, hiscoreBtn, settingsBtn, exitBtn);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, App.sWidth,App.sHeight);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        
        playBtn.setOnAction(e -> {
            if(!App.assets.mute) App.assets.click.play();
            App.showGame();
            HUD.resume();
            System.out.println(App.g.getRoot().getChildren().contains(App.hudLayer));
            // App.g.init_player_again();
            App.g.turnONGame();
            App.g.init_player();
            App.g.startGame();
        });

        hiscoreBtn.setOnAction(e -> {
            App.showHighscore();
            if(!App.assets.mute) App.assets.click.play();
        });

        settingsBtn.setOnAction(e -> {
            App.showSettings();
            if(!App.assets.mute) App.assets.click.play();
        });

        exitBtn.setOnAction(e -> System.exit(0));

        return scene;
    }
}
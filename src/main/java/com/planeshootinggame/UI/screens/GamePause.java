package com.planeshootinggame.UI.screens;

import com.planeshootinggame.App;
import com.planeshootinggame.UI.overlays.HUD;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GamePause extends StackPane {

    private Button resumeBtn;
    private Button restartBtn;
    private Button quitBtn;

    public GamePause() {

        // Overlay setup
        setPrefSize(App.sWidth, App.sHeight);
        setVisible(false);
        getStyleClass().add("overlay");
        getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        setMouseTransparent(false);
        setPickOnBounds(true);

        // Menu container
        VBox menuBox = new VBox(20);
        menuBox.setAlignment(Pos.CENTER);

        // Title
        Label title = new Label("PAUSED");
        title.getStyleClass().add("title");

        // Buttons
        resumeBtn = new Button("Resume");
        restartBtn = new Button("Restart");
        quitBtn = new Button("Quit");

        resumeBtn.setOnAction(e -> {
            App.g.startGame();
            HUD.togglePause();
        });
        restartBtn.setOnAction(e -> {
            App.g.reset();
            App.g.init_player();
            App.g.startGame();
            HUD.resume();
        });
        quitBtn.setOnAction(e -> {
            App.g.stopGame();
            App.g.reset();
            App.showMenu();
        });
        resumeBtn.getStyleClass().add("menu-button");
        restartBtn.getStyleClass().add("menu-button");
        quitBtn.getStyleClass().add("menu-button");

        menuBox.getChildren().addAll(title, resumeBtn, restartBtn, quitBtn);
        getChildren().add(menuBox);
    }


    public void show() {
        setVisible(true);
        toFront();
    }

    public void hide() {
        setVisible(false);
    }
}

package com.planeshootinggame.UI.screens;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GamePause extends StackPane {

    private Runnable onResume;
    private Runnable onRestart;
    private Runnable onQuit;

    public GamePause() {

        // Full-screen overlay
        setPrefSize(1600, 1100);
        getStyleClass().add("overlay");
        setVisible(false);

        // Container
        VBox menuBox = new VBox(20);
        menuBox.setAlignment(Pos.CENTER);

        // Title
        Label title = new Label("PAUSED");
        title.getStyleClass().add("title");

        // Buttons
        Button restartBtn = new Button("Restart");
        Button quitBtn = new Button("Quit");

        restartBtn.getStyleClass().add("menu-button");
        quitBtn.getStyleClass().add("menu-button");

        // Button actions
        restartBtn.setOnAction(e -> {
            if (onRestart != null) onRestart.run();
        });

        quitBtn.setOnAction(e -> {
            if (onQuit != null) onQuit.run();
        });

        menuBox.getChildren().addAll(title, restartBtn, quitBtn);
        getChildren().add(menuBox);
    }

    // ===== Control Methods =====

    public void show() {
        setVisible(true);
        toFront();
    }

    public void hide() {
        setVisible(false);
    }

    // ===== Callbacks =====

    public void setOnResume(Runnable action) {
        this.onResume = action;
    }

    public void setOnRestart(Runnable action) {
        this.onRestart = action;
    }

    public void setOnQuit(Runnable action) {
        this.onQuit = action;
    }
}

package com.planeshootinggame.UI.screens;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class GamePaused {

    public VBox getView(Runnable resumeAction) {
        Label paused = new Label("Paused");
        paused.getStyleClass().add("title");

        Button resume = new Button("Resume");
        Button quit = new Button("Quit");

        resume.getStyleClass().add("menu-button");
        quit.getStyleClass().add("menu-button");

        resume.setOnAction(e -> resumeAction.run());

        VBox layout = new VBox(20, paused, resume, quit);
        layout.getStyleClass().add("overlay");

        return layout;
    }
}

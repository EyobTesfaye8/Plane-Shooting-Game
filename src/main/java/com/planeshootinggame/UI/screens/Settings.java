package com.planeshootinggame.UI.screens;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.control.CheckBox;

public class Settings {

    public Scene getScene(Stage stage) {
        Label title = new Label("Settings");
        title.getStyleClass().add("title");

        CheckBox sound = new CheckBox("Sound");
        sound.getStyleClass().add("label-text");

        Slider volume = new Slider(0, 100, 50);

        Button back = new Button("Back");
        back.getStyleClass().add("menu-button");

        VBox layout = new VBox(20, title, sound, volume, back);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 800, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        return scene;
    }
}

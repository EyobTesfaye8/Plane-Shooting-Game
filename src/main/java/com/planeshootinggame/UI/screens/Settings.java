package com.planeshootinggame.UI.screens;

import com.planeshootinggame.App;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Settings {
    public Scene createSettingsScene(Stage stage) {
        Label title = new Label("Settings");
        title.getStyleClass().add("title");

        // Volume
        Label muteLabel = new Label("Mute Audio");
        muteLabel.getStyleClass().add("label-text");

        CheckBox muteCheckBox = new CheckBox();
        if (App.assets.mute) muteCheckBox.setSelected(true);
        muteCheckBox.setOnAction(e -> {
            App.assets.mute = muteCheckBox.isSelected();
        });

        HBox muteBox = new HBox(15, muteLabel, muteCheckBox);
        muteBox.setAlignment(Pos.CENTER);

        // Back button
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("menu-button");
        backButton.setOnAction(e -> {
                App.showMenu();
                if(!App.assets.mute) App.assets.click.play();
        });

        // Layout
        VBox layout = new VBox(30, title, muteBox, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.getStyleClass().add("root");

        Scene scene = new Scene(layout, App.sWidth, App.sHeight);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        return scene;
    }
}

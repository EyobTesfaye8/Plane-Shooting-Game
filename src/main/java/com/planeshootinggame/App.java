package com.planeshootinggame;

import com.planeshootinggame.UI.components.HUD;
import com.planeshootinggame.UI.screens.GamePause;
import com.planeshootinggame.UI.screens.MainMenu;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class App extends Application {
    public static Pane gameLayer = new Pane();
    public static Pane hudLayer = new Pane();
    public static StackPane root = new StackPane();
    public static GamePause pauseMenu;

    public static AssetLoader assets = new AssetLoader(); 
    public static int sWidth = 1600;
    public static int sHeight = 1100;
    public static GameEngine g;
    public static Scene gameScene;
    public static MainMenu menu;

    @Override
    public void start(Stage stage) throws IOException {

        ImageView background = new ImageView(assets.backgroundIMG);
        background.setFitWidth(sWidth);
        background.setFitHeight(sHeight);
        background.setPreserveRatio(false);

        gameLayer.getChildren().add(background);
        gameLayer.setId("gameroot");

        g = new GameEngine(gameLayer);

        root.getChildren().addAll(gameLayer, hudLayer);

        gameScene = new Scene(root, sWidth, sHeight);

        menu = new MainMenu();
        Scene mainMenuScene = menu.getScene(stage);

        stage.setX(250);
        stage.setY(100);
        stage.setMinWidth(sWidth);
        stage.setMinHeight(sHeight);
        stage.setResizable(false);
        stage.setTitle("Plane Shooting Game");
        // stage.setScene(g.getGameOverScene(stage));
        stage.setScene(mainMenuScene);
        stage.show();
        // g.startGame(); 
    }

public static void createHUD() {

    // SCORE
    Label scoreLabel = new Label("Score: 0");
    scoreLabel.setStyle("-fx-font-size: 28px; -fx-text-fill: white;");
    scoreLabel.setTranslateX(20);
    scoreLabel.setTranslateY(20);

    // HEALTH
    Label healthLabel = new Label("Health: 100");
    healthLabel.setStyle("-fx-font-size: 28px; -fx-text-fill: red;");
    healthLabel.setTranslateX(20);
    healthLabel.setTranslateY(60);

    // PAUSE BUTTON (IMAGE)
    ImageView pauseButton = new ImageView(assets.pauseButtonIMG);
    pauseButton.setFitWidth(50);
    pauseButton.setFitHeight(50);

    // Position top-right
    pauseButton.setTranslateX(App.sWidth - 70);
    pauseButton.setTranslateY(20);

    // Hover effect (optional)
    pauseButton.setOnMouseEntered(e -> pauseButton.setOpacity(0.7));
    pauseButton.setOnMouseExited(e -> pauseButton.setOpacity(1));

    // Click handler
    pauseButton.setOnMouseClicked(e -> {
        // System.out.println("clicked");
        HUD.togglePause();

        if (HUD.isPaused()) {
            pauseMenu.show();
        } else {
            pauseMenu.hide();
        }
        pauseButton.setImage(
            HUD.isPaused() ? assets.playButtonIMG : assets.pauseButtonIMG
        );
    });

    hudLayer.getChildren().addAll(scoreLabel, healthLabel, pauseButton);

    HUD.scoreLabel = scoreLabel;
    HUD.healthLabel = healthLabel;
}


    public static void main(String[] args) {
        launch();
    }

}
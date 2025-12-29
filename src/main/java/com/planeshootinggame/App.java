package com.planeshootinggame;

import com.planeshootinggame.UI.overlays.HistoricalFacts;
import com.planeshootinggame.UI.screens.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;

public class App extends Application {
    public static AssetLoader assets = new AssetLoader(); 
    public static GameEngine g;

    public static int sHeight = 1100;
    public static int sWidth = 1600;
    public static Pane gameLayer = new Pane();
    public static Pane hudLayer = new Pane();
    public static StackPane root = new StackPane();
    public static GamePause pauseMenu;
    public static Scene gameScene;
    public static MainMenu menu = new MainMenu();
    public static Settings settings = new Settings();
    public static HighScore highscore = new HighScore();
    public static HistoricalFacts facts = new HistoricalFacts();

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        HighScoreManager.loadScores();
        stage = primaryStage;
        ImageView background = new ImageView(assets.backgroundIMG);
        background.setFitWidth(sWidth);
        background.setFitHeight(sHeight);
        background.setPreserveRatio(false);

        gameLayer.getChildren().add(background);
        gameLayer.setId("gameroot");
        
        g = new GameEngine(gameLayer);
        root.getChildren().addAll(gameLayer, hudLayer, facts);
        
        gameScene = new Scene(root, sWidth, sHeight);

        stage.setX(250);
        stage.setY(100);
        stage.setMinWidth(sWidth);
        stage.setMinHeight(sHeight);
        stage.setResizable(false);
        stage.setTitle("Adwa");
        showMenu();
        stage.show();
    }

    public static void showMenu(){
        stage.setScene(menu.getScene());
    }

    public static void showGameOver(){
        stage.setScene(new GameOver().getScene(stage, g.getScore()));
    }

    public static void showGamePaused(){
        stage.setScene(new Scene(pauseMenu));
    }

    public static void showGame(){
        stage.setScene(gameScene);
    }

    public static void showSettings(){
        stage.setScene(settings.createSettingsScene(stage));
    }

    public static void showHighscore(){
        stage.setScene(highscore.createHighScoreScene(stage));
    }
    public static void main(String[] args) {
        launch();
    }

}
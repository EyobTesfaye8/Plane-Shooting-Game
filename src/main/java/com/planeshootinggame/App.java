package com.planeshootinggame;

import com.planeshootinggame.UI.overlays.HUD;
import com.planeshootinggame.UI.screens.GameOver;
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

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
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
        // Scene mainMenuScene = menu.getScene(stage);

        stage.setX(250);
        stage.setY(100);
        stage.setMinWidth(sWidth);
        stage.setMinHeight(sHeight);
        stage.setResizable(false);
        stage.setTitle("Plane Shooting Game");
        // stage.setScene(g.getGameOverScene(stage));
        // stage.setScene(mainMenuScene);
        showMenu();
        stage.show();
        // g.startGame(); 
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

    public static void main(String[] args) {
        launch();
    }

}
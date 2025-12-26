package com.planeshootinggame;

import com.planeshootinggame.UI.screens.MainMenu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.GridPane;

public class App extends Application {
    public static GridPane GameRoot = new GridPane();
    public static int sWidth = 2000;
    public static int sHeight = 1500;
    public static GameEngine g;
    public static Scene gameScene;
    
    @Override
   public void start(Stage stage) throws IOException {

        GameRoot.setId("gameroot");

        g = new GameEngine(GameRoot);

        gameScene = new Scene(g.getRoot(), sWidth, sHeight);

        MainMenu menu = new MainMenu();
        Scene mainMenuScene = menu.getScene(stage);

        stage.setX(500);
        stage.setY(200);
        stage.setMinWidth(sWidth);
        stage.setMinHeight(sHeight);
        stage.setResizable(false);
        stage.setTitle("Plane Shooting Game");

        // stage.setScene(g.getGameOverScene(stage));
        stage.setScene(mainMenuScene);
        stage.show();
        // System.out.println(scene.getRoot());
        // if(scene.getRoot().getId() == "gameroot"){
            // g.startGame(); 
        // }
        // else{
        //     System.out.println("jjjfjf");
        // }
    }
    // public static GameEngine getEngine(){
    //     return g;
    // }
    public static void main(String[] args) {
        launch();
    }

}
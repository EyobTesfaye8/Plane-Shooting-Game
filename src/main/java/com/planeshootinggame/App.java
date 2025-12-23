package com.planeshootinggame;

import com.planeshootinggame.UI.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.GridPane;

public class App extends Application {
    static GridPane GameRoot = new GridPane();
    public static int sWidth = 2000;
    public static int sheight = 1500;
    protected static Scene scene;
    protected static GameEngine g = new GameEngine(GameRoot);

    @Override
    public void start(Stage stage) throws IOException {
        GameRoot.setId("gameroot");
        scene = new Scene(g.getRoot());
        // scene = new Scene(MainMenu.createMainMenu());
        stage.setX(500);
        stage.setY(200);
        stage.setMinWidth(sWidth);
        stage.setMinHeight(sheight);
        stage.setResizable(false);
        stage.setTitle("Plane Shooting Game");
        stage.setScene(scene);
        stage.show();
        System.out.println(scene.getRoot());
        // if(scene.getRoot().getId() == "gameroot"){
            g.startGame();
        // }
        // else{
        //     System.out.println("jjjfjf");
        // }
    }

    public static void main(String[] args) {
        launch();
    }

}
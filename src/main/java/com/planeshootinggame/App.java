package com.planeshootinggame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.GridPane;

public class App extends Application {
    public static int sWidth = 2000;
    public static int sheight = 1500;
    protected static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();
        GameEngine g = new GameEngine(root);
        scene = new Scene(g.getRoot());
        stage.setX(500);
        stage.setY(200);
        stage.setMinWidth(sWidth);
        stage.setMinHeight(sheight);
        stage.setResizable(false);
        stage.setTitle("Plane Shooting Game");
        stage.setScene(scene);
        stage.show();

        g.startGame();
    }

    public static void main(String[] args) {
        launch();
    }

}
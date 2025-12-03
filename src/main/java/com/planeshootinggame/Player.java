package com.planeshootinggame;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {
    private double speed = 4;
    private Pane root;

    public Player(double x, double y, GameEngine engine, Pane root) {
        super(x,y,40,30);
        this.root = root;
        Rectangle r = (Rectangle) sprite;
        r.setFill(Color.LIGHTBLUE);
        root.getChildren().add(sprite);
    }

    public void move(boolean left, boolean right, boolean up, boolean down) {
        
    }
    
    @Override
    public void update(){};

}
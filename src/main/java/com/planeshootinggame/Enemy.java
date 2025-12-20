package com.planeshootinggame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Enemy extends GameObject {
    private double dx = 0;
    private double dy = 2;

    public Enemy(double x, double y) {
        super(x,y,70,90);
        Rectangle r = (Rectangle) sprite;
        r.setFill(Color.BLUE);
    }

    @Override
    public boolean outOfScreenH(){
        return x < 0 || x > App.sWidth-width; 
    }

    @Override
    public boolean outOfScreenV(){
        return y < 0 || y > App.sheight-height; 
    }

    @Override
    public void update() {
        x += dx;
        y += dy;
        updateSprite();
    }

    public void attack(){
        
    }
}
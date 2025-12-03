package com.planeshootinggame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Enemy extends GameObject {
    private double dx = 0;
    private double dy = 0.5;

    public Enemy(double x, double y) {
        super(x,y,30,24);
        Rectangle r = (Rectangle) sprite;
        r.setFill(Color.RED);
    }

    @Override
    public void update() {
        x += dx;
        y += dy;
    }

    public void attack(){
        
    }
}
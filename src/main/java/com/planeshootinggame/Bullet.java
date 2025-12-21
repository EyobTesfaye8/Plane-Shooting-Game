package com.planeshootinggame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bullet extends GameObject {
    private double dy=20;

    public Bullet(double x, double y) {
        super(x,y,12,74);
        // this.dy = dy;
        Rectangle r = (Rectangle) sprite;
        r.setFill(Color.BLACK);
    }

    @Override
    public boolean outOfScreenH(){
        return x < 0 || x > App.sWidth-width; 
    }

    @Override
    public boolean outOfScreenV(){
        return y < -100 || y > App.sheight-height; 
    }

    @Override
    public void update() {
        y -= dy;
        updateSprite();
    }
}
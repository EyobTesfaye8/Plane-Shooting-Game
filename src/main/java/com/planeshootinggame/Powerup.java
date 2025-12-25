package com.planeshootinggame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Powerup extends GameObject {
    private PowerupType type;
    private double dy = 1.5;

    public Powerup(double x, double y, PowerupType type) {
        super(x,y,18,18);
        this.type = type;
        Rectangle r = (Rectangle) sprite;
        r.setFill(Color.YELLOW);
    }

    @Override
    public boolean outOfScreenH(){
        return x < 0 || x > App.sWidth-width; 
    }

    @Override
    public boolean outOfScreenV(){
        return y < 0 || y > App.sHeight-height; 
    }

    @Override
    public void update() {
        y += dy;
    }

    public void apply(Player p) {

    }
}
package com.planeshootinggame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Powerup extends GameObject {
    private PowerupType type;
    private double dy = 1.5;

    public Powerup(double x, double y, PowerupType type) {
        super(x,y,18,18);
        this.type = type;
    }

    @Override
    public void update() {
        
    }

    public void apply(Player p) {

    }
}
package com.planeshootinggame;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bullet extends GameObject {
    private double dy;

    public Bullet(double x, double y, double dy) {
        super(x,y,6,12);
        this.dy = dy;
        Rectangle r = (Rectangle) sprite;
        r.setFill(Color.YELLOW);
    }

    @Override
    public void update() {
        y += dy;
    }
}
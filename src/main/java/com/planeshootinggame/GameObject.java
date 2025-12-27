package com.planeshootinggame;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public abstract class GameObject {
    protected ImageView sprite;
    protected double x, y, width, height;

    public GameObject(double x, double y, double width, double height) {
        this.x = x; this.y = y; this.width = width; this.height = height;
    }

    protected void updateSprite(){
        sprite.setTranslateX(x);
        sprite.setTranslateY(y);
    }

    public ImageView getSprite(){return sprite;}

    public abstract boolean outOfScreenH();
    public abstract boolean outOfScreenV();
    public abstract void update();
    public boolean isNull(){return this.sprite != null;}

    public boolean intersects(GameObject other) {
        return this.x < other.x + other.width &&
            this.x + this.width > other.x &&
            this.y < other.y + other.height &&
            this.y + this.height > other.y;
    }
}
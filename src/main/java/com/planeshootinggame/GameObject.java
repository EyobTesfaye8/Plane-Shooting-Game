package com.planeshootinggame;

import javafx.scene.image.ImageView;

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

    public boolean outOfScreenH(){
        return x < 0 || x > App.sWidth-width; 
    }

    public boolean outOfScreenV(){
        return y < 0 || y > App.sHeight-height; 
    }

    public abstract void update();

    public boolean intersects(GameObject other) {
        return this.x < other.x + other.width &&
            this.x + this.width > other.x &&
            this.y < other.y + other.height &&
            this.y + this.height > other.y;
    }
}
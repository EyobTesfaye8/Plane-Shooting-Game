package com.planeshootinggame.BulletTypes;

import com.planeshootinggame.*;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class MegaBullet extends Bullet{
    // Rectangle r = (Rectangle) sprite;

    public MegaBullet(double x, double y){
        super(x, y, 80, 100);
        this.dy = 15;
        this.bulletPower = 10;
        this.sprite = new ImageView(App.assets.megaBulletIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
    }

     @Override
    public void update() {
        y -= dy;
        updateSprite();
    }
}

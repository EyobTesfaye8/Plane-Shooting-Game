package com.planeshootinggame.BulletTypes;

import com.planeshootinggame.*;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class NormalBullet extends Bullet{
    // ImageView bulletImage = new ImageView(App.assets.normalBulletIMG);

    public NormalBullet(double x, double y){
        super(x, y, 10, 200);
        this.dy = 5;
        this.bulletPower = 1;
        this.sprite = new ImageView(App.assets.normalBulletIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
    }

     @Override
    public void update() {
        y -= dy;
        updateSprite();
    }
}

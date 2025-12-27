package com.planeshootinggame.BulletTypes;

import com.planeshootinggame.*;

import javafx.scene.image.ImageView;

final public class EnemyBullet extends Bullet{
    // ImageView enemyBulletIMG = new ImageView("../../../../../Assets/bullets/EnemyBullet");
    
    // Rectangle r = (Rectangle) sprite;

    public EnemyBullet(double x, double y, double dy){
        super(x, y, 100, 400);
        this.dy = dy;
        this.bulletPower = 1;
        this.sprite = new ImageView(App.assets.enemyBulletIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
    }
     @Override
    public void update() {
        y += dy;
        updateSprite();
    }
}

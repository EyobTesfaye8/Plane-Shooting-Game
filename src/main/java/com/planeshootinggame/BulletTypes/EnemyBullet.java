package com.planeshootinggame.BulletTypes;

import com.planeshootinggame.*;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

final public class EnemyBullet extends Bullet{
    Rectangle r = (Rectangle) sprite;

    public EnemyBullet(double x, double y, double dy){
        super(x, y, 10, 40);
        this.dy = dy;
        this.bulletPower = 1;
        r.setFill(Color.RED);
    }
     @Override
    public void update() {
        y += dy;
        updateSprite();
    }
}

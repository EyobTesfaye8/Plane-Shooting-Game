package com.planeshootinggame.BulletTypes;

import com.planeshootinggame.*;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class NormalBullet extends Bullet{
    Rectangle r = (Rectangle) sprite;

    public NormalBullet(double x, double y){
        super(x, y, 20, 50);
        this.dy = 20;
        this.bulletPower = 1;
        r.setFill(Color.RED);
    }

     @Override
    public void update() {
        y -= dy;
        updateSprite();
    }
}

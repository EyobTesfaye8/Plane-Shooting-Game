package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.*;
import com.planeshootinggame.BulletTypes.EnemyBullet;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class ShootingEnemy extends Enemy {
    private double powerupDropChance = 0.30; 
    Rectangle r = (Rectangle) sprite;
    // private Image normalEnemyIMG = new Image("");
    

    public ShootingEnemy(double x, double y){
        super(x,y, 60, 80);
        this.dy = 5;
        this.health = 1;
        r.setFill(Color.YELLOWGREEN);
    }

    @Override
    public void update() {
        y += dy;
        updateSprite();
    }

    @Override
    public void attack(){
        Bullet b = new EnemyBullet(x + width/2, y, 7);
    }

    @Override
    public void changeImage(){
        if(this.getDamageStatus())
            r.setFill(Color.BLACK);
        else
            r.setFill(Color.YELLOWGREEN);
    }
}

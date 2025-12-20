package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.Enemy;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class ShootingEnemy extends Enemy {
    private double powerupDropChance = 0.30; 
    // private Image normalEnemyIMG = new Image("");
    

    public ShootingEnemy(double x, double y){
        super(x,y, 60, 80);
        this.dy = 5;
        this.health = 1;
        Rectangle r = (Rectangle) sprite;
        r.setFill(Color.YELLOWGREEN);
    }

    @Override
    public void update() {
        y += dy;
        updateSprite();
    }

    @Override
    public void attack(){
        // Big enemies shoot / attack....later to be implemented
    }
}

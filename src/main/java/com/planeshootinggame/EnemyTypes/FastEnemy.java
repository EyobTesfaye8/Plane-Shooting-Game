package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.Enemy;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class FastEnemy extends Enemy {
    private double powerupDropChance = 0.15; 
    // private Image normalEnemyIMG = new Image("");
    

    public FastEnemy(double x, double y){
        super(x,y, 80, 90);
        this.dy = 10;
        this.health = 2;
        Rectangle r = (Rectangle) sprite;
        r.setFill(Color.TOMATO);
    }

    @Override
    public void update() {
        y += dy;
        updateSprite();
    }

    @Override
    public void attack(){
        // fast enemies do not shoot / attack
    }
}

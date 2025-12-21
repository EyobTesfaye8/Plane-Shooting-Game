package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.Enemy;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class FastEnemy extends Enemy {
    private double powerupDropChance = 0.15; 
    Rectangle r = (Rectangle) sprite;
    // private Image normalEnemyIMG = new Image("");
    

    public FastEnemy(double x, double y){
        super(x,y, 80, 90);
        this.dy = 10;
        this.health = 2;
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

    @Override
    public void changeImage(){
        if(this.getDamageStatus())
            r.setFill(Color.BLACK);
        else
            r.setFill(Color.TOMATO);
    }
}

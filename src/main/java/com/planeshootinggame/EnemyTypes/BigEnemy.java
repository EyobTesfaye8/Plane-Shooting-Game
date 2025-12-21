package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.Enemy;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class BigEnemy extends Enemy {
    private double powerupDropChance = 0.20; 
    Rectangle r = (Rectangle) sprite;
    // private Image normalEnemyIMG = new Image("");
    

    public BigEnemy(double x, double y){
        super(x,y, 110, 140);
        this.dy = 3;
        this.health = 5;
        r.setFill(Color.MAGENTA);
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

    @Override
    public void changeImage(){
        if(this.getDamageStatus())
            r.setFill(Color.BLACK);
        else
            r.setFill(Color.MAGENTA);
    }
}

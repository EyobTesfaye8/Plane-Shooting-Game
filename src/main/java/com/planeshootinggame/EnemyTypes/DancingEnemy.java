package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.Enemy;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.lang.Math;

final public class DancingEnemy extends Enemy {
    private double powerupDropChance = 0.15;
    public double nextDestination;
    // private Image normalEnemyIMG = new Image("");
    
    
    public DancingEnemy(double x, double y){
        super(x,y, 110, 140);
        this.dy = 3;
        this.dx = 6;
        this.health = 5;
        Rectangle r = (Rectangle) sprite;
        r.setFill(Color.ROYALBLUE);
        // this.nextDestination = x;
    }
    
    @Override
    public void update() {
        if(nextDestination == x){
            nextDestination = Math.random()*1000;
        }
        if(x < nextDestination){
            x+=dx;
            if(nextDestination>x) nextDestination=x;
        }
        else if(x > nextDestination){
            x-=dx;
            if(nextDestination<x) nextDestination=x;
        }
        y += dy;
        updateSprite();
    }

    @Override
    public void attack(){
        // Big enemies shoot / attack....later to be implemented
    }
}

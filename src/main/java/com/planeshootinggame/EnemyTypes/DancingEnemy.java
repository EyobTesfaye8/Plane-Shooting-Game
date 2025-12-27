package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.App;
import com.planeshootinggame.Enemy;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.lang.Math;

final public class DancingEnemy extends Enemy {
    public double nextDestination;
    // Rectangle r = (Rectangle) sprite;
    // private Image normalEnemyIMG = new Image("");
    
    
    public DancingEnemy(double x, double y){
        super(x,y, 110, 140);
        this.dy = 8;
        this.dx = 6;
        this.health = 5;
        this.powerupDropChance = 0.15; 
        this.nextDestination = x;
        // r.setFill(Color.ROYALBLUE);
        this.sprite = new ImageView(App.assets.normalBulletIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
    }
    
    @Override
    public void update() {
        if(nextDestination == x){
            nextDestination = Math.random()*(App.sWidth-width);
        }
        if(x < nextDestination){
            x+=dx;
            if(nextDestination<x) nextDestination=x;
        }
        else if(x > nextDestination){
            x-=dx;
            if(nextDestination>x) nextDestination=x;
        }
        y += dy;
        updateSprite();
    }

    @Override
    public void shootTimer(){
        // Big enemies shoot / attack....later to be implemented
    }

    @Override
    public void changeImage(){
        // if(this.isDamaged())
        //     r.setFill(Color.BLACK);
        // else
        //     r.setFill(Color.ROYALBLUE);
    }
}

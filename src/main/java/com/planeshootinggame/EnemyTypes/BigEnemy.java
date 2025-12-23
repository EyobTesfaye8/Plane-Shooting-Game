package com.planeshootinggame.EnemyTypes;

import java.util.concurrent.CompletableFuture;

import com.planeshootinggame.Enemy;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class BigEnemy extends Enemy {
    private double powerupDropChance = 0.20; 
    Rectangle r = (Rectangle) sprite;
    // private Image normalEnemyIMG = new Image("");

    public BigEnemy(double x, double y){
        super(x,y, 110, 140);
        this.dy = 2;
        this.health = 30;
        r.setFill(Color.MAGENTA);
    }

    @Override
    public void update() {
        y += dy;
        updateSprite();
    }

    @Override
    public void shootTimer(){
        CompletableFuture.runAsync(()->{
            try{
                Thread.sleep((long)(Math.random()*2500 + 1500));
                canShoot = true;
            }catch(InterruptedException e){
                // ignore
            }
        });
    }

    @Override
    public void changeImage(){
        if(this.isDamaged())
            r.setFill(Color.BLACK);
        else
            r.setFill(Color.MAGENTA);
    }
}

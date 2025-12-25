package com.planeshootinggame.EnemyTypes;

import java.util.concurrent.CompletableFuture;

import com.planeshootinggame.*;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class ShootingEnemy extends Enemy {
    Rectangle r = (Rectangle) sprite;
    GameEngine g;
    // private Image normalEnemyIMG = new Image("");
    

    public ShootingEnemy(double x, double y){
        super(x,y, 60, 80);
        this.dy = 5;
        this.health = 1;
        this.powerupDropChance = 0.30;
        r.setFill(Color.YELLOWGREEN);
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
                Thread.sleep((long)(Math.random()*1500 + 500));
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
            r.setFill(Color.YELLOWGREEN);
    }
}

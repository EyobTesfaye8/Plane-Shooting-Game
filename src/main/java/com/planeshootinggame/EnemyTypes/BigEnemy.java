package com.planeshootinggame.EnemyTypes;

import java.util.concurrent.CompletableFuture;

import com.planeshootinggame.App;
import com.planeshootinggame.Enemy;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class BigEnemy extends Enemy {
    // Rectangle r = (Rectangle) sprite;
    // private Image normalEnemyIMG = new Image("");
    
    public BigEnemy(double x, double y){
        super(x,y, 110, 140);
        this.dy = 2;
        this.health = 30;
        this.powerupDropChance = 0.25; 
        // r.setFill(Color.MAGENTA);
        this.sprite = new ImageView(App.assets.normalBulletIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
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
        // if(this.isDamaged())
        //     r.setFill(Color.BLACK);
        // else
        //     r.setFill(Color.MAGENTA);
    }
}

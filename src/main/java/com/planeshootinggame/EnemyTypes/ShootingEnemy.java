package com.planeshootinggame.EnemyTypes;

import java.util.concurrent.CompletableFuture;

import com.planeshootinggame.*;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class ShootingEnemy extends Enemy {
    // Rectangle r = (Rectangle) sprite;
    // GameEngine g;
    // private Image normalEnemyIMG = new Image("");
    

    public ShootingEnemy(double x, double y){
        super(x,y, 100, 90);
        this.dy = 1.5;
        this.health = 2;
        this.sprite = new ImageView(App.assets.shootingEnemyIMGs[frameIndex]);
        sprite.setRotate(90);
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
                Thread.sleep((long)(Math.random()*1500 + 500));
                canShoot = true;
            }catch(InterruptedException e){
                System.out.println("Interrupted while sleeping, shootTimer - shooting enemy");
            }
        });
    }

    @Override
    public void changeImage(long now){
        if(this.isDamaged()) sprite.setImage(App.assets.shootingEnemyHurtIMG);

        else if (now - lastFrame >= frameChangeInterval){
            frameIndex = (++frameIndex) % App.assets.shootingEnemyIMGs.length;
            sprite.setImage(App.assets.shootingEnemyIMGs[frameIndex]);
            lastFrame = now;
        }
    }
}

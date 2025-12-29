package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.App;
import com.planeshootinggame.Enemy;

import java.util.concurrent.CompletableFuture;
import javafx.scene.image.ImageView;

final public class BigEnemy extends Enemy {
    
    public BigEnemy(double x, double y){
        super(x,y, 130, 120);
        this.dy = 1;
        this.health = 5;
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
                Thread.sleep((long)(Math.random()*2500 + 1500));
                canShoot = true;
            }catch(InterruptedException e){
                // ignore
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

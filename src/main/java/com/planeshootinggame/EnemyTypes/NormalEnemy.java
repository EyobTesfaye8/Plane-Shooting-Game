package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.*;

import javafx.scene.image.ImageView;

final public class NormalEnemy extends Enemy {

    public NormalEnemy(double x, double y){
        super(x,y, 60, 70);
        this.dy = 1.5;
        this.health = 2;
        this.powerupDropChance = 0.05;
        this.sprite = new ImageView(App.assets.meleeEnemyIMGs[frameIndex]);
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
        // Normal enemies do not shoot
    }

    @Override
    public void changeImage(long now){
        if(this.isDamaged()) sprite.setImage(App.assets.meleeEnemyHurtIMG);

        else if (now - lastFrame >= frameChangeInterval){
            frameIndex = (++frameIndex) % App.assets.meleeEnemyIMGs.length;
            sprite.setImage(App.assets.meleeEnemyIMGs[frameIndex]);
            lastFrame = now;
        }
    }
}

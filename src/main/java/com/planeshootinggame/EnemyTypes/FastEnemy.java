package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.App;
import com.planeshootinggame.Enemy;

import javafx.scene.image.ImageView;

final public class FastEnemy extends Enemy {

    public FastEnemy(double x, double y){
        super(x,y, 80, 90);
        this.dy = 2;
        this.health = 1;
        this.powerupDropChance = 0.05; 
        // r.setFill(Color.TOMATO);
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
        // fast enemies do not shoot 
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

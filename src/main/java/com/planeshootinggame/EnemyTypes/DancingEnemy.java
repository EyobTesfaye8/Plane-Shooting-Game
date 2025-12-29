package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.App;
import com.planeshootinggame.Enemy;

import javafx.scene.image.ImageView;
import java.lang.Math;

final public class DancingEnemy extends Enemy {
    private double nextDestination;

    public DancingEnemy(double x, double y){
        super(x,y, 110, 140);
        this.dy = 1.5;
        this.dx = 2;
        this.health = 2;
        this.nextDestination = x;
        this.sprite = new ImageView(App.assets.meleeEnemyIMGs[frameIndex]);
        sprite.setRotate(90);
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
    public void changeImage(long now){
        if(this.isDamaged()) sprite.setImage(App.assets.meleeEnemyHurtIMG);

        else if (now - lastFrame >= frameChangeInterval){
            frameIndex = (++frameIndex) % App.assets.meleeEnemyIMGs.length;
            sprite.setImage(App.assets.meleeEnemyIMGs[frameIndex]);
            lastFrame = now;
        }
    }
}

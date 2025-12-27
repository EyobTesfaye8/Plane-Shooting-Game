package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.App;
import com.planeshootinggame.Enemy;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class FastEnemy extends Enemy {
    // Rectangle r = (Rectangle) sprite;
    // private Image normalEnemyIMG = new Image("");
    

    public FastEnemy(double x, double y){
        super(x,y, 80, 90);
        this.dy = 10;
        this.health = 2;
        this.powerupDropChance = 0.05; 
        // r.setFill(Color.TOMATO);
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
        // fast enemies do not shoot / attack
    }

    @Override
    public void changeImage(){
        // if(this.isDamaged())
        //     r.setFill(Color.BLACK);
        // else
        //     r.setFill(Color.TOMATO);
    }
}

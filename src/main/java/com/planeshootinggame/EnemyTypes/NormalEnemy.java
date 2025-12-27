package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.*;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
// import javafx.scene.image.Image;

final public class NormalEnemy extends Enemy {
    // Rectangle r = (Rectangle) sprite;
    // private Image normalEnemyIMG = new Image("");
    

    public NormalEnemy(double x, double y){
        super(x,y, 60, 70);
        this.dy = 5;
        this.health = 3;
        this.powerupDropChance = 0.05;
        // r.setFill(Color.BLUE);
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
        // Normal enemies do not shoot / attack
    }

    @Override
    public void changeImage(){
        // if(this.isDamaged())
        //     r.setFill(Color.BLACK);
        // else
        //     r.setFill(Color.BLUE);
    }
}

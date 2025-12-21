package com.planeshootinggame.EnemyTypes;

import com.planeshootinggame.*;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
// import javafx.scene.image.Image;

final public class NormalEnemy extends Enemy {
    private double powerupDropChance = 0.05; 
    Rectangle r = (Rectangle) sprite;
    // private Image normalEnemyIMG = new Image("");
    

    public NormalEnemy(double x, double y){
        super(x,y, 60, 70);
        this.dy = 5;
        this.health = 3;
        r.setFill(Color.BLUE);
    }

    @Override
    public void update() {
        y += dy;
        updateSprite();
    }

    @Override
    public void attack(){
        // Normal enemies do not shoot / attack
    }

    @Override
    public void changeImage(){
        if(this.getDamageStatus())
            r.setFill(Color.BLACK);
        else
            r.setFill(Color.BLUE);
    }
}

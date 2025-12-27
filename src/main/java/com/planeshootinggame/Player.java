package com.planeshootinggame;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {
    private Pane root;
    private int lives;
    private double speed;
    private boolean isManyBullets = false;
    private boolean isMegaBullet = false;
    // private boolean manyBullets = true;

    public Player(double x, double y, Pane root) {
        super(x,y,100,150);
        this.root = root;
        this.lives = 3;
        this.speed = 15;
        
        sprite = new ImageView(App.assets.healPowerupIMG);
        sprite.setFitHeight(height);
        sprite.setFitWidth(width);
        root.getChildren().add(sprite);
    }

    public boolean isManyBullets(){return isManyBullets;}
    public boolean isMegaBullet(){return isMegaBullet;}
    public int getLives(){return lives;}
    public void damage(){lives--;}
    public void heal(){lives++;}
    public void speedup(){speed+=10;}

    @Override
    public boolean outOfScreenH(){
        return x < 0 || (x > App.sWidth-width);
    }

    @Override
    public boolean outOfScreenV(){
        return y < 0 || (y > App.sHeight-height);
    }

    public void move(boolean left, boolean right, boolean up, boolean down) {
        if(!outOfScreenH()){
            if(left == true) x-=speed;
            if(right == true) x+=speed;
        }
        if(!outOfScreenV()){
            if(up == true) y-=(speed - 5);
            if(down == true) y+=(speed - 5);
        }
        if(x < 0) x = 0; 
        else if(x > App.sWidth-width) x = App.sWidth-width; 
        if(y < 0) y = 0; 
        else if(y > App.sHeight-height) y = App.sHeight-height; 
        updateSprite();
    }
    
    public Pane getRoot(){return root;}
    
    @Override
    public void update(){}
}
package com.planeshootinggame;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {
    private Pane root;
    private int lives;
    private double speed;
    private boolean isMegaBullet = false;
    private boolean canBeIntersected = true;
    private int frameIndex = 0;
    private long lastFrame = 0;
    private long frameChangeInterval = 1000_000_000L;
    // private boolean manyBullets = true;

    public Player(double x, double y, Pane root) {
        super(x,y,100,150);
        this.root = root;
        this.lives = 3;
        this.speed = 15;
        
        sprite = new ImageView(App.assets.playerIMGS[frameIndex]);
        sprite.setFitHeight(height);
        sprite.setFitWidth(width);
        root.getChildren().add(sprite);
    }

    public int getLives(){return lives;}
    public boolean isMegaBullet(){return isMegaBullet;}
    public boolean canBeIntersected(){return canBeIntersected;}
    public void makeMega(){isMegaBullet = true;}
    public void removeMega(){isMegaBullet = false;}
    public void canBeIntersectedToggle(){canBeIntersected = !canBeIntersected;}
    public void damage(){lives--;}
    public void heal(){lives++;}
    public void speedup(){speed+=10;}
    public void slowDown(){speed-=10;}

    @Override
    public boolean outOfScreenH(){
        return x < 0 || (x > App.sWidth-width);
    }

    @Override
    public boolean outOfScreenV(){
        return y < 0 || (y > App.sHeight-height);
    }

    public void move(boolean left, boolean right, boolean up, boolean down, long now) {
        if(!outOfScreenH()){
            if(left == true) x-=speed;
            if(right == true) x+=speed;
        }
        if(!outOfScreenV()){
            if(up == true) y-=(speed - 5);
            if(down == true) y+=(speed - 5);
        }
        if(left || right || up || down){
            if (now - lastFrame >= frameChangeInterval){
                sprite.setImage(App.assets.playerIMGS[frameIndex]);
                frameIndex = (++frameIndex) % App.assets.playerIMGS.length;
            }
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
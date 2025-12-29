package com.planeshootinggame;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    private long frameChangeInterval = 10_000_000L;
    private ImageView shield;
    private StackPane completPlayer;
    private boolean moving = false;
    // private boolean manyBullets = true;

    public Player(double x, double y, Pane root) {
        super(x,y,100,150);
        this.root = root;
        this.lives = 3;
        this.speed = 3;
        shield =  new ImageView(App.assets.playerShield);
        shield.setFitHeight(height+10);
        shield.setFitWidth(width+10);
        shield.setVisible(false);
        sprite = new ImageView(App.assets.playerIMGS[frameIndex]);
        sprite.setFitHeight(height);
        sprite.setFitWidth(width);
        completPlayer = new StackPane(sprite, shield);
        root.getChildren().add(completPlayer);
    }

    public int getLives(){return lives;}
    public boolean isMegaBullet(){return isMegaBullet;}
    public boolean canBeIntersected(){return canBeIntersected;}
    public void makeMega(){isMegaBullet = true;}
    public void removeMega(){isMegaBullet = false;}
    public void canBeIntersectedToggle(){canBeIntersected = !canBeIntersected;}
    public void intersectable(){canBeIntersected = true;}
    public void notIntersectable(){canBeIntersected = false;}
    public void damage(){lives--;}
    public void heal(){lives++;}
    public void speedup(){speed+=3;}
    public void slowDown(){speed-=3;}

    public void move(boolean left, boolean right, boolean up, boolean down) {
        if(left || right || up || down) moving = true;
        else moving = false;
        if(!outOfScreenH()){
            if(left == true) {
                x-=speed; 
                shield.setX(x);
            }
            if(right == true) {
                x+=speed; 
                shield.setX(x);
            }
            shield.setTranslateX(x);
        }
        if(!outOfScreenV()){
            if(up == true) {
                y-=(speed - 1);
                shield.setY(y);
            }
            if(down == true) {
                y+=(speed - 1); 
                shield.setY(y);
            }
            shield.setTranslateY(y);
        }

        if(x < 0) x = 0; 
        else if(x > App.sWidth-width) x = App.sWidth-width; 
        if(y < 0) y = 0; 
        else if(y > App.sHeight-height) y = App.sHeight-height;
        updateSprite();
    }
    
    // public Pane getRoot(){return root;}
    
    @Override
    public void update(){
        shield.setVisible(!canBeIntersected);
    }

    public void update(long now){
        if(!(outOfScreenH() || outOfScreenV())){
            if(moving){
                if (now - lastFrame >= frameChangeInterval){
                    if(isMegaBullet)
                        sprite.setImage(App.assets.shootingPlayerIMGS[frameIndex]);
                    else 
                        sprite.setImage(App.assets.playerIMGS[frameIndex]);
                    frameIndex = (++frameIndex) % App.assets.playerIMGS.length;
                    lastFrame = now;
                }
            }
            else{
                if(isMegaBullet) sprite.setImage(App.assets.shootingPlayerIMGS[frameIndex]);
                else sprite.setImage(App.assets.playerIMGS[frameIndex]);
            }
        }
    }

    public StackPane getPlayer() {
        return completPlayer;
    }
}
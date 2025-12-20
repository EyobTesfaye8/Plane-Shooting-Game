package com.planeshootinggame;

import java.util.Iterator;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {
    private double speed = 20;
    public Pos position;
    private Pane root;
    static int lives;

    public Player(double x, double y, Pane root) {
        super(x,y,100,150);
        this.root = root;
        this.lives = 3;
        Rectangle r = (Rectangle) sprite;
        r.setX(x);
        r.setY(y);
        r.setFill(Color.RED);
        root.getChildren().add(r);
    }

    @Override
    public boolean outOfScreenH(){
        return x < 0 || (x > App.sWidth-width);
    }

    @Override
    public boolean outOfScreenV(){
        return y < 0 || (y > App.sheight-height);
    }

    public void update(boolean left, boolean right, boolean up, boolean down) {
        if(!outOfScreenH()){
            if(left == true) x-=speed;
            if(right == true) x+=speed;
        }
        if(!outOfScreenV()){
            if(up == true) y-=speed;
            if(down == true) y+=speed;
        }
        if(x < 0) x = 0; 
        else if(x > App.sWidth-width) x = App.sWidth-width; 
        if(y < 0) y = 0; 
        else if(y > App.sheight-height) y = App.sheight-height; 
        updateSprite();
    }
    
    public Pane getRoot(){return root;}
    
    @Override
    public void update(){}

    // public void removeOffscreen() {
            
    // }
}
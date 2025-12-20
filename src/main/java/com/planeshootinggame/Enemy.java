package com.planeshootinggame;

import com.planeshootinggame.EnemyTypes.BigEnemy;
import com.planeshootinggame.EnemyTypes.DancingEnemy;
import com.planeshootinggame.EnemyTypes.FastEnemy;
import com.planeshootinggame.EnemyTypes.NormalEnemy;
import com.planeshootinggame.EnemyTypes.ShootingEnemy;

abstract public sealed class Enemy extends GameObject 
            permits ShootingEnemy, 
                    FastEnemy, 
                    BigEnemy,
                    NormalEnemy,
                    DancingEnemy
                    {
    protected double dx;
    protected double dy;
    protected int health;

    public Enemy(double x, double y, double width, double height) {
        super(x,y, width, height);
    }
    
    public void damage(){
        health--;
    }

    @Override
    public boolean outOfScreenH(){
        return x < 0 || x > App.sWidth-width; 
    }

    @Override
    public boolean outOfScreenV(){
        return y < 0 || y > App.sheight-height; 
    }

    abstract public void attack();
}
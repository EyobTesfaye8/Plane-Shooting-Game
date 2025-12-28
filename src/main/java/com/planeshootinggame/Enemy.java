package com.planeshootinggame;

import com.planeshootinggame.EnemyTypes.*;
abstract public sealed class Enemy extends GameObject 
            permits ShootingEnemy, 
                    FastEnemy, 
                    BigEnemy,
                    NormalEnemy,
                    DancingEnemy
{
    protected int health;
    protected double dx;
    protected double dy;
    protected boolean canShoot = true;
    protected double powerupDropChance;
    protected long frameChangeInterval = 100_000_000L;
    protected long lastFrame = 0;
    protected int frameIndex = 0;
    private boolean isDamaged = false;

    public Enemy(double x, double y, double width, double height) {
        super(x,y, width, height);
    }
    
    public void damage(int bulletPower){
        health-=bulletPower;
        isDamaged = true;
    }

    public void resetDamageStatus(){isDamaged = false;}
    public boolean isDamaged(){return isDamaged;}
    public boolean canShoot(){return canShoot;}
    abstract public void shootTimer();
    abstract public void changeImage(long now);

    @Override
    public boolean outOfScreenH(){
        return x < 0 || x > App.sWidth-width; 
    }

    @Override
    public boolean outOfScreenV(){
        return y < 0 || y > App.sHeight-height; 
    }

}
package com.planeshootinggame;

import com.planeshootinggame.BulletTypes.*;


abstract public sealed class Bullet extends GameObject
                permits EnemyBullet,
                        MegaBullet
{
    protected double dy;
    protected double dx;
    protected int bulletPower;

    public Bullet(double x, double y, double width, double height) {
        super(x,y,width,height);
    }

    public int bulletPower(){return bulletPower;}

    @Override
    public boolean outOfScreenH(){
        return x < 0 || x > App.sWidth-200; 
    }

    @Override
    public boolean outOfScreenV(){
        return y < -100 || y > App.sheight+100; 
    }
}
package com.planeshootinggame;

import com.planeshootinggame.BulletTypes.*;


abstract public sealed class Bullet extends GameObject
                permits EnemyBullet,
                        MegaBullet,
                        NormalBullet
{
    protected double dy;
    protected double dx;
    protected int bulletPower;

    public Bullet(double x, double y, double width, double height) {
        super(x,y,width,height);
    }

    public int bulletPower(){return bulletPower;}
}
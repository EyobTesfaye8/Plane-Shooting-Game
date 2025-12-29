package com.planeshootinggame;
import com.planeshootinggame.PowerupTypes.*;
abstract public sealed class Powerup extends GameObject 
                permits ExtraLife,
                        Mega,
                        Shield,
                        Speedup
{
    protected double dy = 2;

    public Powerup(double x, double y, double width, double height) {
        super(x,y,width,height);
    }

    @Override
    public void update() {
        y += dy;
        updateSprite();
    }

    abstract public void apply(Player p);
}
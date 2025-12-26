package com.planeshootinggame.PowerupTypes;

import com.planeshootinggame.Player;
import com.planeshootinggame.Powerup;
import com.planeshootinggame.PowerupType;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class ExtraLife extends Powerup{
    Rectangle r = (Rectangle) sprite;

    public ExtraLife(double x, double y, PowerupType type) {
        super(x,y,40,50);
        this.type = type;
        r.setFill(Color.BLUEVIOLET);
    }

    @Override
    public void apply(Player p){
        p.heal();
    }
}

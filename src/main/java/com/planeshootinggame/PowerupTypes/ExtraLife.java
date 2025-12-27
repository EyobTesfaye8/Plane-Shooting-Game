package com.planeshootinggame.PowerupTypes;

import com.planeshootinggame.App;
import com.planeshootinggame.Player;
import com.planeshootinggame.Powerup;
import com.planeshootinggame.PowerupType;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class ExtraLife extends Powerup{

    public ExtraLife(double x, double y, PowerupType type) {
        super(x,y,40,50);
        this.type = type;
        this.sprite = new ImageView(App.assets.healPowerupIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
    }

    @Override
    public void apply(Player p){
        p.heal();
    }
}

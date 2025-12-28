package com.planeshootinggame.PowerupTypes;

import com.planeshootinggame.App;
import com.planeshootinggame.Player;
import com.planeshootinggame.Powerup;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final public class ExtraLife extends Powerup{

    public ExtraLife(double x, double y) {
        super(x,y,40,50);
        this.sprite = new ImageView(App.assets.healPowerupIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
    }

    @Override
    public void apply(Player p){
        p.heal();
    }
}

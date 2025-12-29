package com.planeshootinggame.PowerupTypes;

import com.planeshootinggame.App;
import com.planeshootinggame.Player;
import com.planeshootinggame.Powerup;
import com.planeshootinggame.UI.overlays.HUD;

import javafx.scene.image.ImageView;

final public class ExtraLife extends Powerup{

    public ExtraLife(double x, double y) {
        super(x,y,60,80);
        this.sprite = new ImageView(App.assets.healPowerupIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
    }

    @Override
    public void apply(Player p){
        p.heal();
        HUD.heal();
    }
}

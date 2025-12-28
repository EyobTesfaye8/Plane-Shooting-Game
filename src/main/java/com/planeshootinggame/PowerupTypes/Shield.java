package com.planeshootinggame.PowerupTypes;

import java.util.concurrent.CompletableFuture;

import com.planeshootinggame.App;
import com.planeshootinggame.Player;
import com.planeshootinggame.Powerup;

import javafx.scene.image.ImageView;

final public class Shield extends Powerup {
    public Shield(double x, double y) {
        super(x,y,40,50);
        // this.type = type;
        this.sprite = new ImageView(App.assets.healPowerupIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
    }

    @Override
    public void apply(Player p){
        // p.megaBulletToggle();
        // CompletableFuture.runAsync(() -> {
        //     try{
        //         Thread.sleep(duration);
        //         p.megaBulletToggle();
        //     }catch(InterruptedException e){
        //         //ignore
        //     }
        // });
    }
}

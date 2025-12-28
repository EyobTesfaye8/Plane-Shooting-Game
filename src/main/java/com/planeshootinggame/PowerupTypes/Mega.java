package com.planeshootinggame.PowerupTypes;

import java.util.concurrent.CompletableFuture;

import com.planeshootinggame.App;
import com.planeshootinggame.Player;
import com.planeshootinggame.Powerup;

import javafx.scene.image.ImageView;

final public class Mega extends Powerup {
    private long duration;
    public Mega(double x, double y) {
        super(x,y,60,70);
        this.sprite = new ImageView(App.assets.riflePowerupIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
        this.duration = 5000;
    }

    @Override
    public void apply(Player p){
        p.makeMega();
        CompletableFuture.runAsync(() -> {
            try{
                Thread.sleep(duration);
                p.removeMega();
            }catch(InterruptedException e){
                //ignore
            }
        });
    }
}

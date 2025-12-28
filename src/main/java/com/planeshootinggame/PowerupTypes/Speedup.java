package com.planeshootinggame.PowerupTypes;

import java.util.concurrent.CompletableFuture;

import com.planeshootinggame.App;
import com.planeshootinggame.Player;
import com.planeshootinggame.Powerup;

import javafx.scene.image.ImageView;

final public class Speedup extends Powerup {
    private long duration;
    public Speedup(double x, double y) {
        super(x,y,40,50);
        this.sprite = new ImageView(App.assets.horsePowerupIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
        this.duration = 3000;
    }

    @Override
    public void apply(Player p){
        p.speedup();
        CompletableFuture.runAsync(() -> {
            try{
                Thread.sleep(duration);
                p.slowDown();
            }catch(InterruptedException e){
                //ignore
            }
        });
    }
}

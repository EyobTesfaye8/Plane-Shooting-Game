package com.planeshootinggame.PowerupTypes;

import java.util.concurrent.CompletableFuture;

import com.planeshootinggame.App;
import com.planeshootinggame.Player;
import com.planeshootinggame.Powerup;

import javafx.scene.image.ImageView;

final public class Shield extends Powerup {
    private long duration;
    public Shield(double x, double y) {
        super(x,y,60,60);
        // this.type = type;
        this.sprite = new ImageView(App.assets.shieldPowerupIMG);
        sprite.setFitWidth(width);
        sprite.setFitHeight(height);
        this.duration = 10000;
    }

    @Override
    public void apply(Player p){
        p.notIntersectable();
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(duration);
                p.intersectable();
            } catch (InterruptedException e) {
                System.out.println("Interrupted : apply - Shield.java");
            }
        });
    }
}

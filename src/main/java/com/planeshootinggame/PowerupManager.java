package com.planeshootinggame;

// import com.planeshootinggame.PowerupType;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PowerupManager {
    private List<Powerup> powerups = new ArrayList<>();
    private Pane root;
    private Random r = new Random();
    
    public PowerupManager(Pane root) { this.root = root; }

    public void spawnPowerup(double x, double y) {
       Powerup p = new Powerup(x, y, PowerupType.values()[r.nextInt(PowerupType.values().length)]);
       powerups.add(p);
       root.getChildren().add(p.getSprite());
    }

    public void update() {
        for (Powerup p : powerups) p.update();
    }

    public void removeSprite(Powerup p) { 
        root.getChildren().remove(p.getSprite());
    }

    public Pane getRoot(){return this.root;}

    public void removeOffscreen(double height) {
        for (Iterator<Powerup> it = powerups.iterator(); it.hasNext();){
            Powerup p = it.next();
            if(p.y > App.sHeight+100){
                it.remove();
                root.getChildren().remove(p.getSprite());
            }
        }
    }
}
package com.planeshootinggame;

// import com.planeshootinggame.PowerupType;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import com.planeshootinggame.PowerupTypes.*;

public class PowerupManager {
    private List<Powerup> powerups = new ArrayList<>();
    private Pane root;
    private Random r = new Random();
    
    public PowerupManager(Pane root) { this.root = root; }

    public void spawnPowerup(double x, double y) {
       double randomNUM = r.nextDouble()*200; //1000
       boolean spawned = false;
       if(randomNUM < 200) spawned = true;
       if(spawned){
           Powerup p;
           if(randomNUM > 150){
               p = new Mega(x, y);
           }
           else if (randomNUM > 100){
               p = new ExtraLife(x, y);
           }
           else if (randomNUM > 0){
               p = new Speedup(x, y);
           }
           else {
               p = new Shield(x, y);
           }
           root.getChildren().add(p.sprite);
           powerups.add(p);
       }
    }

    public void update() {
        for (Powerup p : powerups) p.update();
    }

    public void removeSprite(Powerup p) { 
        root.getChildren().remove(p.getSprite());
    }

    public Pane getRoot(){return this.root;}
    public List<Powerup> getPowerups(){return powerups;}

    public void removeOffscreen() {
        for (Iterator<Powerup> it = powerups.iterator(); it.hasNext();){
            Powerup p = it.next();
            if(p.y > App.sHeight+100){
                it.remove();
                root.getChildren().remove(p.getSprite());
            }
        }
    }
}
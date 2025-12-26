package com.planeshootinggame;

// import com.planeshootinggame.PowerupType;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import com.planeshootinggame.PowerupTypes.ExtraLife;

public class PowerupManager {
    private List<Powerup> powerups = new ArrayList<>();
    private Pane root;
    private Random r = new Random();
    
    public PowerupManager(Pane root) { this.root = root; }

    public void spawnPowerup(double x, double y) {
       double randomNUM = r.nextDouble()*1000;
       boolean spawned = false;
       if(randomNUM < 200) spawned = true;
       if(spawned){
           Powerup p;
           // if(randomNUM > 600){
               // p = new ExtraLife(x, y, PowerupType.values()[r.nextInt(PowerupType.values().length)]);
               p = new ExtraLife(x, y, PowerupType.EXTRA_LIFE);
           // }
           // else if (randomNUM > 300){
           //     enemy = new FastEnemy(r.nextInt(App.sWidth-100), -300);
           // }
           // else if (randomNUM > 200){
           //     enemy = new BigEnemy(r.nextInt(App.sWidth-100), -300);
           // }
           // else if (randomNUM > 150){
           //     enemy = new ShootingEnemy(r.nextInt(App.sWidth-100), -300);
           // }
           // else{
           //     enemy = new DancingEnemy(r.nextInt(App.sWidth-100), -300);
           // }
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
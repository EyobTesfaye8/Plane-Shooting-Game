package com.planeshootinggame;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
public class AssetLoader {
    public Image shootingEnemyIMGs[] =  new Image[20];
    public Image meleeEnemyIMGs[] =     new Image[20];
    public Image backgroundIMG =        new Image(getClass().getResource("/Assets/Image/Background.png").toExternalForm());
    public Image enemyBulletIMG =       new Image(getClass().getResource("/Assets/Image/bullets/EnemyBullet.svg").toExternalForm());
    public Image megaBulletIMG =        new Image(getClass().getResource("/Assets/Image/bullets/MegaBullet.svg").toExternalForm());
    public Image normalBulletIMG =      new Image(getClass().getResource("/Assets/Image/bullets/NormalBullet.png").toExternalForm());
    public Image homeButtonIMG =        new Image(getClass().getResource("/Assets/Image/GUI/HomeButton.png").toExternalForm());
    public Image pauseButtonIMG =       new Image(getClass().getResource("/Assets/Image/GUI/PauseButton.png").toExternalForm());
    public Image playButtonIMG =        new Image(getClass().getResource("/Assets/Image/GUI/PlayButton.png").toExternalForm());
    public Image settingsButtonIMG =    new Image(getClass().getResource("/Assets/Image/GUI/SettingsButton.png").toExternalForm());
    // public Image playerIMG =            new Image(getClass().getResource("/Assets/Image/player/PlayerImmunityShield.png").toExternalForm());
    public Image playerShield =         new Image(getClass().getResource("/Assets/Image/player/PlayerImmunityShield.png").toExternalForm());
    public Image riflePowerupIMG =      new Image(getClass().getResource("/Assets/Image/powerups/Rifle.png").toExternalForm());
    public Image healPowerupIMG =       new Image(getClass().getResource("/Assets/Image/powerups/Heal.png").toExternalForm());
    public Image shieldPowerupIMG =     new Image(getClass().getResource("/Assets/Image/powerups/Shield.png").toExternalForm());
    public Image horsePowerupIMG =      new Image(getClass().getResource("/Assets/Image/powerups/Horse.png").toExternalForm());

    public AudioClip click =            new AudioClip(getClass().getResource("/Assets/Sound/MenuSelectionClick.wav").toExternalForm()); 
    public AssetLoader(){
        for(int i = 0; i < 20; i++){
            // System.out.println("/Assets/Image/enemies/shootingMove/survivor-move_knife_"+i+".png");
            shootingEnemyIMGs[i] = new Image(
                getClass().getResource("/Assets/Image/enemies/shootingMove/survivor-move_rifle_"+i+".png").toExternalForm());
            meleeEnemyIMGs[i] = new Image(
                getClass().getResource("/Assets/Image/enemies/meleeMove/survivor-move_knife_"+i+".png").toExternalForm());
        }
    }
    
}

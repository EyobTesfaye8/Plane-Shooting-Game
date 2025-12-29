package com.planeshootinggame.UI.overlays;

import java.util.Random;

import com.planeshootinggame.App;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HistoricalFacts extends StackPane{
    Text note = new Text();
    Random r = new Random();
    Button xBtn = new Button("X");
    VBox contentBox = new VBox(20);

    String weponsUsedFact[] = {
        "Ethiopian forces at the Battle of Adwa used a large number of\nmodern rifles, including Gras, Lebel, and Martini-Henry rifles.\nMany of these weapons were obtained through trade and diplomacy.",
        "Artillery played an important role in the battle, with Ethiopia\nusing cannons captured from earlier conflicts or purchased abroad.\nThese guns helped counter Italian advances effectively.",
        "Traditional weapons such as spears, swords, and shields were\nstill carried by many Ethiopian warriors.\nThey were used mainly in close combat situations.",
        "Italian forces relied heavily on modern European firearms and\nmachine guns, including the Carcano rifle.\nHowever, their technological advantage was not decisive.",
        "The successful use of both modern firearms and traditional\nweapons demonstrated Ethiopia’s adaptability.\nThis balance contributed significantly to their victory at Adwa.",
        "Large quantities of ammunition were stockpiled by Ethiopian\nforces before the battle.\nThis preparation allowed sustained fighting during the conflict.",
        "Many Ethiopian soldiers were trained in the use of firearms\nprior to the battle.\nThis training reduced the effectiveness gap with Italian troops.",
        "Machine guns were present on the Italian side, but difficult\nterrain limited their effectiveness.\nThis reduced their impact on the outcome of the battle.",
        "Captured Italian weapons were sometimes reused by Ethiopian\nfighters during the battle.\nThis helped increase available firepower as fighting continued.",
        "Weapon supply routes and logistics played a critical role in\nmaintaining Ethiopian combat strength.\nEffective planning ensured weapons were available when needed."
    };
    String logisticsFact[] = {
        "Ethiopian forces organized large-scale supply systems to feed\nand equip tens of thousands of soldiers.\nLocal communities especially women played a key role in providing food.",
        "Food supplies such as grain and livestock were gathered in\nadvance of the battle.\nThis preparation ensured the army could remain in the field.",
        "The Ethiopian army used knowledge of local terrain to move\nsupplies efficiently.\nMountain paths helped avoid Italian patrols.",
        "Water sources were carefully planned and secured before the\nengagement.\nControl of wells and rivers supported troop endurance.",
        "Italy faced serious logistical challenges due to long supply\nlines from the coast.\nThese difficulties weakened Italian forces at Adwa.",
        "Pack animals such as mules and horses were widely used to\ntransport food, weapons, and ammunition.\nThis allowed supplies to reach remote positions.",
        "Communication between Ethiopian leaders helped coordinate\nsupply movement across different units.\nThis reduced shortages during the battle.",
        "Italian troops struggled with limited food and ammunition\nsupplies during the campaign.\nDelays and mismanagement affected their readiness.",
        "The ability of Ethiopian forces to sustain a large army over\nan extended period was decisive.\nStrong logistics directly contributed to victory at Adwa."
    };
    String shieldFact[] = {
        "Ethiopian warriors commonly used round shields made from\ntreated animal hide during the Battle of Adwa.\nThese shields were durable and flexible in combat.",
        "The shields were designed to protect against swords, spears,\nand even some firearm attacks.\nThey were especially effective in close combat situations.",
        "Beyond protection, shields often carried cultural symbols\nand patterns representing identity.\nThey also served to boost morale among fighters."
    };
    String horsesFact[] = {
        "Horses played an important role in the Ethiopian army at the\nBattle of Adwa, especially among cavalry units.\nThey were used for rapid movement and battlefield coordination.",
        "Ethiopian cavalry riders often carried rifles, swords, and\ntraditional weapons while mounted.\nThis made them highly flexible in combat situations.",
        "The strong and resilient local horse breeds were well adapted\nto Ethiopia’s rugged terrain.\nThey could endure long marches with limited supplies.",
        "Mounted warriors were also used to deliver messages between\ncommanders during the battle.\nThis improved communication across the large army.",
        "Horses symbolized status and leadership within the Ethiopian\nforces.\nMany high-ranking nobles and commanders fought on horseback."
    };
    String generalFacts[] = {
        "The Battle of Adwa took place on March 1, 1896, between\nEthiopian forces and the Kingdom of Italy.\nIt was part of the First Italo-Ethiopian War.",
        "The war began due to disputes over the Treaty of Wuchale.\nItaly claimed the treaty gave it a protectorate over Ethiopia,\nbut Emperor Menelik II rejected this interpretation.",
        "Emperor Menelik II led the Ethiopian forces.\nHe was supported by Empress Taytu Betul and a coalition of\nregional leaders and warriors from across Ethiopia.",
        "Ras Alula Engida, Ras Mikael, and Ras Mengesha were among\nthe famous Ethiopian commanders who played key roles\nin the victory at Adwa.",
        "Italy sent a well-equipped army but underestimated the\nstrength and determination of Ethiopian forces.\nThey relied heavily on modern firearms and artillery.",
        "Ethiopian forces included tens of thousands of soldiers,\nmany armed with rifles, cannons, and traditional weapons.\nThey also used knowledge of the terrain to their advantage.",
        "The battle began with Italian troops advancing uphill into\nwell-prepared Ethiopian positions.\nPoor planning and underestimation contributed to Italian losses.",
        "Ethiopians surrounded and overwhelmed the Italian forces,\ncutting off retreat routes.\nItalian soldiers suffered heavy casualties.",
        "The Ethiopian victory at Adwa was decisive.\nIt preserved Ethiopian independence and ended Italy’s attempt\nto colonize the country at that time.",
        "Menelik II’s leadership, coordination among regional leaders,\nand strong logistics ensured success.\nHis ability to unite Ethiopia was key to the outcome.",
        "The victory at Adwa had global significance.\nIt inspired other African nations and anti-colonial movements,\nand marked Ethiopia as a symbol of resistance.",
        "After the battle, Italy signed the Treaty of Addis Ababa in 1896,\nformally recognizing Ethiopia’s independence.\nMenelik II became an international hero.",
        "Casualties were heavy on both sides.\nEthiopians suffered thousands of losses,\nbut Italian losses were even more severe, with thousands killed or captured.",
        "Adwa demonstrated that African forces could defeat a European\narmy through strategy, unity, and knowledge of terrain.\nIt challenged European colonial narratives of the time.",
        "The battle is commemorated every year in Ethiopia on March 2nd,\ncelebrating the bravery of the soldiers and the leadership\nof Menelik II and Empress Taytu Betul.",
        "Emperor Menelik II reportedly traveled on horseback across\nlong distances to personally inspect his army’s positions.\nHe was known for his hands-on leadership style.",
        "Empress Taytu Betul, Menelik’s wife, played a crucial role\nin planning and organizing supplies for the army.\nShe even accompanied troops to the front lines.",
        "Some Ethiopian warriors wore brightly colored traditional clothing\nand carried decorated shields.\nThis boosted morale and intimidated opponents.",
        "Local communities helped gather food, water, and supplies\nfor the army, demonstrating nationwide support for independence.\nCivilians played an essential role behind the scenes.",
        "Legend says that during the battle, the sound of war drums\nand horns was used to coordinate attacks and boost morale.\nThis traditional communication system was very effective.",
        "Despite Italy’s modern weapons, Ethiopia’s strategic use\nof terrain, like hills and narrow passes, gave them an advantage.\nIt’s a famous example of smart tactics overcoming technology."
    };

    public HistoricalFacts() {
        setPrefSize(App.sWidth, App.sHeight);
        getStylesheets().add(getClass().getResource("/com/planeshootinggame/UI/screens/style.css").toExternalForm());
        getStyleClass().add("overlay");
        setVisible(false);

        contentBox.setAlignment(Pos.CENTER);

        Label title = new Label("HISTORICAL FACT");
        title.getStyleClass().add("title");

        note.getStyleClass().add("label-text");

        xBtn.getStyleClass().add("menu-button");
        xBtn.setPrefSize(50, 50);
        xBtn.setOnAction(e -> hide());

        contentBox.getChildren().addAll(title, note, xBtn);
        getChildren().add(contentBox);
    }

    public void showFact(FactType type) {
        String fact = switch (type) {
            case GENERAL_FACT       -> generalFacts[r.nextInt(generalFacts.length)];
            case WEAPONS_USED_FACT  -> weponsUsedFact[r.nextInt(weponsUsedFact.length)];
            case LOGISTICS_FACT     -> logisticsFact[r.nextInt(logisticsFact.length)];
            case HORSES_FACT        -> horsesFact[r.nextInt(horsesFact.length)];
            case SHIELD_FACT        -> shieldFact[r.nextInt(shieldFact.length)];
        };

        note.setText(fact);

        HUD.pause();
        setVisible(true);
        toFront();
    }

    public void hide(){
        HUD.resume();
        setVisible(false);
    }
}

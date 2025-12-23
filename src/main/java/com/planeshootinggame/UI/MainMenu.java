// package com.planeshootinggame.UI;

// import com.planeshootinggame.App;

// import javafx.geometry.Pos;
// import javafx.scene.control.Button;
// import javafx.scene.layout.VBox;
// import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
// import javafx.scene.layout.Pane;
// public class MainMenu extends App{

//     public static Pane createMainMenu() {

//         // Buttons
//         Button newGameBtn = new Button("New Game");
//         newGameBtn.setPrefSize(400, 100);
//         newGameBtn.setFont(Font.font("arial", FontWeight.BOLD, 50));
//         newGameBtn.setStyle("-fx-background-color: #3498db;");
//         Button highScoreBtn = new Button("High Score");
//         highScoreBtn.setPrefSize(400, 100);
//         highScoreBtn.setFont(Font.font("arial", FontWeight.BOLD, 50));
//         highScoreBtn.setStyle("-fx-background-color: #317dafff;");
//         Button settingsBtn = new Button("Settings");
//         settingsBtn.setPrefSize(400, 100);
//         settingsBtn.setFont(Font.font("arial", FontWeight.BOLD, 50));
//         settingsBtn.setStyle("-fx-background-color: #27516dff;");
//         Button exitBtn = new Button("Exit");
//         exitBtn.setPrefSize(400, 100);
//         exitBtn.setFont(Font.font("arial", FontWeight.BOLD, 50));
//         exitBtn.setStyle("-fx-background-color: #5f90b0ff;");

//         // Button actions (lambda expressions)
//         newGameBtn.setOnAction(e -> {
//             System.out.println("New Game clicked");
//             scene.setRoot(g.getRoot());
//             g.changeGameOverStatus();
//             g.startGame();
//         });

//         highScoreBtn.setOnAction(e -> {
//             System.out.println("High Score clicked");
//         });

//         settingsBtn.setOnAction(e -> {
//             System.out.println("Settings clicked");
//         });

//         exitBtn.setOnAction(e -> {
//             System.exit(0);
//         });

//         // Layout
//         VBox root = new VBox(15); // spacing between buttons
//         root.setAlignment(Pos.CENTER);
//         root.getChildren().addAll(
//                 newGameBtn,
//                 highScoreBtn,
//                 settingsBtn,
//                 exitBtn
//         );

//         return root;
//     }
// }

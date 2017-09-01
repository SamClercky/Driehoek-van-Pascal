package com.samclercky.dvp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 *
 * @author Clercky
 */
public class MainWindow extends Application{

    @Override
    public void start(Stage primaryStage) {
        // create root
        BorderPane root = new BorderPane();
        
        // fill root
        // create titleContainer
        HBox titleContainer = new HBox();
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.setPadding(new Insets(10));
        // create titleLbl
        Label titleLbl = new Label("De driehoek van Pascal");
        titleLbl.setFont(Font.font("Arial Black", FontWeight.BLACK, 26));
        // add lbl to container
        titleContainer.getChildren().add(titleLbl);
        // add title to top
        root.setTop(titleContainer);
        
        // create triangle and add it to root
        
        // set window and show
        primaryStage.setTitle("De driehoek van Pascal");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}

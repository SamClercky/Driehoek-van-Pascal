package com.samclercky.dvp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author Clercky
 */
public class GenerateSection extends HBox{
    private DVP dvp;
    private Label logLbl;
    
    public GenerateSection(DVP dvp) {
        this.dvp = dvp;
        createGUI();
    }
    
    public void log(String msg) {
        logLbl.setText(msg);
    }
    
    private void createGUI() {
        // set HBox presets
        setAlignment(Pos.CENTER_RIGHT);
        setSpacing(3);
        setPadding(new Insets(10));
        
        // create log
        logLbl = new Label();
        logLbl.setAlignment(Pos.CENTER_LEFT);
        logLbl.maxWidth(Double.MAX_VALUE);
        setHgrow(logLbl, Priority.ALWAYS);
        getChildren().add(logLbl);
        
        // create textField max DVP
        TextField maxTxt = new TextField();
        maxTxt.setPromptText("Count of rows");
        getChildren().add(maxTxt);
        
        // create btn
        Button maxBtn = new Button("Genereer");
        maxBtn.setOnAction((ActionEvent event) -> {
            String msg = maxTxt.getText();
            int max = 0;
            try {
                max = Integer.parseInt(msg);
            } catch(NumberFormatException ex) {
                log("Geen nummer meegegeven");
                return;
            }
            if (max < 0) {
                log("Nummer is te laag");
                return;
            }
            dvp.setMax(max);
            
            maxTxt.setDisable(true);
            log("Aan het genereren...");
            dvp.render();
            maxTxt.setDisable(false);
            log("Gegenereerd :-)");
        });
        getChildren().add(maxBtn);
    }
}

package com.samclercky.dvp;

import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Clercky
 */
public class DVP extends VBox{
    // private
    private final int celWidth = 30; // width of each cel
    private final int celHeight = 30; // height of each cel
    private int max = 40; // the amount of rows and columns
    
    // constructors
    /**
     * Helper class to easily create a triangle of Pascal
     */
    public DVP() {
    }
    
    // public members
    /**
     * Creates the triangle and puts it into the root
     */
    public void render() {       
        for (int i = 0; i <= max; i++) {
            getChildren().add(createRow(i));
        }
        
        setPrefSize(calcMaxWidth(), getHeight());
    }
    
    // private members
    private HBox createRow(int row) {
        HBox result = new HBox();
        result.setAlignment(Pos.CENTER);
        
        result.prefWidthProperty().bind(widthProperty());
        
        for (int i = 0; i <= row; i++) {
            result.getChildren().add(createCel(row, i));
        }
        
        return result;
    }
    private Label createCel(int row, int column) {
        // TODO add black stroke
        Label result = new Label();
        result.setText(Long.toString(createData(row, column)));
        result.setPrefSize(celWidth, celHeight);
        StringBuilder styles = new StringBuilder();
        styles.append("-fx-border-color: black;");
        styles.append("-fx-border-width: 1px;");
        
        result.setStyle(styles.toString());
        result.setAlignment(Pos.CENTER);
        
        return result;
    }
    private long createData(int row, int column) {
        
        
        return calcFaculteit(row) / (calcFaculteit(column) * calcFaculteit(row - column));
    }
    private long calcFaculteit(long num) {
        if (num <= 1) {
            return 1;
        } else {
            return calcFaculteit(num - 1) * num;
        }
    }
    private double calcMaxWidth() {
        return celWidth * (max+1);
    }
}

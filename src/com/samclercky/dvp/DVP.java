package com.samclercky.dvp;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author Clercky
 */
public class DVP {
    // private
    private Pane root; // root of triangle
    private final int celWidth = 30; // width of each cel
    private final int celHeight = 30; // height of each cel
    private int max = 5; // the amount of rows and columns
    
    // constructors
    /**
     * Helper class to easily create a triangle of Pascal
     * @param root sets the container for the triangle (can also be set via setRoot()
     */
    public DVP(Pane root) {
        setRoot(root);
    }
    /**
     * Helper class to easily create a triangle of Pascal
     */
    public DVP() {
        setRoot(new Pane());
    }
    
    // public members
    /**
     * Creates the triangle and puts it into the root
     */
    public void addDataToRoot() {
        // TODO create triangle and add it to root
    }
    
    // private members
    private HBox createRow(int row) {
        HBox result = new HBox();
        result.setAlignment(Pos.CENTER);
        
        for (int i = 0; i <= row; i++) {
            result.getChildren().add(createCel(row, i));
        }
        
        return result;
    }
    private Label createCel(int row, int column) {
        // TODO add black stroke
        Label result = new Label();
        result.setText(Integer.toString(createData(row, column)));
        result.setPrefSize(celWidth, celHeight);
        return result;
    }
    private int createData(int row, int column) {
        // TODO create data
        return 0;
    }
    
    // accessors
    public void setRoot(Pane root) {
        this.root = root;
    }
}

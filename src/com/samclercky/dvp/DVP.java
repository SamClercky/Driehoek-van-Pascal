package com.samclercky.dvp;

import java.math.BigInteger;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Clercky
 */
public class DVP extends VBox{
    // private
    private int celWidth = 50; // width of each cel
    private final int celHeight = 30; // height of each cel
    private int max = 40; // the amount of rows and columns
    private final int fontSize = 50/7;
    
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
        // search the largest cel, multiply by fontsize and use it as celwidth
        celWidth = createData(max, (int)max/2).toString().length() * fontSize;
        System.out.println("celWidth: " + celWidth);
        
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
        result.setText(createData(row, column).toString());
        result.setPrefSize(celWidth, celHeight);
        StringBuilder styles = new StringBuilder();
        styles.append("-fx-border-color: black;");
        styles.append("-fx-border-width: 1px;");
        
        result.setStyle(styles.toString());
        result.setAlignment(Pos.CENTER);
        
        return result;
    }
    private BigInteger createData(int row, int column) {
        return calcFaculteit(new BigInteger(Integer.toString(row)))
                .divide(
                        calcFaculteit(new BigInteger(Integer.toString(column)))
                            .multiply(
                                    calcFaculteit(new BigInteger(Integer.toString(row - column)))
                            )
                );
    }
    private BigInteger calcFaculteit(BigInteger num) {
        if (num.toString().equals("1") || num.toString().equals("0")) {
            return new BigInteger("1");
        } else {
            return calcFaculteit(num.add(new BigInteger("-1"))).multiply(num);
        }
    }
    private double calcMaxWidth() {
        return celWidth * (max+1);
    }
}

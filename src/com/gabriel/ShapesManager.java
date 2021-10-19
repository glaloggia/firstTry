package com.gabriel;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShapesManager {
    private ArrayList<Shape> shapes;

    public boolean isDisplayNames() {
        return displayNames;
    }

    public void setDisplayNames(boolean displayNames) {
        this.displayNames = displayNames;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    private boolean displayNames;

    public ShapesManager(){
        shapes = new ArrayList<>();
        displayNames = false;
    }

    public void drawShapes(Graphics g){

        for(Shape shape:this.shapes){
            shape.drawShape(g);
        }

    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }
}

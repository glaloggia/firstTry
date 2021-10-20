package com.gabriel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
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


    public void toggleFilling(MouseEvent e) {
        for (Shape shape:getIntersectingShapes(e)) {
            shape.toggleFilling();
        }
    }

    private ArrayList<Shape> getIntersectingShapes(MouseEvent e){
        ArrayList<Shape> listOfIntersections = new ArrayList<>();
        for (Shape shape:this.shapes) {
            if(inBounds(shape.getBoundingBox(),new Point(e.getX(),e.getY())))
                listOfIntersections.add(shape);
        }
        return listOfIntersections;
    }

    private boolean inBounds(BoundingBox boundingBox, Point point) {

        return (boundingBox.getTopRight().getX() > point.getX()) && (point.getX() > boundingBox.getBottomLeft().getX()) &&

                (boundingBox.getBottomLeft().getY() < point.getY()) && (point.getY() < boundingBox.getTopRight().getY());
    }

}

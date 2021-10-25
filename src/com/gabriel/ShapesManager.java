package com.gabriel;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * ShapesManager is the class that controls the correct displaying of the figures.
 * It contains an array of figures and two booleans that decides if the names and the bounding boxes
 * will be displayed.
 * It's not possible to change these settings during run-time, only at compiling time.
 * @author Gabriel La Loggia - L00169720
 */
public class ShapesManager {

    private ArrayList<Shape> shapes;
    private boolean displayBoundingBoxes;
    private boolean displayNames;

    public ShapesManager(){
        shapes = new ArrayList<>();
        displayNames = false;
        displayBoundingBoxes = false;
    }

    public boolean isDisplayBoundingBoxes() {
        return displayBoundingBoxes;
    }

    public boolean isDisplayNames() {
        return displayNames;
    }

    public void setDisplayNames(boolean displayNames) {
        this.displayNames = displayNames;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }



    public void drawShapes(Graphics g){

        for(Shape shape:this.shapes){
            shape.drawShape(g);
            if(isDisplayNames()) shape.displayName(g);
            if(isDisplayBoundingBoxes()) shape.displayBoundingBox(g);
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

    public void moveOrRotate(MouseEvent e) {
        for (Shape shape:getIntersectingShapes(e)) {
            shape.moveOrRotate();
        }
    }

    public void setDisplayBoundingBoxes(boolean displayBoundingBoxes) {
        this.displayBoundingBoxes = displayBoundingBoxes;
    }
}

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

    /**
     * Constructor, as a default, doesn't show bounding boxes or shape names,
     * but there are getters and setters to change both properties.
     */
    public ShapesManager(){
        shapes = new ArrayList<>();
        displayNames = false;
        displayBoundingBoxes = false;
    }

    /**
     * drawShapes goes through the array of shapes and call the drawing method in all of them
     * also, if the attributes of the object are true, it will display the name of the shape
     * and the bounding box.
     * @param g graphical context
     */
    public void drawShapes(Graphics g){

        for(Shape shape:this.shapes){
            shape.drawShape(g);
            if(isDisplayNames()) shape.displayName(g);
            if(isDisplayBoundingBoxes()) shape.displayBoundingBox(g);
        }

    }

    /**
     * toggleFilling reacts when a mouse click is intersecting one or more shapes.
     * If that happens, it switches from outline to filled or vice-versa.
     * @param e mouse event
     */
    public void toggleFilling(MouseEvent e) {
        for (Shape shape:getIntersectingShapes(e)) {
            shape.toggleFilling();
        }
    }

    /**
     * getIntersectingShapes use the coords embedded in the click mouse event, and detects any possible intersection
     * with the bounding box of each shape.
     * @param e mouse event
     * @return It returns a sub-set of shapes that have intersection with the mouse click.
     */
    private ArrayList<Shape> getIntersectingShapes(MouseEvent e){
        ArrayList<Shape> listOfIntersections = new ArrayList<>();
        for (Shape shape:this.shapes) {
            if(inBounds(shape.getBoundingBox(),new Point(e.getX(),e.getY())))
                listOfIntersections.add(shape);
        }
        return listOfIntersections;
    }

    /**
     * inBounds is a helper function that compare coords to detect intersections.
     * @param boundingBox a shape bounding box
     * @see BoundingBox
     * @param point a point to compare
     * @see Point
     * @return it will return a logical True if there is an intersection detected.
     */
    private boolean inBounds(BoundingBox boundingBox, Point point) {

        return (boundingBox.getTopRight().getX() > point.getX()) && (point.getX() > boundingBox.getBottomLeft().getX()) &&

                (boundingBox.getBottomLeft().getY() < point.getY()) && (point.getY() < boundingBox.getTopRight().getY());
    }

    /**
     * moveOrRotate will call a method from each shape and it will move or rotate the shape accordingly
     * @param e mouse event
     */
    public void moveOrRotate(MouseEvent e) {
        for (Shape shape:getIntersectingShapes(e)) {
            shape.moveOrRotate();
        }
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

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void setDisplayBoundingBoxes(boolean displayBoundingBoxes) {
        this.displayBoundingBoxes = displayBoundingBoxes;
    }
}

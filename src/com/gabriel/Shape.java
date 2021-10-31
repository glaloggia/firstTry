package com.gabriel;

import java.awt.*;

/**
 * Shape is an abstract class that contains the basic and common traits of every type of shape:
 * Color, Center Point, isFilled, and a bounding box.
 * @author Gabriel La Loggia - L00169720
 */
public abstract class Shape {
    protected Color color;
    /**
     * isFilled is a boolean that decides if the shape will be filled or just the outline
     */
    protected boolean isFilled;
    /**
     * xCenter and yCenter are pair of coords pointing the center of the shape.
     */
    protected int xCenter, yCenter;
    /**
     * boundingBox it's used for intersections
     * @see BoundingBox
     */
    protected BoundingBox boundingBox;

    /**
     * Constructor
     * @param xCenter x coord for the center of the shape
     * @param yCenter y coord for the center of the shape
     * @param color color of the outline or the filling
     * @param isFilled boolean that decides if the shape will be filled or not
     * @param boundingBox every shape must have a bounding box
     */
    public Shape(int xCenter, int yCenter,Color color, boolean isFilled,BoundingBox boundingBox ) {
        this.color = color;
        this.isFilled = isFilled;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.boundingBox = boundingBox;
    }

    /**
     * drawShape have to be implemented in every shape
     * @param g is the graphical context
     */
    public abstract void drawShape(Graphics g);

    /**
     * toggleFilling is a public method that switch on/off the filling in the shape
     */
    public void toggleFilling(){
        this.isFilled = !this.isFilled;
    }

    /**
     * moveOrRotate is an abstract method that need to be defined in every shape
     */
    public abstract void moveOrRotate();

    /**
     * displayName is invoked by the shapes manager
     * @param g is the graphical context
     * @see ShapesManager
     */
    public void displayName(Graphics g) {
        g.setColor(Color.black);
        g.drawString(this.toString(),this.getBoundingBox().getBottomLeft().getX(),this.boundingBox.getBottomLeft().getY());
    }

    /**
     * displayBoundingBox is invoked by the shapes manager
     * @param g is the graphical context
     * @see ShapesManager
     */
    public void displayBoundingBox(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(boundingBox.getBottomLeft().getX(),boundingBox.getBottomLeft().getY(),boundingBox.getTopRight().getX()-boundingBox.getBottomLeft().getX(),boundingBox.getTopRight().getY()-boundingBox.getBottomLeft().getY());
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public int getxCenter() {
        return xCenter;
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public int getyCenter() {
        return yCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

}

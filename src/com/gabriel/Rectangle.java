package com.gabriel;

import java.awt.*;

/**
 * Rectangle class is in charge of drawing a rectangle and creating a bounding box for interaction with the GUI.
 * It implements the interface Moveable, and it's a sub-class of Shape.
 * @author Gabriel La Loggia - L00169720
 */
public class Rectangle extends Shape implements Moveable{
    protected int width;
    protected int height;

    /**
     * Constructor, it takes x and y as the center of the rectangle and from there, it creates the bounding box.
     * @param x x coord for the center
     * @param y y coord for the center
     * @param width width of the rectangle
     * @param height height of the rectangle
     * @param color color of the rectangle
     * @param isFilled filling boolean flag
     */
    public Rectangle(int x, int y, int width, int height, Color color,boolean isFilled) {
        super(x,y,color,isFilled,new BoundingBox(new Point(x-width/2,y-height/2),new Point(x+width/2,y+height/2)));
        this.width = width;
        this.height = height;
    }

    /**
     * drawShape is an overwritten function that comes from the super class Shape.
     * It's in charge of drawing the rectangle, with or without filling.
     * @param g is the graphical context
     */
    @Override
    public void drawShape(Graphics g) {

        g.setColor(super.color);
        if (super.isFilled){
            g.fillRect(xCenter-width/2,yCenter-height/2, this.width,this.height);
        }else{
            g.drawRect(xCenter-width/2,yCenter-height/2, this.width,this.height);
        }
    }

    /**
     * moveOrRotate implements the method from the super class Shape, it rotates or move the shape.
     * This function will be called by the shapes manager, on every shape.
     * @see ShapesManager
     * @see Shape
     */
    @Override
    public void moveOrRotate() {
        moveTenUnits();
    }


    /**
     * moveTenUnits implements the interface Moveable, and it moves the shape 10 units to the right.
     * First it moves the x coord of the center point, , and then, it recalculate the bounding box.
     * @see BoundingBox
     * @see Point
     */
    @Override
    public void moveTenUnits() {
        xCenter = xCenter + 10;
        setBoundingBox(new BoundingBox(new Point(xCenter-width/2,yCenter-height/2),new Point(xCenter+width/2,yCenter+height/2)));
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}

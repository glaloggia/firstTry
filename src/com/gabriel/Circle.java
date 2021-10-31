package com.gabriel;

import java.awt.*;

/**
 * Circle class is in charge of drawing a circle, and creating a bounding box around it for interaction with the GUI
 * @author Gabriel La Loggia - L00169720
 */
public class Circle extends Shape {
    private int radius;

    /**Constructor, creates the circle calling the super class constructor, and setting up the radius attribute.
     *
     * @param x x coord for the center
     * @param y y coord for the center
     * @param radius radius of the circle
     * @param color color of the circle
     * @param isFilled filling boolean flag
     */
    public Circle(int x, int y, int radius, Color color, boolean isFilled) {
        super(x, y, color, isFilled, calculateBB(x, y, radius));
        this.radius = radius;
    }

    /**
     * calculateBB is a helper private function that takes the x and y coords from the center and the radius and
     * creates a square around the circle
     * @param x x coord for the center
     * @param y y coord for the center
     * @param radius radius of the circle
     * @return it returns a boundingbox object.
     * @see BoundingBox
     */
    private static BoundingBox calculateBB(int x, int y, int radius) {
        Point bottomLeft = new Point(x - radius, y - radius);
        Point topRight = new Point(x + radius, y + radius);
        BoundingBox boundingBox = new BoundingBox(bottomLeft, topRight);
        return boundingBox;
    }

    /**
     * drawShape is an overwritten function that comes from the super class Shape.
     * It's in charge of drawing the circle, with or without filling.
     * @param g is the graphical context
     */
    @Override
    public void drawShape(Graphics g) {
        g.setColor(color);
        if (super.isFilled) {
            g.fillOval(xCenter - radius,
                    yCenter - radius,
                    radius * 2,
                    radius * 2);
        } else {
            g.drawOval(xCenter - radius,
                    yCenter - radius,
                    radius * 2,
                    radius * 2);
        }
    }


    /**
     * displayBoundingBox is a function that display the bounding box around the circle
     * @param g is the graphical context
     * @see BoundingBox
     */
    @Override
    public void displayBoundingBox(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(boundingBox.getBottomLeft().getX(),boundingBox.getBottomLeft().getY(),radius*2,radius*2);
    }

    /**
     * According to design, circle doesn't move or rotate.
     */
    @Override
    public void moveOrRotate() {

    }

    public String toString() {
        return "Circle";
    }
}

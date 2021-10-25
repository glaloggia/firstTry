package com.gabriel;

import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius, Color color, boolean isFilled) {
        super(x, y, color, isFilled, calculateBB(x, y, radius));
        this.radius = radius;
    }

    private static BoundingBox calculateBB(int x, int y, int radius) {
        Point bottomLeft = new Point(x - radius, y - radius);
        Point topRight = new Point(x + radius, y + radius);
        BoundingBox boundingBox = new BoundingBox(bottomLeft, topRight);
        return boundingBox;
    }

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

    @Override
    public void moveOrRotate() {

    }

    public String toString() {
        return "Circle";
    }

    @Override
    public void displayBoundingBox(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(boundingBox.getBottomLeft().getX(),boundingBox.getBottomLeft().getY(),radius*2,radius*2);
    }
}
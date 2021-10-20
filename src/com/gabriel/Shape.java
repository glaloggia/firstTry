package com.gabriel;

import java.awt.*;

public abstract class Shape {
    protected Color color;
    protected boolean isFilled;
    protected int xCenter, yCenter;
    protected BoundingBox boundingBox;

    public Shape(int xCenter, int yCenter,Color color, boolean isFilled,BoundingBox boundingBox ) {
        this.color = color;
        this.isFilled = isFilled;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.boundingBox = boundingBox;
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

    public abstract void drawShape(Graphics g);

    public void toggleFilling(){
        this.isFilled = !this.isFilled;
    }
} 

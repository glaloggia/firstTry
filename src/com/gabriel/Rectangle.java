package com.gabriel;

import java.awt.*;

public class Rectangle extends Shape implements Moveable{
    protected int width;
    protected int height;

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

    public Rectangle(int x, int y, int width, int height, Color color,boolean isFilled) {
        super(x,y,color,isFilled,new BoundingBox(new Point(x-width/2,y-height/2),new Point(x+width/2,y+height/2)));
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawShape(Graphics g) {

        g.setColor(super.color);
        if (super.isFilled){
            g.fillRect(xCenter-width/2,yCenter-height/2, this.width,this.height);
        }else{
            g.drawRect(xCenter-width/2,yCenter-height/2, this.width,this.height);
        }
        g.setColor(Color.black);
        g.drawRect(boundingBox.getBottomLeft().getX(),boundingBox.getBottomLeft().getY(),boundingBox.getTopRight().getX()-boundingBox.getBottomLeft().getX(),boundingBox.getTopRight().getY()-boundingBox.getBottomLeft().getY());
    }

    @Override
    public void moveOrRotate() {
        moveTenUnits();
    }

    @Override
    public String toString() {
        return "Rectangle";
    }

    @Override
    public void moveTenUnits() {
        xCenter = xCenter + 10;
        setBoundingBox(new BoundingBox(new Point(xCenter-width/2,yCenter-height/2),new Point(xCenter+width/2,yCenter+height/2)));
    }
}

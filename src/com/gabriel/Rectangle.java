package com.gabriel;

import java.awt.*;

public class Rectangle extends Shape{
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
        super(x,y,color,isFilled,new BoundingBox(new Point(x,y),new Point(x+width,y+height)));
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawShape(Graphics g) {

        g.setColor(super.color);
        if (super.isFilled){
            g.fillRect(xCenter-width/2,yCenter-height/2, this.width,this.height);
        }else{
            g.drawRect(xCenter,yCenter, this.width,this.height);
        }
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}

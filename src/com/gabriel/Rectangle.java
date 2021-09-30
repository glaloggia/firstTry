package com.gabriel;

import java.awt.*;

public class Rectangle extends Shape{
    protected int width;
    protected int height;

    public Rectangle(int x, int y, int width, int height,Color color) {
        this.width = width;
        this.height = height;
        super.color = color;
        super.xCenter = x;
        super.yCenter = y;
        super.filled  = true;
    }

    @Override
    public void drawShape(Graphics g) {

        g.setColor(super.color);
        if (super.filled){
            g.fillRect(xCenter,yCenter, this.width,this.height);
        }else{
            g.drawRect(xCenter,yCenter, this.width,this.height);
        }
    }
}

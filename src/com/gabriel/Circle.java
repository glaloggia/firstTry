package com.gabriel;

import java.awt.*;

public class Circle extends Shape{
    private int radius;

    public Circle(int x,int y,int radius,Color color) {
        this.radius = radius;
        super.xCenter = x;
        super.yCenter = y;
        super.color = color;
        super.filled = true;
    }

    @Override
    public void drawShape(Graphics g) {
        g.setColor(color);
        if (super.filled) {
            g.fillOval(xCenter - radius,
                    yCenter - radius,
                    radius * 2,
                    radius * 2);
        }else{
            g.drawOval(xCenter - radius,
                    yCenter - radius,
                    radius * 2,
                    radius * 2);
        }
    }
}

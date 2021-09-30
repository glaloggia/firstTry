package com.gabriel;

import java.awt.*;

public abstract class Shape {
    protected Color color;
    protected boolean filled;
    protected int xCenter, yCenter;

    public abstract void drawShape(Graphics g);

    public void toggleFilling(){
        this.filled = !this.filled;
    }
}

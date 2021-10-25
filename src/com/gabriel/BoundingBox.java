package com.gabriel;

import java.awt.*;

/**
 * BoundingBox is a class that creates a rectangular border in every shape, and it is used to detect
 * collisions and intersections. It can be drawn or hidden from the view.
 *@author Gabriel La Loggia - L00169720
 */
public class BoundingBox{

    private Point bottomLeft;
    private Point topRight;

    public BoundingBox(Point bottomLeft,Point topRight){
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public BoundingBox(Point[] points){

    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    @Override
    public String toString() {
        return "BoundingBox";
    }
}

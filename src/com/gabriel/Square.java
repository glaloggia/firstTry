package com.gabriel;

import java.awt.*;

/**
 * Square is subclass of Rectangle, and the bounding box is the same as the shape of the square.
 * @author Gabriel La Loggia - L00169720
 */
public class Square extends Rectangle{

    /**
     * Square by definition is a rectangle with the equals width and height so the constructor, in this case,
     * calls the super class constructor.
     * @param x x coord for the center
     * @param y y coord for the center
     * @param width sides of the square
     * @param color color of the square
     * @param isFilled filling boolean flag
     * @see Rectangle
     */
    public Square(int x, int y, int width, Color color,boolean isFilled){

        super(x,y,width,width,color,isFilled);

    }

    @Override
    public String toString() {
        return "Square";
    }
}

package com.gabriel;

import java.awt.*;

public class Square extends Rectangle{

    public Square(int x, int y, int width, Color color,boolean isFilled){

        super(x,y,width,width,color,isFilled);

    }

    @Override
    public String toString() {
        return "Square";
    }
}

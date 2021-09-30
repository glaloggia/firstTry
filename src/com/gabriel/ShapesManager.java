package com.gabriel;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShapesManager {
    private ArrayList<Shape> shapes;

// This is an example of how to create a basic window.
//    public static void main(String[] args) {
//        JFrame ventana = new JFrame();
//        JPanel panel = new JPanel();
//        ventana.add(panel);
//        ventana.setTitle("hola");
//        ventana.setVisible(true);
//        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);
//    }

    public ShapesManager(){
        shapes = new ArrayList<>();
    }

    public void drawShapes(Graphics g){

        for(Shape shape:this.shapes){
            shape.drawShape(g);
        }

    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }
}

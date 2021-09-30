package com.gabriel;

import javax.swing.*;
import java.awt.*;

public class WindowCreator {
    public static void main(String[] args) {

        ShapesManager shapesManager = new ShapesManager();
        Rectangle rectangle = new Rectangle(100,100,100,50, Color.MAGENTA);
        shapesManager.addShape(rectangle);
        Circle circle = new Circle(150,150,50,Color.BLUE);
        shapesManager.addShape(circle);
        Square square = new Square(200,200,25,Color.black);
        shapesManager.addShape(square);
        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Shapes Manager");
        customWindow.setVisible(true);
    }
}

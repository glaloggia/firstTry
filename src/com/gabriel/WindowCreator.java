package com.gabriel;

import javax.swing.*;
import java.awt.*;

public class WindowCreator {
    public static void main(String[] args) {

        ShapesManager shapesManager = new ShapesManager();

        Rectangle rectangle = new Rectangle(100,25,100,50, Color.MAGENTA,true);
        shapesManager.addShape(rectangle);

        Circle circle = new Circle(0,0,50,Color.BLUE,true);
        shapesManager.addShape(circle);

        Circle circle2 = new Circle(320,240,50,Color.yellow,true);
        shapesManager.addShape(circle2);

        Square square = new Square(175,25,50,Color.black,true);
        shapesManager.addShape(square);

//        Quadrilateral quadrilateral = new Quadrilateral(rectangle);
//        shapesManager.addShape(quadrilateral);

        Quadrilateral quadrilateral2 = new Quadrilateral(new Point(320,240),new Point(250,170),new Point(420,140),new Point(390,310),new Point(220,340));
        shapesManager.addShape(quadrilateral2);

        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Shapes Manager");
        customWindow.setVisible(true);
    }
}

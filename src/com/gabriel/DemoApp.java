package com.gabriel;

import javax.swing.*;
import java.awt.*;

/**
 * DemoApp is an example that uses all the classes developed for this assignment.
 * First, creates the shapes container, ShapesManager.
 * Then adds some shapes, and finally, set a window, to contain all the elements for a GUI.
 * @author Gabriel La Loggia - L00169720
 */
public class DemoApp {
    public static void main(String[] args) {

        ShapesManager shapesManager = new ShapesManager();

        shapesManager.setDisplayNames(true);
        shapesManager.setDisplayBoundingBoxes(true);

        Circle circle1 = new Circle(600,85,75,Color.red,true);
        shapesManager.addShape(circle1);

        Square square1 = new Square(380,85,150,Color.white,true);
        shapesManager.addShape(square1);

        Rectangle rectangle1 = new Rectangle(150,85,150,75, Color.blue,true);
        shapesManager.addShape(rectangle1);

        Quadrilateral quadrilateral1 = new Quadrilateral(new Point(320,250),new Point(200,180),new Point(420,250),new Point(390,320),new Point(220,350),Color.orange);
        shapesManager.addShape(quadrilateral1);

        Rectangle rectangle2 = new Rectangle(600,275,100,50, Color.pink,true);
        Quadrilateral quadrilateral2 = new Quadrilateral(rectangle2);
        shapesManager.addShape(quadrilateral2);

        Circle circle2 = new Circle(150,500,50,Color.yellow,true);
        shapesManager.addShape(circle2);

        Square square2 = new Square(380,450,150,Color.cyan,true);
        shapesManager.addShape(square2);

        Rectangle rectangle3 = new Rectangle(550,500,150,75, Color.green,true);
        shapesManager.addShape(rectangle3);

        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setLocationRelativeTo(null);
        customWindow.setTitle("Shapes Manager");
        customWindow.setVisible(true);
    }
}

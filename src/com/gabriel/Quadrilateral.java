package com.gabriel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Quadrilateral is a sub-class of Shape, and is Rotatable. By right-clicking on its bounding box, it rotates 90 degrees
 * @author Gabriel La Loggia - L00169720
 */
public class Quadrilateral extends Shape implements Rotatable{

    Point points[];

    /**
     * First Constructor uses a center point, which is only uses as a rotation center by this implementation, and an
     * array of points, 4 by our definition.
     * @param centrePoint it's a Point object with the center of the shape
     * @param points it's an array of Point objects
     * @see Point
     */
    public Quadrilateral(Point centrePoint, Point[] points){
        super(centrePoint.getX(),centrePoint.getY(),Color.black,true,calculateBB(points));
        this.points = points;
    }

    /**
     * Second constructor is the same as the previous one, but with the additional parameter of Color.
     * @param centrePoint it's a Point object with the center of the shape
     * @param points it's an array of Point objects
     * @param color it's the color of the shape
     * @see Point
     */
    public Quadrilateral(Point centrePoint, Point[] points,Color color){
        super(centrePoint.getX(),centrePoint.getY(),color,true,calculateBB(points));
        this.points = points;
    }

    /**
     * Third constructor, instead of using an array, this constructor accepts the four points as parameters.
     * @param centrePoint it's a Point object with the center of the shape
     * @param p1 a point in the quadrilateral
     * @param p2 a point in the quadrilateral
     * @param p3 a point in the quadrilateral
     * @param p4 a point in the quadrilateral
     * @see Point
     */
    public Quadrilateral(Point centrePoint, Point p1, Point p2, Point p3, Point p4){
        super(centrePoint.getX(),centrePoint.getY(),Color.black,true,calculateBB(p1,p2,p3,p4));
        this.points = new Point[4];
        this.points[0]=p1;
        this.points[1]=p2;
        this.points[2]=p3;
        this.points[3]=p4;
    }

    /**
     * Fourth constructor, the same as the third one, but with the addition of the Color parameter
     * @param centrePoint it's a Point object with the center of the shape
     * @param p1 a point in the quadrilateral
     * @param p2 a point in the quadrilateral
     * @param p3 a point in the quadrilateral
     * @param p4 a point in the quadrilateral
     * @param color it's the color of the shape
     * @see Point
     */
    public Quadrilateral(Point centrePoint, Point p1, Point p2, Point p3, Point p4,Color color){
        super(centrePoint.getX(),centrePoint.getY(),color,true,calculateBB(p1,p2,p3,p4));
        this.points = new Point[4];
        this.points[0]=p1;
        this.points[1]=p2;
        this.points[2]=p3;
        this.points[3]=p4;
    }

    /**
     * Fifth constructor, it creates a bounding box taking as the only parameter, an object Rectangle.
     * @param rectangle it's a Rectangle object
     * @see Rectangle
     */
    public Quadrilateral(Rectangle rectangle){
        super(rectangle.xCenter, rectangle.yCenter, rectangle.getColor(),rectangle.isFilled(), rectangle.getBoundingBox());

        Point p1,p2,p3,p4;

        p1 = new Point(rectangle.xCenter- rectangle.width/2, rectangle.yCenter- rectangle.height/2);
        p2 = new Point(rectangle.xCenter+ rectangle.width/2, rectangle.yCenter- rectangle.height/2);
        p3 = new Point(rectangle.xCenter+ rectangle.width/2, rectangle.yCenter+ rectangle.height/2);
        p4 = new Point(rectangle.xCenter- rectangle.width/2, rectangle.yCenter+ rectangle.height/2);

        this.points = new Point[4];
        this.points[0]=p1;
        this.points[1]=p2;
        this.points[2]=p3;
        this.points[3]=p4;
    }

    /**
     * calculateBB is a private helper function that from 4 points as input parameters returns a bouinding box object.
     * @param p1 object type Point
     * @param p2 object type Point
     * @param p3 object type Point
     * @param p4 object type Point
     * @return Returns a bounding box object.
     * @see BoundingBox
     * @see Point
     */
    private static BoundingBox calculateBB(Point p1, Point p2, Point p3, Point p4) {

        return calculateBB(new Point[]{p1, p2, p3, p4});

    }

    /**
     * Second version of calculateBB, instead of taking 4 points, it takes an array of Points as its only parameter.
     * @param points it's an array of Point objects
     * @return Returns a bounding box object.
     * @see Point
     */
    private static BoundingBox calculateBB(Point[] points) {

        BoundingBox boundingBox;
        int minX,minY,maxX,maxY;

        Point bottomLeft;
        Point topRight;

        minX = points[0].getX();
        minY = points[0].getY();
        maxX = points[0].getX();
        maxY = points[0].getY();

        for (Point point:points) {
            if (minX > point.getX()) minX = point.getX();
            if (maxX < point.getX()) maxX = point.getX();
            if (minY > point.getY()) minY = point.getY();
            if (maxY < point.getY()) maxY = point.getY();
        }

        bottomLeft = new Point(minX,minY);
        topRight = new Point(maxX,maxY);

        boundingBox = new BoundingBox(bottomLeft,topRight);

        return boundingBox;
    }


    /**
     * drawShape is an overwritten function that comes from the super class Shape.
     * It's in charge of drawing the Quadrilateral, with or without filling.
     * @param g is the graphical context
     */
    @Override
    public void drawShape(Graphics g) {
        int[] puntosX = {this.points[0].getX(),this.points[1].getX(),this.points[2].getX(),this.points[3].getX()};
        int[] puntosY = {this.points[0].getY(),this.points[1].getY(),this.points[2].getY(),this.points[3].getY()};

        g.setColor(super.color);
        if (super.isFilled) {
            g.fillPolygon(puntosX,puntosY,4);
        }else{
            g.drawPolygon(puntosX,puntosY,4);
        }
    }

    /**
     * moveOrRotate implements the Interface Shape, it rotates or move the shape.
     * This function will be called by the shapes manager, on every shape.
     * @see ShapesManager
     * @see Shape
     */
    @Override
    public void moveOrRotate() {
        rotateNinetyDegrees();
    }

    /**
     * rorateNinetyDegrees implements the interface Rotatable, and it rotates the shapee 90 degrees.
     * First it rotates individually the four points of the shape, and then, it rotates the four points of the
     * bounding box.
     */
    @Override
    public void rotateNinetyDegrees() {
        Point[] boundingBoxPoints;

        for (Point point:points) {
            normalize(point);
            rotate(point);
            denormalize(point);
        }

        boundingBoxPoints = convertBoundingBox(boundingBox);

        for (Point point:boundingBoxPoints) {
            normalize(point);
            rotate(point);
            denormalize(point);
        }

        boundingBox = calculateBB(boundingBoxPoints);

    }

    /**
     * convertBoundigBox it's a private helper function that takes a bounding box and extract the four points.
     * @param boundingBox it's a BoundingBox object
     * @return it returns an array of Point objects.
     * @see Point
     * @see BoundingBox
     */
    private Point[] convertBoundingBox(BoundingBox boundingBox) {

        Point bLeft, tRight, tPoint;

        Point[] converted = new Point[4];

        bLeft = boundingBox.getBottomLeft();
        tRight = boundingBox.getTopRight();

        tPoint = new Point(bLeft.getX(), bLeft.getY());
        converted[0]=tPoint;
        tPoint = new Point(bLeft.getX(), tRight.getY());
        converted[1]=tPoint;
        tPoint = new Point(tRight.getX(), tRight.getY());
        converted[2]=tPoint;
        tPoint = new Point(tRight.getX(), bLeft.getY());
        converted[3]=tPoint;

        return converted;

    }

    /**
     * denormalize is a private helper function that Restores the vector to the original position
     * @param point it's an object Point
     * @see Point
     */
    private void denormalize(Point point) {
        point.setX(point.getX()+xCenter);
        point.setY(point.getY()+yCenter);
    }

    /**
     * rotate is a private helper function that rotates a vector which origin is at the center of coords (0,0)
     * @param point it's an object Point
     * @see Point
     */
    private void rotate(Point point) {
        int auxX = point.getX();
        int auxY = point.getY();

        point.setX(-1* auxY);
        point.setY(auxX);
    }

    /**
     * normalize is a private helper function that take a vector as an input, and it transports it to the origin of
     * coords (0,0).
     * @param point it's a Point object
     * @see Point
     */
    private void normalize(Point point) {
        point.setX(point.getX()-xCenter);
        point.setY(point.getY()-yCenter);
    }

    @Override
    public String toString() {
        return "Quadrilateral";
    }
}

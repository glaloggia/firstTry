package com.gabriel;

import java.awt.*;

public class Quadrilateral extends Shape implements Rotatable{

    Point points[];

    public Quadrilateral(Point centrePoint, Point[] points){
        super(centrePoint.getX(),centrePoint.getY(),Color.black,true,calculateBB(points));
        this.points = points;
    }

    public Quadrilateral(Point centrePoint, Point p1, Point p2, Point p3, Point p4){
        super(centrePoint.getX(),centrePoint.getY(),Color.black,true,calculateBB(p1,p2,p3,p4));
        this.points = new Point[4];
        this.points[0]=p1;
        this.points[1]=p2;
        this.points[2]=p3;
        this.points[3]=p4;
    }

    private static BoundingBox calculateBB(Point p1, Point p2, Point p3, Point p4) {

        return calculateBB(new Point[]{p1, p2, p3, p4});

    }

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

    @Override
    public void drawShape(Graphics g) {
        int[] puntosX = {this.points[0].getX(),this.points[1].getX(),this.points[2].getX(),this.points[3].getX()};
        int[] puntosY = {this.points[0].getY(),this.points[1].getY(),this.points[2].getY(),this.points[3].getY()};

        if (super.isFilled) {
            g.fillPolygon(puntosX,puntosY,4);
        }else{
            g.drawPolygon(puntosX,puntosY,4);
        }
        g.setColor(Color.red);

        g.drawPolygon(new int[]{boundingBox.getBottomLeft().getX(),boundingBox.getBottomLeft().getX(),boundingBox.getTopRight().getX(),boundingBox.getTopRight().getX()},
                new int[]{boundingBox.getBottomLeft().getY(),boundingBox.getTopRight().getY(),boundingBox.getTopRight().getY(),boundingBox.getBottomLeft().getY()},4);

    }

    @Override
    public void rotateNinetyDegrees() {

    }

    @Override
    public String toString() {
        return "Quadrilateral";
    }
}

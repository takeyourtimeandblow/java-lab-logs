package org;

import org.geometry2d.*;
import org.geometry3d.Cylinder;
import java.util.logging.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(org.Main.class.getName());

    public static void main (String[] args) {
        LOGGER.fine("main called");
        Circle circle = new Circle(1.0);
        LOGGER.fine("Circle created");
        System.out.println(circle.toString());
        LOGGER.fine("circle.toString() called");
        Rectangle rectangle = new Rectangle(4, 2);
        LOGGER.fine("Rectangle created");
        System.out.println(rectangle.toString());
        LOGGER.fine("rectangle.toString() called");
        Cylinder cylinder = new Cylinder(1.0, 1.0);
        LOGGER.fine("Cylinder created");
        cylinder.area();
        LOGGER.fine("cylinder.area() called");
        cylinder.volume();
        LOGGER.fine("cylinder.volume() called");
        System.out.println(cylinder.toString());
        LOGGER.fine("cylinder.toString() called");
        Figure e = new Circle(1.0);

    }
}
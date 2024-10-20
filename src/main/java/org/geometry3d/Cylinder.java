package org.geometry3d;

import org.exceptions.FigureNotExistsException;

import java.io.IOException;
import java.util.logging.*;

public class Cylinder implements Figure {
    private double height;
    private double radius;
    private static final double PI = Math.PI;

    private static final Logger LOGGER = Logger.getLogger(Cylinder.class.getName());

    public Cylinder(double height, double radius){
        try { //start logger
            Handler fileHandler = new FileHandler("cylinder.log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.FINEST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if (height <= 0 || radius <= 0)
                throw new FigureNotExistsException(this.getClass().getSimpleName());
            this.height = height;
            this.radius = radius;

            LOGGER.log(Level.FINEST, "Creation successful");
        } catch (FigureNotExistsException e){
            LOGGER.log(Level.SEVERE, "exception", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public double area() {
        LOGGER.log(Level.FINEST, "method area() called");
        return 2*PI*radius*height;
    }

    @Override
    public double volume() {
        LOGGER.log(Level.FINEST, "method volume() called");
        return PI*radius*radius*height;
    }

    @Override
    public String toString(){
        LOGGER.log(Level.FINEST, "method toString() called");
        return this.getClass().getSimpleName() + "\n" +
                "radius = " + radius + ";\n" +
                "height = " + height + ";\n" +
                "area = " + area() + ";\n" +
                "volume = " + volume() + ';';
    }
}

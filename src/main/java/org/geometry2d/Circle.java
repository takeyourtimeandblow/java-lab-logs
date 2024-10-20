package org.geometry2d;

import org.exceptions.FigureNotExistsException;

import java.io.IOException;
import java.util.logging.*;

public class Circle implements Figure{
    private double radius;
    private static final double PI = Math.PI;

    private static final Logger LOGGER = Logger.getLogger(Circle.class.getName());


    public Circle(double radius){
        try { //start logger
            Handler fileHandler = new FileHandler("figures.log");
            fileHandler.setFormatter(new XMLFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if (radius <=0) {
                throw new FigureNotExistsException(this.getClass().getSimpleName());
            }
            this.radius = radius;

            LOGGER.log(Level.SEVERE, "Creation successful");
        } catch (FigureNotExistsException e) {
            LOGGER.log(Level.SEVERE, "exception", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public double area() {
        return (PI* radius * radius);
    }

    @Override
    public double perimeter() {
        return (2*PI* radius);
    }
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + "\n" +
                "radius = " + radius + ";\n" +
                "area = " + area() + ";\n" +
                "perimeter = " + perimeter() + ';';
    }
}

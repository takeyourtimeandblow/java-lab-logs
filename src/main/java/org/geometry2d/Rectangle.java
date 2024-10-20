package org.geometry2d;

import org.exceptions.FigureNotExistsException;

import java.io.IOException;
import java.util.logging.*;

public class Rectangle implements Figure {
    private double width;
    private double height;

    private static final Logger LOGGER = Logger.getLogger(Circle.class.getName());

    public Rectangle(double width, double height){
        try { //start logger
            Handler fileHandler = new FileHandler("figures.log");
            fileHandler.setFormatter(new XMLFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if ( width <= 0 || height <= 0 ) {
                throw new FigureNotExistsException(this.getClass().getSimpleName());
            }
            this.width = width;
            this.height = height;

            LOGGER.log(Level.INFO, "Creation successful");
        } catch (FigureNotExistsException e) {
            LOGGER.log(Level.INFO, "exception", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public double area(){
        return width*height;
    }
    @Override
    public double perimeter(){
        return (width+height)*2;
    }
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + "\n" +
                "width = " + width + ";\n" +
                "height = " + height + ";\n" +
                "area = " + area() + ";\n" +
                "perimeter = " + perimeter() + ';';
    }
}

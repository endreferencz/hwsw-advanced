package com.epam.training.rectangle;

public class Rectangle {

    protected double height;

    protected double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setSize(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double area() {
        return height * width;
    }

    public double perimeter() {
        return 2 * (height + width);
    }

    @Override
    public String toString() {
        return "Rectangle [height=" + height + ", width=" + width + "]";
    }

}

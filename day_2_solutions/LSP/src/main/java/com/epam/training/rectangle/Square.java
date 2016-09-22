package com.epam.training.rectangle;

public class Square extends Rectangle {

    public Square(double length) {
        super(length, length);
    }

    @Override
    public void setSize(double height, double width) {
        this.height = height;
        this.width = height;
    }

    @Override
    public String toString() {
        return "Square [size=" + height + "]";
    }

}

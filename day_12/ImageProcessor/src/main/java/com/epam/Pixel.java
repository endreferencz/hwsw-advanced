package com.epam;

public class Pixel {

    private volatile int color;
    private Coordinate coordinate;

    public Pixel(int color, Coordinate coordinate) {
        this.color = color & 0xFFFFFF;
        this.coordinate = coordinate;
    }

    public Pixel(int red, int green, int blue, Coordinate coordinate) {
        this.coordinate = coordinate;
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    public int getRed() {
        return color >> 16;
    }

    public void setRed(int red) {
        color &= 0xFFFF;
        color += (trunc(red) << 16);
    }

    public int getGreen() {
        return (color >> 8) & 0xFF;
    }

    public void setGreen(int green) {
        color &= 0xFF00FF;
        color += (trunc(green) << 8);
    }

    public int getBlue() {
        return color & 0xFF;
    }

    public void setBlue(int blue) {
        color &= 0xFFFF00;
        color += trunc(blue);
    }

    private int trunc(int color) {
        return Math.min(color, 255);
    }

    public int getSum() {
        return getRed() + getGreen() + getBlue();
    }

    public int toInt() {
        return color;
    }

    public void applySepia() {
        int red = getRed();
        int green = getGreen();
        int blue = getBlue();
        setRed((int) (red * 0.393 + green * 0.769 + blue * 0.189));
        setGreen((int) (red * 0.349 + green * 0.686 + blue * 0.168));
        setBlue((int) (red * 0.272 + green * 0.534 + blue * 0.131));
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}

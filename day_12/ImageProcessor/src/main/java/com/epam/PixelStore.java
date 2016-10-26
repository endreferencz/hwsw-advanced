package com.epam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PixelStore {

    private static final int AREA_SIZE = 5;
    private int width;
    private int height;
    private List<Pixel> pixels;

    public PixelStore(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new ArrayList<>(this.width * this.height);
    }

    public void add(int color) {
        pixels.add(new Pixel(color, new Coordinate(pixels.size() % width, pixels.size() / width)));
    }

    public Pixel getPixel(Coordinate coordinate) {
        return pixels.get(coordinate.getY() * width + coordinate.getX());
    }

    public List<Pixel> getArea(Pixel pixel) {
        List<Pixel> result = new ArrayList<>(AREA_SIZE * AREA_SIZE);
        Coordinate coordinate = pixel.getCoordinate();
        for (int i = -AREA_SIZE; i < AREA_SIZE; i++) {
            for (int j = -AREA_SIZE; j < AREA_SIZE; j++) {
                Coordinate location = coordinate.move(new Coordinate(i, j));
                if (inbound(location)) {
                    result.add(getPixel(location));
                }
            }
        }
        return result;
    }

    private boolean inbound(Coordinate location) {
        return location.getX() >= 0 && location.getY() >= 0 && location.getX() < width && location.getY() < height;
    }

    public Pixel getAreaColor(Pixel pixel) {
        List<Pixel> result = getArea(pixel);
        double red = result.stream().mapToInt(p -> p.getRed()).average().getAsDouble();
        double green = result.stream().mapToInt(p -> p.getGreen()).average().getAsDouble();
        double blue = result.stream().mapToInt(p -> p.getBlue()).average().getAsDouble();
        return new Pixel((int) red, (int) green, (int) blue, pixel.getCoordinate());
    }

    public Stream<Pixel> stream() {
        return pixels.stream();
    }

    public Stream<Pixel> parallelStream() {
        return pixels.parallelStream();
    }

}

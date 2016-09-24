package com.epam.training.rectangle;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Rectangle> rectangles = Arrays.asList(new Rectangle(13, 28), new Rectangle(31, 48));
        setSameHeightForRectangles(rectangles, 30);
        setSameWidthForRectangles(rectangles, 40);
        if (!checkSameSize(rectangles)) {
            System.out.println("Bug!");
        } else {
            System.out.println("Ok!");
        }
    }

    private static boolean checkSameSize(List<Rectangle> rectangles) {
        boolean result = true;
        if (!rectangles.isEmpty()) {
            for (Rectangle rectangle : rectangles) {
                if (rectangle.getHeight() != rectangles.get(0).getHeight() || rectangle.getWidth() != rectangles.get(0).getWidth()) {
                    result = false;
                }
            }
        }
        return result;
    }

    private static void setSameHeightForRectangles(List<Rectangle> rectangles, double height) {
        for (Rectangle rectangle : rectangles) {
            rectangle.setSize(height, rectangle.getWidth());
        }
    }

    private static void setSameWidthForRectangles(List<Rectangle> rectangles, double width) {
        for (Rectangle rectangle : rectangles) {
            rectangle.setSize(rectangle.getHeight(), width);
        }
    }

}

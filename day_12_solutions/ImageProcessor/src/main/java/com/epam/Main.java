package com.epam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URI inputImageUri = Main.class.getClassLoader().getResource("image.png").toURI();
        BufferedImage image = ImageIO.read(new File(inputImageUri));
        PixelStore pixels = storePixels(image);
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        int[] rgbArray = createImageArray(pixels);
        result.setRGB(0, 0, image.getWidth(), image.getHeight(), rgbArray, 0, image.getWidth());
        ImageIO.write(result, "jpg", new File("result.jpg"));
    }

    private static int[] createImageArray(PixelStore pixels) {
        long start = System.currentTimeMillis();
        int[] rgbArray = pixels
                .parallelStream()
                .map(p -> pixels.getAreaColor(p))
                .peek(p -> p.applySepia())
                .mapToInt(p -> p.toInt())
                .toArray();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return rgbArray;
    }

    private static PixelStore storePixels(BufferedImage image) {
        PixelStore pixels = new PixelStore(image.getWidth(), image.getHeight());
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                pixels.add(rgb);
            }
        }
        return pixels;
    }

}

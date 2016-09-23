package com.epam.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class NumberGuessing {

    public static void main(String[] args) throws IOException {
        new NumberGuessing().start();
    }

    private void start() throws IOException {
        int min = 0;
        int max = 1023;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            boolean finished = false;
            while (!finished) {
                int guess = guess(min, max);
                System.out.println(guess);
                String input = br.readLine();
                String simpleInput = input.trim();
                if (simpleInput.startsWith(">")) {
                    min = guess + 1;
                } else if (simpleInput.startsWith("<")) {
                    max = guess - 1;
                } else {
                    System.out.println("It was: " + guess);
                    finished = true;
                }
            }
        }
    }

    private int guess(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

}

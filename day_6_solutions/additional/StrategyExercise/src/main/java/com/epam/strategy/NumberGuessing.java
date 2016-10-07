package com.epam.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NumberGuessing {

    @Autowired
    @Qualifier("random")
    private NumberGuessingStrategy strategy;

    public NumberGuessing() {
    }

    public void start() throws IOException {
        int min = 0;
        int max = 1023;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            boolean finished = false;
            while (!finished) {
                int guess = strategy.guess(min, max);
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

}

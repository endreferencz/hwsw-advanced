package com.epam.pressure;

import java.util.Random;

public class SensorPressureGenerator {

	public double samplePressure() {
        // placeholder implementation that simulate a real sensor in a real tire
        Random basicRandomNumbersGenerator = new Random();
        return 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
    }
    
}

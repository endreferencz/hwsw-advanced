package com.epam.testing.dashboard;

public class Dashboard {

    private Thermometer thermometer;

    public Dashboard(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    public String temperature() {
        double temperature = thermometer.measure();
        String result;
        if (temperature < 0) {
            result = "Freezing";
        } else if (temperature < 10) {
            result = "Cold";
        } else if (temperature < 30) {
            result = "Good";
        } else {
            result = "Hot";
        }
        return result;
    }

}

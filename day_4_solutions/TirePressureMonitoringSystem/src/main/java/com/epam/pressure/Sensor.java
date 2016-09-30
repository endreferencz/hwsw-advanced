package com.epam.pressure;

public class Sensor {
	public static final double OFFSET = 16;

	private SensorPressureGenerator generator;

	public Sensor(SensorPressureGenerator generator) {
		this.generator = generator;
	}

	public double popNextPressurePsiValue() {
		double pressureTelemetryValue;
		pressureTelemetryValue = generator.samplePressure();
		return OFFSET + pressureTelemetryValue;
	}

}

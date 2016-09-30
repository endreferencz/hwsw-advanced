package com.epam.pressure;

public class Alarm {
	private final double lowPressureThreshold = 17;
	private final double highPressureThreshold = 21;

	private Sensor sensor;

	private boolean alarmOn = false;

	public Alarm(Sensor sensor) {
		this.sensor = sensor;
	}

	public void check() {
		double psiPressureValue = sensor.popNextPressurePsiValue();
		if (psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue) {
			alarmOn = true;
		}
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}

	public static void main(String[] args) {
		Alarm alarm = new Alarm(new Sensor(new SensorPressureGenerator()));
		alarm.check();
		System.out.println(alarm.isAlarmOn());
	}
}

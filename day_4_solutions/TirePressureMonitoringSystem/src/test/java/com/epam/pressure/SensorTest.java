package com.epam.pressure;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class SensorTest {

	@Test
	public void testNextPressure() {
		// Given
		SensorPressureGenerator pressureGenerator = Mockito.mock(SensorPressureGenerator.class);
		Mockito.when(pressureGenerator.samplePressure()).thenReturn(5.0);
		Sensor sensor = new Sensor(pressureGenerator);

		// When
		double value = sensor.popNextPressurePsiValue();

		// Then
		Assert.assertEquals(21, value, 0.000000001);
	}

}

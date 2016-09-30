package com.epam.testing.dashboard;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

public class DashboardTest {

	@Test
	public void testTemperature() {
		// Given
		Dashboard dashboard = new Dashboard(new Thermometer() {
			@Override
			public double measure() {
				return 23;
			}
		});
		
		// When
		String actual = dashboard.temperature();

		// Then
		Assert.assertEquals("Good", actual);
	}
	
	@Test
	public void testTemperatureWithMockito() {
		// Given
		Thermometer thermometer = mock(Thermometer.class);
		when(thermometer.measure()).thenReturn(9.0);
		Dashboard dashboard = new Dashboard(thermometer);
		
		// When
		String actual = dashboard.temperature();

		// Then
		Assert.assertEquals("Cold", actual);
	}

}

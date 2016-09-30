package com.epam.pressure;

import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    @Test
    public void testCheckAlarmOff() {
        // Given
        Sensor sensor = mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
        Alarm alarm = new Alarm(sensor);

        // When
        alarm.check();

        // Then
        Assert.assertFalse("Pressure is normal, but alarm turned on incorrectly", alarm.isAlarmOn());
    }

    @Test
    public void testCheckAlarmOnPressureLow() {
        // Given
        Sensor sensor = mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(13.0);
        Alarm alarm = new Alarm(sensor);

        // When
        alarm.check();

        // Then
        Assert.assertTrue("Pressure is too low, alarm should turn on", alarm.isAlarmOn());
    }

    @Test
    public void testCheckAlarmOnPressureHigh() {
        // Given
        Sensor sensor = mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
        Alarm alarm = new Alarm(sensor);

        // When
        alarm.check();

        // Then
        Assert.assertTrue("Pressure is too high, alarm should turn on", alarm.isAlarmOn());
    }

    @Test
    public void testCheckAlarmOnPressureChanges() {
        // Given
        Sensor sensor = mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.0, 20.0);
        Alarm alarm = new Alarm(sensor);

        // When
        alarm.check();
        alarm.check();

        // Then
        Assert.assertTrue("Pressure was too high once, alarm should remain on", alarm.isAlarmOn());
    }

}

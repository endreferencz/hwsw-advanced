package com.epam.telemetry;

import org.junit.Test;
import org.mockito.Mockito;

public class TelemetryClientTest {

    @Test(expected = IllegalStateException.class)
    public void testCheckTransmission() {
        TelemetryClient client = Mockito.mock(TelemetryClient.class);
        Mockito.when(client.getOnlineStatus()).thenReturn(true);
        Mockito.when(client.receive()).thenThrow(new IllegalStateException());
        TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls(client);
        controls.checkTransmission();
    }

}

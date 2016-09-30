package com.epam.telemetry;

public class TelemetryDiagnosticControls {

    private static final String DIAGNOSTIC_CHANNEL_CONNECTION_STRING = "*111#";

    private final TelemetryClient telemetryClient;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() {
        diagnosticInfo = "";

        telemetryClient.disconnect();

        int retryLeft = 3;
        while (!telemetryClient.getOnlineStatus() && retryLeft > 0) {
            telemetryClient.connect(DIAGNOSTIC_CHANNEL_CONNECTION_STRING);
            retryLeft--;
        }

        if (!telemetryClient.getOnlineStatus()) {
            throw new IllegalStateException("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }

    public static void main(String[] args) {
        TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls(new TelemetryClient());
        controls.checkTransmission();
        System.out.println(controls.getDiagnosticInfo());
    }

}

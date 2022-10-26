package model;

public class VitalSigns {
    private String bodyTemperature;
    private String pulseRate;
    private String rateOfBreathing;
    private String bloodPressure;

    public VitalSigns() {}

    public VitalSigns(String bodyTemperature, String pulseRate, String rateOfBreathing, String bloodPressure) {
        this.bodyTemperature = bodyTemperature;
        this.pulseRate = pulseRate;
        this.rateOfBreathing = rateOfBreathing;
        this.bloodPressure = bloodPressure;
    }

    public String getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(String bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public String getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(String pulseRate) {
        this.pulseRate = pulseRate;
    }

    public String getRateOfBreathing() {
        return rateOfBreathing;
    }

    public void setRateOfBreathing(String rateOfBreathing) {
        this.rateOfBreathing = rateOfBreathing;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
}

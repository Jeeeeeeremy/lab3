package model;

import java.util.ArrayList;

public class VitalSigns {
    String bodyTemperature;
    String pulseRate;
    String rateOfBreathing;
    String bloodPressure;
    ArrayList<String> diagnosis;

    public VitalSigns() {
    }

    public VitalSigns(String bodyTemperature, String pulseRate, String rateOfBreathing, String bloodPressure, ArrayList<String> diagnosis) {
        this.bodyTemperature = bodyTemperature;
        this.pulseRate = pulseRate;
        this.rateOfBreathing = rateOfBreathing;
        this.bloodPressure = bloodPressure;
        this.diagnosis = diagnosis;
    }

    public VitalSigns(String bodyTemperature, String pulseRate, String rateOfBreathing, String bloodPressure) {
        this.bodyTemperature = bodyTemperature;
        this.pulseRate = pulseRate;
        this.rateOfBreathing = rateOfBreathing;
        this.bloodPressure = bloodPressure;
    }

    public String getBodyTemperature() {
        return bodyTemperature;
    }

    public String getPulseRate() {
        return pulseRate;
    }

    public String getRateOfBreathing() {
        return rateOfBreathing;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public ArrayList<String> getDiagnosis() {
        return diagnosis;
    }

    public void setBodyTemperature(String bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public void setPulseRate(String pulseRate) {
        this.pulseRate = pulseRate;
    }

    public void setRateOfBreathing(String rateOfBreathing) {
        this.rateOfBreathing = rateOfBreathing;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public void addDiagnosis(String diagnosis) {
        this.diagnosis.add(diagnosis);
    }
}

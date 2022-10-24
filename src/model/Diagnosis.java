package model;

import java.util.ArrayList;

public class Diagnosis {
    String bodyTemperature;
    String pulseRate;
    String rateOfBreathing;
    String bloodPressure;
    String diagnosis;

    public Diagnosis() {
    }

    public Diagnosis(String bodyTemperature, String pulseRate, String rateOfBreathing, String bloodPressure, String diagnosis) {
        this.bodyTemperature = bodyTemperature;
        this.pulseRate = pulseRate;
        this.rateOfBreathing = rateOfBreathing;
        this.bloodPressure = bloodPressure;
        this.diagnosis = diagnosis;
    }

    public Diagnosis(String bodyTemperature, String pulseRate, String rateOfBreathing, String bloodPressure) {
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

    public String getDiagnosis() {
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

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "bodyTemperature='" + bodyTemperature + '\'' +
                ", pulseRate='" + pulseRate + '\'' +
                ", rateOfBreathing='" + rateOfBreathing + '\'' +
                ", bloodPressure='" + bloodPressure + '\'' +
                ", diagnosis=" + diagnosis +
                '}';
    }
}

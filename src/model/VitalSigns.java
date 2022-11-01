package model;

import java.util.Random;

public class VitalSigns {
    private double bodyTemperature;

    private int pulseRate;

    private int diastolicPressure;

    private int systolicPressure;

    public VitalSigns() {}

    public VitalSigns(double bodyTemperature, int pulseRate, int diastolicPressure, int systolicPressure) {
        this.bodyTemperature = bodyTemperature;
        this.pulseRate = pulseRate;
        this.diastolicPressure = diastolicPressure;
        this.systolicPressure = systolicPressure;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public int getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(int pulseRate) {
        this.pulseRate = pulseRate;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public VitalSigns getRandomVitalSigns(){
        VitalSigns vitalSigns = new VitalSigns();
        Random random = new Random();
        vitalSigns.setPulseRate(random.nextInt(50)+50);
        vitalSigns.setSystolicPressure(random.nextInt(90)+70);
        vitalSigns.setDiastolicPressure(random.nextInt(70)+40);
        double d = random.nextDouble()*3+35;
        String result = String .format("%.1f",d);
        vitalSigns.setBodyTemperature(Double.parseDouble(result));
        return vitalSigns;
    }
}

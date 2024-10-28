/*
    Manages various types of measurements (rainfall, sunshine, and temperature)
    for a specific region
*/

import java.util.ArrayList;

public class Region {
    private String regionName;
    private ArrayList<Measurement> regionData;

    public Region() {
        regionName = "UNKNOWN";
        this.regionData = new ArrayList<>();
    }

    public Region(String regionName) {
        this.regionName = regionName;
        this.regionData = new ArrayList<>();
    }

    public void process(String rainfall) {
        Rainfall rainfallMeasurement = new Rainfall(rainfall);
        regionData.add(rainfallMeasurement);
    }

    public void process(String rainfall, String sunshine) {
        Rainfall rainfallMeasurement = new Rainfall(rainfall);
        Sunshine sunshineMeasurement = new Sunshine(sunshine);
        regionData.add(rainfallMeasurement);
        regionData.add(sunshineMeasurement);
    }

    public void process(String rainfall, String sunshine, String minTemperature) {
        Rainfall rainfallMeasurement = new Rainfall(rainfall);
        Sunshine sunshineMeasurement = new Sunshine(sunshine);
        Temperature temperatureMeasurement = new Temperature(minTemperature);
        regionData.add(rainfallMeasurement);
        regionData.add(sunshineMeasurement);
        regionData.add(temperatureMeasurement);
    }

    public void process(String rainfall, String sunshine, String minTemperature, String maxTemperature) {
        Rainfall rainfallMeasurement = new Rainfall(rainfall);
        Sunshine sunshineMeasurement = new Sunshine(sunshine);
        Temperature temperatureMeasurementMin = new Temperature(minTemperature);
        Temperature temperatureMeasurementMax = new Temperature(maxTemperature);
        regionData.add(rainfallMeasurement);
        regionData.add(sunshineMeasurement);
        regionData.add(temperatureMeasurementMin);
        regionData.add(temperatureMeasurementMax);
    }

    public double getAverage(int colIndex) {
        return regionData.get(colIndex).getAverage();
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        int regionNameLength = regionName.length();
        sb.append(" ".repeat(16 - regionNameLength)).append(regionName).append("|");

        for (Measurement measurement : regionData) {
            int measurementLength = measurement.toString().length();
            sb.append(" ".repeat(16 - measurementLength)).append(measurement).append("|");
        }

        return sb.toString();
    }
}

/*
    Calculates average rainfall in mm
*/

import java.util.ArrayList;

public class Rainfall extends Measurement{
    public Rainfall(String rainfallMeasurements) {
        this.measurementUnit = "mm";
        this.data = new ArrayList<>();
        process(rainfallMeasurements);
    }

    @Override
    void process(String line) {
        String[] rainfallValues = line.split(",");
        for (String singleRainfall : rainfallValues) {
            double rainfall = Double.parseDouble(singleRainfall);
            if(rainfall < 0) {
                rainfall = 0.0;
            }
            data.add(rainfall);
        }

    }
}
/*
    Calculates average temperature in degrees celsius
*/

public class Temperature extends Measurement{
    public Temperature(String temperature){
        measurementUnit = "° C";
        process(temperature);
    }

    @Override
    public void process(String line){
        String[] temperatureValues = line.split("\t");

        for(String temperatureValue : temperatureValues) {
            double tempValue = Double.parseDouble(temperatureValue);
            data.add(tempValue);
        }
    }
}

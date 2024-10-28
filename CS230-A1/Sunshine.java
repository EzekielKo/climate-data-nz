/*
    Calculates average sunshine hours
*/

public class Sunshine extends Measurement{
    public Sunshine(String sunshineDuration) {
        measurementUnit = "hr";
        process(sunshineDuration);
    }
    @Override
    public void process(String line) {
        String[] sunshineValues = line.split(",");
        for(String sunshineValue : sunshineValues) {
            double newSunshineValue = Double.parseDouble(sunshineValue);
            data.add(newSunshineValue);
        }
    }
}

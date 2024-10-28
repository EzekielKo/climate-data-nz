/*
    Manages a collection of numerical data and provide common operations on that data,
    such as calculating the average and formatting output.
*/

import java.util.ArrayList;

abstract class Measurement {
    protected ArrayList<Double> data;
    protected String measurementUnit;

    public Measurement() {
        this.data = new ArrayList<>();
    }

    public double getAverage(){
        if(data.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Double number : data) {
            sum += number;
        }
        return sum / data.size();
    }
    abstract void process(String line);

    public String toString(){
        return String.format("%.2f%s",getAverage(), measurementUnit);
    }
}

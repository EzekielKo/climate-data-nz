/*
    Processes and manages climate data for various regions. Uses all the different classes
    created throughout to give a result formatted to be user-friendly
*/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Statistics {
    private ArrayList<Region> regions;
    private String[] columnNames;
    private ClimateType climateType;

    public Statistics(ClimateType climateType) {
        this.climateType = climateType;
        this.columnNames = climateType.getColumnNames();
        this.regions = new ArrayList<>();
    }

    public void process(String regionDataFileName) {
        ArrayList<String> regionData = new ArrayList<>();
        try {
            File myObj = new File(regionDataFileName);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if(data.contains(",")) {
                    String[] dataValues = data.split(",");
                    regionData.add(Arrays.toString(dataValues));
                } else if (data.contains("\t")) {
                    String[] dataValues = data.split(" ");
                    regionData.add(Arrays.toString(dataValues));
                }
            }
            myReader.close();

            Region newRegion = new Region();
            //Create a region based on how many arguments there are
            String regionName = regionDataFileName.substring(0,regionDataFileName.length() - 4);
            String regionRainfall = (!regionData.get(0).isEmpty() ?
                    regionData.get(0).substring(1, regionData.get(0).length() - 1) : null);
            String regionSunshine = (!regionData.get(1).isEmpty() ?
                    regionData.get(1).substring(1, regionData.get(1).length() - 1) : null);
            String regionMinTemperature = (!regionData.get(2).isEmpty() ?
                    regionData.get(2).substring(1, regionData.get(2).length() - 1) : null);
            String regionMaxTemperature = (!regionData.get(3).isEmpty() ?
                    regionData.get(3).substring(1, regionData.get(3).length() - 1) : null);

            if(climateType.equals(ClimateType.RAINFALL)) {
                newRegion = new Region(regionName);
                newRegion.process(regionRainfall);
                regions.add(newRegion);
            } else if (climateType.equals(ClimateType.RAINFALL_SUNSHINE)){
                newRegion = new Region(regionName);
                newRegion.process(regionRainfall, regionSunshine);
                regions.add(newRegion);
            } else if (climateType.equals(ClimateType.RAINFALL_SUNSHINE_TEMPERATURE)){
                newRegion = new Region(regionName);
                newRegion.process(regionRainfall, regionSunshine, regionMinTemperature);
                regions.add(newRegion);
            } else if (climateType.equals(ClimateType.ALL)){
                newRegion = new Region(regionName);
                newRegion.process(regionRainfall, regionSunshine, regionMinTemperature, regionMaxTemperature);
                regions.add(newRegion);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }
    public void displayTable() {
        System.out.println("Average climatological data for selected locations throughout NZ");
        System.out.println("================================================================");
        System.out.println("================================================================\n");

        String[] getClimateColumnNames = climateType.getColumnNames();
        ArrayList<String> climateColumnNames = new ArrayList<>(Arrays.asList(getClimateColumnNames));
        int climateColumnCount = climateColumnNames.size();

        //Print the table headings
        System.out.print("          Region|");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < climateColumnCount; i++) {
            int wordLength = climateColumnNames.get(i).length();
            sb.append(" ".repeat(16 - wordLength)).append(climateColumnNames.get(i)).append("|");
        }
        System.out.print(sb + "\n");
        System.out.println("=".repeat(sb.length() + 17));

        // Print the regions
        for(Region region : regions) {
            System.out.print(region + "\n");
        }

    }
}

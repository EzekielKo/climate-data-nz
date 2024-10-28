/*
    Defines an enum named ClimateType that represents various combinations of climate data types.
*/

import java.util.Arrays;

enum ClimateType {
    RAINFALL(0),
    RAINFALL_SUNSHINE(1),
    RAINFALL_SUNSHINE_TEMPERATURE(2),
    ALL(3);

    private static final String[] NAMES = {
            "Rainfall",
            "Sunshine",
            "Min.Temperature",
            "Max.Temperature"};

    private final int index;

    ClimateType(int index) {
        this.index = index;
    }

    public String[] getColumnNames() {
        return Arrays.copyOfRange(NAMES, 0, index + 1);
    }

    public static ClimateType fromInt(int value) {
        return ClimateType.values()[value];
    }
}
package us.fok.lenzenslijper.util;

public class NumericUtilities {

    public static Integer constrainInteger(Integer i, Integer defaultValue, Integer minValue, Integer maxValue) {
        if (i == null) {
            return defaultValue;
        }
        else {
            if (maxValue != null) { i = Math.min(i, maxValue); }
            if (minValue != null) { i = Math.max(i, minValue); }
            return i;
        }
    }

}

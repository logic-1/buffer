package com.prateek.client;

/**
 * Created by prateek.gupta on 16/02/17.
 */
public enum RelativePosition {
    BEFORE("BEFORE"), AFTER("AFTER");

    private final String stringValue;
    RelativePosition(String stringValue) {
        this.stringValue = stringValue;
    }

    public static RelativePosition forName(String input){
        if(input == null)
            return null;

        for (RelativePosition each : RelativePosition.values()) {
            if(each.stringValue.equals(input.trim().toUpperCase()))
                return each;
        }
        return null;
    }

}

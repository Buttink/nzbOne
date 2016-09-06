package org.sickbeard;

public enum Folder {
    BY_SEASON,
    FLATTEN,
    ;


    @Override
    public String toString() {
        switch (this) {
            case BY_SEASON: return "1";
            default:
            case FLATTEN: return "0";
        }
    }
}

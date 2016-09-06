package org.sickbeard;

public enum Pause {
    PAUSE,
    UNPAUSE,
    ;


    @Override
    public String toString() {
        switch (this) {
            case PAUSE: return "0";
            default:
            case UNPAUSE: return "1";
        }
    }
}

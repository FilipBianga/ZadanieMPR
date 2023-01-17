package com.example.helpdesk.model;

public enum Status {
    NEW(1), IN_PROGRESS(1.5), DONE(2);
    private final double multiplier;

    Status(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}

package com.example.demo.models;

public enum Sex {
    men("M"),
    female("F"),
    unisex("U");

    private final String displayName;

    Sex(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

package com.cortexits.pharmacy.utils;

public enum PrefetchList {
    CONNECTING ("Connecting Database"),
    CHECKING ("Checking Database"),
    AUTHENTICATING ("Checking Authentication"),
    MODULES ("Loading Modules"),
    INITIALIZING ("Fetching Initial Data"),
    PREPARING ("Preparing"),
    COMPLETING ("Completing");

    private String p;

    PrefetchList(String p) {
        this.p = p;
    }

    public final String get() {
        return p;
    }
}

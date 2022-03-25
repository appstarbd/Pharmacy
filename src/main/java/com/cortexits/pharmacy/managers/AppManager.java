package com.cortexits.pharmacy.managers;

public class AppManager extends BaseManager {
    private static String name = "Pharmacy Management System";
    private static String version = "1.0";

    public AppManager() {
    }

    public AppManager(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public static String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public static String getVersion() {
        return version;
    }

//    public void setVersion(String version) {
//        this.version = version;
//    }
}

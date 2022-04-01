module com.cortexits.pharmacy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.apache.commons.lang3;

//    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
//    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansolo.tilesfx;

//    requires java.desktop;

//    requires com.cortexits.pharmacy.medicine;

    opens com.cortexits.pharmacy to javafx.fxml;
    exports com.cortexits.pharmacy;
//    exports com.cortexits.pharmacy.base;
//    opens com.cortexits.pharmacy.base to javafx.fxml;
    exports com.cortexits.pharmacy.managers;
    opens com.cortexits.pharmacy.managers to javafx.fxml;
    exports com.cortexits.pharmacy.controllers;
    opens com.cortexits.pharmacy.controllers to javafx.fxml;
    exports com.cortexits.pharmacy.auth;
    opens com.cortexits.pharmacy.auth to javafx.fxml;
    exports com.cortexits.pharmacy.dashboard;
    opens com.cortexits.pharmacy.dashboard to javafx.fxml;
    exports com.cortexits.pharmacy.pos;
    opens com.cortexits.pharmacy.pos to javafx.fxml;
    exports com.cortexits.pharmacy.medicine;
    opens com.cortexits.pharmacy.medicine to javafx.fxml;
    exports com.cortexits.pharmacy.stock;
    opens com.cortexits.pharmacy.stock to javafx.fxml;
    exports com.cortexits.pharmacy.customer;
    opens com.cortexits.pharmacy.customer to javafx.fxml;
    exports com.cortexits.pharmacy.supplier;
    opens com.cortexits.pharmacy.supplier to javafx.fxml;
    exports com.cortexits.pharmacy.purchase;
    opens com.cortexits.pharmacy.purchase to javafx.fxml;
//    exports com.cortexits.pharmacy.vendor;
//    opens com.cortexits.pharmacy.vendor to javafx.fxml;

    exports com.cortexits.pharmacy.manufacturer;

    exports com.cortexits.pharmacy.utils;
    exports com.cortexits.pharmacy.views;

//    exports com.cortexits.pharmacy.sample;
//    opens com.cortexits.pharmacy.sample to javafx.fxml;
}
package com.cortexits.pharmacy;

import com.cortexits.pharmacy.managers.AppManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        if (AppManager.initApplication(primaryStage)) {
            System.out.println("init::start");
//            AppManager.startApplication(primaryStage);
        } else {
            System.err.println("Failed to start the application");
//            throw new Exception();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
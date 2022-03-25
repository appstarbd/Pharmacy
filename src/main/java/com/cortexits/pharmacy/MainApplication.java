package com.cortexits.pharmacy;

import com.cortexits.pharmacy.managers.AppManager;
import com.cortexits.pharmacy.managers.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("views/main.fxml"));
////        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        Scene scene = new Scene(fxmlLoader.load());
////        scene.getStylesheets().add("com/cortexits/pharmacy/styles/main.css");
////        scene.getStylesheets().add(getClass().getResource("auth.css").toExternalForm());
//        primaryStage.setTitle("Pharmacy Management System");
//        primaryStage.setScene(scene);
//        primaryStage.show();
        if (AppManager.initApplication()) {
            AppManager.startApplication(primaryStage);
        } else {
            throw new Exception();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
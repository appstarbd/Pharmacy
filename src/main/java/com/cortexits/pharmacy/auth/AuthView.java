package com.cortexits.pharmacy.auth;

import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.managers.ViewManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AuthView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new ViewManager(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}

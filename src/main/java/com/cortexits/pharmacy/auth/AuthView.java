package com.cortexits.pharmacy.auth;

import com.cortexits.pharmacy.MainApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AuthView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("auth.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(fxmlLoader.load());
//        scene.getStylesheets().add("com/cortexits/pharmacy/styles/auth.css");
//        scene.getStylesheets().add(getClass().getResource("auth.css").toExternalForm());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
//        stage.toFront();
        stage.setTitle("PMS :: Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

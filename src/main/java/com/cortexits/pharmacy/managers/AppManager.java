package com.cortexits.pharmacy.managers;

import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.utils.View;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppManager extends BaseManager {
    private static AppManager instance;
    private static String name = "Pharmacy Management System";
    private static String version = "1.0";

    private static boolean auth = false;

    public AppManager() {
    }

    public AppManager(String name, String version) {
        AppManager.name = name;
        AppManager.version = version;
    }

    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
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

//    Initialize app with Splash Screen
    public static boolean initApplication() {
        return true;
    }
//    Start app after initializations and check auth
    public static void startApplication(Stage stage) throws IOException {
        ViewManager.setStage(stage);
        if (isAuth()) {
            ViewManager.showView(ViewManager.VIEW.MAIN);
        } else {
            ViewManager.showView(ViewManager.VIEW.AUTH);
        }
    }

    public static boolean isAuth() {
        return auth;
    }

    public static void setAuth(boolean auth) {
        AppManager.auth = auth;
    }

    public static boolean checkPermissions() {
        return false;
    }

    public static void doLogin() throws IOException {
//        auth = true;
//        boolean isSuccess = true;
        Stage stage = ViewManager.getStage();
        if (auth) {
            stage.hide();
            ViewManager.setStage(new Stage());
//            ViewManager.showView(ViewManager.VIEW.MAIN);
            ViewManager.showView(View.MAIN, StageStyle.DECORATED);
        } else {
//            ViewManager.showView(ViewManager.VIEW.AUTH);
//            ViewManager.showView(View.AUTH, StageStyle.UNDECORATED);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong username or password");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        }
    }

    public static void shutdown() {
        Platform.runLater(Platform::exit);
    }
}

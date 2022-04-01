package com.cortexits.pharmacy.managers;

import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.utils.View;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.time.Duration;

public class AppManager extends BaseManager {
    private static AppManager instance;
    private static String name = "Pharmacy Management System";
    private static String version = "1.0";

    private static boolean auth = false;
    private static boolean isComplete = false;

    private static Stage stage;

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
//    public static boolean initApplication(Stage stage) throws IOException {
//        //        AppManager.stage = stage;
//        ViewManager.setStage(stage);
//        ViewManager.showView(View.SPLASH, StageStyle.UNDECORATED, true);
//        Task<Integer> task = new Task<>() {
//            @Override
//            protected Integer call() throws Exception {
//                int iterations;
//                for (iterations = 0; iterations < 1000; iterations++) {
//                    if (isCancelled()) {
//                        updateMessage("Cancelled");
//                        break;
//                    }
//                    System.out.println("Iteration " + iterations);
//                    updateMessage("Iteration " + iterations);
//                    updateProgress(iterations, 1000);
//                }
//                return iterations;
//            }
//
//            @Override
//            protected void done() {
//                super.done();
//                System.out.println("done");
//            }
//
//            @Override
//            public boolean isDone() {
//                System.out.println("isDone");
//                return super.isDone();
//            }
//        };
////        Task<ObservableList<Rectangle>> task = new Task<ObservableList<Rectangle>>() {
////            @Override protected ObservableList<Rectangle> call() throws Exception {
////                updateMessage("Creating Rectangles");
////                ObservableList<Rectangle> results = FXCollections.observableArrayList();
////                for (int i=0; i<100; i++) {
////                    if (isCancelled()) break;
////                    Rectangle r = new Rectangle(10, 10);
////                    r.setX(10 * i);
////                    results.add(r);
////                    updateProgress(i, 100);
////                }
////                return results;
////            }
////        };
////        task.setOnFailed(event -> isComplete = false);
////        Thread th = new Thread(task);
////        th.setDaemon(true);
////        th.start();
//        task.setOnSucceeded(event -> {
//            isComplete = true;
////            th.stop();
////            try {
////                startApplication(new Stage());
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//            System.out.println("on success: " + isComplete);
//        });
//        task.run();
////        ViewManager.setStage(new Stage());
////        try {
////            ViewManager.showView(View.SPLASH, StageStyle.UNDECORATED, true);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        Platform.runLater(new Task<>() {
////            @Override
////            protected Object call() throws Exception {
////                for(int i = 0; i <= 1000; i++) {
////                    System.out.println(i);
////                    try {
////                        Thread.sleep(5);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                    if (i == 1000) {
////                        isComplete = true;
////                    }
////                }
////                return null;
////            }
////        });
//
////        System.out.println(Integer.MAX_VALUE);
//        System.out.println("is complete: " + isComplete);
//        return isComplete;
//    }
    public static boolean initApplication(Stage stage) throws IOException {
        ViewManager.hideActiveView();
        ViewManager.setStage(stage);
        ViewManager.showView(View.SPLASH, StageStyle.UNDECORATED, true);
        return true;
    }
    public static boolean initApplication() throws IOException {
        return initApplication(new Stage());
    }
//    Start app after initializations and check auth
    public static void startApplication(Stage stage) throws Exception {
        AppManager.stage = stage;
        ViewManager.hideActiveView();
        ViewManager.setStage(stage);
        if (isAuth()) {
            ViewManager.showView(View.MAIN, StageStyle.DECORATED);
        } else {
//            ViewManager.setStage(new Stage());
            ViewManager.showView(View.AUTH, StageStyle.UNDECORATED, true);
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
        Alert powerOffAlert = new Alert(Alert.AlertType.WARNING,"Do you really want to close this application?", ButtonType.YES, ButtonType.NO);
        powerOffAlert.initModality(Modality.APPLICATION_MODAL);
        powerOffAlert.initStyle(StageStyle.UNDECORATED);
        powerOffAlert.initOwner(ViewManager.getStage());
        powerOffAlert.showAndWait()
                .filter(response -> response == ButtonType.YES)
//                .ifPresentOrElse(, Platform.exit());
                .ifPresent(response -> Platform.exit());
    }
}

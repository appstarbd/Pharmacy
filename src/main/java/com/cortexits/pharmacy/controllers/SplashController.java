package com.cortexits.pharmacy.controllers;

import com.cortexits.pharmacy.managers.AppManager;
import com.cortexits.pharmacy.managers.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashController extends BaseController {

    @FXML
    private Text brandText;
    @FXML
    private Label progressText;
    @FXML
    private ProgressBar progressBar;
//    private Task<Integer> task;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final Task<ObservableList<String>> task = new Task<>() {
            @Override
            protected ObservableList<String> call() throws InterruptedException {
//                ObservableList<String> foundFriends = FXCollections.observableArrayList();
                ObservableList<String> checkList =
                        FXCollections.observableArrayList(
                                "Connecting Database", "Checking Database", "Checking Authentication", "Loading Modules",
                                "Fetching Initial Data", "Generating View", "Completing Check"
                        );

                updateMessage("Loading...");
                for (int i = 0; i < checkList.size(); i++) {
                    Thread.sleep(500);
                    updateProgress(i + 1, checkList.size());
                    String nextCheck = checkList.get(i);
//                    foundFriends.add(nextCheck);
                    updateMessage(nextCheck);
                }
//                Thread.sleep(400);
                updateMessage("All done.");

//                return foundFriends;
                return checkList;
            }
        };

//        showSplash(
//                initStage,
//                friendTask,
//                () -> showMainStage(friendTask.valueProperty())
//        );
        progressText.textProperty().bind(task.messageProperty());
        progressBar.progressProperty().bind(task.progressProperty());
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                try {
                    AppManager.startApplication(new Stage());
//                    AppManager.startApplication(ViewManager.getStage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        new Thread(task).start();
//        task.run();
    }
//    public void initialize(URL location, ResourceBundle resources) {
//        task = new Task<>() {
//            @Override
//            protected Integer call() throws Exception {
//                int iterations;
//                for (iterations = 0; iterations < 1000; iterations++) {
//                    if (isCancelled()) {
//                        updateMessage("Cancelled");
//                        break;
//                    }
//                    Thread.sleep(5);
//                    System.out.println("Iteration " + iterations);
//                    updateMessage("Iteration " + iterations);
//                    updateProgress(iterations, 1000);
//                }
//                return iterations;
//            }
//        };
//        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
//                ViewManager.getStage().hide();
//                System.out.println("hide");
//                try {
////                    AppManager.setAuth(true);
//                    AppManager.startApplication(new Stage());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
////        task.run();
//        new Thread(task).start();
////        progressBar.
//    }
}

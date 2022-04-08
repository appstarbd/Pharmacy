package com.cortexits.pharmacy.controllers;

import com.cortexits.pharmacy.managers.AppManager;
import com.cortexits.pharmacy.utils.PrefetchFeature;
import com.cortexits.pharmacy.utils.PrefetchList;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SplashController extends BaseController {

    @FXML
    private Text brandText;
    @FXML
    private Label progressText;
    @FXML
    private ProgressBar progressBar;
    private Task<PrefetchList[]> task;

    private PrefetchFeature prefetchFeature;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prefetchFeature = PrefetchFeature.getInstance();
        task = new Task<>() {
            @Override
            protected PrefetchList[] call() throws InterruptedException {
                PrefetchList[] checkList = PrefetchList.values();

                updateMessage("Loading...");
                for (PrefetchList param : checkList) {
                    Thread.sleep(500);
                    updateProgress(param.ordinal() + 1, checkList.length);
                    updateMessage(param.get());
                    prefetchFeature.check(param);
                }
                updateMessage("All done.");

                return checkList;
            }
        };
        progressText.textProperty().bind(task.messageProperty());
        progressBar.progressProperty().bind(task.progressProperty());
        task.setOnSucceeded(event -> {
            try {
                AppManager.startApplication(new Stage());
//                    AppManager.startApplication(ViewManager.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        new Thread(task).start();
//        task.run();
    }
}

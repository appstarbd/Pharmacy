package com.cortexits.pharmacy.controllers;

import com.cortexits.pharmacy.managers.ViewManager;
import com.cortexits.pharmacy.views.NotificationView;
import com.cortexits.pharmacy.views.popover.PopOver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class TopBarController extends BaseController {

    @FXML
    private HBox topBar;
    @FXML
    private Button notificationButton;
    @FXML
    private Label notificationCount;
    @FXML
    private Button messageNotification;

    private NotificationView notificationView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        notificationView = new NotificationView();
        notificationCount.setText(notificationView.getCountString());
    }

    @FXML
    private void onSearchAction(MouseEvent event) {
////        popOver = createPopOver();
//        if (!popOver.isDetached()) {
//            popOver.hide();
//        }
//
//        System.out.println("popover showing: " + popOver.isShowing());
//        if (popOver.isShowing()) {
//            popOver.hide(Duration.ZERO);
//        }
//        popOver.show(((TextField) event.getSource()), event.getX(), event.getY());
////        popOver2.show(ViewManager.getStage(), event.getX(), event.getY());
    }

    @FXML
    private void onNotificationAction(MouseEvent event) {
//        notificationView.setOwner(notificationButton);
        notificationView.setOwner(ViewManager.getStage());
        notificationView.show();
    }

    @FXML
    private void onMessageNotificationAction(MouseEvent event) {
    }

}

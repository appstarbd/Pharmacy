package com.cortexits.pharmacy.controllers;

import com.cortexits.pharmacy.managers.ViewManager;
import com.cortexits.pharmacy.utils.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class SidebarController extends BaseController {

    @FXML
    public VBox sideButtonHolder;

    @FXML
    public ToggleButton dashboardButton;
    @FXML
    public ToggleGroup sideMenuGroup;
    @FXML
    public Button powerButton;

    private SideButton posButton;
    private SideButton inventoryButton;
//    private SideButton stockButton;
    private SideButton customerButton;
//    private SideButton stockAdjustButton;
//    private SideButton settingsButton;
    private SideButton reportButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Tooltip dashboardTooltip = new Tooltip("Dashboard");
        dashboardTooltip.setShowDelay(new Duration(0));
        dashboardButton.setTooltip(dashboardTooltip);
        Tooltip powerOffTooltip = new Tooltip("Exit");
        powerOffTooltip.setShowDelay(new Duration(0));
        powerButton.setTooltip(powerOffTooltip);

//        posButton = new SideButton(View.POS_SALE, Icon.POINT_OF_SALE, "POS Sale");
        posButton = new SideButton(sideMenuGroup, View.POS_SALE, Icon.POINT_OF_SALE);
//        inventoryButton = new SideButton(View.MEDICINE, Icon.PILL, "Medicine");
        inventoryButton = new SideButton(sideMenuGroup, View.MEDICINE, Icon.PILL);
//        customerButton = new SideButton(View.CUSTOMER, Icon.ACCOUNT, "Customer");
        customerButton = new SideButton(sideMenuGroup, View.CUSTOMER, Icon.ACCOUNT);
//        reportButton = new SideButton(View.AUTH, Icon.FINANCE, "Report");
        reportButton = new SideButton(sideMenuGroup, View.AUTH, Icon.FINANCE);
//        sideMenuGroup.getToggles().addAll(posButton, inventoryButton, customerButton, reportButton);
        sideButtonHolder.getChildren().setAll(posButton, inventoryButton, customerButton/*, stockButton*//*, stockAdjustButton*//*, settingsButton*/, reportButton);
    }

    @FXML
    protected void onDashboardAction() throws IOException {
//        StageManager.setContentPane("Dashboard", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/dashboard.fxml"))));
        ViewManager.setView("Dashboard", View.DASHBOARD);
        if (dashboardButton.isArmed()) {
            dashboardButton.setSelected(true);
        }
    }

    @FXML
    protected void onPowerAction() {
        Alert powerOffAlert = new Alert(Alert.AlertType.WARNING,"Do you really want to close this application?", ButtonType.YES, ButtonType.NO);
        powerOffAlert.initModality(Modality.APPLICATION_MODAL);
        powerOffAlert.initStyle(StageStyle.UNDECORATED);
        powerOffAlert.initOwner(ViewManager.getStage());
        powerOffAlert.showAndWait()
                .filter(response -> response == ButtonType.YES)
                .ifPresent(response -> Platform.exit());


//        com.cortexits.pharmacy.helpers.MyHelper.printFiles("views", "fxml");
//        com.cortexits.pharmacy.helpers.MyHelper.printFxmlFiles(null);
//        com.cortexits.pharmacy.helpers.MyHelper.printFxmlFiles("management");
        com.cortexits.pharmacy.helpers.MyHelper.printIconFiles();
    }
}

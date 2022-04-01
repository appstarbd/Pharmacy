package com.cortexits.pharmacy.controllers;

import com.cortexits.pharmacy.managers.MenuManager;
import com.cortexits.pharmacy.managers.ViewManager;
import com.cortexits.pharmacy.utils.Icon;
import com.cortexits.pharmacy.utils.View;
import com.cortexits.pharmacy.utils.Views;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends BaseController {

//    @FXML
//    private MenuBar menuBar;
    @FXML
    private Text titleText;
    @FXML
    private AnchorPane contentPane;
//    private ScrollPane contentPane;
//    private StackPane contentPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        ViewManager.setMenuBar(menuBar);
        ViewManager.setTitleText(titleText);
        ViewManager.setContainer(contentPane);

//        initMenus();

        try {
//            StageManager.setContentPane("Dashboard", FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/dashboard.fxml"))));
//            ViewManager.setView("Dashboard", View.DASHBOARD);
            ViewManager.setView(View.DASHBOARD);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void initMenus() {
//
////        EventHandler<ActionEvent> handler = event -> {
////            try {
////                ViewManager.setView("Manufacturer", Views.AUTH);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        };
//
//        Menu managementMenu = MenuManager.getInstance()
//                .menu("Management")
//                .item("Medicine", Icon.PILL, this::medicineAction)
//                .item("Manufacturer", Icon.FACTORY, this::manufacturerAction)
////                .item("Manufacturer", handler)
////                .item("Supplier", this::supplierAction)
//                .item("Purchase", Icon.CART_VARIANT, this::purchaseAction)
//                .item("Stock", Icon.ARCHIVE, this::stockAction)
//                .item("Return", Icon.CASH_REFUND, this::returnAction)
//                .build();
//
//        Menu payrollMenu = MenuManager.getInstance()
//                .menu("Payroll")
//                .item("Employee", Icon.ACCOUNT_GROUP, this::employeeAction)
//                .item("Attendance", Icon.BADGE_ACCOUNT, this::attendanceAction)
//                .item("Salary", Icon.CASH_MULTIPLE, this::salaryAction)
//                .item("Leave", Icon.BEACH, this::leaveAction)
//                .build();
//
//        Menu customerMenu = MenuManager.getInstance()
//                .menu("Customer")
//                .item("Customer", Icon.ACCOUNT, this::customerAction)
//                .item("Credit Customer", Icon.ACCOUNT_CASH, this::customerAction)
//                .build();
//
//        Menu reportMenu = MenuManager.getInstance()
//                .menu("Reports")
////                .item("Customer", Icon.ACCOUNT, this::customerAction)
////                .item("Credit Customer", Icon.ACCOUNT_CASH, this::customerAction)
//                .build();
//
//        Menu settingsMenu = MenuManager.getInstance()
//                .menu("Settings")
//                .build();
//
//        Menu aboutMenu = MenuManager.getInstance()
//                .menu("About")
//                .item("What is PharmaBiller", Icon.LOGO)
//                .item("How to use", Icon.FOLDER_QUESTION)
//                .item("Tips of the Day", Icon.LIGHTBULB_MULTIPLE)
//                .item("Check for Update", Icon.FOLDER_ARROW_DOWN)
//                .item("Register", Icon.ACCOUNT_KEY)
//                .item("License", Icon.LICENSE)
////                .item("Watch Videos")
//                .item("Video Tutorials", Icon.YOUTUBE)
////                .item("About", this::aboutAction)
//                .build();
//
//        menuBar.getMenus().setAll(managementMenu, payrollMenu, customerMenu, reportMenu, settingsMenu, aboutMenu);
//    }

}

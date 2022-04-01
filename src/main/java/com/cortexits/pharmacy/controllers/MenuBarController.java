package com.cortexits.pharmacy.controllers;

import com.cortexits.pharmacy.managers.MenuManager;
import com.cortexits.pharmacy.managers.ViewManager;
import com.cortexits.pharmacy.utils.Icon;
import com.cortexits.pharmacy.utils.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuBarController extends BaseController {

    @FXML
    private MenuBar menuBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ViewManager.setMenuBar(menuBar);
        initMenus();
    }

    private void initMenus() {

//        EventHandler<ActionEvent> handler = event -> {
//            try {
//                ViewManager.setView("Manufacturer", Views.AUTH);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        };

        Menu managementMenu = MenuManager.getInstance()
                .menu("Management")
                .item("Medicine", Icon.PILL, this::medicineAction)
                .item("Manufacturer", Icon.FACTORY, this::manufacturerAction)
//                .item("Manufacturer", handler)
//                .item("Supplier", this::supplierAction)
                .item("Purchase", Icon.CART_VARIANT, this::purchaseAction)
                .item("Stock", Icon.ARCHIVE, this::stockAction)
                .item("Return", Icon.CASH_REFUND, this::returnAction)
                .build();

        Menu payrollMenu = MenuManager.getInstance()
                .menu("Payroll")
                .item("Employee", Icon.ACCOUNT_GROUP, this::employeeAction)
                .item("Attendance", Icon.BADGE_ACCOUNT, this::attendanceAction)
                .item("Salary", Icon.CASH_MULTIPLE, this::salaryAction)
                .item("Leave", Icon.BEACH, this::leaveAction)
                .build();

        Menu customerMenu = MenuManager.getInstance()
                .menu("Customer")
                .item("Customer", Icon.ACCOUNT, this::customerAction)
                .item("Credit Customer", Icon.ACCOUNT_CASH, this::creditCustomerAction)
                .build();

        Menu reportMenu = MenuManager.getInstance()
                .menu("Reports")
//                .item("Customer", Icon.ACCOUNT, this::customerAction)
//                .item("Credit Customer", Icon.ACCOUNT_CASH, this::customerAction)
                .build();

        Menu settingsMenu = MenuManager.getInstance()
                .menu("Settings")
                .build();

        Menu aboutMenu = MenuManager.getInstance()
                .menu("About")
                .item("What is PharmaBiller", Icon.LOGO)
                .item("How to use", Icon.FOLDER_QUESTION)
                .item("Tips of the Day", Icon.LIGHTBULB_MULTIPLE)
                .item("Check for Update", Icon.FOLDER_ARROW_DOWN)
                .item("Register", Icon.ACCOUNT_KEY)
                .item("License", Icon.LICENSE)
//                .item("Watch Videos")
                .item("Video Tutorials", Icon.YOUTUBE)
//                .item("About", this::aboutAction)
                .build();

        menuBar.getMenus().setAll(managementMenu, payrollMenu, customerMenu, reportMenu, settingsMenu, aboutMenu);
    }

    private void medicineAction(ActionEvent event) {
        try {
            ViewManager.setView("Medicine", View.MANAGEMENT_MEDICINE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void manufacturerAction(ActionEvent event) {
        try {
            ViewManager.setView("Manufacturer", View.MANAGEMENT_MANUFACTURER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void supplierAction(ActionEvent event) {
        try {
            ViewManager.setView("Supplier", View.MANAGEMENT_SUPPLIER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void purchaseAction(ActionEvent event) {
        try {
            ViewManager.setView("Purchase", View.MANAGEMENT_PURCHASE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stockAction(ActionEvent event) {
        try {
            ViewManager.setView("Stock", View.MANAGEMENT_STOCK);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void returnAction(ActionEvent event) {
        try {
            ViewManager.setView("Return", View.MANAGEMENT_RETURN);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void customerAction(ActionEvent event) {
        try {
            ViewManager.setView("Customer", View.MANAGEMENT_CUSTOMER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void creditCustomerAction(ActionEvent event) {
        try {
            ViewManager.setView("Credit Customer", View.MANAGEMENT_CREDIT_CUSTOMER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void employeeAction(ActionEvent event) {
        try {
            ViewManager.setView("Employee", View.MANAGEMENT_EMPLOYEE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void attendanceAction(ActionEvent event) {
        try {
            ViewManager.setView("Attendance", View.MANAGEMENT_ATTENDANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void salaryAction(ActionEvent event) {
        try {
            ViewManager.setView("Salary", View.MANAGEMENT_SALARY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void leaveAction(ActionEvent event) {
        try {
            ViewManager.setView("Leave", View.MANAGEMENT_LEAVE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void aboutAction(ActionEvent event) {
        Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION, "About PharmaBiller");
        aboutAlert.initStyle(StageStyle.UNDECORATED);
//        aboutAlert.initOwner();
        aboutAlert.showAndWait();
    }
}

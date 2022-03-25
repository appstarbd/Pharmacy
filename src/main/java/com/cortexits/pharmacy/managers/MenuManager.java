package com.cortexits.pharmacy.managers;

import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.utils.Icon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

public class MenuManager extends BaseManager implements EventHandler<ActionEvent> {
    private static MenuManager instance;

    private Menu menu;
    private MenuItem menuItem;

    public MenuManager() {
    }

    public static MenuManager getInstance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    public MenuManager menu(String menuName) {
        menu = new Menu(menuName);
        return getInstance();
    }

    public MenuManager menu(String menuName, Icon icon) {
        menu(menuName);
        Image menuImage = getImage(icon);
        ImageView imageView = new ImageView(menuImage);
        imageView.setFitWidth(18d);
        imageView.setFitHeight(18d);
        menu.setGraphic(imageView);
        return getInstance();
    }

    public MenuManager item(String menuItemName) {
        menuItem = new MenuItem(menuItemName);
        menu.getItems().add(menuItem);
        return getInstance();
    }

    public MenuManager item(String menuItemName, Icon icon) {
        menuItem = new MenuItem(menuItemName);
//        item(menuItemName);
        Image itemImage = getImage(icon);
//        Image image = new Image(icon.get());
        ImageView imageView = new ImageView(itemImage);
        imageView.setFitWidth(18);
        imageView.setFitHeight(18d);
        menuItem.setGraphic(imageView);
        menu.getItems().add(menuItem);
        return getInstance();
    }

    public MenuManager item(String menuItemName, EventHandler<ActionEvent> event) {
//    public MenuManager with(String menuItemName, ActionEvent event) {
        menuItem = new MenuItem(menuItemName);
        menuItem.setOnAction(event);
//        item(menuItemName);
        menu.getItems().add(menuItem);
        return getInstance();
    }

    public MenuManager item(String menuItemName, Icon icon, EventHandler<ActionEvent> event) {
        menuItem = new MenuItem(menuItemName);
        Image itemImage = getImage(icon);
        ImageView imageView = new ImageView(itemImage);
//        imageView.setFitWidth(18);
//        imageView.setFitHeight(18d);
        menuItem.setGraphic(imageView);
        menuItem.setOnAction(event);
        menu.getItems().add(menuItem);
        return getInstance();
    }

    public Menu build() {
        return menu;
    }

    private Image getImage(Icon icon) {
        Image image = new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream(icon.get())));
        return image;
    }

//    private boolean initMenus() {
//        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
//        Menu medicineMenu = new Menu("Medicine");
////        medicineMenu.setMnemonicParsing(true);
//        MenuItem addMedicine = new MenuItem("Add New");
////        addMedicine.setAccelerator(KeyCombination.keyCombination(KeyCode.N));
//        MenuItem addMedicineCategory = new MenuItem("Category");
//        MenuItem addMedicineGroup = new MenuItem("Group");
//        MenuItem addMedicineUnit = new MenuItem("Unit");
//        MenuItem addMedicineLeaf = new MenuItem("Leaf");
//        medicineMenu.getItems().setAll(addMedicine, addMedicineCategory, addMedicineGroup, addMedicineUnit, addMedicineLeaf);
//
////        Menu manufacturerMenu = new Menu("Manufacturer");
////        MenuItem manufacturerMenuItem = new MenuItem("Manage Manufacturer");
////        manufacturerMenu.getItems().add(manufacturerMenuItem);
////        manufacturerMenuItem.setOnAction(new EventHandler<ActionEvent>() {
////            @Override
////            public void handle(ActionEvent event) {
////                try {
////                    ViewManager.setView("Manufacturer", Views.AUTH);
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            }
////        });
////        Menu supplierMenu = new Menu("Supplier");
////        Menu purchaseMenu = new Menu("Purchase");
////        Menu stockMenu = new Menu("Stock");
////        Menu returnMenu = new Menu("Return");
////        Menu payrollMenu = new Menu("Payroll");
////        Menu customerMenu = new Menu("Customer");
//        Menu managementMenu = new Menu("Management");
//        MenuItem manufacturerMenuItem = new MenuItem("Manufacturer");
//        MenuItem supplierMenuItem = new MenuItem("Supplier");
//        MenuItem purchaseMenuItem = new MenuItem("Purchase");
//        MenuItem stockMenuItem = new MenuItem("Stock");
//        MenuItem returnMenuItem = new MenuItem("Return");
//        MenuItem payrollMenuItem = new MenuItem("Payroll");
//        MenuItem customerMenuItem = new MenuItem("Customer");
//
//        managementMenu.getItems().addAll(manufacturerMenuItem, supplierMenuItem, purchaseMenuItem, stockMenuItem, returnMenuItem, payrollMenuItem, customerMenuItem);
//        manufacturerMenuItem.setOnAction(event -> {
//            try {
//                ViewManager.setView("Manufacturer", "views/management/manufacturer.fxml");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        Menu settingsMenu = new Menu("Settings");
//
//        Menu aboutMenu = new Menu("About");
//        MenuItem whatIsMenuItem = new MenuItem("What is PharmaBiller");
//        MenuItem howToMenuItem = new MenuItem("How to use");
//        MenuItem tipsMenuItem = new MenuItem("Tips of the Day");
//        MenuItem updateMenuItem = new MenuItem("Check for Update");
//        MenuItem registerMenuItem = new MenuItem("Register");
//        MenuItem licenseMenuItem = new MenuItem("License");
//        MenuItem videoMenuItem = new MenuItem("Watch Videos");
//        MenuItem aboutMenuItem = new MenuItem("About");
//        aboutMenu.getItems().setAll(whatIsMenuItem, howToMenuItem, tipsMenuItem, new SeparatorMenuItem(), updateMenuItem, registerMenuItem, licenseMenuItem, new SeparatorMenuItem(), videoMenuItem, aboutMenuItem);
////        menuBar.getMenus().setAll(medicineMenu, /*manufacturerMenu,*/ supplierMenu, purchaseMenu, stockMenu, returnMenu, payrollMenu, customerMenu, managementMenu, settingsMenu, aboutMenu);
//        return appMenuBar.getMenus().setAll(medicineMenu, managementMenu, settingsMenu, aboutMenu);
//    }

    @Override
    public void handle(ActionEvent event) {
    }
}

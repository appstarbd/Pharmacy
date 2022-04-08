/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cortexits.pharmacy.auth;

import com.cortexits.pharmacy.controllers.BaseController;
import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.customer.Customer;
import com.cortexits.pharmacy.managers.AppManager;
import com.cortexits.pharmacy.managers.ViewManager;
import com.cortexits.pharmacy.model.BaseModel;
import com.cortexits.pharmacy.model.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 *
 * @author imran
 */
public class AuthController extends BaseController {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField userPass;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void onLoginAction(ActionEvent e) throws IOException {
        String username = userName.getText();
        String password = userPass.getText();
//        AppManager.setAuth(Objects.equals(username, password));
        AppManager.doLogin(username, password);

//        Customer customer = new Customer();
//        customer.find();
//        find();
//        User user = new User();
//        user.setFirstName("Imran");
//        user.setLastName("Khan");
//        user.setPhoneNo("01852362788");
//        user.setEmail("imrankhan.cse24@gmail.com");
//        user.setPassword("123456");
//        user.save();

//        User user = new User();
//        System.out.println(user.getAll());
//        System.out.println(User.getInstance().find(1));
//        System.out.println(User.getInstance().checkUser(username, password));
    }

    @FXML
    public void onCancelAction() {
        AppManager.shutdown();
    }
}

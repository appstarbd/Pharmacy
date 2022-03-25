/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cortexits.pharmacy.auth;

import com.cortexits.pharmacy.controllers.BaseController;
import com.cortexits.pharmacy.MainApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author imran
 */
public class AuthController extends BaseController {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void onLoginAction(ActionEvent e) throws IOException {
        MainApplication mainApplication = new MainApplication();

//        Scene scene = ((Scene) e.getSource()).getWindow().getScene();
//        scene.getWindow().hide();
//        Window window = ((Window) e.getSource()).getScene().getWindow();
//        mainApplication.start(new Stage());
    }

    @FXML
    public void onCancelAction() {
        Platform.exit();
    }
}

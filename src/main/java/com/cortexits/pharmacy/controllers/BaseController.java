/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cortexits.pharmacy.controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author imran
 */
public abstract class BaseController implements Initializable {
//    @FXML
//    private Text titleText;
//    @FXML
////    private AnchorPane contentPane;
//    private ScrollPane contentPane;
//
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void find() {
        System.out.println(getClass().getName());
    }
    public void findAll() {}
    public void get() {}
    public void getAll() {}
    public void save() {}
    public void update() {}
    public void saveOrUpdate() {}
    public void destroy() {}
    
}

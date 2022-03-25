package com.cortexits.pharmacy.managers;

import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Screen;

public abstract class BaseManager {

    protected String theme = "default";
    protected Screen primaryScreen = Screen.getPrimary();
    protected Rectangle2D rectangle2D = primaryScreen.getBounds();
    protected ObservableList<Screen> screens = Screen.getScreens();

    protected MenuBar appMenuBar;

//    abstract void getMenus();

}

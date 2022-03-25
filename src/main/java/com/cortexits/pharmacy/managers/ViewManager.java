package com.cortexits.pharmacy.managers;

import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.utils.Icon;
import com.cortexits.pharmacy.utils.View;
import com.cortexits.pharmacy.utils.Views;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by Andreas on 6/14/16.
 */
public class ViewManager extends BaseManager {

    public enum VIEW {
        AUTH, MAIN
    }

    private static MenuBar menuBar;
    private static Text titleText;
    private static Stage stage;
    private static Scene scene;
    private static FXMLLoader fxmlLoader;
//    private static AnchorPane contentPane;
    private static ScrollPane contentPane;

    public ViewManager(Stage stage) throws IOException {
        ViewManager.stage = stage;
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(Views.MAIN));
////        int width = (int) rectangle2D.getWidth();
////        width = width / 2;
////        int height = (int) rectangle2D.getHeight();
//////        height = height / 2;
////        Scene scene = new Scene(fxmlLoader.load(), width, height);
//        Scene scene = new Scene(fxmlLoader.load());
////        scene.getStylesheets().add(MainApplication.class.getResource("themes/" + theme + "/main.css").toExternalForm());
////        stage.initStyle(StageStyle.UNDECORATED);
////        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.setTitle(AppManager.getName());
//        stage.getIcons().add(new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream("images/yellow-pill.png"))));
//        stage.setScene(scene);
//        stage.toFront();
//        stage.centerOnScreen();
////        stage.setAlwaysOnTop(true);
//        stage.show();
    }

//    public ViewManager(Stage stage) throws IOException {
//        ViewManager.stage = stage;
////        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("views/auth.fxml"));
//////        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
////        ViewManager.scene = new Scene(fxmlLoader.load());
//////        scene.getStylesheets().add("com/cortexits/pharmacy/styles/auth.css");
//////        scene.getStylesheets().add(getClass().getResource("auth.css").toExternalForm());
////        ViewManager.stage.initStyle(StageStyle.UNDECORATED);
////        ViewManager.stage.setAlwaysOnTop(true);
//////        stage.toFront();
////        ViewManager.stage.setTitle("PMS :: Login");
////        ViewManager.stage.setScene(scene);
////        ViewManager.stage.show();
//    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ViewManager.stage = stage;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        ViewManager.scene = scene;
    }

    public static ScrollPane getContentPane() {
        return contentPane;
    }

    public static void setContentPane(ScrollPane contentPane) {
        ViewManager.contentPane = contentPane;
    }

    public static MenuBar getMenuBar() {
        return menuBar;
    }

    public static void setMenuBar(MenuBar menuBar) {
        ViewManager.menuBar = menuBar;
    }

    public static Text getTitleText() {
        return titleText;
    }

    public static void setTitleText(Text titleText) {
        ViewManager.titleText = titleText;
    }

//    public static Stage getStage() {
//        return stage;
//    }

    public static void setRoot(Parent root) {
        ViewManager.stage.getScene().setRoot(root);
    }

    public static void setContainer(ScrollPane contentPane) {
        ViewManager.contentPane = contentPane;
    }

    public static void setContentPane(Parent root) {
//        StageManager.contentPane.getChildren().setAll(root);
//        ViewManager.contentPane.setFitToWidth(true);
//        ViewManager.contentPane.setFitToHeight(true);
//        ViewManager.contentPane.setPannable(true);
//        ViewManager.contentPane.setManaged(false);
        ViewManager.contentPane.setContent(root);
    }

    public static void setContentPane(String title, Parent root) {
        ViewManager.titleText.setText(title);
//        StageManager.contentPane.getChildren().setAll(root);
        ViewManager.setContentPane(root);
    }

//    public static void setContentPane(AnchorPane root) {
//        StageManager.contentPane.setFitToWidth(true);
//        StageManager.contentPane.setFitToHeight(true);
//        StageManager.contentPane.setContent(root);
//    }

    public static void setView(String title, View view) throws IOException {
//        StageManager.titleText.setText(title);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource(view.get())));
        ViewManager.setContentPane(title, parent);
    }

    public static void setView(View view) throws IOException {
        setView(view.title(), view);
    }

    public static void showView(VIEW view) throws IOException {
        stage.getIcons().add(new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream(Icon.LOGO.get()))));
        stage.setTitle(AppManager.getName());
        stage.toFront();
        stage.centerOnScreen();
        if (view == VIEW.AUTH) {
            showAuth();
        } else {
            showMain();
        }
        stage.show();
    }

    public static void showView(View view, StageStyle stageStyle) throws IOException {
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource(view.get()));
        scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream(Icon.LOGO.get()))));
        stage.setTitle(AppManager.getName());
        stage.initStyle(stageStyle);
        stage.setScene(scene);
        stage.toFront();
        stage.requestFocus();
//        stage.setFullScreen(true);
        stage.setResizable(!stage.isFullScreen());
        stage.setMaximized(true);
        stage.show();
    }

    private static void showAuth() throws IOException {
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource(View.AUTH.get()));
        scene = new Scene(fxmlLoader.load());
        stage.initStyle(StageStyle.UNDECORATED);
//        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
    }

    private static void showMain() throws IOException {
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource(View.MAIN.get()));
        scene = new Scene(fxmlLoader.load());
//        scene.getStylesheets().add(MainApplication.class.getResource("themes/" + theme + "/main.css").toExternalForm());
        stage.initStyle(StageStyle.DECORATED);
//        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
//        stage.setAlwaysOnTop(true);
    }
}

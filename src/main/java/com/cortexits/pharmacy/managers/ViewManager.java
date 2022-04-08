package com.cortexits.pharmacy.managers;

import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.utils.Icon;
import com.cortexits.pharmacy.utils.View;
import com.cortexits.pharmacy.utils.Views;
import com.cortexits.pharmacy.views.Preloader;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.*;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by Andreas on 6/14/16.
 */
public class ViewManager extends BaseManager {

//    public enum VIEW {
//        AUTH, MAIN
//    }

    private static MenuBar menuBar;
    private static Text titleText;
    private static Stage stage;
    private static Scene scene;
    private static FXMLLoader fxmlLoader;
    private static AnchorPane contentPane;
//    private static ScrollPane contentPane;

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
        setStage(stage);
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
        ViewManager.stage.setOnCloseRequest(event -> {
            AppManager.shutdown();
            event.consume();
//            Alert powerOffAlert = new Alert(Alert.AlertType.WARNING,"Do you really want to close this application?", ButtonType.YES, ButtonType.NO);
//            powerOffAlert.initModality(Modality.APPLICATION_MODAL);
//            powerOffAlert.initStyle(StageStyle.UNDECORATED);
//            powerOffAlert.initOwner(ViewManager.getStage());
//            powerOffAlert.showAndWait()
//                    .filter(response -> response == ButtonType.YES)
//                    .ifPresentOrElse(event.consume(), Platform.exit());
        });
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        ViewManager.scene = scene;
    }

//    public static ScrollPane getContentPane() {
    public static AnchorPane getContentPane() {
        return contentPane;
    }

//    public static void setContentPane(ScrollPane contentPane) {
    public static void setContentPane(AnchorPane contentPane) {
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
//        ViewManager.stage.getScene().setRoot(root);
        ViewManager.scene.setRoot(root);
    }

//    public static void setContainer(ScrollPane contentPane) {
    public static void setContainer(AnchorPane contentPane) {
        ViewManager.contentPane = contentPane;
    }

    public static void setContentPane(Parent root) {
        Platform.runLater(() -> {
//            root.set;
//            StackPane stackPane = new StackPane(root, new Preloader());
            AnchorPane.setTopAnchor(root, 5d);
            AnchorPane.setRightAnchor(root, 5d);
            AnchorPane.setBottomAnchor(root, 5d);
            AnchorPane.setLeftAnchor(root, 5d);

            ViewManager.contentPane.getChildren().setAll(root);
//            ScrollPane scrollPane = new ScrollPane(root);
//            scrollPane.setFitToWidth(true);
//
//            AnchorPane.setTopAnchor(scrollPane, 10d);
//            AnchorPane.setRightAnchor(scrollPane, 10d);
//            AnchorPane.setBottomAnchor(scrollPane, 10d);
//            AnchorPane.setLeftAnchor(scrollPane, 10d);
//            ViewManager.contentPane.getChildren().setAll(scrollPane);

////        ViewManager.contentPane.setFitToWidth(true);
//        ViewManager.contentPane.setFitToHeight(false);
////        ViewManager.contentPane.setPannable(true);
////        ViewManager.contentPane.setManaged(false);
//        ViewManager.contentPane.setContent(root);
////        ViewManager.contentPane.vvalueProperty().addListener(new ChangeListener<Number>() {
////            public void changed(ObservableValue<? extends Number> ov,
////                                Number old_val, Number new_val) {
//////                fileName.setText(imageNames[(new_val.intValue() - 1)/100]);
////                System.out.println(old_val);
////                System.out.println(new_val);
////            }
////        });
////        ViewManager.contentPane.setPrefHeight(1012);
//            System.out.println(ViewManager.contentPane.getHeight());
        });

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

    public static Window getOwner() {
        return stage.getOwner();
    }

    public static Node getFocusOwner() {
        return getScene().getFocusOwner();
    }

//    public static void showView(VIEW view) throws IOException {
//        stage.getIcons().add(new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream(Icon.LOGO.get()))));
//        stage.setTitle(AppManager.getName());
//        stage.toFront();
//        stage.centerOnScreen();
//        if (view == VIEW.AUTH) {
//            showAuth();
//        } else {
//            showMain();
//        }
//        stage.show();
//        stage.setOnCloseRequest(event -> AppManager.shutdown());
//    }

    public static void showView(View view, StageStyle stageStyle) throws IOException {
        showView(view, stageStyle, false);
    }

    public static void showView(View view, boolean alwaysOnTop) throws IOException {
        showView(view, StageStyle.DECORATED, alwaysOnTop);
    }

    public static void showView(View view, StageStyle stageStyle, boolean alwaysOnTop) throws IOException {
        if (stage.isShowing()) {
            stage.hide();
        }
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource(view.get()));
        scene = new Scene(fxmlLoader.load());
//        scene = new Scene(fxmlLoader.load(), 1024, 768);
        stage.getIcons().add(new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream(Icon.LOGO.get()))));
        stage.setTitle(AppManager.getName());
        stage.initStyle(stageStyle);
        stage.setScene(scene);
        stage.toFront();
        stage.requestFocus();
//        stage.setFullScreen(true);
//        stage.setResizable(!stage.isFullScreen());
//        stage.setMaximized(true);
//        stage.setOnCloseRequest(event -> {
//            AppManager.shutdown();
//            event.consume();
////            Alert powerOffAlert = new Alert(Alert.AlertType.WARNING,"Do you really want to close this application?", ButtonType.YES, ButtonType.NO);
////            powerOffAlert.initModality(Modality.APPLICATION_MODAL);
////            powerOffAlert.initStyle(StageStyle.UNDECORATED);
////            powerOffAlert.initOwner(ViewManager.getStage());
////            powerOffAlert.showAndWait()
////                    .filter(response -> response == ButtonType.YES)
////                    .ifPresentOrElse(event.consume(), Platform.exit());
//        });
        stage.setAlwaysOnTop(alwaysOnTop);
        stage.show();
//        stage.showAndWait();
    }

//    private static void showAuth() throws IOException {
//        fxmlLoader = new FXMLLoader(MainApplication.class.getResource(View.AUTH.get()));
//        scene = new Scene(fxmlLoader.load());
//        stage.initStyle(StageStyle.UNDECORATED);
////        stage.setAlwaysOnTop(true);
//        stage.setScene(scene);
//    }

//    private static void showMain() throws IOException {
//        fxmlLoader = new FXMLLoader(MainApplication.class.getResource(View.MAIN.get()));
//        scene = new Scene(fxmlLoader.load());
////        scene.getStylesheets().add(MainApplication.class.getResource("themes/" + theme + "/main.css").toExternalForm());
//        stage.initStyle(StageStyle.DECORATED);
////        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.setScene(scene);
////        stage.setAlwaysOnTop(true);
//    }

    public static void hideActiveView() {
        if (stage != null && stage.isShowing()) {
            stage.hide();
//        } else {
//            throw new Exception();
        }
    }
}

package com.cortexits.pharmacy.views;

import com.cortexits.pharmacy.managers.ViewManager;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class AlertView {
    private static Alert alert;
    private static AlertView instance;

    static {
        instance = new AlertView();
    }

    public AlertView() {
    }

    public AlertView(AlertType alertType, String contentText) {
        createAlert(alertType, contentText);
    }

    public static AlertView show(String contentText) {
        createAlert(AlertType.NONE, contentText);
        return instance;
    }
    public static AlertView showInformation(String contentText) {
        createAlert(AlertType.INFORMATION, contentText);
        return instance;
    }
    public static AlertView showConfirmation(String contentText) {
        createAlert(AlertType.CONFIRMATION, contentText);
        return instance;
    }
    public static AlertView showWarning(String contentText) {
        createAlert(AlertType.WARNING, contentText);
        return instance;
    }
    public static AlertView showError(String contentText) {
        createAlert(AlertType.ERROR, contentText);
        return instance;
    }

    private static void createAlert(AlertType alertType, String contentText) {
        alert = new Alert(alertType, contentText);
        alert.initModality(Modality.APPLICATION_MODAL);
//        alert.initStyle(StageStyle.UNDECORATED);
        alert.initOwner(ViewManager.getStage());
//        alert.setContentText(contentText);
//        alert.set
        alert.showAndWait();
    }

//    public void open() {
//        alert.showAndWait();
////                .filter(response -> response == ButtonType.YES);
////                .ifPresentOrElse(, Platform.exit());
////                .ifPresent(response -> Platform.exit());
////        return getResult();
//    }

    public void setButtons(ButtonType... buttonTypes) {
        alert.getButtonTypes().addAll(buttonTypes);
    }

    public void setPositive(ButtonType... buttonTypes) {
        alert.getButtonTypes().addAll(buttonTypes);
    }

    public Boolean isPositive() {
        ButtonType result = alert.getResult();
        return (ButtonType.OK.equals(result) || ButtonType.YES.equals(result) || ButtonType.APPLY.equals(result) || ButtonType.FINISH.equals(result));
    }

    public void setNegative(ButtonType... buttonTypes) {
        alert.getButtonTypes().addAll(buttonTypes);
    }

    public Boolean isNegative() {
        ButtonType result = alert.getResult();
        return (ButtonType.NO.equals(result) || ButtonType.CANCEL.equals(result) || ButtonType.CLOSE.equals(result));
    }

    public static Dialog<ButtonType> createExceptionDialog(Throwable th) {
        return createExceptionDialog(th, "Exception stacktrace:");
    }
    public static Dialog<ButtonType> createExceptionDialog(Throwable th, String contentText) {
        Dialog<ButtonType> dialog = new Dialog<>();

        dialog.setTitle("Program exception");

        final DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.setContentText("Details of the problem:");
        dialogPane.getButtonTypes().addAll(ButtonType.OK);
        dialogPane.setContentText(th.getMessage());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(ViewManager.getStage());

        Label label = new Label(contentText);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        th.printStackTrace(pw);
        pw.close();

        TextArea textArea = new TextArea(sw.toString());
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane root = new GridPane();
        root.setVisible(false);
        root.setMaxWidth(Double.MAX_VALUE);
        root.add(label, 0, 0);
        root.add(textArea, 0, 1);
        dialogPane.setExpandableContent(root);
        dialog.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> System.out.println("The exception was approved"));
        return dialog;
    }

}

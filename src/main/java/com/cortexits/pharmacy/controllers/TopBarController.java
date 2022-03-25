package com.cortexits.pharmacy.controllers;

import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.managers.ViewManager;
import com.cortexits.pharmacy.utils.Popover;
import com.cortexits.pharmacy.utils.View;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;

import java.net.URL;
import java.util.ResourceBundle;

public class TopBarController extends BaseController {
    @FXML
    private Button notificationButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Popup popup = new Popup();
//        Parent parent = FXMLLoader.load(MainApplication.class.getResourceAsStream(View.DASHBOARD.get()));
//        popup.getContent().add(notificationButton);
//        popup.show(ViewManager.getStage());
//        popup.getContent().add(new Label("LLLLLLLLLLL"));

//        notificationButton.setOnAction(e -> {
////            if (!popup.isShowing())
////                popup.show(ViewManager.getStage());
////            else
////                popup.hide();
//            // CREATE ROOT
//
//        });

        Pane root = new Pane() {
            @Override protected void layoutChildren() {
                super.layoutChildren();
                final double w = getWidth();
                final double h = getHeight();
//                    final double menuHeight = SHOW_MENU ? menuBar.prefHeight(w) : 0;
//                    final double toolBarHeight = toolBar.prefHeight(w);
//                    if (menuBar != null) {
//                        menuBar.resize(w, menuHeight);
//                    }
//                    toolBar.resizeRelocate(0, menuHeight, w, toolBarHeight);
//                    pageBrowser.setLayoutY(toolBarHeight + menuHeight);
//                    pageBrowser.resize(w, h-toolBarHeight);
//                    pageBrowser.resize(w, h - toolBarHeight - menuHeight);
//                    sampleListPopover.autosize();
//                    Point2D listBtnBottomCenter = listButton.localToScene(listButton.getWidth()/2, listButton.getHeight());
//                    sampleListPopover.setLayoutX((int)listBtnBottomCenter.getX()-50);
//                    sampleListPopover.setLayoutY((int)listBtnBottomCenter.getY()+20);
//                    Point2D searchBoxBottomCenter = searchBox.localToScene(searchBox.getWidth()/2, searchBox.getHeight());
//                    searchPopover.setLayoutX((int)searchBoxBottomCenter.getX()-searchPopover.getLayoutBounds().getWidth()+50);
//                    searchPopover.setLayoutY((int)searchBoxBottomCenter.getY()+20);
            }
        };
        // create and setup list popover
        Popover sampleListPopover = new Popover();
        sampleListPopover.setPrefWidth(440);
        root.getChildren().add(sampleListPopover);
//            final SamplePopoverTreeList rootPage = new SamplePopoverTreeList(Samples.ROOT,pageBrowser);
        notificationButton.setOnMouseClicked((MouseEvent e) -> {
            if (sampleListPopover.isVisible()) {
                sampleListPopover.hide();
            } else {
                sampleListPopover.clearPages();
//                    sampleListPopover.pushPage(rootPage);
                sampleListPopover.show();
//                    sampleListPopover.show(() -> {
//                        listButton.setSelected(false);
//                    });
            }
        });
    }
}

package com.cortexits.pharmacy.utils;

import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.managers.ViewManager;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class SideButton extends ToggleButton {
    String title;
    Image image;
    ImageView imageView;
    View view;

    public SideButton() {}

//    public SideButton(String title, String image) {
//        this.title = title;
////        setText(title);
////        setContentDisplay(ContentDisplay.TOP);
////        setFont(Font.font(10d));
////        setPrefSize(60, 60);
//        setImageIcon(image);
//        Tooltip tooltip = new Tooltip(title);
//        tooltip.setShowDelay(new Duration(0));
//        setTooltip(tooltip);
//    }

//    public SideButton(String title, String image, View view) {
//        this(title, image);
//        this.view = view;
//        attachView(view);
//    }

    public SideButton(View view, Icon icon) {
        this(view.title(), view, icon);
    }
    public SideButton(ToggleGroup toggleGroup, View view, Icon icon) {
        this(view.title(), view, icon);
        setToggleGroup(toggleGroup);
    }

    public SideButton(String title, View view, Icon icon) {
        this.title = title;
        setImageIcon(icon);
        Tooltip tooltip = new Tooltip(title);
        tooltip.setShowDelay(new Duration(0));
        setTooltip(tooltip);

        this.view = view;
        attachView(view);
    }

    public void setImageIcon(Icon image) {
//        this.image = new Image(image.get());
        this.image = new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream(image.get())));
        imageView = new ImageView(this.image);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
        setGraphic(imageView);
//        System.out.println("image: " + this.image);
//        System.out.println("image: " + image);
    }

    public void attachView(View view) {
        setOnAction(e -> {
            try {
                if (isArmed()) {
                    setSelected(true);
                }
                ViewManager.setView(title, view);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

//    @Override
//    public void fire() {
////        super.fire();
//        System.out.println("fire...");
//        try {
//            attachView(view);
////                StageManager.setView(title, view);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
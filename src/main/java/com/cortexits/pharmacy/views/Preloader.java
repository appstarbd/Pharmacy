package com.cortexits.pharmacy.views;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Preloader extends Pane {
    private ProgressIndicator progressIndicator;

    public Preloader() {
//        super();
        setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(0), Insets.EMPTY)));
        progressIndicator = new ProgressIndicator(ProgressIndicator.INDETERMINATE_PROGRESS);
        getChildren().add(progressIndicator);
//        set
    }

//    @Override
//    public Node getStyleableNode() {
//        return super.getStyleableNode();
//    }

//    public boolean isVisible() {
    public boolean isShowing() {
        return super.isVisible();
    }

    public void show() {
        setVisible(true);
    }

    public void hide() {
        setVisible(false);
    }
}

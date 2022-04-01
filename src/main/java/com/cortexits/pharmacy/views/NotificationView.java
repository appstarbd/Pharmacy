package com.cortexits.pharmacy.views;

import com.cortexits.pharmacy.managers.ViewManager;
import com.cortexits.pharmacy.views.popover.PopOver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Window;
import javafx.util.Duration;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationView extends Pane {

    private PopOver popOver;
    private Node node;

    private NotificationList notificationList;

    public NotificationView() {
        this.layoutChildren();
        notificationList = new NotificationList();
        getChildren().add(notificationList);
        popOver = createPopOver();
//        node = ViewManager.getStage().getScene().getFocusOwner();
    }

    public NotificationView(Node owner) {
        this();
        node = owner;
    }

    public void show() {
        if (!popOver.isDetached()) {
            System.out.println("detached");
            popOver.hide(Duration.ZERO);
        }

        if (popOver != null && popOver.isShowing()) {
            System.out.println("showing");
            popOver.hide(Duration.ZERO);
        }
        popOver.setContentNode(this);
        popOver.show(node);
    }

    public void setOwner(Node owner) {
        node = owner;
    }

    public void setOwner(Window owner) {
        node = owner.getScene().getFocusOwner();
//        node = owner.getScene().getRoot();
    }

    private PopOver createPopOver() {
        PopOver popOver = new PopOver();
//        popOver.setDetachable(detachable.isSelected());
//        popOver.setDetachable(true);
//        popOver.setDetached(detached.isSelected());
//        popOver.setDetached(false);
//        popOver.arrowSizeProperty().bind(masterArrowSize);
//        popOver.setArrowSize(0);
        popOver.setArrowLocation(PopOver.ArrowLocation.TOP_CENTER);
//        popOver.arrowIndentProperty().bind(masterArrowIndent);
//        popOver.setArrowIndent(0);
//        popOver.arrowLocationProperty().bind(masterArrowLocation);
//        popOver.cornerRadiusProperty().bind(masterCornerRadius);
//        popOver.headerAlwaysVisibleProperty().bind(masterHeaderAlwaysVisible);
//        popOver.setHeaderAlwaysVisible(false);
//        popOver.setAnimated(animated.isSelected());
        popOver.setAnimated(true);
//        popOver.closeButtonEnabledProperty().bind(closeButtonEnabled.selectedProperty());
        return popOver;
    }

    public int getCount() {
        return notificationList.getSize();
    }

    public String getCountString() {
        int n = notificationList.getSize();
        return n > 100 ? "99+" : String.valueOf(n) ;
    }

    /**
     * class T
     */
    static class NotificationList extends ListView<Number> {

        final Number[] data = {
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                100.00, -12.34, 33.01,71.00, 23000.00, -6.00, 0, 42223.00, -12.05,
                500.00, 430000.00, 1.00, -4.00, 1922.01, -90.00, 11111.00,
                500.00, 430000.00, 1.00, -4.00, 1922.01, -90.00, 11111.00,
                500.00, 430000.00, 1.00, -4.00, 1922.01, -90.00, 11111.00,
                500.00, 430000.00, 1.00, -4.00, 1922.01, -90.00, 11111.00,
                500.00, 430000.00, 1.00, -4.00, 1922.01, -90.00, 11111.00,
                3901349.00, 12.00, -1.00, -2.00, 15.00, 47.50, 12.11
        };

        public NotificationList() {
            final ObservableList numbers = FXCollections.<Number>observableArrayList(Arrays.asList(data));
            setItems(numbers);
//            List<VBox> vBox = new ArrayList<>();
//            for (int i = 1; i <= 10; ++i) {
//                VBox box = new VBox(new Circle(10, 10, 10 * i, Color.RED));
//                vBox.add(box);
//            }
////            vBox.getChildren().addAll();
//            ObservableList<VBox> boxes = FXCollections.observableArrayList(vBox);
//            setItems(boxes);
            getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            setCellFactory((ListView<java.lang.Number> list) ->
                    new MoneyFormatCell());
        }

//        public NotificationList(ObservableList<T> items) {
//            super(items);
//        }

        public Parent createContent() {

            final ObservableList<Number> numbers =
                    FXCollections.<Number>observableArrayList(Arrays.asList(data));
            final ListView<Number> listView = new ListView<>(numbers);

            listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listView.setCellFactory((ListView<java.lang.Number> list) ->
                    new MoneyFormatCell());

            return listView;
        }

        public int getSize() {
            return getItems().size();
        }

        static class MoneyFormatCell extends ListCell<Number> {
            @Override
            public void updateItem(Number item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null) {
                    setText("");
                    return;
                }

                // format the number as if it were a monetary value using the
                // formatting relevant to the current locale. This would format
                // 43.68 as "$43.68", and -23.67 as "($23.67)"
                double value = item.doubleValue();
                DecimalFormat df = new DecimalFormat("\u00A4#,##0.00;(\u00A4#,##0.00)");
                setText(df.format(value));
                setTextFill(value == 0 ?
                        Color.BLACK : value < 0 ? Color.RED : Color.GREEN);
            }
        }
    }
}

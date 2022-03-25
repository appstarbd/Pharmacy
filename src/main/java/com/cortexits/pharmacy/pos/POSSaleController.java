package com.cortexits.pharmacy.pos;

import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.controllers.BaseController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Callback;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class POSSaleController extends BaseController {
    @FXML
    private FlowPane itemsFlowPane;

    @FXML
    private TableView<Cart> cartTable;
    @FXML
    private TableColumn<String, Object> columnSerial;
    @FXML
    private TableColumn<String, Object> columnName;
    @FXML
    private TableColumn<String, Object> columnQty;
    @FXML
    private TableColumn<String, Object> columnPrice;
    @FXML
    private TableColumn<String, Object> columnTotal;
    @FXML
    private TableColumn<Cart, Void> columnAction;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Button> itemButtons = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Button itemButton = new Button();
            itemButton.setPrefWidth(110d);
            itemButton.setPrefHeight(80d);
            itemButton.setMaxWidth(110d);
            itemButton.setMaxHeight(100d);
            itemButton.setAlignment(Pos.CENTER);
            itemButton.getStyleClass().add("item");

            String name = "Napa Tablet " + i;
            Tooltip tooltip = new Tooltip(name);
            Duration duration = new Duration(0d);
            tooltip.setShowDelay(duration);
            itemButton.setTooltip(tooltip);

            GridPane gridPane = new GridPane();
//            gridPane.setPrefWidth(100);
//            gridPane.setPrefHeight(100);
//            gridPane.setGridLinesVisible(true);
//            gridPane.getColumnConstraints().add(new ColumnConstraints(100)); // column 0 is 100 wide
//            ColumnConstraints column1 = new ColumnConstraints(100,100, Double.MAX_VALUE);
            ColumnConstraints column1 = new ColumnConstraints();
            column1.setHgrow(Priority.SOMETIMES);
            column1.setMinWidth(10d);
            column1.setFillWidth(true);
            ColumnConstraints column2 = new ColumnConstraints();
            column2.setHgrow(Priority.SOMETIMES);
            column2.setMinWidth(10d);
            column2.setFillWidth(true);
            gridPane.getColumnConstraints().addAll(column1, column2);

            RowConstraints row1 = new RowConstraints();
            row1.setVgrow(Priority.SOMETIMES);
            row1.setMinHeight(10d);
            row1.setPrefHeight(30d);
            row1.setFillHeight(true);
            RowConstraints row2 = new RowConstraints();
            row2.setVgrow(Priority.NEVER);
            row2.setMinHeight(10d);
            row2.setFillHeight(true);
            RowConstraints row3 = new RowConstraints();
            row3.setVgrow(Priority.NEVER);
            row3.setMinHeight(10d);
            row3.setFillHeight(true);
            gridPane.getRowConstraints().addAll(row1, row2, row3);

//            GridPane.setHgrow();
//            gridPane.getColumnConstraints().add(new ColumnConstraints(10));
//            GridPane.setHgrow(gridPane, Priority.SOMETIMES);
//            gridPane.getColumnConstraints().add(new ColumnConstraints(10, 10, 10));

//            GridPane.setHgrow(gridPane, Priority.SOMETIMES);
//            gridPane.getColumnConstraints().add(new ColumnConstraints(10, 10, 10));

//            GridPane.setVgrow(gridPane, Priority.SOMETIMES);
//            gridPane.getRowConstraints().add(new RowConstraints(10, 30, 10, Priority.SOMETIMES, VPos.CENTER, true));
//            GridPane.setVgrow(gridPane, Priority.NEVER);
//            gridPane.getRowConstraints().add(new RowConstraints(10, 30, 10));
//            GridPane.setVgrow(gridPane, Priority.NEVER);
//            gridPane.getRowConstraints().add(new RowConstraints(10, 30, 10));

//            ImageView imageView = new ImageView(Icons.PILL);
            ImageView imageView = new ImageView(new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream("images/yellow-pill.png"))));
            imageView.setFitWidth(30d);
            imageView.setFitHeight(30d);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);
//            GridPane.setFillWidth(imageView, true);
            GridPane.setRowSpan(imageView, 1);
            GridPane.setColumnSpan(imageView, 2);
            GridPane.setHalignment(imageView, HPos.CENTER);
//            GridPane.setFillHeight(imageView, true);
//            GridPane.setVgrow(imageView, Priority.SOMETIMES);
//            GridPane.setValignment(imageView, VPos.BOTTOM);
//            gridPane.add(imageView, 0, 1);

            GridPane.setConstraints(imageView, 0, 0);

            Label itemName = new Label(name);
            itemName.setFont(Font.font(12d));
//            itemName.setMaxWidth(50);
//            GridPane.setRowIndex(itemName, 1);
//            gridPane.add(itemName, 0, 1);
            GridPane.setRowSpan(itemName, 1);
            GridPane.setColumnSpan(itemName, 2);
            GridPane.setConstraints(itemName, 0, 1);

//            Label itemCategory = new Label("Tablet");
////            GridPane.setColumnIndex(itemCategory, 1);
////            GridPane.setRowIndex(itemCategory, 1);
//            GridPane.setHalignment(itemCategory, HPos.RIGHT);
////            gridPane.add(itemCategory, 2, 0);
//            GridPane.setConstraints(itemCategory, 1, 1);
//
            Label itemIngredient = new Label("10mg");
            itemIngredient.setFont(Font.font(10d));
            itemIngredient.setTextFill(Paint.valueOf("#686868"));
//            GridPane.setRowIndex(itemIngredient, 2);
//            gridPane.add(itemIngredient, 0, 2);
            GridPane.setConstraints(itemIngredient, 0, 2);

            Label itemPrice = new Label("TK.5");
            itemPrice.setFont(Font.font(10d));
            itemPrice.setTextFill(Paint.valueOf("#068d40"));
//            GridPane.setColumnIndex(itemPrice, 1);
//            GridPane.setRowIndex(itemPrice, 2);
            GridPane.setHalignment(itemPrice, HPos.RIGHT);
//            gridPane.add(itemPrice, 1, 2);
            GridPane.setConstraints(itemPrice, 1, 2);

            gridPane.getChildren().addAll(imageView, itemName, /*itemCategory,*/ itemIngredient, itemPrice);

            itemButton.setGraphic(gridPane);
            itemsFlowPane.getChildren().add(itemButton);
        }

        final ObservableList<Cart> data = FXCollections.observableArrayList(
//                new Cart("1", "Napa", "2", "2", "4"),
//                new Cart("2", "Paracitamol", "2", "2", "4")
        );

        for (int i = 1; i <= 10; i++) {
            data.add(new Cart(String.valueOf(i), "Item " + i, "2", "2", "4"));
        }

        columnSerial.setCellValueFactory(new PropertyValueFactory<>("serial"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        addButtonToTable();

        cartTable.setItems(data);
    }

    private void addButtonToTable() {
//        TableColumn<Cart, Void> colBtn = new TableColumn("Button Column");

        Callback<TableColumn<Cart, Void>, TableCell<Cart, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Cart, Void> call(final TableColumn<Cart, Void> param) {
                final TableCell<Cart, Void> cell = new TableCell<>() {

                    private final Button btn = new Button();
//                    private final ImageView imageView = new ImageView(new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream("images/yellow-pill.png"))));
                    private final FontIcon fontIcon = new FontIcon("mdi2d-delete");
//                    private final FontIcon fontIcon = new FontIcon(IkonPro);
                    {
//                        imageView.setFitWidth(10d);
//                        imageView.setFitHeight(10d);
//                        btn.setGraphic(imageView);
                        fontIcon.setIconColor(Paint.valueOf("#f00"));
                        btn.getStyleClass().add("item-remove");
                        btn.setGraphic(fontIcon);
                        btn.setOnAction((ActionEvent event) -> {
                            Cart data = getTableView().getItems().get(getIndex());
                            System.out.println(data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        columnAction.setCellFactory(cellFactory);

//        cartTable.getColumns().add(columnAction);

    }

    public static class Cart {

        private final StringProperty serial;
        private final StringProperty name;
        private final StringProperty quantity;
//        private final StringProperty unit;
        private final StringProperty price;
        private final StringProperty total;

        public Cart(String serial, String name, String quantity, String price, String total) {
            this.serial = new SimpleStringProperty(serial);
            this.name = new SimpleStringProperty(name);
            this.quantity = new SimpleStringProperty(quantity);
            this.price = new SimpleStringProperty(price);
            this.total = new SimpleStringProperty(total);
        }

        public String getSerial() {
            return serial.get();
        }

        public StringProperty serialProperty() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial.set(serial);
        }

        public String getName() {
            return name.get();
        }

        public StringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getQuantity() {
            return quantity.get();
        }

        public StringProperty quantityProperty() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity.set(quantity);
        }

        public String getPrice() {
            return price.get();
        }

        public StringProperty priceProperty() {
            return price;
        }

        public void setPrice(String price) {
            this.price.set(price);
        }

        public String getTotal() {
            return total.get();
        }

        public StringProperty totalProperty() {
            return total;
        }

        public void setTotal(String total) {
            this.total.set(total);
        }

        @Override
        public String toString() {
            return "Cart{" +
                    "serial=" + serial +
                    ", name=" + name +
                    ", quantity=" + quantity +
                    ", price=" + price +
                    ", total=" + total +
                    '}';
        }
    }
}

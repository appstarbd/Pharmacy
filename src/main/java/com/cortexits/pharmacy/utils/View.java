package com.cortexits.pharmacy.utils;

import org.apache.commons.lang3.StringUtils;

public enum View {
    SUPPLIER ("views/supplier.fxml"),
    DASHBOARD ("views/dashboard.fxml"),
    SIDE_BAR ("views/side-bar).fxml"),
    DATA_TABLE ("views/data-table).fxml"),
    TOP_BAR ("views/top-bar).fxml"),
    VENDOR ("views/vendor.fxml"),
    AUTH ("views/auth.fxml"),
    PURCHASE ("views/purchase.fxml"),
    FORM ("views/form.fxml"),
    STOCK ("views/stock.fxml"),
    MEDICINE_FORM ("views/medicine-form.fxml"),
    TOP_CONTROLS ("views/top-controls.fxml"),
    POS2 ("views/pos2.fxml"),
    LOGIN ("views/login.fxml"),
    POS_SALE ("views/pos-sale.fxml"),
    MEDICINE ("views/medicine.fxml"),
    MAIN ("views/main.fxml"),
    CUSTOMER ("views/customer.fxml"),

    MANAGEMENT_PURCHASE ("views/management/purchase.fxml"),
    MANAGEMENT_MANUFACTURER ("views/management/manufacturer.fxml"),
    MANAGEMENT_ATTENDANCE ("views/management/attendance.fxml"),
    MANAGEMENT_SUPPLIER ("views/management/supplier.fxml"),
    MANAGEMENT_STOCK ("views/management/stock.fxml"),
    MANAGEMENT_LEAVE ("views/management/leave.fxml"),
    MANAGEMENT_PAYROLL ("views/management/payroll.fxml"),
    MANAGEMENT_SALARY ("views/management/salary.fxml"),
    MANAGEMENT_CUSTOMER ("views/management/customer.fxml"),
    MANAGEMENT_RETURN ("views/management/return.fxml"),
    MANAGEMENT_MEDICINE ("views/management/medicine.fxml"),
    MANAGEMENT_EMPLOYEE ("views/management/employee.fxml");

//    public enum Management {
//        SUPPLIER ("views/supplier.fxml"),
//        DASHBOARD ("views/dashboard.fxml"),
//        SIDE_BAR ("views/side-bar).fxml"),
//        DATA_TABLE ("views/data-table).fxml"),
//        TOP_BAR ("views/top-bar).fxml"),
//        VENDOR ("views/vendor.fxml"),
//        AUTH ("views/auth.fxml"),
//        PURCHASE ("views/purchase.fxml"),
//        FORM ("views/form.fxml"),
//        STOCK ("views/stock.fxml"),
//        MEDICINE_FORM ("views/medicine-form.fxml"),
//        TOP_CONTROLS ("views/top-controls.fxml"),
//        POS2 ("views/pos2.fxml"),
//        LOGIN ("views/login.fxml"),
//        POS_SALE ("views/pos-sale.fxml"),
//        MEDICINE ("views/medicine.fxml"),
//        MAIN ("views/main.fxml"),
//        CUSTOMER ("views/customer.fxml");
//
//        private final String v;
//
//        Management(String v) {
//            this.v = v;
//        }
//
//        public final String view() {
//            return v;
//        }
//
//        public final String viewName() {
//            return name();
//        }
//    }

    private final String v;

    View(String v) {
        this.v = v;
    }

    public final String title() {
        String name = name();
        name = StringUtils.replace(name, "_", " ");
        return StringUtils.capitalize(name.toLowerCase());
    }

    public final String view() {
        return get();
    }

    public final String get() {
        return v;
    }
}

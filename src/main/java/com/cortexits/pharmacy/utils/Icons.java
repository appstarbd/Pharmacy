package com.cortexits.pharmacy.utils;

import com.cortexits.pharmacy.MainApplication;
import javafx.scene.image.Image;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class Icons {

    public static String LOGO = "images/yellow-pill.png";

    public static String SCALE_BALANCE = "com/cortexits/pharmacy/icons/scale-balance.png";
    public static String ACCOUNT_CIRCLE_OUTLINE = "com/cortexits/pharmacy/icons/account-circle-outline.png";
    public static String POINT_OF_SALE = "com/cortexits/pharmacy/icons/point-of-sale.png";
    public static String HAMMER_WRENCH = "com/cortexits/pharmacy/icons/hammer-wrench.png";
    public static String COG_OUTLINE = "com/cortexits/pharmacy/icons/cog-outline.png";
    public static String ACCOUNT = "com/cortexits/pharmacy/icons/account.png";
    public static String RECEIPT_OUTLINE = "com/cortexits/pharmacy/icons/receipt-outline.png";
    public static String CASH_MULTIPLE = "com/cortexits/pharmacy/icons/cash-multiple.png";
    public static String INBOX_MULTIPLE = "com/cortexits/pharmacy/icons/inbox-multiple.png";
    public static String POWER = "com/cortexits/pharmacy/icons/power.png";
    public static String MAGNIFY = "com/cortexits/pharmacy/icons/magnify.png";
    public static String BELL_OUTLINE = "com/cortexits/pharmacy/icons/bell-outline.png";
    public static String PACKAGE_VARIANT = "com/cortexits/pharmacy/icons/package-variant.png";
    public static String PACKAGE_VARIANT_CLOSED = "com/cortexits/pharmacy/icons/package-variant-closed.png";
    public static String ARCHIVE = "com/cortexits/pharmacy/icons/archive.png";
    public static String FINANCE = "com/cortexits/pharmacy/icons/finance.png";
    public static String VIEW_DASHBOARD = "com/cortexits/pharmacy/icons/view-dashboard.png";
    public static String PACKAGE = "com/cortexits/pharmacy/icons/package.png";
    public static String PILL = "com/cortexits/pharmacy/icons/pill.png";
    public static String BOOK_OUTLINE = "com/cortexits/pharmacy/icons/book-outline.png";
    public static String STOCKING = "com/cortexits/pharmacy/icons/stocking.png";
    public static String INBOX = "com/cortexits/pharmacy/icons/inbox.png";

    public static Image getImage(String imageName) {
        Image image = new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream(imageName)));
        return image;
    }
    public static Image getIcon(String iconName) {
        return getImage(iconName);
    }

}

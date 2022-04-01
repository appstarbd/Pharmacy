package com.cortexits.pharmacy.utils;

public enum Icon {

    LOGO ("images/yellow-pill.png"),
    SPLASH ("images/splash.png"),

    ACCOUNT_CASH ("icons/account-cash.png"),
    ACCOUNT_CIRCLE_OUTLINE ("icons/account-circle-outline.png"),
    ACCOUNT_GROUP ("icons/account-group.png"),
    ACCOUNT_KEY ("icons/account-key.png"),
    ACCOUNT ("icons/account.png"),
    ARCHIVE ("icons/archive.png"),
    ARROW_LEFT_CIRCLE ("icons/arrow-left-circle.png"),
    ARROW_LEFT ("icons/arrow-left.png"),
    BACKBURGER ("icons/backburger.png"),
    BACKSPACE ("icons/backspace.png"),
    BADGE_ACCOUNT ("icons/badge-account.png"),
    BEACH ("icons/beach.png"),
    BELL_OUTLINE ("icons/bell-outline.png"),
    BOOK_LOCK_OPEN_OUTLINE ("icons/book-lock-open-outline.png"),
    BOOK_OUTLINE ("icons/book-outline.png"),
    CARD_ACCOUNT_DETAILS ("icons/card-account-details.png"),
    CART_VARIANT ("icons/cart-variant.png"),
    CASH_MULTIPLE ("icons/cash-multiple.png"),
    CASH_REFUND ("icons/cash-refund.png"),
    CASH_REGISTER ("icons/cash-register.png"),
    CASH ("icons/cash.png"),
    CAST_EDUCATION ("icons/cast-education.png"),
    CLOUD_DOWNLOAD_OUTLINE ("icons/cloud-download-outline.png"),
    CLOUD_DOWNLOAD ("icons/cloud-download.png"),
    COG_OUTLINE ("icons/cog-outline.png"),
    FACTORY ("icons/factory.png"),
    FILE_DOWNLOAD ("icons/file-download.png"),
    FINANCE ("icons/finance.png"),
    FOLDER_ACCOUNT ("icons/folder-account.png"),
    FOLDER_ARROW_DOWN ("icons/folder-arrow-down.png"),
    FOLDER_PLAY ("icons/folder-play.png"),
    FOLDER_QUESTION ("icons/folder-question.png"),
    HAMMER_WRENCH ("icons/hammer-wrench.png"),
    HELP_BOX ("icons/help-box.png"),
    HELP_RHOMBUS ("icons/help-rhombus.png"),
    HELP ("icons/help.png"),
    INBOX_MULTIPLE ("icons/inbox-multiple.png"),
    INBOX ("icons/inbox.png"),
    LICENSE ("icons/license.png"),
    LIGHTBULB_MULTIPLE ("icons/lightbulb-multiple.png"),
    LIGHTBULB_QUESTION ("icons/lightbulb-question.png"),
    LOGOUT_VARIANT ("icons/logout-variant.png"),
    LOGOUT ("icons/logout.png"),
    MAGNIFY ("icons/magnify.png"),
    MONITOR_ACCOUNT ("icons/monitor-account.png"),
    MONITOR_ARROW_DOWN_VARIANT ("icons/monitor-arrow-down-variant.png"),
    MONITOR_ARROW_DOWN ("icons/monitor-arrow-down.png"),
    PACKAGE_VARIANT_CLOSED ("icons/package-variant-closed.png"),
    PACKAGE_VARIANT ("icons/package-variant.png"),
    PACKAGE ("icons/package.png"),
    PILL ("icons/pill.png"),
    POINT_OF_SALE ("icons/point-of-sale.png"),
    POWER ("icons/power.png"),
    RECEIPT_OUTLINE ("icons/receipt-outline.png"),
    SCALE_BALANCE ("icons/scale-balance.png"),
    SHIELD_ACCOUNT ("icons/shield-account.png"),
    STOCKING ("icons/stocking.png"),
    TABLE_ARROW_DOWN ("icons/table-arrow-down.png"),
    TRAY_ARROW_DOWN ("icons/tray-arrow-down.png"),
    TRUCK ("icons/truck.png"),
    VIEW_DASHBOARD ("icons/view-dashboard.png"),
    YOUTUBE ("icons/youtube.png");

    private final String i;

    Icon(String i) {
        this.i = i;
    }

    public final String get() {
        return i;
    }
}

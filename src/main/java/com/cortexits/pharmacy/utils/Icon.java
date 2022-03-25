package com.cortexits.pharmacy.utils;

public enum Icon {

    LOGO ("images/yellow-pill.png"),

    TABLE_ARROW_DOWN ("icons/table-arrow-down.png"),
    SHIELD_ACCOUNT ("icons/shield-account.png"),
    SCALE_BALANCE ("icons/scale-balance.png"),
    ACCOUNT_CIRCLE_OUTLINE ("icons/account-circle-outline.png"),
    CASH ("icons/cash.png"),
    FOLDER_ARROW_DOWN ("icons/folder-arrow-down.png"),
    POINT_OF_SALE ("icons/point-of-sale.png"),
    MONITOR_ACCOUNT ("icons/monitor-account.png"),
    HAMMER_WRENCH ("icons/hammer-wrench.png"),
    COG_OUTLINE ("icons/cog-outline.png"),
    FOLDER_ACCOUNT ("icons/folder-account.png"),
    ACCOUNT ("icons/account.png"),
    TRAY_ARROW_DOWN ("icons/tray-arrow-down.png"),
    LIGHTBULB_MULTIPLE ("icons/lightbulb-multiple.png"),
    BADGE_ACCOUNT ("icons/badge-account.png"),
    RECEIPT_OUTLINE ("icons/receipt-outline.png"),
    ACCOUNT_GROUP ("icons/account-group.png"),
    CASH_MULTIPLE ("icons/cash-multiple.png"),
    ACCOUNT_CASH ("icons/account-cash.png"),
    HELP_RHOMBUS ("icons/help-rhombus.png"),
    INBOX_MULTIPLE ("icons/inbox-multiple.png"),
    MONITOR_ARROW_DOWN ("icons/monitor-arrow-down.png"),
    FILE_DOWNLOAD ("icons/file-download.png"),
    POWER ("icons/power.png"),
    MAGNIFY ("icons/magnify.png"),
    FOLDER_QUESTION ("icons/folder-question.png"),
    CASH_REGISTER ("icons/cash-register.png"),
    ARROW_LEFT_CIRCLE ("icons/arrow-left-circle.png"),
    BELL_OUTLINE ("icons/bell-outline.png"),
    PACKAGE_VARIANT ("icons/package-variant.png"),
    CLOUD_DOWNLOAD ("icons/cloud-download.png"),
    CAST_EDUCATION ("icons/cast-education.png"),
    PACKAGE_VARIANT_CLOSED ("icons/package-variant-closed.png"),
    ARCHIVE ("icons/archive.png"),
    BACKBURGER ("icons/backburger.png"),
    LIGHTBULB_QUESTION ("icons/lightbulb-question.png"),
    FACTORY ("icons/factory.png"),
    ARROW_LEFT ("icons/arrow-left.png"),
    FINANCE ("icons/finance.png"),
    HELP ("icons/help.png"),
    CLOUD_DOWNLOAD_OUTLINE ("icons/cloud-download-outline.png"),
    BEACH ("icons/beach.png"),
    HELP_BOX ("icons/help-box.png"),
    CASH_REFUND ("icons/cash-refund.png"),
    BOOK_LOCK_OPEN_OUTLINE ("icons/book-lock-open-outline.png"),
    YOUTUBE ("icons/youtube.png"),
    BACKSPACE ("icons/backspace.png"),
    VIEW_DASHBOARD ("icons/view-dashboard.png"),
    LICENSE ("icons/license.png"),
    PACKAGE ("icons/package.png"),
    PILL ("icons/pill.png"),
    TRUCK ("icons/truck.png"),
    BOOK_OUTLINE ("icons/book-outline.png"),
    CART_VARIANT ("icons/cart-variant.png"),
    FOLDER_PLAY ("icons/folder-play.png"),
    STOCKING ("icons/stocking.png"),
    INBOX ("icons/inbox.png"),
    ACCOUNT_KEY ("icons/account-key.png"),
    CARD_ACCOUNT_DETAILS ("icons/card-account-details.png"),
    MONITOR_ARROW_DOWN_VARIANT ("icons/monitor-arrow-down-variant.png");

    private final String i;

    Icon(String i) {
        this.i = i;
    }

    public final String get() {
        return i;
    }
}

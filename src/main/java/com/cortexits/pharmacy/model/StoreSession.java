package com.cortexits.pharmacy.model;

import java.util.Date;

public class StoreSession extends BaseModel {
    private Date openTime;
    private Date closeTime;
    private String outletId;
    private String openedByUserId;
    private String closedByUserId;

    public StoreSession() {
    }

    public StoreSession(Date openTime, Date closeTime, String outletId, String openedByUserId, String closedByUserId) {
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.outletId = outletId;
        this.openedByUserId = openedByUserId;
        this.closedByUserId = closedByUserId;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getOpenedByUserId() {
        return openedByUserId;
    }

    public void setOpenedByUserId(String openedByUserId) {
        this.openedByUserId = openedByUserId;
    }

    public String getClosedByUserId() {
        return closedByUserId;
    }

    public void setClosedByUserId(String closedByUserId) {
        this.closedByUserId = closedByUserId;
    }
}

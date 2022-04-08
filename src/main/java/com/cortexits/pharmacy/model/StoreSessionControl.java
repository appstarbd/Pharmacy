package com.cortexits.pharmacy.model;

import java.util.Date;

public class StoreSessionControl extends BaseModel {
    private StoreSession currentData;

    public StoreSessionControl() {
    }

    public StoreSessionControl(StoreSession currentData) {
        this.currentData = currentData;
    }

    public StoreSession getCurrentData() {
        return currentData;
    }

    public void setCurrentData(StoreSession currentData) {
        this.currentData = currentData;
    }
}

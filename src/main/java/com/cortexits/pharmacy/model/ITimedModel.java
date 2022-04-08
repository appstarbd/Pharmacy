package com.cortexits.pharmacy.model;

import java.util.Date;

public interface ITimedModel {
    boolean isUpdateSync();
    void setUpdateSync(boolean isSynchronized);

    boolean isLastUpdate();
    void setLastUpdate(boolean isUpdated);

    Date getLastUpdateAt();
    void setLastUpdateAt(Date lastUpdateTime);

    Date getLastSyncAt();
    void setLastSyncAt(Date lastSyncTime);

}

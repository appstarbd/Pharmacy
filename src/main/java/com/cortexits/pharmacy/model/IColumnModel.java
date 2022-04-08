package com.cortexits.pharmacy.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public interface IColumnModel extends ITimedModel {

    Integer getId();
    void setId(Integer id);

    Long getVersion();
    void setVersion(Long version);

    Date getCreatedAt();
    void setCreatedAt(Date createdAt);

    Date getUpdatedAt();
    void setUpdatedAt(Date updatedAt);

    Date getDeletedAt();
    void setDeletedAt(Date deletedAt);

    Boolean getCloudSynced();
    void setCloudSynced(Boolean cloudSynced);

    Boolean getHasSyncError();
    void setHasSyncError(Boolean hasSyncError);
}

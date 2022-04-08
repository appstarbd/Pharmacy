package com.cortexits.pharmacy.model;

import com.cortexits.pharmacy.utils.DatabaseUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//@Entity
public abstract class BaseModel implements IColumnModel, Serializable, Comparable {
    @Serial
    private static final long serialVersionUID = 1L;

    public static String PROP_ID = "id";
    public static String PROP_VERSION = "version";
    public static String PROP_CREATED_AT = "createdAt";
    public static String PROP_UPDATED_AT = "updatedAt";
    public static String PROP_DELETED_AT = "deletedAt";
    public static String PROP_LAST_UPDATE_AT = "lastUpdateAt";
    public static String PROP_LAST_SYNC_AT = "lastSyncAt";
    public static String PROP_CLOUD_SYNCED = "cloudSynced";
    public static String PROP_HAS_SYNC_ERROR = "hasSyncError";

//    private static BaseModel instance;

    private Integer id;
    private long version;
    private Date createdAt = new Date();
    private Date updatedAt;
    private Date deletedAt;
    private Date lastUpdateAt;
    private Date lastSyncAt;
    private Boolean cloudSynced;
    private Boolean hasSyncError;

//    public static BaseModel getInstance() {
//        return Objects.requireNonNullElseGet(instance, BaseModel::new);
//    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        this.createdAt = Objects.requireNonNullElseGet(createdAt, Date::new);
    }

    @Override
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public Date getDeletedAt() {
        return deletedAt;
    }

    @Override
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public Boolean getCloudSynced() {
        return cloudSynced;
    }

    @Override
    public void setCloudSynced(Boolean cloudSynced) {
        this.cloudSynced = cloudSynced;
    }

    @Override
    public Boolean getHasSyncError() {
        return hasSyncError;
    }

    @Override
    public void setHasSyncError(Boolean hasSyncError) {
        this.hasSyncError = hasSyncError;
    }

    @Override
    public boolean isUpdateSync() {
        return false;
    }

    @Override
    public void setUpdateSync(boolean isSynchronized) {

    }

    @Override
    public boolean isLastUpdate() {
        return false;
    }

    @Override
    public void setLastUpdate(boolean isUpdated) {

    }

    @Override
    public Date getLastUpdateAt() {
        return lastUpdateAt;
    }

    @Override
    public void setLastUpdateAt(Date lastUpdateTime) {
        this.lastUpdateAt =lastUpdateTime;
    }

    @Override
    public Date getLastSyncAt() {
        return lastSyncAt;
    }

    @Override
    public void setLastSyncAt(Date lastSyncTime) {
        this.lastSyncAt = lastSyncTime;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public BaseModel find(BaseModel model, Integer key) {
//        SessionFactory sessionFactory = DatabaseUtil.getInstance().getSession().getSessionFactory();
//        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityManager entityManager = DatabaseUtil.getInstance().getEntityManager();
        entityManager.getTransaction().begin();
        BaseModel modelObject = entityManager.find(model.getClass(), key);
        entityManager.getTransaction().commit();
        entityManager.close();
        return modelObject;
    }
    public void findAll() {}
    public void get() {}
    public List<?> getAll(BaseModel model) {
//        SessionFactory sessionFactory = DatabaseUtil.getInstance().getSession().getSessionFactory();
//        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityManager entityManager = DatabaseUtil.getInstance().getEntityManager();
        entityManager.getTransaction().begin();
        List<?> result = entityManager.createQuery(String.format("from %s", model.getClass().getSimpleName()), model.getClass()).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
    protected void save(BaseModel model) {
//        SessionFactory sessionFactory = DatabaseUtil.getInstance().getSession().getSessionFactory();
//        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityManager entityManager = DatabaseUtil.getInstance().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void update(BaseModel model) {
        Session session = DatabaseUtil.getInstance().getSession();
        Transaction transaction = DatabaseUtil.getInstance().beginTransaction(session);
        session.update(model);
        DatabaseUtil.getInstance().commitTransaction(transaction);
        DatabaseUtil.getInstance().closeSession(session);

    }
    public void saveOrUpdate() {}
    public void destroy() {}
}

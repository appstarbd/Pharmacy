package com.cortexits.pharmacy.managers;

import com.cortexits.pharmacy.model.User;
import com.cortexits.pharmacy.model.UserPermission;
import com.cortexits.pharmacy.model.UserType;
import com.cortexits.pharmacy.utils.DatabaseUtil;
import com.cortexits.pharmacy.views.AlertView;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public class AuthManager extends BaseManager {
    private static AuthManager instance;
    private User user;
    private UserType userType;
    private UserPermission userPermission;
    private List<UserPermission> userPermissions;

    public static AuthManager getInstance() {
//        return Objects.requireNonNullElseGet(instance, AuthManager::new);
        if (instance == null) {
            instance = new AuthManager();
        }
        return instance;
    }

    public User verifyUser(String userName, String password) {
        EntityManager entityManager = DatabaseUtil.getInstance().getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> criteria = builder.createQuery( User.class );
        Root<User> root = criteria.from( User.class );
        criteria.select(root);
//        criteria.where( builder.equal( root.get("name"), u ) );
//        criteria.where(builder.or(builder.equal(root.get("userName"), u), builder.equal(root.get("phoneNo"), u), builder.equal(root.get("email"), u)))
//        criteria.where(builder.or(root.get("name"), u))
//                .where(builder.equal( root.get("password"), password ));

        criteria.where(
                builder.and(
                        builder.or(
                                builder.equal(root.get("userName"), userName),
                                builder.equal(root.get("phoneNo"), userName),
                                builder.equal(root.get("email"), userName)
                        ),
                        builder.equal(root.get("password"), password)
                )
        );
        TypedQuery<User> typedQuery = entityManager.createQuery( criteria );
//        typedQuery.setHint("User", userName);
        User user = null;
        try {
            user = typedQuery.getSingleResult();
        } catch (NoResultException e) {
//            e.printStackTrace();
            AlertView.createExceptionDialog(e);
        }
        setUser(user);
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserPermission getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(UserPermission userPermission) {
        this.userPermission = userPermission;
    }

    public List<UserPermission> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(List<UserPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }

    public String getFullName() {
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }
}

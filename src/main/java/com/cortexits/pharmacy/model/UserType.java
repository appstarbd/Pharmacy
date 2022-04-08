package com.cortexits.pharmacy.model;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UserType extends BaseModel {
    private String name;
    private Set<UserPermission> permissions = new HashSet<>(0);

    public UserType() {
    }

    public UserType(String name, Set<UserPermission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public void addToPermissions(UserPermission userPermission) {
        if (null == getPermissions())
            setPermissions(new TreeSet<>());
        getPermissions().add(userPermission);
    }
}

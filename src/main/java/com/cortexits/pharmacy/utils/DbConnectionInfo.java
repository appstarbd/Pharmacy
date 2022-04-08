package com.cortexits.pharmacy.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionInfo {
    private Database database;
    private String driverClass;
    private String userName;
    private String password;
    private String connectionString;
    private Connection connection;

    public Database getSelectedDatabase() {
        return this.database;
    }

    public void setSelectedDatabase(Database database) {
        this.database = database;
    }

    public String getDriverClass() {
        return this.driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public Connection openConnection() throws Exception {
        Class.forName(getDriverClass());
        this.connection = DriverManager.getConnection(getConnectionString(), getUserName(), getPassword());
        this.connection.setAutoCommit(false);
        return this.connection;
    }

    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public int hashCode() {
        return this.connectionString.hashCode();
    }

    @Override
    public boolean equals(Object connectionInfo) {
        if (!(connectionInfo instanceof DbConnectionInfo dbConnectionInfo))
            return false;
        if (this.database != dbConnectionInfo.database)
            return false;
        return false;
    }
}


package com.cortexits.pharmacy.utils;

import com.cortexits.pharmacy.model.User;
import org.hibernate.*;

import java.sql.SQLException;

public class PrefetchFeature {
    public enum Features {}

    private static PrefetchFeature instance;

    public PrefetchFeature() {

    }

    public static PrefetchFeature getInstance() {
        if (instance == null) {
            instance = new PrefetchFeature();
        }
        return instance;
    }

    public void check(PrefetchList param) {
        System.out.println(param.get());
        switch (param) {
            case CONNECTING -> {
                try {
                    connecting();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case CHECKING -> {
                checking();
            }
            case AUTHENTICATING -> {
                authenticating();
            }
            case MODULES -> {
//                loadModules();
            }
            case INITIALIZING -> {
//                initializing();
            }
            case PREPARING -> {
//                preparing();
            }
            case COMPLETING -> {
//                completing();
            }
            default -> System.out.println("Undefined");
        }
    }

    private void connecting() {
        try {
            DatabaseUtil.checkConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void checking() {
        DatabaseUtil.createConnection();
//        DatabaseUtil.createDatabase();
    }

    private void authenticating() {
//        try {
//            Session session = DatabaseUtil.getInstance().getSession();
//            Transaction transaction = session.beginTransaction();
//            session.save(new User("Imran-1x"));
//            System.out.println(transaction.getStatus());
//            transaction.commit();
//            session.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        User user = new User();
//        user.setFirstName("Yousuf");
//        user.setLastName("Sunny");
//        user.setUserName("sunny");
//        user.setPhoneNo("01852362798");
//        user.setEmail("sunny@email.com");
//        user.setPassword("123456");
//        user.save();
    }
    private void loadModules() {}
    private void initializing() {}
    private void preparing() {}
    private void completing() {}

}

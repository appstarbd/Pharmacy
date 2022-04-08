package com.cortexits.pharmacy.managers;

import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.model.User;
import com.cortexits.pharmacy.utils.Database;
import com.cortexits.pharmacy.utils.View;
import com.cortexits.pharmacy.views.AlertView;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

public class AppManager extends BaseManager {
    private static AppManager instance;
    private static String name = "Pharmacy Management System";
    private static String version = "1.0";

    private static boolean auth = false;
    private static boolean isComplete = false;

    private static Stage stage;

    public AppManager() {
    }

    public AppManager(String name, String version) {
        AppManager.name = name;
        AppManager.version = version;
    }

    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    public static String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public static String getVersion() {
        return version;
    }

//    public void setVersion(String version) {
//        this.version = version;
//    }

//    Initialize app with Splash Screen
//    public static boolean initApplication(Stage stage) throws IOException {
//        //        AppManager.stage = stage;
//        ViewManager.setStage(stage);
//        ViewManager.showView(View.SPLASH, StageStyle.UNDECORATED, true);
//        Task<Integer> task = new Task<>() {
//            @Override
//            protected Integer call() throws Exception {
//                int iterations;
//                for (iterations = 0; iterations < 1000; iterations++) {
//                    if (isCancelled()) {
//                        updateMessage("Cancelled");
//                        break;
//                    }
//                    System.out.println("Iteration " + iterations);
//                    updateMessage("Iteration " + iterations);
//                    updateProgress(iterations, 1000);
//                }
//                return iterations;
//            }
//
//            @Override
//            protected void done() {
//                super.done();
//                System.out.println("done");
//            }
//
//            @Override
//            public boolean isDone() {
//                System.out.println("isDone");
//                return super.isDone();
//            }
//        };
////        Task<ObservableList<Rectangle>> task = new Task<ObservableList<Rectangle>>() {
////            @Override protected ObservableList<Rectangle> call() throws Exception {
////                updateMessage("Creating Rectangles");
////                ObservableList<Rectangle> results = FXCollections.observableArrayList();
////                for (int i=0; i<100; i++) {
////                    if (isCancelled()) break;
////                    Rectangle r = new Rectangle(10, 10);
////                    r.setX(10 * i);
////                    results.add(r);
////                    updateProgress(i, 100);
////                }
////                return results;
////            }
////        };
////        task.setOnFailed(event -> isComplete = false);
////        Thread th = new Thread(task);
////        th.setDaemon(true);
////        th.start();
//        task.setOnSucceeded(event -> {
//            isComplete = true;
////            th.stop();
////            try {
////                startApplication(new Stage());
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//            System.out.println("on success: " + isComplete);
//        });
//        task.run();
////        ViewManager.setStage(new Stage());
////        try {
////            ViewManager.showView(View.SPLASH, StageStyle.UNDECORATED, true);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        Platform.runLater(new Task<>() {
////            @Override
////            protected Object call() throws Exception {
////                for(int i = 0; i <= 1000; i++) {
////                    System.out.println(i);
////                    try {
////                        Thread.sleep(5);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                    if (i == 1000) {
////                        isComplete = true;
////                    }
////                }
////                return null;
////            }
////        });
//
////        System.out.println(Integer.MAX_VALUE);
//        System.out.println("is complete: " + isComplete);
//        return isComplete;
//    }
    public static boolean initApplication() throws IOException {
        return initApplication(new Stage());
    }

    public static boolean initApplication(Stage stage) throws IOException {
        ViewManager.hideActiveView();
        ViewManager.setStage(stage);
        ViewManager.showView(View.SPLASH, StageStyle.UNDECORATED, true);
        return true;
    }
//    Start app after initializations and check auth
    public static void startApplication(Stage stage) throws Exception {
        AppManager.stage = stage;
        ViewManager.hideActiveView();
        ViewManager.setStage(stage);
        if (isAuth()) {
            ViewManager.showView(View.MAIN, StageStyle.DECORATED);
        } else {
//            ViewManager.setStage(new Stage());
            ViewManager.showView(View.AUTH, StageStyle.UNDECORATED, true);
        }
    }

    public static boolean isAuth() {
        return auth;
    }

    public static void setAuth(boolean auth) {
        AppManager.auth = auth;
    }

    public static boolean checkPermissions() {
        return false;
    }

//    public static void doLoginh() throws IOException {
//
//        Database database = getDefaultDatabase();
//        String dialect = database.getHibernateDialect();
//        String driverClass = database.getHibernateConnectionDriverClass();
//        String connectString = database.getConnectString("localhost", "3306", "pharmabase");
//        String databaseUser = "root";
//        String databasePassword = "123456";
//
//        HashMap<String, Object> hibernateSettings = new HashMap<>();
//        hibernateSettings.put("hibernate.dialect", dialect);
//        hibernateSettings.put("hibernate.connection.driver_class", driverClass);
//        hibernateSettings.put("hibernate.connection.url", connectString);
//        hibernateSettings.put("hibernate.connection.username", databaseUser);
//        hibernateSettings.put("hibernate.connection.password", databasePassword);
//
//        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                // "jdbc" is the default, but for explicitness
////                .configure()
//                .applySettings(hibernateSettings)
////                .applySetting(AvailableSettings.TRANSACTION_COORDINATOR_STRATEGY, "jdbc")
//                .build();
//
//        Metadata metadata = new MetadataSources(serviceRegistry)
////                            .addAnnotatedClass(Customer.class)
////                .addAnnotatedClass(User.class)
//                .getMetadataBuilder()
//                .build();
//
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
//                .build();
//
//        Session session = sessionFactory.openSession();
//        try {
//            // calls Connection#setAutoCommit(false) to
//            // signal start of transaction
//            session.getTransaction().begin();
//
//            session.createQuery("UPDATE user set NAME = 'Isacc'||NAME")
//                    .executeUpdate();
//            // calls Connection#commit(), if an error
//            // happens we attempt a rollback
//            session.getTransaction().commit();
//        }
//        catch (Exception e) {
//            // we may need to rollback depending on
//            // where the exception happened
//            if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE
//                    || session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
//                session.getTransaction().rollback();
//            }
//            // handle the underlying error
//        }
//        finally {
//            session.close();
//            sessionFactory.close();
//        }
//    }

    public static void doLogin() throws IOException {
//        auth = true;
//        boolean isSuccess = true;
        Stage stage = ViewManager.getStage();
        if (auth) {
            stage.hide();
            ViewManager.setStage(new Stage());
//            ViewManager.showView(ViewManager.VIEW.MAIN);
            ViewManager.showView(View.MAIN, StageStyle.DECORATED);
        } else {
//            ViewManager.showView(ViewManager.VIEW.AUTH);
//            ViewManager.showView(View.AUTH, StageStyle.UNDECORATED);
//            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong username or password");
//            alert.initStyle(StageStyle.UNDECORATED);
//            alert.showAndWait();
            AlertView.showError("Wrong username or password");
        }
    }

    public static void doLogin(String userName, String password) throws IOException {
        String u = StringUtils.trim(userName);
        String p = StringUtils.trim(password);

        if (StringUtils.isEmpty(u) && StringUtils.isNotEmpty(p)) {
            AlertView.showError("Username can't be empty!");
        } else if (StringUtils.isNotEmpty(u) && StringUtils.isEmpty(p)) {
            AlertView.showError("Password can't be empty!");
        } else if (StringUtils.isEmpty(u) && StringUtils.isEmpty(p)) {
            AlertView.showError("Username and Password can't be empty!");
        } else {
            User user = AuthManager.getInstance().verifyUser(u, p);
            if (Objects.isNull(user)) {
                AlertView.showError("User not found, try correct one or contact with administrator!");
            } else {
                setAuth(Objects.nonNull(user));
                AuthManager.getInstance().setUser(user);
                doLogin();
            }
        }
    }

    public static void doLogout() throws IOException {
        AuthManager.getInstance().setUser(null);
        setAuth(false);
        Stage stage = ViewManager.getStage();
        stage.hide();
        ViewManager.setStage(new Stage());
//            ViewManager.showView(ViewManager.VIEW.MAIN);
        ViewManager.showView(View.AUTH, StageStyle.UNDECORATED, true);
    }

    public static void shutdown() {
//        Alert powerOffAlert = new Alert(Alert.AlertType.WARNING,"Do you really want to close this application?", ButtonType.YES, ButtonType.NO);
//        powerOffAlert.initModality(Modality.APPLICATION_MODAL);
//        powerOffAlert.initStyle(StageStyle.UNDECORATED);
//        powerOffAlert.initOwner(ViewManager.getStage());
//        powerOffAlert.showAndWait()
//                .filter(response -> response == ButtonType.YES)
////                .ifPresentOrElse(, Platform.exit());
//                .ifPresent(response -> Platform.exit());
//        AlertView alertView = new AlertView(Alert.AlertType.WARNING,"Do you really want to close this application?", ButtonType.YES, ButtonType.NO);
//        alertView.open();
//        if (alertView.isPositive()) {
//            Platform.exit();
//        }
//        AlertView.showConfirmation("Do you really want to close this application?");
        AlertView alertView = AlertView.showConfirmation("Do you really want to close this application?");
        if (alertView.isPositive()) {
            Platform.exit();
        }
    }
}

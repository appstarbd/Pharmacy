package com.cortexits.pharmacy.utils;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import com.cortexits.pharmacy.MainApplication;
import com.cortexits.pharmacy.exceptions.DatabaseConnectionException;
import com.cortexits.pharmacy.model.BaseModel;
import com.cortexits.pharmacy.model.Store;
import com.cortexits.pharmacy.model.User;
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.tool.hbm2ddl.SchemaExport;
//import org.hibernate.tool.hbm2ddl.SchemaUpdate;
//import org.hibernate.tool.schema.TargetType;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseUtil {

	private static DatabaseUtil instance;

	public static final Integer DATABASE_VERSION = 1;
	public static final String FK_NAME = "FK_NAME";
	public static final String FK_TABLE_NAME = "FK_TABLE_NAME";
	public static final String TABLE_NAME = "TABLE_NAME";
	public static final String TYPE_NAME = "TYPE_NAME";
	public static final String COLUMN_NAME = "COLUMN_NAME";
	public static final String TABLE = "TABLE";

	private static StandardServiceRegistry standardServiceRegistry;

	protected static Map<String, SessionFactory> sessionFactoryMap;
	protected static SessionFactory sessionFactory;
	protected static ThreadLocal<Map> mappedSessions;
	protected static ThreadLocal<Session> sessions;

	private static final Database database;
	private static final String dialect;
	private static final String driverClass;
	private static final String connectString;
	private static final String databaseUser;
	private static final String databasePassword;

	private static final Map<String, Object> hibernateSettings;

//	private static Log log = LogFactory.getLog(DatabaseUtil.class);

	static {
		database = DatabaseUtil.getDefaultDatabase();
		dialect = database.getHibernateDialect();
		driverClass = database.getHibernateConnectionDriverClass();
		connectString = database.getConnectString("localhost", database.getDefaultPort(), "pharmabase");
		databaseUser = "root";
		databasePassword = "123456";

		hibernateSettings = new HashMap<>();
		hibernateSettings.put("hibernate.dialect", dialect);
		hibernateSettings.put("hibernate.connection.driver_class", driverClass);
		hibernateSettings.put("hibernate.connection.url", connectString);
		hibernateSettings.put("hibernate.connection.username", databaseUser);
		hibernateSettings.put("hibernate.connection.password", databasePassword);
	}

	public DatabaseUtil() {
	}

	public static DatabaseUtil getInstance() {
		if (instance == null) {
			instance = new DatabaseUtil();
		}
		return instance;
	}

	public static void checkConnection() throws DatabaseConnectionException, SQLException {
		checkConnection(connectString, driverClass, databaseUser, databasePassword);
	}

	public static void checkConnection(String connectUrl, String className, String user, String password) throws DatabaseConnectionException, SQLException {
		Connection connection;
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(connectUrl, user, password);
		} catch (Exception exception) {
			throw new DatabaseConnectionException(exception.getMessage());
		}
	}

	public static void createConnection() {
		createConnection(connectString, dialect, driverClass, databaseUser, databasePassword);
	}

	public static void createConnection(String connectString, String dialect, String driverClass, String databaseUser, String databasePassword) {

//		hibernateSettings.put("hibernate.dialect", dialect);
//		hibernateSettings.put("hibernate.connection.driver_class", driverClass);
//		hibernateSettings.put("hibernate.connection.url", connectString);
//		hibernateSettings.put("hibernate.connection.username", databaseUser);
//		hibernateSettings.put("hibernate.connection.password", databasePassword);

		try {
			StandardServiceRegistry standardServiceRegistry = serviceRegistry();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

			metadataSources.addPackage(BaseModel.class.getPackage());
//		metadataSources.addAnnotatedClass(Store.class);
//		metadataSources.addAnnotatedClass(User.class);

			Metadata metadata = metadataSources.getMetadataBuilder().build();
			SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
			sessionFactoryBuilder.applyInterceptor(new DataInterceptor());
			SessionFactory sessionFactory = sessionFactoryBuilder.build();
			setSessionFactory(sessionFactory);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void createDatabase() {
		createDatabase(connectString, dialect, driverClass, databaseUser, databasePassword);
	}

	public static void createDatabase(String connectString, String dialect, String driverClass, String databaseUser, String databasePassword) {
		hibernateSettings.put("hibernate.connection.autocommit", true);
		hibernateSettings.put("hibernate.max_fetch_depth", 3);
		hibernateSettings.put("hibernate.show_sql", true);
		hibernateSettings.put("hibernate.hbm2ddl.auto", "update");
		hibernateSettings.put("hibernate.connection.isolation", 1);
		hibernateSettings.put("hibernate.current_session_context_class", "thread");
//        hibernateSettings.put("hibernate.cache.use_second_level_cache", true);
//        hibernateSettings.put("hibernate.cache.provider_class", "org.hibernate.cache.EhCacheProvider");
//        hibernateSettings.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
		createConnection(connectString, dialect, driverClass, databaseUser, databasePassword);
	}

//	public static boolean createDatabase(String connectionUrl, String dialect, String driverClass, String username, String password, boolean paramBoolean) {
//		return createDatabase("hibernate.cfg.xml", connectionUrl, dialect, driverClass, username, password, paramBoolean, false);
//	}
//
//	public static boolean createDatabase(String connectionUrl, String dialect, String driverClass, String username, String password, boolean paramBoolean1, boolean paramBoolean2) {
//		return createDatabase("hibernate.cfg.xml", connectionUrl, dialect, driverClass, username, password, paramBoolean1, paramBoolean2);
//	}

//	public static boolean createDatabase(String cfg, String connectionUrl, String dialect, String driverClass, String username, String password, boolean paramBoolean1, boolean paramBoolean2) {
//		try {
////			_RootDAO.releaseConnection();
//			StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
////					.configure();
////					.configure("com/cortexits/pharmacy/" + cfg);
////					.configure("/com/cortexits/pharmacy/hibernate.cfg.xml");
//			standardServiceRegistryBuilder.applySetting("hibernate.dialect", dialect);
//			standardServiceRegistryBuilder.applySetting("hibernate.connection.driver_class", driverClass);
//			standardServiceRegistryBuilder.applySetting("hibernate.connection.url", connectionUrl);
//			standardServiceRegistryBuilder.applySetting("hibernate.connection.username", username);
//			standardServiceRegistryBuilder.applySetting("hibernate.connection.password", password);
//			standardServiceRegistryBuilder.applySetting("hibernate.hbm2ddl.auto", "create");
////			standardServiceRegistryBuilder.applySetting("hibernate.c3p0.checkoutTimeout", "0");
////			standardServiceRegistryBuilder.applySetting("hibernate.cache.use_second_level_cache", "false");
//			StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.build();
//			Metadata metadata = (new MetadataSources(standardServiceRegistry)).getMetadataBuilder().build();
//
//			System.out.println(metadata.getDatabase());
//
////			SchemaExport schemaExport = new SchemaExport();
////			EnumSet<TargetType> enumSet = EnumSet.of(TargetType.DATABASE);
////			schemaExport.create(enumSet, metadata);
////			_RootDAO.setSessionFactory(metadata.buildSessionFactory());
////			DefaultDataInserter defaultDataInserter = new DefaultDataInserter();
////			defaultDataInserter.insertDefaultData(DATABASE_VERSION, false);
////			if (!paramBoolean1) {
////				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
////				return true;
////			}
////			if (paramBoolean2) {
////				defaultDataInserter.createSampleTestData();
////			} else {
////				defaultDataInserter.createSampleData(false);
////			}
////			StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
//			return true;
//		} catch (Exception exception) {
//			exception.printStackTrace();
//			return false;
//		}
//	}

	public static void updateLegacyDatabase() {}

	public static boolean updateDatabase(String connectionUrl, String dialect, String driverClass, String username, String password) {
//		return updateDatabase(Application.getInstance().getHibernateConfigurationFileName(), connectionUrl, dialect, driverClass, username, password);
		return true;
	}

//	String configureFile, String connectionUrl, String dialect, String driverClass, String username, String password
//public static boolean updateDatabase(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
	public static boolean updateDatabase(String configureFile, String connectionUrl, String dialect, String driverClass, String username, String password) {
//		try {
//			_RootDAO.releaseConnection();
//			StandardServiceRegistry standardServiceRegistry = a(configureFile, connectionUrl, dialect, driverClass, username, password);
//			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
//			Metadata metadata = metadataSources.getMetadataBuilder().build();
//			SchemaUpdate schemaUpdate = new SchemaUpdate();
//			EnumSet<TargetType> enumSet = EnumSet.of(TargetType.DATABASE, TargetType.STDOUT);
////			schemaUpdate.getExceptions()
//			schemaUpdate.execute(enumSet, metadata);
//			SessionFactory sessionFactory = metadata.buildSessionFactory();
//			_RootDAO.setSessionFactory(sessionFactory);
////			Store store = StoreDAO.getRestaurant();
//			Restaurant store = RestaurantDAO.getRestaurant();
//			Integer integer = (store == null) ? null : store.getDatabaseVersion();
//			System.out.println("DatabaseVersion: " + String.valueOf(integer));
////			if (integer == null || integer < 135) {
////				UpdateDBTo135 updateDBTo135 = new UpdateDBTo135(sessionFactory);
////				updateDBTo135.update();
////			}
//			if (integer == null || integer < 101) {
//				UpdateDBTo101 updateDBTo101 = new UpdateDBTo101(connectionUrl, username, password, sessionFactory);
//				updateDBTo101.update();
//			}
////			if (integer == null || integer < 104) {
////				PosLog.debug(DashboardUtil.class, "updating db to 104");
////				UpdateDBTo104 updateDBTo104 = new UpdateDBTo104();
////				updateDBTo104.update();
////			}
////			if (integer == null || integer < 122) {
////				PosLog.debug(DashboardUtil.class, "updating db to 122");
////				UpdateDBTo122 updateDBTo122 = new UpdateDBTo122();
////				updateDBTo122.update();
////			}
////			if (integer == null || integer < 129) {
////				PosLog.debug(DashboardUtil.class, "updating db to 129");
////				UpdateDBTo129 updateDBTo129 = new UpdateDBTo129();
////				updateDBTo129.update();
////			}
////			if (integer == null || integer < 151) {
////				PosLog.debug(DashboardUtil.class, "updating db to 151");
////				UpdateDBTo151 updateDBTo151 = new UpdateDBTo151();
////				updateDBTo151.update();
////			}
////			if (integer == null || integer < 160) {
////				PosLog.debug(DashboardUtil.class, "updating db to 160");
////				UpdateDBTo160 updateDBTo160 = new UpdateDBTo160(sessionFactory);
////				updateDBTo160.update();
////			}
////			if (integer == null || integer < 165) {
////				PosLog.debug(DashboardUtil.class, "updating db to 165");
////				UpdateDBTo165 updateDBTo165 = new UpdateDBTo165();
////				updateDBTo165.update(sessionFactory);
////			}
////			if (integer == null || integer < 171) {
////				PosLog.debug(DashboardUtil.class, "updating db to 171");
////				UpdateDBTo171 updateDBTo171 = new UpdateDBTo171(sessionFactory);
////				updateDBTo171.updateTickets();
////				updateDBTo171.updateTransactions();
////			}
////			if (integer == null || integer < 185) {
////				PosLog.debug(DashboardUtil.class, "updating db to 185");
////				UpdateDBTo185 updateDBTo185 = new UpdateDBTo185();
////				updateDBTo185.update();
////			}
////			if (integer == null || integer < 188) {
////				PosLog.debug(DashboardUtil.class, "updating db to 188");
////				UpdateDBTo188 updateDBTo188 = new UpdateDBTo188(schemaUpdate, enumSet, metadata, paramString3, sessionFactory, paramString5);
////				updateDBTo188.update();
////			}
////			if (integer == null || integer < 195) {
////				PosLog.debug(DashboardUtil.class, "updating db to 195");
////				UpdateDBTo194 updateDBTo194 = new UpdateDBTo194();
////				updateDBTo194.update();
////			}
////			if (integer == null || integer < 208) {
////				PosLog.debug(DashboardUtil.class, "updating db to 208");
////				UpdateDBTo207 updateDBTo207 = new UpdateDBTo207(paramString2, paramString5, paramString6);
////				updateDBTo207.update();
////			}
////			if (integer == null || integer < 209) {
////				PosLog.debug(DashboardUtil.class, "updating db to 209");
////				UpdateDBTo209 updateDBTo209 = new UpdateDBTo209(paramString2, paramString5, paramString6);
////				updateDBTo209.update();
////			}
////			if (integer == null || integer < 210) {
////				PosLog.debug(DashboardUtil.class, "updating db to 210");
////				UpdateDBTo210 updateDBTo210 = new UpdateDBTo210(paramString2, paramString5, paramString6);
////				updateDBTo210.update();
////			}
////			if (integer == null || integer < 213) {
////				PosLog.debug(DashboardUtil.class, "updating db to 213");
////				UpdateDBTo213 updateDBTo213 = new UpdateDBTo213();
////				updateDBTo213.update();
////			}
////			if (integer == null || integer < 228) {
////				PosLog.debug(DashboardUtil.class, "updating db to 228");
////				UpdateDBTo228 updateDBTo228 = new UpdateDBTo228();
////				updateDBTo228.update();
////			}
////			if (integer == null || integer < 239) {
////				PosLog.debug(DashboardUtil.class, "updating db to 239");
////				UpdateDBTo239 updateDBTo239 = new UpdateDBTo239(sessionFactory);
////				updateDBTo239.update();
////			}
////			if (integer == null || integer < 252) {
////				PosLog.debug(DashboardUtil.class, "updating db to 252");
////				UpdateDBTo252 updateDBTo252 = new UpdateDBTo252(paramString2, paramString5, paramString6);
////				updateDBTo252.update();
////			}
////			if (integer == null || integer < 254) {
////				PosLog.debug(DashboardUtil.class, "updating db to 254");
////				UpdateDBTo254 updateDBTo254 = new UpdateDBTo254();
////				updateDBTo254.update();
////			}
////			if (integer == null || integer < 262) {
////				PosLog.debug(DashboardUtil.class, "updating db to 262");
////				UpdateDBTo262 updateDBTo262 = new UpdateDBTo262(sessionFactory);
////				updateDBTo262.update();
////			}
////			if (integer == null || integer < 263) {
////				PosLog.debug(DashboardUtil.class, "updating db to 263");
////				UpdateDBTo263 updateDBTo263 = new UpdateDBTo263(paramString2, paramString5, paramString6);
////				updateDBTo263.update();
////			}
////			if (integer == null || integer < 265) {
////				PosLog.debug(DashboardUtil.class, "updating db to 265");
////				UpdateDBTo265 updateDBTo265 = new UpdateDBTo265(paramString2, paramString5, paramString6);
////				updateDBTo265.update();
////			}
////			if (integer == null || integer < 268) {
////				PosLog.debug(DashboardUtil.class, "updating db to 268");
////				UpdateDBTo268 updateDBTo268 = new UpdateDBTo268(sessionFactory);
////				updateDBTo268.update();
////			}
//			if (integer == null || integer < 271) {
//				PosLog.debug(DashboardUtil.class, "updating db to 271");
//				UpdateDBTo271 updateDBTo271 = new UpdateDBTo271(sessionFactory);
//				updateDBTo271.update();
//			}
////			store = StoreDAO.getRestaurant();
//			store = RestaurantDAO.getRestaurant();
//			if (store != null) {
//				store.setDatabaseVersion(DATABASE_VERSION);
//				store.setSoftwareVersion(VersionInfo.getVersion());
//				store.setSoftwareNumericVersion(VersionInfo.getNumericVersion());
////				StoreDAO.getInstance().update(store);
//				RestaurantDAO.getInstance().update(store);
//			} else {
//				DefaultDataInserter.createStore(DATABASE_VERSION);
//			}
//			sessionFactory.close();
//			StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
//			return true;
//		} catch (Exception exception) {
//			PosLog.error(DatabaseUtil.class, exception);
//			log.error(exception);
//			return false;
//		}
		return true;
	}

//	String configureFile, String connectionUrl, String dialect, String driverClass, String username, String password
	public static void updateSchema(String connectionUrl, String dialect, String driverClass, String username, String password) {
//		String configureFile = Application.getInstance().getHibernateConfigurationFileName();
//		StandardServiceRegistry standardServiceRegistry = a(configureFile, connectionUrl, dialect, driverClass, username, password);
//		Metadata metadata = (new MetadataSources(standardServiceRegistry)).getMetadataBuilder().build();
//		SchemaUpdate schemaUpdate = new SchemaUpdate();
//		EnumSet<TargetType> enumSet = EnumSet.of(TargetType.DATABASE, TargetType.STDOUT);
//		schemaUpdate.execute(enumSet, metadata);
	}

	private static StandardServiceRegistry serviceRegistry() {
		return serviceRegistry(hibernateSettings);
	}

	private static StandardServiceRegistry serviceRegistry(Map<String, Object> hibernateSettings) {
		releaseConnection();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        try {
			standardServiceRegistryBuilder.configure((MainApplication.class.getResource("hibernate.cfg.xml")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		standardServiceRegistryBuilder.applySettings(hibernateSettings);
//        setupC3P0connectionPoolSettings(standardServiceRegistryBuilder);
		standardServiceRegistry = standardServiceRegistryBuilder.build();
		return standardServiceRegistry;
	}

	private static StandardServiceRegistry serviceRegistry(String configureFile, String connectionUrl, String dialect, String driverClass, String username, String password) {
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = (new StandardServiceRegistryBuilder()).configure(configureFile);
		standardServiceRegistryBuilder.applySetting("hibernate.dialect", dialect);
		standardServiceRegistryBuilder.applySetting("hibernate.connection.driver_class", driverClass);
		standardServiceRegistryBuilder.applySetting("hibernate.connection.url", connectionUrl);
		standardServiceRegistryBuilder.applySetting("hibernate.connection.username", username);
		standardServiceRegistryBuilder.applySetting("hibernate.connection.password", password);
		standardServiceRegistryBuilder.applySetting("hibernate.max_fetch_depth", "3");
		standardServiceRegistryBuilder.applySetting("hibernate.connection.isolation", String.valueOf(1));
//		standardServiceRegistryBuilder.applySetting("hibernate.connection.isolation", "true");
		standardServiceRegistryBuilder.applySetting("hibernate.cache.use_second_level_cache", "false");
		standardServiceRegistryBuilder.applySetting("hibernate.hbm2ddl.auto", "update");
		standardServiceRegistryBuilder.applySetting("hibernate.show_sql", "true");
		standardServiceRegistryBuilder.applySetting("hibernate.generate_statistics", "true");
		return standardServiceRegistryBuilder.build();
	}

	public static boolean isDbUpdateNeeded() {
//		try {
////			Store store = StoreDAO.getRestaurant();
//			Restaurant store = RestaurantDAO.getRestaurant();
//			if (store == null)
//				throw new PosException(Messages.getString("DatabaseUtil.3") + Messages.getString("DatabaseUtil.4"));
//			Integer integer = store.getDatabaseVersion();
//			if (integer != null && integer >= DATABASE_VERSION)
//				return false;
//			return true;
//		} catch (SQLGrammarException sQLGrammarException) {
//			Throwable throwable = sQLGrammarException.getCause();
//			if (throwable != null) {
//				String str = throwable.getMessage();
//				if (str != null) {
//					Pattern pattern = Pattern.compile("Column .* is either not in any table");
//					boolean bool = pattern.matcher(str).find();
//					if (bool)
//						return true;
//				}
//			}
//			log.error(sQLGrammarException);
//			return false;
//		}
		return true;
	}

	public static boolean isDbUpdateNeeded(Integer paramInteger) {
		return paramInteger == null || paramInteger < DATABASE_VERSION;
	}

//	public static Map<String, String> getStoreProperties(String paramString1, String paramString2, String paramString3, String paramString4) throws Exception {
//		Class.forName(paramString2);
//		Connection connection = null;
//		try {
//			String str1 = Messages.getString("DatabaseUtil.6");
////			str1 = String.format(str1, new Object[] { VersionInfo.getAppName() });
//			str1 = String.format(str1, VersionInfo.getAppName());
//			connection = DriverManager.getConnection(paramString1, paramString3, paramString4);
//			DatabaseMetaData databaseMetaData = connection.getMetaData();
//			String str2 = getActualTableName(databaseMetaData, "store_properties");
//			if (str2 == null)
//				throw new PosException(str1);
//			String str3 = getActualColumnName(databaseMetaData, str2, "property_name");
//			String str4 = getActualColumnName(databaseMetaData, str2, "property_value");
//			if (str3 == null || str4 == null)
//				throw new PosException(str1);
////			String str5 = String.format("select * from %s", new Object[] { str2 });
//			String str5 = String.format("select * from %s", str2);
//			HashMap<Object, Object> hashMap = new HashMap<>();
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery(str5);
//			while (resultSet.next()) {
//				String str6 = resultSet.getString(str3);
//				String str7 = resultSet.getString(str4);
//				hashMap.put(str6, str7);
//			}
//			resultSet.close();
//			statement.close();
//			return (Map)hashMap;
//		} finally {
//			if (connection != null)
//				connection.close();
//		}
//	}

	public static boolean hasTable(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
		try (ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"})) {
			ArrayList<String> arrayList = new ArrayList<>();
			while (resultSet.next()) {
				String str = resultSet.getString(TABLE_NAME);
				arrayList.add(str.toLowerCase());
			}
			return arrayList.contains(tableName.toLowerCase());
		}
	}

	public static String getActualTableName(DatabaseMetaData paramDatabaseMetaData, String paramString) throws SQLException {
		try (ResultSet resultSet = paramDatabaseMetaData.getTables(null, null, null, new String[]{"TABLE"})) {
			while (resultSet.next()) {
				String str = resultSet.getString(TABLE_NAME);
				if (str.equalsIgnoreCase(paramString))
					return str;
			}
			return null;
		}
	}

	public static String getActualColumnName(DatabaseMetaData paramDatabaseMetaData, String paramString1, String paramString2) throws SQLException {
		try (ResultSet resultSet = paramDatabaseMetaData.getColumns(null, null, paramString1, null)) {
			while (resultSet.next()) {
				String str = resultSet.getString(COLUMN_NAME);
				if (str.equalsIgnoreCase(paramString2))
					return str;
			}
			return null;
		}
	}

	public static void removeConstrainsFromDestDB(DbConnectionInfo paramDbConnectionInfo) throws Exception {
		Connection connection = null;
		try {
			paramDbConnectionInfo.openConnection();
			connection = paramDbConnectionInfo.getConnection();
			connection.setAutoCommit(false);
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			String str1 = paramDbConnectionInfo.getSelectedDatabase().getHibernateDialect();
			Dialect dialect = (Dialect)Class.forName(str1).newInstance();
			String str2 = dialect.getDropForeignKeyString();
			String str3 = dialect.getSchemaNameResolver().resolveSchemaName(connection, dialect);
			Statement statement = connection.createStatement();
			ResultSet resultSet = databaseMetaData.getTables(null, str3, null, new String[] { "TABLE" });
			while (resultSet.next()) {
				String str = resultSet.getString(TABLE_NAME);
				ResultSet resultSet1 = databaseMetaData.getImportedKeys(null, str3, str);
				while (resultSet1.next()) {
					String str4 = "ALTER TABLE " + str + str2 + resultSet1.getString(FK_NAME);
					statement.execute(str4);
				}
				resultSet1.close();
				resultSet1 = databaseMetaData.getExportedKeys(null, str3, str);
				while (resultSet1.next()) {
					String str4 = "ALTER TABLE " + resultSet1.getString(FK_TABLE_NAME) + str2 + resultSet1.getString(FK_NAME);
					statement.execute(str4);
				}
				resultSet1.close();
				ArrayList<String> arrayList = new ArrayList<>();
				ResultSet resultSet2 = databaseMetaData.getColumns(null, str3, str, null);
				ResultSet resultSet3 = databaseMetaData.getPrimaryKeys(null, str3, str);
				while (resultSet3.next()) {
					String str4 = resultSet3.getString(COLUMN_NAME);
					arrayList.add(str4);
				}
				ResultSetMetaData resultSetMetaData = resultSet2.getMetaData();
				byte b = 1;
				while (resultSet2.next()) {
					String str4 = resultSet2.getString(COLUMN_NAME);
					if (b < resultSetMetaData.getColumnCount()) {
						int i = resultSetMetaData.isNullable(b);
						if (i == 0 && !arrayList.contains(str4)) {
							String str5 = "ALTER TABLE " + str + " ALTER COLUMN " + str4 + " null";
							statement.execute(str5);
						}
					}
					b++;
				}
				resultSet2.close();
				resultSet3.close();
			}
			resultSet.close();
			System.out.println("=======================");
			statement.close();
			connection.commit();
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	public static void restoreDbConstraints(DbConnectionInfo paramDbConnectionInfo) {
		Database database = paramDbConnectionInfo.getSelectedDatabase();
		updateDatabase(paramDbConnectionInfo.getConnectionString(), database.getHibernateDialect(), database
				.getHibernateConnectionDriverClass(), paramDbConnectionInfo.getUserName(), paramDbConnectionInfo.getPassword());
	}

	public static Database getDefaultDatabase() {
		return Database.getByProviderName(getDatabaseProviderName());
	}

	public static String getDatabaseProviderName() {
		return "MySQL";
	}

	public static void setupC3P0connectionPoolSettings(StandardServiceRegistryBuilder standardServiceRegistryBuilder) {
		standardServiceRegistryBuilder.applySetting("hibernate.c3p0.min_size", "0");
		standardServiceRegistryBuilder.applySetting("hibernate.c3p0.max_size", "5");
		standardServiceRegistryBuilder.applySetting("hibernate.c3p0.timeout", "120");
		standardServiceRegistryBuilder.applySetting("hibernate.c3p0.max_statements", "0");
		standardServiceRegistryBuilder.applySetting("hibernate.c3p0.checkoutTimeout", "3000");
		standardServiceRegistryBuilder.applySetting("hibernate.c3p0.acquireRetryAttempts", "1");
		standardServiceRegistryBuilder.applySetting("hibernate.c3p0.acquireRetryDelay", "100");
		standardServiceRegistryBuilder.applySetting("hibernate.c3p0.acquireIncrement", "1");
		standardServiceRegistryBuilder.applySetting("testConnectionOnCheckout", "true");
		standardServiceRegistryBuilder.applySetting("hibernate.c3p0.breakAfterAcquireFailure", "false");
	}

	public static void setSessionFactory(SessionFactory paramSessionFactory) {
		setSessionFactory(null, paramSessionFactory);
	}
	public static void setSessionFactory(String paramString, SessionFactory sessionFactory) {
		if (null == paramString) {
			DatabaseUtil.sessionFactory = sessionFactory;
		} else {
			if (null == sessionFactoryMap)
				sessionFactoryMap = new HashMap<>();
			sessionFactoryMap.put(paramString, sessionFactory);
		}
	}

	protected SessionFactory getSessionFactory() {
		return getSessionFactory(getConfigurationFileName());
	}

	protected SessionFactory getSessionFactory(String paramString) {
		if (null == paramString) {
			if (null == sessionFactory)
				throw new RuntimeException("The session factory has not been initialized (or an error occurred during initialization)");
			return sessionFactory;
		}
		if (null == sessionFactoryMap)
			throw new RuntimeException("The session factory for '" + paramString + "' has not been initialized (or an error occurred during initialization)");
		SessionFactory sessionFactory = sessionFactoryMap.get(paramString);
		if (null == sessionFactory)
			throw new RuntimeException("The session factory for '" + paramString + "' has not been initialized (or an error occurred during initialization)");
		return sessionFactory;
	}

	public Session getSession() {
		return getSession(getConfigurationFileName(), false);
	}

	public Session createNewSession() {
		return getSession(getConfigurationFileName(), true);
	}

	protected Session getSession(String paramString, boolean paramBoolean) {
		if (paramBoolean)
			return getSessionFactory(paramString).openSession();
		if (null == paramString) {
			if (null == sessions)
				sessions = new ThreadLocal<>();
			Session session1 = sessions.get();
			if (null == session1 || !session1.isOpen()) {
				session1 = getSessionFactory(null).openSession();
				sessions.set(session1);
			}
			return session1;
		}
		if (null == mappedSessions)
			mappedSessions = new ThreadLocal<>();
		Map<Object, Object> map = mappedSessions.get();
		if (null == map) {
			map = new HashMap<>(1);
			mappedSessions.set(map);
		}
		Session session = (Session)map.get(paramString);
		if (null == session || !session.isOpen()) {
			session = getSessionFactory(paramString).openSession();
			map.put(paramString, session);
		}
		return session;
	}

	public static void closeCurrentThreadSessions() {
		if (null != sessions) {
			Session session = sessions.get();
			if (null != session && session.isOpen()) {
				session.close();
				sessions.set(null);
			}
		}
		if (null != mappedSessions) {
			Map<Object, Session> map = mappedSessions.get();
			if (null != map) {
				HibernateException hibernateException = null;
				for (Session session : map.values()) {
					try {
						if (null != session && session.isOpen())
							session.close();
					} catch (HibernateException hibernateException1) {
						hibernateException = hibernateException1;
					}
				}
				map.clear();
				if (null != hibernateException)
					throw hibernateException;
			}
		}
	}

	public void closeSession(Session paramSession) {
		try {
			if (null != paramSession)
				paramSession.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public Transaction beginTransaction(Session session) {
		return session.beginTransaction();
	}

	public void commitTransaction(Transaction transaction) {
		transaction.commit();
	}

	public static Configuration getNewConfiguration(String paramString) {
		return new Configuration();
	}

	public String getConfigurationFileName() {
		return null;
	}

	public EntityManager getEntityManager() {
		EntityManager entityManager = sessionFactory.createEntityManager();
		return entityManager;
	}

	public static void releaseConnection() {
		closeCurrentThreadSessions();
		if (sessionFactory != null && !sessionFactory.isClosed())
			sessionFactory.close();
		if (standardServiceRegistry != null)
			StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
	}
}

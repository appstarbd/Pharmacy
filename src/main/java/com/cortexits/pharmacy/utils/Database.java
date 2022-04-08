package com.cortexits.pharmacy.utils;

import org.apache.commons.lang3.StringUtils;

public enum Database {
	DERBY_SINGLE("Derby Single", "jdbc:derby:pharmabase/data", "jdbc:derby:pharmabase/data;create=true", "", "org.apache.derby.jdbc.EmbeddedDriver", ""),
	DERBY_SERVER("Derby Server", "jdbc:derby://<host>:<port>/<db>", "jdbc:derby://<host>:<port>/<db>;create=true", "51527", "org.apache.derby.jdbc.ClientDriver", ""),
//	H2("H2", "jdbc:log4jdbc:h2:file:pharmabase/data", "jdbc:log4jdbc:h2:file:pharmabase/data;AUTO_SERVER=TRUE;TRACE_LEVEL_FILE=4", "", "org.h2.Driver", ""),
//	H2_MEMORY("H2 Memory", "jdbc:log4jdbc:h2:file:pharmabase/data", "jdbc:log4jdbc:h2:file:pharmabase/data;AUTO_SERVER=TRUE;TRACE_LEVEL_FILE=4", "", "org.h2.Driver", ""),
//	DB2("DB2", "jdbc:", "jdbc:", "", "Driver", "org.hibernate.dialect.DB2Dialect"),
//	HYPERSONIC("HypersonicSQL", "jdbc:", "jdbc:", "", "Driver", "org.hibernate.dialect.HSQLDialect"),
//	FIREBIRD("Firebird", "jdbc:", "jdbc:", "", "Driver", "org.hibernate.dialect.FirebirdDialect"),
	MYSQL("MySQL", "jdbc:mysql://<host>:<port>/<db>?characterEncoding=UTF-8", "jdbc:mysql://<host>:<port>/<db>?characterEncoding=UTF-8", "3306", "com.mysql.cj.jdbc.Driver", "org.hibernate.dialect.MySQL8Dialect"),
	POSTGRES("POSTGRES", "jdbc:postgresql://<host>:<port>/<db>", "jdbc:postgresql://<host>:<port>/<db>", "5432", "org.postgresql.Driver", "org.hibernate.dialect.PostgreSQLDialect"),
	MS_SQL("MSSQL Server", "jdbc:jtds:sqlserver://<host>:<port>/<db>", "jdbc:jtds:sqlserver://<host>:<port>/<db>", "1433", "net.sourceforge.jtds.jdbc.Driver", "org.hibernate.dialect.SQLServerDialect");

	private String providerName;
	private String connectString;
	private String createConnectString;
	private String defaultPort;
	private String driverClass;
	private String dialect;

	Database(String providerName, String connectString, String createConnectString, String defaultPort, String driverClass, String dialect) {
		this.providerName = providerName;
		this.connectString = connectString;
		this.createConnectString = createConnectString;
		this.defaultPort = defaultPort;
		this.driverClass = driverClass;
		this.dialect = dialect;
	}

	public String getConnectString(String db) {
		return getConnectString("localhost", "3306", db);
	}

	public String getConnectString(String host, String defaultPort, String db) {
		String connectString = this.connectString.replace("<host>", host);
		if (StringUtils.isEmpty(defaultPort))
			defaultPort = this.defaultPort;
		connectString = connectString.replace("<port>", defaultPort);
		connectString = connectString.replace("<db>", db);
		return connectString;
	}

	public String getCreateDbConnectString(String host, String defaultPort, String db) {
		String createConnectString = this.createConnectString.replace("<host>", host);
		if (StringUtils.isEmpty(defaultPort))
			defaultPort = this.defaultPort;
		createConnectString = createConnectString.replace("<port>", defaultPort);
		createConnectString = createConnectString.replace("<db>", db);
		return createConnectString;
	}

	public String getProviderName() {
		return this.providerName;
	}

	public String getJdbcUrlFormat() {
		return this.connectString;
	}

	public String getDefaultPort() {
		return this.defaultPort;
	}

	public String getHibernateConnectionDriverClass() {
		return this.driverClass;
	}

	public String getHibernateDialect() {
		return this.dialect;
	}

	public static Database getByProviderName(String providerName) {
		Database[] databases = values();
		for (Database database : databases) {
			if (database.providerName.equals(providerName))
				return database;
		}
		return null;
	}

	@Override
	public String toString() {
		return this.providerName;
	}
}

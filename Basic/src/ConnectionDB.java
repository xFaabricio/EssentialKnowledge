import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	private Connection connection = null;
	
	private String hostName = null;
	private String userName = null;
	private String password = null;
	private String url = null;
	private String jdbcDriver = null;
	private String dataBaseName = null;
	private String dataBasePrefix = null;
	private String dataBasePort = null;
	private String dataBaseKey = null;
	
	public ConnectionDB(String hostName, String userName, String password, String jdbcDriver,
			String dataBaseName, String dataBasePrefix, String dataBasePort) {
		super();
		this.hostName = hostName;
		this.userName = userName;
		this.password = password;
		this.jdbcDriver = jdbcDriver;
		this.dataBaseName = dataBaseName;
		this.dataBasePrefix = dataBasePrefix;
		this.dataBasePort = dataBasePort;
		
		this.url = dataBasePrefix + hostName + ":"+dataBasePort+"/" + dataBaseName + "/";
	}
	
	

	public ConnectionDB(String userName, String password, String url, String jdbcDriver) {
		super();
		this.userName = userName;
		this.password = password;
		this.url = url;
		this.jdbcDriver = jdbcDriver;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				//TODO: use um sistema de log apropriado.
				e.printStackTrace();
			}
		}
	}

	public Connection getConnection() {
		
		try {
			
			if(connection == null) {
				Class.forName(this.jdbcDriver);
				connection = DriverManager.getConnection(this.url, this.userName, this.password);
				identifyDataBaseWithoutSysout();
			}else if(connection.isClosed()) {
				connection = null;
				return getConnection();
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return connection;
	}

	public void identifyDataBaseWithoutSysout() {
		
		if(jdbcDriver.equals("oracle.jdbc.driver.OracleDriver")) {
			dataBaseKey = "ORACLE";
		}else if(jdbcDriver.equals("com.microsoft.sqlserver.jdbc.SQLServerDriver")) {
			dataBaseKey = "SQLSERVER";
		}else if(jdbcDriver.equals("com.mysql.jdbc.Driver")) {
			dataBaseKey = "MYSQL";
		}else {
			dataBaseKey = null;
		}
		
	}
	
	public void identifyDataBase() {
		
		System.out.println("Identificando Banco de Dados...");
		
		if(jdbcDriver.equals("oracle.jdbc.driver.OracleDriver")) {
			dataBaseKey = "ORACLE";
			System.out.println("Banco: Oracle");
		}else if(jdbcDriver.equals("com.microsoft.sqlserver.jdbc.SQLServerDriver")) {
			dataBaseKey = "SQLSERVER";
			System.out.println("Banco: SQLServer");		
		}else if(jdbcDriver.equals("com.mysql.jdbc.Driver")) {
			dataBaseKey = "MYSQL";
			System.out.println("Banco: MySQL");
		}else {
			System.out.println("Banco não identificado");
		}
		
	}
	
	public void connectionTest() {
		
		getConnection();
		
		identifyDataBase();
		
		try {
			if(connection.isValid(20)) {
				System.out.println("Conexão realizada com sucesso !!");
				closeConnection();
			}
		} catch (SQLException e) {
			// TODO: handle exception			
			System.out.println("Conexão malsucedida !!");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public String getDataBaseName() {
		return dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}

	public String getDataBasePrefix() {
		return dataBasePrefix;
	}

	public void setDataBasePrefix(String dataBasePrefix) {
		this.dataBasePrefix = dataBasePrefix;
	}

	public String getDatabasePort() {
		return dataBasePort;
	}

	public void setDatabasePort(String databasePort) {
		this.dataBasePort = databasePort;
	}

	public String getDataBasePort() {
		return dataBasePort;
	}

	public void setDataBasePort(String dataBasePort) {
		this.dataBasePort = dataBasePort;
	}

	public String getDataBaseKey() {
		return dataBaseKey;
	}

	public void setDataBaseKey(String dataBaseKey) {
		this.dataBaseKey = dataBaseKey;
	}
	
}

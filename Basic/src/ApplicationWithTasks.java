import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationWithTasks {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
			
//		String hostName = "localhost";
//		String dataBaseName = "SIQ_JUN_WEB";
//		String dataBasePrefix = "jdbc:sqlserver:/";
//		String databasePort = "1433";
		
		/**
		 * Exemplo Conex�o com SQLSERVER
		 **/
		
		// Informar as configura��es do banco de dados
		
		String userName = "sa";
		String password = "lsalles";
		String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SIQ_JUN_WEB";
		
		// Passando as informa��es para o construtor
		
//		ConnectionDB connectionDB = new ConnectionDB(hostName, userName, password, jdbcDriver, dataBaseName, dataBasePrefix, databasePort);		
		ConnectionDB connectionDB = new ConnectionDB(userName, password, url, jdbcDriver);
		
		//Simples teste para ver se foi realizada a conex�o
		connectionDB.connectionTest();
		
		// Realizar a conex�o com o banco de dados
		Connection connectionSQLServer = connectionDB.getConnection();
		connectionSQLServer.close();
		
		
		/**
		 * Exemplo Conex�o com Oracle
		 **/
				
		// Informar as configura��es do banco de dados

		userName = "SIQ_DANIEL";
		password = "SIQ_DANIEL";
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=ORASIQ)(SERVER=DEDICATED)))";
		
		connectionDB = new ConnectionDB(userName, password, url, jdbcDriver);
		
		//Simples teste para ver se foi realizada a conex�o
		connectionDB.connectionTest();
		
		// Realizar a conex�o com o banco de dados
		Connection connectionOracle = connectionDB.getConnection();
		connectionOracle.close();
		
		/**
		 * Exemplo Conex�o com MySQL
		 **/
				
		// Informar as configura��es do banco de dados

		userName = "siq_jun_web";
		password = "siq_jun_web";
		jdbcDriver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/siq_jun_web?useSSL=false";
		
		connectionDB = new ConnectionDB(userName, password, url, jdbcDriver);
		
		//Simples teste para ver se foi realizada a conex�o
		connectionDB.connectionTest();
		
		// Realizar a conex�o com o banco de dados
		Connection connectionMySQL = connectionDB.getConnection();
		connectionMySQL.close();
		
	}

}

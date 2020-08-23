import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationWithTasks {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
//		String hostName = "localhost";
//		String dataBaseName = "SIQ_JUN_WEB";
//		String dataBasePrefix = "jdbc:sqlserver:/";
//		String databasePort = "1433";
		
		String tableName = null;
		
		/**
		 * Exemplo Conexão com SQLSERVER
		 **/
		
		// Informar as configurações do banco de dados
		
		String userName = "sa";
		String password = "lsalles";
		String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SIQ_JUN_WEB";
		
		// Passando as informações para o construtor
		
//		ConnectionDB connectionDB = new ConnectionDB(hostName, userName, password, jdbcDriver, dataBaseName, dataBasePrefix, databasePort);		
		ConnectionDB connectionDBSQLServer = new ConnectionDB(userName, password, url, jdbcDriver);
		
		//Simples teste para ver se foi realizada a conexão
		connectionDBSQLServer.connectionTest();
		
		// Realizar a conexão com o banco de dados
		Connection connectionSQLServer = connectionDBSQLServer.getConnection();
		connectionSQLServer.close();
		
		
		/**
		 * Exemplo Conexão com Oracle
		 **/
				
		// Informar as configurações do banco de dados

		userName = "SIQ_DANIEL";
		password = "SIQ_DANIEL";
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=ORASIQ)(SERVER=DEDICATED)))";
		
		ConnectionDB connectionDBOracle = new ConnectionDB(userName, password, url, jdbcDriver);
		
		//Simples teste para ver se foi realizada a conexão
		connectionDBOracle.connectionTest();
		
		// Realizar a conexão com o banco de dados
		Connection connectionOracle = connectionDBOracle.getConnection();
		connectionOracle.close();
		
		/**
		 * Exemplo Conexão com MySQL
		 **/
				
		// Informar as configurações do banco de dados

		userName = "siq_jun_web";
		password = "siq_jun_web";
		jdbcDriver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/siq_jun_web?useSSL=false&allowPublicKeyRetrieval=true";
		
		ConnectionDB connectionDBMySQL = new ConnectionDB(userName, password, url, jdbcDriver);
		
		//Simples teste para ver se foi realizada a conexão
		connectionDBMySQL.connectionTest();
		
		// Realizar a conexão com o banco de dados
		Connection connectionMySQL = connectionDBMySQL.getConnection();

		// Utilizar o DAO referente ao Banco
		GenericDAO genericDAO = getGenericDAOByDataBase(connectionDBMySQL);
		
		//Criação de Tabela
		tableName = "TESTE";
		
		List<ColumnsInformations> columnsInformationsList = new ArrayList<>();		
		ColumnsInformations columnsInformations = new ColumnsInformations("TEXTO", "VARCHAR(20)");
		columnsInformationsList.add(columnsInformations);
		
		genericDAO.createTable(connectionMySQL, tableName, columnsInformationsList);
		
		
		connectionMySQL.close();
		
	}

	
	public static GenericDAO getGenericDAOByDataBase(ConnectionDB connectionDB) {
		
		GenericDAO genericDAO = null;
		
		if(connectionDB.getDataBaseKey().equals("MYSQL")) {
			genericDAO = new GenericDAOMySQL();
		}else if (connectionDB.getDataBaseKey().equals("SQLSERVER")) {
			genericDAO = new GenericDAOSQLServer();
		}else if(connectionDB.getDataBaseKey().equals("ORACLE")) {
			genericDAO = new GenericDAOOracle();
		}else{
			genericDAO = new GenericDAODefault();
		}
		
		return genericDAO;
	}
	
}

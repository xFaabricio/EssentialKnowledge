package br.com.basic.databases;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import br.com.basic.ColumnsInformations;
import br.com.basic.interfaces.GenericDAO;

public class GenericDAOSQLServer implements GenericDAO {

	@Override
	public void createTable(Connection connection, String tableName, List<ColumnsInformations> columnsInformations)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Connection connection, String tableName, HashMap<String, String> columnsAndValues)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInformations(Connection connection, List<ColumnsInformations> columnsInformations)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAllInformations(Connection connection, List<ColumnsInformations> columnsInformations)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTable(Connection connection, String tableName)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}

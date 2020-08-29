package br.com.basic.interfaces;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import br.com.basic.ColumnsInformations;

public interface GenericDAO {

	// Verificar se a Tabela já existe
	
	public void createTable(Connection connection, String tableName, List<ColumnsInformations> columnsInformations) throws SQLException;
	
	public void deleteTable(Connection connection, String tableName) throws SQLException;
	
	public void insert(Connection connection, String tableName, HashMap<String,String> columnsAndValues) throws SQLException;
	
	public void deleteAllInformations(Connection connection, String tableName, List<ColumnsInformations> whereColumnsInformations) throws SQLException;
	
	public void updateAllInformations(Connection connection, String tableName, List<ColumnsInformations> updateColumnsInformations, List<ColumnsInformations> whereColumnsInformations) throws SQLException;
	
}

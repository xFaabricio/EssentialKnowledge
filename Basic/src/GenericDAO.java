import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface GenericDAO {

	// Verificar se a Tabela já existe
	
	public void createTable(Connection connection, String tableName, List<ColumnsInformations> columnsInformations) throws SQLException;
	
	public void insert(Connection connection, String tableName, HashMap<String,String> columnsAndValues) throws SQLException;
	
	public void deleteAllInformations(Connection connection, List<ColumnsInformations> columnsInformations) throws SQLException;
	
	public void updateAllInformations(Connection connection, List<ColumnsInformations> columnsInformations) throws SQLException;
	
}

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class GenericDAOMySQL implements GenericDAO {

	@Override
	public void createTable(Connection connection, String tableName, List<ColumnsInformations> columnsInformations)
			throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Iniciando Criação da Tabela: " + tableName);
		
		try {
			
			Statement statament = connection.createStatement();
			Boolean tableFound = false;
			
			//Verificando se a Tabela existe
            String query = ("SELECT * FROM information_schema.tables WHERE table_schema = 'siq_jun_web' AND table_name = " + "'" + tableName + "';");
            ResultSet resultSet = statament.executeQuery(query);                      
            
            if(resultSet.next()) {
        		System.out.println("Criação não concluída: Tabela já existe.");
        		tableFound = true;
            }
            
            if(!tableFound) {            	            	
            	String createTable = "CREATE TABLE " + tableName + "("; 
            	
            	for(int x=0; x<columnsInformations.size(); x++) {            		
            		
            		if(x==0) {
            			createTable += columnsInformations.get(x).getColumnName() + " " + columnsInformations.get(x).getColumnType();
            		}else {
            			createTable += "," + columnsInformations.get(x).getColumnName()+ " " + columnsInformations.get(x).getColumnType();
            		}
            	}
            	
            	createTable += ")";
            	
            	statament.executeUpdate(createTable);
            	System.out.println("A tabela " + tableName + " foi criada com sucesso !!");
            }
            
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Falha na Criação da tabela: " + e.getMessage());
		}
		
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

	
}

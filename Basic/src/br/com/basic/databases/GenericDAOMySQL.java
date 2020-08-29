package br.com.basic.databases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.basic.ColumnsInformations;
import br.com.basic.interfaces.GenericDAO;

public class GenericDAOMySQL implements GenericDAO {

	@Override
	public void createTable(Connection connection, String tableName, List<ColumnsInformations> columnsInformations)
			throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Iniciando Cria��o da Tabela: " + tableName);
		
		try {
			
			Statement statament = connection.createStatement();
			Boolean tableFound = false;
			
			//Verificando se a Tabela existe
            String query = ("SELECT * FROM information_schema.tables WHERE table_schema = 'siq_jun_web' AND table_name = " + "'" + tableName + "';");
            ResultSet resultSet = statament.executeQuery(query);                      
            
            if(resultSet.next()) {
        		System.out.println("Cria��o n�o conclu�da: Tabela j� existe.");
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
			
			System.out.println("Falha na Cria��o da tabela: " + e.getMessage());
		}
		
	}

	@Override
	public void insert(Connection connection, String tableName, HashMap<String, String> columnsAndValues)
			throws SQLException {
				
		System.out.println("Iniciando Insert de Registro na Tabela: " + tableName);
		
		try {
			
			Statement statament = connection.createStatement();
			Boolean tableFound = false;
			
			//Verificando se a Tabela existe
            String query = ("SELECT * FROM information_schema.tables WHERE table_schema = 'siq_jun_web' AND table_name = " + "'" + tableName + "';");
            ResultSet resultSet = statament.executeQuery(query);                      
            
            if(resultSet.next()) {
        		System.out.println("Tabela existe, pronta para inser��o de registros !");
        		tableFound = true;
            }
            
            if(tableFound) {            	            	
            	
            	String insert = "INSERT INTO " + tableName + " (";
            	String columns = "";
            	String values = "";
            	
            	int count = 0;
            	
            	for(Map.Entry<String, String> entry : columnsAndValues.entrySet()) {
            	    String key = entry.getKey();
            	    String value = entry.getValue();
            	    
            	    if(count == 0) {
            	    	columns += key;
            	    	values += "'"+value+"'";
            	    }else {
            	    	columns += "," +key;
            	    	values += "," +"'"+value+"'";
            	    }
            	}
            	
            	insert += columns + ")" + " VALUES ( " + values + " );";
            	
            	statament.execute(insert);
            	
            	System.out.println("Inser��o realizada com sucesso !!");
            }else {
            	System.out.println("A Tabela " + tableName + " n�o existe, n�o � poss�vel realizar inser��o.");
            }
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Falha na inser��o de registros: " + e.getMessage());
		}
		
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
		
		System.out.println("Deletando a Tabela: " + tableName);
		
		//Verificando se a Tabela existe
        
		try {
		
			String query = ("SELECT * FROM information_schema.tables WHERE table_schema = 'siq_jun_web' AND table_name = " + "'" + tableName + "';");
			Statement statament = connection.createStatement();        
	        ResultSet resultSet = statament.executeQuery(query);                      
	        
	        if(resultSet.next()) {
	    		String deleteTable = "DROP TABLE " + tableName;
	    		
	    		statament.executeUpdate(deleteTable);
	        	System.out.println("A tabela " + tableName + " foi deletada com sucesso !!");
	        }
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Falha ao deletar a tabela: " + e.getMessage());
		}
		
		
	}

	
}

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
		
		System.out.println("Iniciando Criação da Tabela: " + tableName);
		
		try {
			
			Statement statament = connection.createStatement();
			
			//Verificando se a Tabela existe
            
            if(!verifyIfTableExist(connection, tableName)) {            	            	
            	String createTable = "CREATE TABLE " + tableName + "("; 
            	
            	for(int x=0; x<columnsInformations.size(); x++) {            		
            		
            		if(x==0) {
            			createTable += columnsInformations.get(x).getColumnName() + " " + columnsInformations.get(x).getColumnTypeOrValue();
            		}else {
            			createTable += "," + columnsInformations.get(x).getColumnName()+ " " + columnsInformations.get(x).getColumnTypeOrValue();
            		}
            	}
            	
            	createTable += ")";
            	
            	statament.executeUpdate(createTable);
            	System.out.println("A tabela " + tableName + " foi criada com sucesso !!");
            }else {
            	System.out.println("Criação não concluída: Tabela já existe.");
            }
            
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Falha na Criação da tabela: " + e.getMessage());
		}
		
	}

	@Override
	public void insert(Connection connection, String tableName, HashMap<String, String> columnsAndValues)
			throws SQLException {
				
		System.out.println("Iniciando Insert de Registro na Tabela: " + tableName);
		
		try {
			
			Statement statament = connection.createStatement();
			
			//Verificando se a Tabela existe
   
            if(verifyIfTableExist(connection, tableName)) {            	            	
            	
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
            	
            	statament.executeUpdate(insert);
            	
            	System.out.println("Inserção realizada com sucesso !!");
            }else {
            	System.out.println("A Tabela " + tableName + " não existe, não é possível realizar inserção.");
            }
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Falha na inserção de registros: " + e.getMessage());
		}
		
	}


	@Override
	public void deleteTable(Connection connection, String tableName)
			throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Deletando a Tabela: " + tableName);
		 
		//Verificando se a Tabela existe
        
		try {
			
			Statement statament = connection.createStatement();
			
	        if(verifyIfTableExist(connection, tableName)) {
	    		String deleteTable = "DROP TABLE " + tableName;
	    		
	    		statament.executeUpdate(deleteTable);
	        	System.out.println("A tabela " + tableName + " foi deletada com sucesso !!");
	        }
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Falha ao deletar a tabela: " + e.getMessage());
		}
		
		
	}

	@Override
	public void deleteAllInformations(Connection connection, String tableName,
			List<ColumnsInformations> whereColumnsInformations) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Deletando registros da Tabela: " + tableName);
		
		try {
		
			Statement statament = connection.createStatement();
			
			//Verificando se a Tabela existe
			if(verifyIfTableExist(connection, tableName)) {
				
				String delete = "DELETE FROM " + tableName;
				
				if(whereColumnsInformations != null && whereColumnsInformations.size() > 0) {
					for(int i=0; i < whereColumnsInformations.size(); i++) {
						
						if(i==0) {
							delete += " WHERE " + whereColumnsInformations.get(i).getColumnName() + " = " + whereColumnsInformations.get(i).getColumnTypeOrValue();
						}else {
							delete += " AND " + whereColumnsInformations.get(i).getColumnName() + " = " + whereColumnsInformations.get(i).getColumnTypeOrValue();
						}
						
					}
				}
				
				statament.executeUpdate(delete);
				
			}else {
				System.out.println("Tabela " + tableName + " não encontranda !!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Falha ao deletar os registros da tabela " + tableName + " : " + e.getMessage());
		}
		
		
		
	}

	@Override
	public void updateAllInformations(Connection connection, String tableName,
			List<ColumnsInformations> updateColumnsInformations, List<ColumnsInformations> whereColumnsInformations)
			throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Atualizando registros da Tabela: " + tableName);
		
		try {
			
			Statement statament = connection.createStatement();
			
			//Verificando se a Tabela existe
			if(verifyIfTableExist(connection, tableName)) {
				
				String delete = "DELETE FROM " + tableName;
				
				if(whereColumnsInformations != null && whereColumnsInformations.size() > 0) {
					for(int i=0; i < whereColumnsInformations.size(); i++) {
						
						if(i==0) {
							delete += " WHERE " + whereColumnsInformations.get(i).getColumnName() + " = " + whereColumnsInformations.get(i).getColumnTypeOrValue();
						}else {
							delete += " AND " + whereColumnsInformations.get(i).getColumnName() + " = " + whereColumnsInformations.get(i).getColumnTypeOrValue();
						}
						
					}
				}
				
				statament.executeUpdate(delete);
				
			}else {
				System.out.println("Tabela " + tableName + " não encontranda !!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Falha ao deletar os registros da tabela " + tableName + " : " + e.getMessage());
		}
		
	}

	
	public Boolean verifyIfTableExist(Connection connection, String tableName) {
		
		boolean tableExists = false;
		
		try {
			String query = ("SELECT * FROM information_schema.tables WHERE table_schema = " + "'" + connection.getMetaData().getUserName().split("@")[0] + "'" + " AND table_name = " + "'" + tableName + "';");
			Statement statament = connection.createStatement();        
	        ResultSet resultSet = statament.executeQuery(query);
	        
	        tableExists = resultSet.next();
	        
		} catch (SQLException e) {
			// TODO: handle exception			
			System.out.println("Falha na verificação da tabela: " + e.getMessage());
		}
		
		return tableExists;
	}
	
}

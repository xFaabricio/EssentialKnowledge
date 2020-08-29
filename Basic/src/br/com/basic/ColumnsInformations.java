package br.com.basic;

public class ColumnsInformations {

	String columnName;
	
	String columnTypeOrValue;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnTypeOrValue() {
		return columnTypeOrValue;
	}

	public void setColumnTypeOrValue(String columnTypeOrValue) {
		this.columnTypeOrValue = columnTypeOrValue;
	}

	public ColumnsInformations(String columnName, String columnTypeOrValue) {
		super();
		this.columnName = columnName;
		this.columnTypeOrValue = columnTypeOrValue;
	}
	
}

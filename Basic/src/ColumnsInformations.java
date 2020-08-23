
public class ColumnsInformations {

	String columnName;
	
	String columnType;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public ColumnsInformations(String columnName, String columnType) {
		super();
		this.columnName = columnName;
		this.columnType = columnType;
	}
	
}

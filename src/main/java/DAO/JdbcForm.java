package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JdbcForm {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/betesterschema";

	static final String USER = "root";
	static final String PASS = "123456";

	Connection connection = null;
	PreparedStatement preStatement = null;
	ResultSet result = null;

	public ResultSet query(String sql) throws SQLException, ClassNotFoundException {
		preStatement = getStatement(sql);
		
		result = preStatement.executeQuery();
		return result;
	}

	public ResultSet query(String sql, ArrayList<Object> pars) throws SQLException, ClassNotFoundException {
		preStatement = getStatement(sql);
		
		for (int i = 0; i < pars.size(); i++) {
			if(pars.get(i) instanceof String){
				preStatement.setString(i+1, (String) pars.get(i) );
			}else if(pars.get(i) instanceof Integer){
				preStatement.setInt(i+1, (Integer) pars.get(i) );
			}
		}
		
		result = preStatement.executeQuery();
		return result;
	}

	private PreparedStatement getStatement(String sql) throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		return connection.prepareStatement(sql);
	}

	public void endQuery() throws SQLException {
		if (connection != null)
			connection.close();
		if (preStatement != null)
			preStatement.close();
		if (result != null)
			result.close();
	}

}

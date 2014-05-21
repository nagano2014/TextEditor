package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
	
	protected Connection con = null;
	protected Statement stmt = null;
		
	protected void getConnection() throws SQLException, ClassNotFoundException {
		String drv = "com.mysql.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/ver_ctrl_db";
		String user = "root";
		String pass = "root";
		
		if(this.con != null) {
			return;
		}
		
		Class.forName(drv);
		con = DriverManager.getConnection(url, user, pass);
	}
	
	protected void createStmt() throws SQLException, ClassNotFoundException {
		if(this.stmt != null) {
			return;
		}
		
		getConnection();
		
		stmt = con.createStatement();
	}
	
	protected void close() throws SQLException {
		if(this.stmt != null) {
			this.stmt.close();
		}
		this.stmt = null;
		
		if(con != null) {
			this.con.close();
		}
		this.con = null;
	}
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
	
	private Connection con = null;
	private Statement stmt = null;
		
	protected void getConnection() throws DAOException {
		String drv = "com.mysql.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/ver_ctrl_db";
		String user = "root";
		String pass = "root";
		
		if(this.con != null) {
			return;
		}
		
		try {
			Class.forName(drv);
		} catch (ClassNotFoundException e) {
			throw new DAOException("[conect]異常", e);
		}
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			return;
		} catch (SQLException e) {
			throw new DAOException("[conect]異常", e);
		}
	}
	
	protected void createStmt() throws DAOException {
		if(this.stmt != null) {
			return;
		}
		
		getConnection();
		
		try {
			stmt = con.createStatement();
		} catch(SQLException e) {
			throw new DAOException("[createStmt]異常", e);
		}
	}
	
	protected void close() throws DAOException {
		if(this.stmt != null) {
			try {
				this.stmt.close();
			} catch (SQLException e) {
				throw new DAOException("[close]異常", e);
			}
		}
		this.stmt = null;
		
		if(con != null) {
			try {
				this.con.close();
			} catch(SQLException e) {
				throw new DAOException("[close]異常", e);
			}
		}
		this.con = null;
	}
}

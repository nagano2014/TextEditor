package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
	
	protected Connection con = null;
	protected Statement stmt = null;
		
	protected void getConnection() {
		String drv = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ver_ctrl_db";
		String user = "root";
		String pass = "root";
		
		if(this.con != null) {
			return;
		}
		try{
			Class.forName(drv);
		}catch(ClassNotFoundException e){
			System.out.println("[conect]異常" + e);
		}
		
		try{
		con = DriverManager.getConnection(url, user, pass);
		return;
		
		}catch(SQLException e){
			System.out.println("[conect]異常" + e);
		}
	}
	
	protected void createStmt()  {
		if(this.stmt != null) {
			return;
		}
		
		try{
			stmt = con.createStatement();
		}catch(SQLException e){
			System.out.println("[createStmt]異常" + e);
		}
	}
	
	protected void close()  {
		if(this.stmt != null) {
			try{
				stmt.close();
			}catch(SQLException e){
				System.out.println("[close]異常" + e);
			}
		}
	
		this.stmt = null;
		
		if(con != null) {
			try{
				con.close();
			}catch(SQLException e){
				System.out.println("[close]異常" + e);
			}
		}
		this.con = null;
	}
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * データベース接続の取得とステートメントの取得
 * @author 高松
 *
 * 
 */

public abstract class DAO {
	
	//コネクションオブジェクト
	protected Connection con = null;
	//ステートメントオブジェクト
	protected Statement stmt = null;
		
	protected void getConnection() {
		//JDBCドライバ名
		String drv = "com.mysql.jdbc.Driver";
		//URL・ユーザー名・パスワードの設定
		String url = "jdbc:mysql://localhost:3306/ver_ctrl_db";
		String user = "root";
		String pass = "root";
		
		if(this.con != null) {
			return;
		}
		try{
			//JDBCドライバのロード
			Class.forName(drv);
			//ロードに失敗した場合の処理
		}catch(ClassNotFoundException e){
			System.out.println("[conect]異常" + e);
		}
		
		try{
			//データベースへの接続取得
		con = DriverManager.getConnection(url, user, pass);
		return;
		
		//SQLに関する例外処理
		}catch(SQLException e){
			System.out.println("[conect]異常" + e);
		}
	}
	
	protected void createStmt()  {
		if(this.stmt != null) {
			return;
		}
		
		try{
			//ステートメント取得
			stmt = con.createStatement();
		}catch(SQLException e){
			//SQLに関する例外処理
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

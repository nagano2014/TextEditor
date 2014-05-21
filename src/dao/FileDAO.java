package dao;

import java.sql.Date;
import java.sql.ResultSet;

import entity.FileEt;

public class FileDAO extends DAO{
	
	public FileEt selectByCode(int file_id, String file_path, Date file_make_day) {
		ResultSet res = null;
		
		getConnection();
		createStmt();
		
		FileEt fileEt = null;
		
		String sql = "insert into m_file values(" + file_id + ", '" + file_path + "', '" + file_make_day + "')";
		
		res = stmt.executeQuery(sql);
		
		boolean countFlg = res.next();
		if(countFlg) {
			fileEt = new FileEt();
			fileEt.setfileId(res.getString("file_id"));
			fileEt.setfilePath(res.getString("file_path"));
			fileEt.setfileMakeDay(res.getString("file_make_day"));
		}
		res.close();
		
		return fileEt;
	}
}
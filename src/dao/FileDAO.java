package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.FileEt;

public class FileDAO extends DAO{
	
	public int insert(int mFileId, String mFilePath, Date mFileMakeDay) {
		
		getConnection();
		createStmt();
		
		int count = 0;
		
		String sql = "(INSERT INTO m_file VALUES(" + mFileId + ", '" + mFilePath + "', '" + mFileMakeDay + "')";
		
		try {
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			close();
		}
		
		return count;
	}
	
	public List selectAll() {
		getConnection();
		createStmt();
		
		List<FileEt> list = new ArrayList<FileEt>();
		
		FileEt file = null;
		ResultSet res = null;
		
		try {
			String sql = "SELECT * FROM m_file";
			
			res = stmt.executeQuery(sql);
			
			boolean countFlg = res.next();
			if(countFlg) {
				int mFileId = res.getInt("file_id");
				String mFilePath = res.getString("file_path");
				Date mFileMd = res.getDate("file_make_day");
				list.add(new FileEt(mFileId, mFilePath, mFileMd));
			}
			res.close();
		}catch (SQLException e) {
			System.out.println(e);
		}finally{
			close();
		}
		return list;
	}
}
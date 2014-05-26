package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.FileEt;

/**
 * FileDAO
 * @author 会津
 *
 */

public class FileDAO extends DAO{
	
	/**
	 * 
	 * @param filePath
	 * @return SQL文の実行回数
	 */
	
	public int insert(String filePath) {
		
		getConnection();
		createStmt();
		
		int count = 0;
		
		String sql = "INSERT INTO m_file VALUES(0 , '" + filePath + "', NOW())";
		
		try {
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			close();
		}
		
		return count;
	}
	
	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return 検索結果
	 */
	
	public List<FileEt> selectByDate(Date date1, Date date2) {
		getConnection();
		createStmt();
		
		List<FileEt> list = new ArrayList<FileEt>();
		
		ResultSet res = null;
		
		try {
			String sql = "SELECT * FROM m_file WHERE file_make_day BETWEEN '" + date1 + "' AND '" + date2 + "'";
			
			res = stmt.executeQuery(sql);
			
			while(res.next()) {
				int mFileId = res.getInt("file_id");
				String mFilePath = res.getString("file_path");
				Timestamp mFileMd = res.getTimestamp("file_make_day");
				
				list.add(new FileEt(mFileId, mFilePath, mFileMd));
			}
			res.close();
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			close();
		}
		return list;
	}
	
	/**
	 * 
	 * @return 最大のファイルID
	 */
	
	public int getLatestFileId(){
		int id = -1;
		ResultSet res = null;
		String sql = "SELECT MAX(file_id) as file_id FROM m_file";
		getConnection();
		createStmt();
		
		try{
			res = stmt.executeQuery(sql);
			while(res.next()){
				id = res.getInt("file_id");
			}
		}catch (SQLException e) {
			
		}finally{
			close();
		}
		return id;
	}
}

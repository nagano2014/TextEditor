package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.TextEt;

public class TextDAO extends DAO{

	/*
	 * テキストDAO
	 * 会津匠
	 */
	
	public int insert(int FileId, int mLineNumber, String mLineContents) {
		
		getConnection();
		createStmt();
		
		int count = 0;
		
		String sql = "(INSERT INTO m_text VALUES(" + FileId + ", '" +mLineNumber + "', '" + mLineContents + "')";
		
		try {
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			close();
		}
		
		return count;
	}
	
	public List<TextEt> selectAll() {
		getConnection();
		createStmt();
		
		List<TextEt> list = new ArrayList<TextEt>();
		
		ResultSet res = null;

		try {
			String sql = "SELECT * FROM m_text";
		
			res = stmt.executeQuery(sql);
			
			boolean countFlg = res.next();
			if(countFlg) {
				int mFileId = res.getInt("file_id");
				int mLineNumber = res.getInt("line_number");
				String mLineContents = res.getString("line_contents");
				
				list.add(new TextEt(mFileId, mLineNumber, mLineContents));
			}
			res.close();
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			close();
		}
		return list;
	}
}
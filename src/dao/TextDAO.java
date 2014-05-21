package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.TextEt;

public class TextDAO extends DAO{

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
	
	public TextEt select(int mFileId, int mLineNumber, String mLineContents) {
		getConnection();
		createStmt();
		
		TextEt text = null;
		ResultSet res = null;

		try {
			String sql = "(SELECT * FROM m_text";
		
			res = stmt.executeQuery(sql);
			
			boolean countFlg = res.next();
			if(countFlg) {
				text = new TextEt();
				text.setFileId(mFileId);
				text.setLineNumber(mLineNumber);
				text.setLineContents(mLineContents);
			}
			res.close();
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			close();
		}
		
		return text;
	}
}
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.TextEt;

/**
 * TextDAO
 * @author 会津
 *
 */

public class TextDAO extends DAO{

	/**
	 * 
	 * @param fileId
	 * @param lineNumber
	 * @param lineContents
	 * @return SQL文の実行回数
	 */
	
	public int insert(int fileId, int lineNumber, String lineContents) {
		
		getConnection();
		createStmt();
		
		int count = 0;
		
		String sql = "INSERT INTO m_text VALUES(" + fileId + ", '" +lineNumber + "', '" + lineContents + "')";
		
		try {
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(lineNumber);
		}finally{
			close();
		}
		
		return count;
	}
	
	/**
	 * 
	 * @param fileId
	 * @return 検索結果
	 */
	
	public List<TextEt> selectByFileId(int fileId) {
		getConnection();
		createStmt();
		
		List<TextEt> list = new ArrayList<TextEt>();
		
		ResultSet res = null;

		try {
			String sql = "SELECT * FROM m_text WHERE file_id = " + fileId;
		
			res = stmt.executeQuery(sql);
			
			while(res.next()) {
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
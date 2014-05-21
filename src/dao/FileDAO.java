/*package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class FileDAO extends DAO{
	
	public EmployeeItem selectByCode(String code) throws DAOException {
		ResultSet res = null;
		
		getConnection();
		createStmt();
		
		EmployeeItem item = null;
		try {
			String sql = "insert into m_file values(" + file_id + ", '" + file_path + "', '" + file_make_day + "')";
			
			res = stmt.executeQuery(sql);
			
			boolean countFlg = res.next();
			if(countFlg) {
				item = new EmployeeItem();
				item.setfileId(res.getString("file_id"));
				item.setfilePath(res.getString("file_path"));
				item.setfileMakeDay(res.getString("file_make_day"));
			}
			res.close();
		} catch (SQLException e) {
			throw new DAOException("[selectByCode]異常", e);
		} finally {
			close();
		}
		return item;
	}
}*/
package dao;

import java.sql.Date;
import java.sql.ResultSet;

import entity.FileEt;

public class FileDAO extends DAO{

	public FileDAO (int fileId, String filePath, Date fileMakeDay) {
		ResultSet res = null;

		getConnection();
		createStmt();

		FileEt fileEt = null;

		String sql = "insert into m_file values(" + fileId + ", '" + filePath + "', '" + fileMakeDay + "')";

		res = stmt.executeQuery(sql);

		boolean countFlg = res.next();
		if(countFlg) {
			fileEt = new FileEt();
			fileEt.setfileId(res.getString("fileId"));
			fileEt.setfilePath(res.getString("filePath"));
			fileEt.setfileMakeDay(res.getString("fileMakeDay"));
		}
		res.close();

		return fileEt;
	}
}
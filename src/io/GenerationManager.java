package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dao.FileDAO;
import dao.TextDAO;
import entity.FileEt;
import entity.TextEt;

public class GenerationManager {
	/**
	 * ファイルとテキストをデータベースに保存する
	 * @param file 実態のパス
	 */
	public void insertGeneration(File file){
		//ファイル情報の書き込み
		FileDAO fDao = new FileDAO();
		String path = file.getAbsolutePath().replaceAll("\\\\", "/");
		fDao.insert(path);
		
		//テキスト内容の書き込み
		TextDAO tDao = new TextDAO();
		int fileId = fDao.getLatestFileId();
		int lineNumber = 0;
		BufferedReader br;
		try{
			if (file.isFile() && file.canRead()){
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
				String str;
				while((str = br.readLine()) != null){
					lineNumber++;
					tDao.insert(fileId, lineNumber, str);
				}
				br.close();
			}
		}catch(IOException err){
		}
	}

	/**
	 * 指定の日付に保存されたファイル一覧を返却する
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @return ファイル一覧
	 */
	public List<FileEt> getFileList(String year, String month, String day){
		FileDAO fDao = new FileDAO();
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
		Date date1 = new Date(c.getTimeInMillis());
		Date date2 = new Date(c.getTimeInMillis() + 86400000);
		return fDao.selectByDate(date1, date2);
	}
	
	/**
	 * 指定されたテキストファイルを返却する
	 * @param fileId 主キー
	 * @return テキスト
	 */
	public String getText(int fileId){
		StringBuilder sb = new StringBuilder();
		TextDAO tDao = new TextDAO();
		List<TextEt> list = new ArrayList<TextEt>();
		list = tDao.selectByFileId(fileId);
		for(TextEt e : list){
			sb.append(e.getLineContents() + "\n");
		}
		return sb.toString();
	}
}

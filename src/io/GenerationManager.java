package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

import dao.FileDAO;
import dao.TextDAO;

public class GenerationManager {
	/**
	 * ファイルとテキストをデータベースに保存する
	 * @param file 実態のパス
	 */
	public void insertGeneration(File file){
		//ファイル情報の書き込み
		FileDAO fDao = new FileDAO();
		String path = file.getAbsolutePath().replaceAll("\\\\", "/");
		fDao.insert(0, path, new Date(System.currentTimeMillis()));
		
		//テキスト内容の書き込み
		TextDAO tDao = new TextDAO();
		int fileId = fDao.getLatestFileId();
		System.out.println(fileId);
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
}

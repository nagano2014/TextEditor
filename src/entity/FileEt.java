package entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * ファイルエンティティ
 * @author 高松
 * 
 * データの取得と格納
 */

public class FileEt {
	private int mFileId;
	private String mFilePath;
	private Timestamp mFileMakeDay;
	
	public FileEt(){
		
	}
	
	public FileEt(int fileid, String filepath, Timestamp filemd){
		mFileId = fileid;
		mFilePath = filepath;
		mFileMakeDay = filemd;
	}
	
	public int getFileId(){
		return mFileId;
	}
	
	public void setFileId(int fileid){
		mFileId = fileid;
	}
	
	public String getFilePath(){
		return mFilePath;
	}
	
	public void setFilePath(String filepath){
		mFilePath = filepath;
	}
	
	public Date getFileMd(){
		return mFileMakeDay;
	}
	
	public void setFileMd(Timestamp filemd){
		mFileMakeDay = filemd;
	}
	
}
package entity;

import java.util.Date;

/**
 * ファイルエンティティ
 * @author 高松
 *
 */

public class FileEt {
	private int mFileId;
	private String mFilePath;
	private Date mFileMakeDay;
	
	public FileEt(){
		
	}
	
	public FileEt(int fileid, String filepath, Date filemd){
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
	
	public void setFileMd(Date filemd){
		mFileMakeDay = filemd;
	}
	
}
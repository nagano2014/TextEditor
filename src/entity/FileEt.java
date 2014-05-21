package entity;

import java.util.Date;

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
	
	public int getFileid(){
		return mFileId;
	}
	
	public void setFileid(int fileid){
		mFileId = fileid;
	}
	
	public String getFilepath(){
		return mFilePath;
	}
	
	public void setFileid(String filepath){
		mFilePath = filepath;
	}
	
	public Date getFilemd(){
		return mFileMakeDay;
	}
	
	public void setFileid(Date filemd){
		mFileMakeDay = filemd;
	}
	
	@Override
	public String toString(){
		String buffer = "[FileEt: fileid:"+mFileId +" filepath:"+ mFilePath +" filemd:" + mFileMakeDay +"]";
		return buffer;
	}
	
}
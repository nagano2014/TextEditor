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
	
	/**
	 * フィールド
	 */
	
	private int fileId;
	private String filePath;
	private Timestamp fileMakeDay;
	
	/**
	 * コンストラクタ
	 */
	
	public FileEt(){
		
	}
	
	/**
	 * コンストラクタ
	 * @param fileId
	 * @param filePath
	 * @param fileMakeDay
	 */
	
	public FileEt(int fileId, String filePath, Timestamp fileMakeDay){
		this.fileId = fileId;
		this.filePath = filePath;
		this.fileMakeDay = fileMakeDay;
	}
	
	public int getFileId(){
		return fileId;
	}
	
	public void setFileId(int fileId){
		this.fileId = fileId;
	}
	
	public String getFilePath(){
		return filePath;
	}
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	
	public Date getFileMakeDay(){
		return fileMakeDay;
	}
	
	public void setFileMd(Timestamp fileMakeDay){
		this.fileMakeDay = fileMakeDay;
	}
	
}
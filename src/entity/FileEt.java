package entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * ファイルエンティティ
 * @author 高松
 * 
 * 
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
	
	/**
	 * ファイルIDを取得
	 * @return ファイルID
	 */
	public int getFileId(){
		return fileId;
	}
	
	/**
	 * ファイルIDを格納
	 * @param fileId 主キー
	 */
	public void setFileId(int fileId){
		this.fileId = fileId;
	}
	
	/**
	 * ファイルパスを取得
	 * @return ファイルパス
	 */
	public String getFilePath(){
		return filePath;
	}
	
	/**
	 * ファイルパスを格納
	 */
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	
	/**
	 * ファイル作成日を取得
	 * @return ファイル作成日
	 */
	public Date getFileMakeDay(){
		return fileMakeDay;
	}
	
	/**
	 * ファイル作成日を格納
	 */
	public void setFileMd(Timestamp fileMakeDay){
		this.fileMakeDay = fileMakeDay;
	}
	
}
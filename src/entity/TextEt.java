package entity;

/**
 * テキストエンティティ
 * @author 高松
 *
 * データの取得と格納
 */

public class TextEt {
	private int fileId;
	private int lineNumber;
	private String lineContents;
	
	
	/**
	 * コンストラクタ
	 */
	
	public TextEt(){
		
	}
	
	/**
	 * コンストラクタ
	 * @param fileId
	 * @param lineNumber
	 * @param lineContents
	 */
	
	public TextEt(int fileId, int lineNumber, String lineContents){
		this.fileId = fileId;
		this.lineNumber = lineNumber;
		this.lineContents = lineContents;
	}
	
	public int getFileId(){
		return fileId;
	}
	
	public void setFileId(int fileId){
		this.fileId = fileId;
	}
	
	public int getLineNumber(){
		return lineNumber;
	}
	
	public void setLineNumber(int lineNumber){
		this.lineNumber = lineNumber;
	}
	
	public String getLineContents(){
		return lineContents;
	}
	
	public void setLineContents(String lineContents){
		this.lineContents = lineContents;
	}

}

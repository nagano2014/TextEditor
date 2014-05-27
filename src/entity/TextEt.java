package entity;

/**
 * テキストエンティティ
 * @author 高松
 *
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
	 * @return 行番号
	 */
	public int getLineNumber(){
		return lineNumber;
	}
	
	/**
	 * 行番号を格納
	 */
	public void setLineNumber(int lineNumber){
		this.lineNumber = lineNumber;
	}
	
	/**
	 * 行内容を取得
	 * @return 行内容
	 */
	public String getLineContents(){
		return lineContents;
	}
	
	/**
	 * 行内容を格納
	 */
	public void setLineContents(String lineContents){
		this.lineContents = lineContents;
	}

}

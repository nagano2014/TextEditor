package entity;


public class TextEt {
	private int mFileId;
	private int mLineNumber;
	private String mLineContents;
	
	/**
	 * テキストエンティティ
	 * @author 高松
	 *
	 * データの取得と格納
	 */
	
	public TextEt(){
		
	}
	
	public TextEt(int fileid, int linenum, String linecon){
		mFileId = fileid;
		mLineNumber = linenum;
		mLineContents = linecon;
	}
	
	public int getFileId(){
		return mFileId;
	}
	
	public void setFileId(int fileid){
		mFileId = fileid;
	}
	
	public int getLineNumber(){
		return mLineNumber;
	}
	
	public void setLineNumber(int linenum){
		mLineNumber = linenum;
	}
	
	public String getLineContents(){
		return mLineContents;
	}
	
	public void setLineContents(String linecon){
		mLineContents = linecon;
	}

}

package entity;


public class TextEt {
	private int mFileId;
	private int mLineNumber;
	private String mLineContents;
	
	public TextEt(){
		
	}
	
	public TextEt(int fileid, int linenum, String linecon){
		mFileId = fileid;
		mLineNumber = linenum;
		mLineContents = linecon;
	}
	
	public int getFileid(){
		return mFileId;
	}
	
	public void setFileid(int fileid){
		mFileId = fileid;
	}
	
	public int getLinenumber(){
		return mLineNumber;
	}
	
	public void setLinenumber(int linenum){
		mLineNumber = linenum;
	}
	
	public String getLinecontents(){
		return mLineContents;
	}
	
	public void setFileid(String linecon){
		mLineContents = linecon;
	}
	
	@Override
	public String toString(){
		String buffer = "[FileEt: fileid:"+mFileId +" linenum:"+ mLineNumber +" linecon:" + mLineContents +"]";
		return buffer;
	}

}

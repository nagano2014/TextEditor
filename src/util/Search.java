package util;

import javax.swing.JTextArea;
/**
 * テキスト内の文字検索
 * @author 安藤
 *
 */
public class Search {
	/**
	 * 上から文字検索
	 * @param area　本文
	 * @param key　検索ワード
	 * @return　検索後の本文
	 */
	public static JTextArea strTopSearch(JTextArea area,String key){
		
		String textArea = area.getText();
		String word = textArea.substring(area.getSelectionEnd(), textArea.length());
		
		area.setSelectionStart(area.getSelectionEnd()+ word.indexOf(key));
		area.setSelectionEnd(area.getSelectionStart()+ key.length());
		
		area.requestFocus(true);
		
		return area;
	}
	/**
	 * 下から文字検索
	 * @param area　本文
	 * @param key　検索ワード
	 * @return　検索後の本文
	 */
	public static JTextArea strBottomSearch(JTextArea area,String key){
		
		String textArea = area.getText();
		String word = textArea.substring(0, area.getSelectionStart());
		
		area.setSelectionStart(word.lastIndexOf(key));
		area.setSelectionEnd(area.getSelectionStart() + key.length());
		
		area.requestFocus(true);
		
		return area;
	}
	
	/**
	 * 上からの検索が可能ならtrue、不可能ならばfalseを返す。
	 * @param area　本文
	 * @param key　検索ワード
	 * @return　検索可能ならtrue
	 */
	public static boolean canTopSearch(JTextArea area, String key){
		String textArea = area.getText();
		String word = textArea.substring(area.getSelectionEnd(), textArea.length());
		return word.indexOf(key) != -1 && !area.getText().equals("");
	}
	/**
	 * 下からの検索が可能ならtrue、不可能ならばfalseを返す。
	 * @param area　本文
	 * @param key　検索ワード
	 * @return　検索可能ならtrue
	 */
	public static boolean canBottomSearch(JTextArea area, String key){
		String textArea = area.getText();
		String word = textArea.substring(0, area.getSelectionStart());
		return word.indexOf(key) != -1 && !area.getText().equals("");
	}

}

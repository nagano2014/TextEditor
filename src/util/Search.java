package util;

import javax.swing.JTextArea;
/**
 * テキスト内の文字検索
 * @author 安藤
 *
 */
public class Search {
	/**
	 * 文字検索
	 * @param area　本文
	 * @param key　検索ワード
	 * @return　検索後の本文
	 */
	public static JTextArea strSearch(JTextArea area,String key){
		
		String textArea = area.getText();
		String word = textArea.substring(area.getSelectionEnd(), textArea.length());
		
		area.setSelectionStart(area.getSelectionEnd()+ word.indexOf(key));
		area.setSelectionEnd(area.getSelectionStart()+ key.length());
		
		area.requestFocus(true);
		
		return area;
	}
	/**
	 * 検索が可能ならtrue、不可能ならばfalseを返す。
	 * @param area　本文
	 * @param key　検索ワード
	 * @return　検索可能ならtrue
	 */
	public boolean canSearch(JTextArea area, String key){
		String textArea = area.getText();
		String word = textArea.substring(area.getSelectionEnd(), textArea.length());
		return word.indexOf(key) != -1;
		
	}

}

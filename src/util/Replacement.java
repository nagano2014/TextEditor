package util;

import javax.swing.JTextArea;

/**
 * テキスト内の文字置換を行う
 * @author nagano02
 *
 */
public class Replacement {
	/**
	 * 単語の置換
	 * @param area 本文
	 * @param before 置換前の単語
	 * @param after 置換後の単語
	 * @return 置換後の本文
	 */
	public JTextArea strReplacement(JTextArea area, String before, String after){
		while(area.getText().indexOf(before) != -1){
			int start = area.getText().indexOf(before);
    		int end = start + before.length();
    		area.replaceRange(after, start, end);
    	}
		return area;
	}
}

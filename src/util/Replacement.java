package util;

import javax.swing.JTextArea;

/**
 * テキスト内の文字置換を行う
 * @author nagano02
 *
 */
public class Replacement{
	/**
	 * 単語の置換
	 * @param area 本文
	 * @param beforeWord 置換前の単語
	 * @param afterWord 置換後の単語
	 * @return 置換後の本文
	 */
	public JTextArea strReplacement(JTextArea area, String beforeWord, String afterWord){
		while(area.getText().indexOf(beforeWord) != -1){
			int start = area.getText().indexOf(beforeWord);
			int end = start + beforeWord.length();
			area.replaceRange(afterWord, start, end);
			area.select(area.getText().indexOf(afterWord), area.getText().indexOf(afterWord) + afterWord.length());
		}
		return area;
	}
	/**
	 * 置換可能ならtrue、不可能ならfalseを返す
	 * @param area 本文
	 * @param beforeWord 置換前の単語
	 * @return 置換可能ならtrue
	 */
	public boolean canReplace(JTextArea area, String beforeWord){
		return area.getText().indexOf(beforeWord) != -1;
	}
}

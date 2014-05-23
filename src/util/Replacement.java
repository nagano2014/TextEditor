package util;

import javax.swing.JTextArea;

/**
 * テキスト内の文字置換を行う
 * @author 塩原
 *
 */
public class Replacement{
	/**
	 * 単語の置換
	 * @param area 本文
	 * @param oldWord 置換前の単語
	 * @param newWord 置換後の単語
	 * @return 置換が完了すればtrue
	 */
	public static boolean strReplace(JTextArea area, String oldWord, String newWord){
		boolean result = canReplace(area, oldWord);
		if(result){
			String str = area.getText();
			int index = str.lastIndexOf(oldWord);
			area.setText(str.replaceAll(oldWord, newWord));
			//テキスト内で最後に置換された部分を選択状態にする
			area.select(index, index + newWord.length());
		}
		return result;
	}
	/**
	 * 置換可能ならtrue、不可能ならfalseを返す
	 * @param area 本文
	 * @param oldWord 置換前の単語
	 * @return 置換可能ならtrue
	 */
	private static boolean canReplace(JTextArea area, String oldWord){
		return area.getText().indexOf(oldWord) != -1 && !area.getText().equals("") && !oldWord.equals("");
	}
}

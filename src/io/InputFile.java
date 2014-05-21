package io;

import java.awt.Component;

import javax.swing.JFileChooser;

/**
 * ファイルを開く
 * @author 塩原
 *
 */
public class InputFile{
	/**
	 * ファイル選択ダイアログを開く
	 * @param parent 親となるコンポーネント
	 * @return 
	 */
	public int open(Component parent){
		JFileChooser chooser = new JFileChooser();
		return chooser.showOpenDialog(parent);
	}
}

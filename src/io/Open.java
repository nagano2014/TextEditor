package io;

import java.awt.Component;

import javax.swing.JFileChooser;

/**
 * ファイルを開く
 * @author 塩原
 *
 */
public class Open{
	public int fileOpen(Component parent){
		JFileChooser chooser = new JFileChooser();
		return chooser.showOpenDialog(parent);
	}
}

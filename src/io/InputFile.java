package io;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	public static JTextArea open(Component parent){
		String user = System.getenv("USERNAME");
		JFileChooser chooser = new JFileChooser("C:/Users/" + user + "/Desktop");
		chooser.addChoosableFileFilter(createTxtFilter());
		chooser.showOpenDialog(parent);
		
		File file = chooser.getSelectedFile();
		StringBuilder sb = new StringBuilder();
		BufferedReader br;
		try{
			if (file.isFile() && file.canRead()){
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"SHIFT_JIS"));
				String str;
				while((str = br.readLine()) != null){
					sb.append(str + "\n");
				}
				br.close();
			}
		}catch(IOException err){
		}
		return new JTextArea(sb.toString());
	}
	private static FileNameExtensionFilter createTxtFilter(){
		return new FileNameExtensionFilter("txtファイル", "txt", "TXT");
	}
}

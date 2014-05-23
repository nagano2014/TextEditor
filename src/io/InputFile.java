package io;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
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
	 * @return 開かなかった場合null
	 */
	public static String open(Component parent){
		String text = null;
		String user = System.getenv("USERNAME");
		JFileChooser chooser = new JFileChooser("C:/Users/" + user + "/Desktop");
		chooser.addChoosableFileFilter(createTxtFilter());
		int state = chooser.showOpenDialog(parent);
		
		if(state == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			StringBuilder sb = new StringBuilder();
			BufferedReader br;
			try{
				if (file.isFile() && file.canRead()){
					br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"MS932"));
					String str;
					while((str = br.readLine()) != null){
						str = str.concat("\n");
						str = new String(str.getBytes("UTF-8"), "UTF-8");
						sb.append(str);
					}
					br.close();
				}
			}catch(IOException err){
			}
			text = sb.toString();
		}
		return text;
	}
	private static FileNameExtensionFilter createTxtFilter(){
		return new FileNameExtensionFilter("txtファイル", "txt", "TXT");
	}
}

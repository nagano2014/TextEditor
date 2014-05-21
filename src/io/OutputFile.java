package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 * ファイルをテキスト形式で保存する
 * @author 塩原
 *
 */
public class OutputFile {
	public static void save(JTextArea area){
		JFileChooser filechooser = new JFileChooser();
		int state = filechooser.showSaveDialog(area);
		
		if(state == JFileChooser.APPROVE_OPTION){
			File file = filechooser.getSelectedFile();
			
			try {
				PrintWriter pw;
				if (file.toString().substring(file.toString().length() - 4).equals(".txt")) {
					pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				}else{
					pw = new PrintWriter(new BufferedWriter(new FileWriter(file + ".txt")));
				}
					pw.println(area.getText()); // 書き込み処理
	            pw.close(); // ライタを閉じる
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

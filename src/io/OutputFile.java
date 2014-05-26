package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 * ファイルをローカルに保存し、データベースに情報を格納する
 * @author nagano02
 *
 */
public class OutputFile {
	public static void save(JTextArea area){
		JFileChooser filechooser = new JFileChooser();
		int state = filechooser.showSaveDialog(area);
		
		if(state == JFileChooser.APPROVE_OPTION){
			File file = filechooser.getSelectedFile();
			String[] strs = area.getText().split("\n");
			try {
				PrintWriter pw;
				if (!file.toString().substring(file.toString().length() - 4).equals(".txt")) {
					file = new File(file.getPath() + ".txt");
				}
				pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "MS932"));
				for(String str : strs){
					pw.println(str);
				}
				pw.flush();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			GenerationManager gm = new GenerationManager();
			gm.insertGeneration(file);
		}
	}
}

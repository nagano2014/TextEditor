package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class OutputFile {
	public static void save(JTextArea area){
		JFileChooser filechooser = new JFileChooser();
		int state = filechooser.showSaveDialog(area);
		
		if(state == JFileChooser.APPROVE_OPTION){
			File file = filechooser.getSelectedFile();
			String[] strs = area.getText().split("\n");
			try {
				PrintWriter pw;
				if (file.toString().substring(file.toString().length() - 4).equals(".txt")) {
					pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				}else{
					pw = new PrintWriter(new BufferedWriter(new FileWriter(file + ".txt")));
				}
				for(String str : strs){
					pw.println(str);
				}
				pw.flush();
	            pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

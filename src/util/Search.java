package util;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Search {
public static JTextArea strSearch(JTextArea area,JTextField key){
		
		String textArea = area.getText();
		String keyword = key.getText();

		int start = textArea.indexOf(keyword);
		int end = start + keyword.length();
		
		area.setSelectionStart(start);
		area.setSelectionEnd(end);

		area.requestFocus(true);
		return area;
	}
	
	public boolean canSearch(JTextArea area, String key){
		return area.getText().indexOf(key) != -1;
	}

}

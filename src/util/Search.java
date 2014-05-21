package util;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Search {
public static JTextArea strSearch(JTextArea area,JTextField key){
		
		String textArea = area.getText();
		String keyword = key.getText();

		int start = textArea.indexOf(keyword);
		int end = start + keyword.length();
		
		area.setSelectionStart(end+textArea.indexOf(keyword));
		area.setSelectionEnd(start+keyword.length());

		area.requestFocus(true);
		return area;
	}
	
	public boolean canReplace(JTextArea area, String key){
		return area.getText().indexOf(key) != -1;
	}

}

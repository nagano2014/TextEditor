package util;

import javax.swing.JTextArea;

public class Search {
public static JTextArea strSearch(JTextArea area,String key){
		
		String textArea = area.getText();

		int start = textArea.indexOf(key);
		int end = start + key.length();
		
		area.setSelectionStart(start);
		area.setSelectionEnd(end);

		area.requestFocus(true);
		return area;
	}
	
	public boolean canSearch(JTextArea area, String key){
		return area.getText().indexOf(key) != -1;
	}

}

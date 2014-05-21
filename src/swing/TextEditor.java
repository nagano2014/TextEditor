package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import util.Replacement;

public class TextEditor extends JFrame implements ActionListener{

	static JTextArea textArea = new JTextArea();
	
	TextEditor() {
		JFrame frame = new JFrame("TextEditor");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("ファイル");
		JMenu menu2 = new JMenu("編集");
		
		JMenuItem open = new JMenuItem("開く");
		JMenuItem save = new JMenuItem("保存");
		JMenuItem generalmanagement = new JMenuItem("世代管理");
		JMenuItem search = new JMenuItem("検索");
		JMenuItem replace = new JMenuItem("置換");
		
		// メニューアイテムの追加
		menu1.add(open);
		menu1.add(save);
		menu1.add(generalmanagement);
		menu2.add(search);
		menu2.add(replace);
		// イベントリスクの設定
		open.addActionListener(this);
		save.addActionListener(this);
		generalmanagement.addActionListener(this);
		search.addActionListener(this);
		replace.addActionListener(this);
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		frame.add(textArea);
		// メニューバーをフレームに設定
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextEditor();
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "開く"){
			
		}
		if (e.getActionCommand() == "保存") {
			
		}
		if (e.getActionCommand() == "世代管理") {
			
		}
		if (e.getActionCommand() == "検索") {
			JFrame search = new JFrame("検索");
			search.setLayout(new FlowLayout());
			search.setBounds(200, 200, 400, 300);
			JLabel label = new JLabel("条件");
			JTextArea text = new JTextArea(1, 20);
			JButton button = new JButton("検索");
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionevent){
					// 処理
				}
			});
			search.add(label);
			search.add(text);
			search.add(button);
			search.setVisible(true);
		}
		if (e.getActionCommand() == "置換") {
			JFrame replace = new JFrame("置換");
			replace.setLayout(new BoxLayout(replace.getContentPane(), BoxLayout.Y_AXIS));
			replace.setBounds(200, 200, 400, 150);
			JLabel label = new JLabel("置換前の文字列");
			final JTextArea text = new JTextArea(1, 20);
			JLabel label2 = new JLabel("置換後の文字列");
			final JTextArea text2 = new JTextArea(1, 20);
			JButton button = new JButton("置換");
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionevent){
					Replacement r = new Replacement();
					if (r.canReplace(textArea, text.getText())) {
						textArea = r.strReplacement(textArea, text.getText(), text2.getText());
					} else {
						JFrame replaceError = new JFrame("置換エラー");
						replaceError.setLayout(new FlowLayout());
						replaceError.setBounds(200, 200, 400, 150);
						JLabel errorMessage = new JLabel("置換対象が見つかりませんでした。");
						replaceError.add(errorMessage);
						replaceError.setVisible(true);
					}
					
				}
			});
			replace.add(label);
			replace.add(text);
			replace.add(label2);
			replace.add(text2);
			replace.add(button);
			replace.setVisible(true);
		}
	}

}

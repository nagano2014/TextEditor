package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.Replacement;
import util.Search;

/**
 * TextEditor本体
 * @author 徳武
 *
 */
public class TextEditor extends JFrame implements ActionListener{

	static JTextArea textArea = new JTextArea();
	
	/**
	 * TextEditorの本体画面を構成する
	 */
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
	
	/**
	 * メニューのボタンを押した時のアクションを定義する
	 */
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "開く"){
			
		}
		if (e.getActionCommand() == "保存") {
			
		}
		if (e.getActionCommand() == "世代管理") {
			
		}
		if (e.getActionCommand() == "検索") {
			final JFrame search = new JFrame("検索");
			search.setAlwaysOnTop(true);
			search.setResizable(false);
			search.setLayout(new FlowLayout());
			search.setBounds(200, 200, 400, 100);
			JLabel label = new JLabel("条件");
			final JTextField text = new JTextField(20);
			JButton button = new JButton("検索");
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionevent){
					Search s = new Search();
					if (s.canSearch(textArea, text.getText())) {
						textArea = Search.strSearch(textArea, text.getText());
					} else {
						JDialog replaceError = new JDialog(search, "検索エラー", true);
						replaceError.setLayout(new FlowLayout());
						replaceError.setBounds(200, 200, 400, 150);
						JLabel errorMessage = new JLabel("検索対象が見つかりませんでした。");
						replaceError.add(errorMessage);
						replaceError.setVisible(true);
					}
					
				}
			});
			search.add(label);
			search.add(text);
			search.add(button);
			search.setVisible(true);
		}
		if (e.getActionCommand() == "置換") {
			final JFrame replace = new JFrame("置換");
			replace.setAlwaysOnTop(true);
			replace.setResizable(false);
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			replace.setLayout(new BoxLayout(replace.getContentPane(), BoxLayout.Y_AXIS));
			replace.setBounds(200, 200, 400, 150);
			JLabel label = new JLabel("置換前の文字列");
			final JTextField text = new JTextField(20);
			panel1.add(label);
			panel1.add(text);
			JLabel label2 = new JLabel("置換後の文字列");
			final JTextField text2 = new JTextField(20);
			panel2.add(label2);
			panel2.add(text2);
			JButton button = new JButton("置換");
			panel3.add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionevent){
					Replacement r = new Replacement();
					if (r.canReplace(textArea, text.getText())) {
						textArea = r.strReplacement(textArea, text.getText(), text2.getText());
					} else {
						JDialog replaceError = new JDialog(replace, "置換エラー", true);
						replaceError.setLayout(new FlowLayout());
						replaceError.setBounds(200, 200, 400, 150);
						JLabel errorMessage = new JLabel("置換対象が見つかりませんでした。");
						replaceError.add(errorMessage);
						replaceError.setVisible(true);
					}
					
				}
			});
			replace.add(panel1);
			replace.add(panel2);
			replace.add(panel3);
			replace.setVisible(true);
		}
	}

}

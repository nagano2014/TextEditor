package swing;

import io.GenerationManager;
import io.InputFile;
import io.OutputFile;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import util.Replacement;
import util.Search;
import entity.FileEt;

/**
 * TextEditor本体
 * @author 徳武
 *
 */
public class TextEditor extends JFrame implements ActionListener{

	static JTextArea textArea = new JTextArea();
	static List<FileEt> fileList;
	static List<Integer> array;
	private GenerationManager gm = new GenerationManager();	
	
	
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
		menu1.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		menu2.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		
		
		JMenuItem open = new JMenuItem("開く");
		JMenuItem save = new JMenuItem("保存");
		JMenuItem generalManagement = new JMenuItem("世代管理");
		JMenuItem print = new JMenuItem("印刷");
		JMenuItem search = new JMenuItem("検索");
		JMenuItem cut = new JMenuItem("切り取り");
		JMenuItem paste = new JMenuItem("貼り付け");
		/*if(textArea.getText().equals("")){
			search.setEnabled(false);
		}*/
		
		JMenuItem replace = new JMenuItem("置換");
		open.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		save.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		generalManagement.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		print.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		search.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		replace.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		cut.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		paste.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		
		// メニューアイテムの追加
		menu1.add(open);
		menu1.add(save);
		menu1.add(generalManagement);
		menu1.add(print);
		menu2.add(search);
		menu2.add(replace);
		menu2.add(cut);
		menu2.add(paste);
		// イベントリスクの設定
		open.addActionListener(this);
		save.addActionListener(this);
		generalManagement.addActionListener(this);
		print.addActionListener(this);
		search.addActionListener(this);
		replace.addActionListener(this);
		cut.addActionListener(this);
		paste.addActionListener(this);
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		frame.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.add(scrollPane);
		// メニューバーをフレームに設定
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextEditor();
	}
	
	/**
	 * メニューのボタンを押した時のアクションを定義する
	 * @param e
	 */
	public void actionPerformed(ActionEvent e){
		// 「開く」メニューを選んだ時
		if (e.getActionCommand() == "開く"){
			String text = InputFile.open(textArea);
			if (text != null) {
				textArea.setText(text);
			}
		}
		// 「保存メニュー」選んだ時
		if (e.getActionCommand() == "保存") {
			OutputFile.save(textArea);
		}
		// 「世代管理」メニューを選んだ時
		if (e.getActionCommand() == "世代管理") {
			final JFrame general = new JFrame("世代管理");
			final JLabel label = new JLabel("作成年月日");
			final JLabel year = new JLabel("年");
			final JLabel month = new JLabel("月");
			final JLabel day = new JLabel("日");
			Calendar cal = Calendar.getInstance();
			final JComboBox comboYear = new JComboBox(new String[]
					{"2014", "2015", "2016", "2017", "2018", "2019", "2020"});
			comboYear.setSelectedItem(String.valueOf(cal.get(Calendar.YEAR)));
			final JComboBox comboMonth = new JComboBox(new String[]
					{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
			comboMonth.setSelectedItem(String.valueOf(cal.get(Calendar.MONTH) + 1));
			final JComboBox comboDay = new JComboBox(new String[]
					{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
					  "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
					  "25", "26", "27", "28", "29", "30", "31"});
			comboDay.setSelectedItem(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
			
			JButton button = new JButton("選択");
			final DefaultListModel model = new DefaultListModel();
			final JList list = new JList(model);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionevent){
					model.clear();
					//GenerationManager gm = new GenerationManager();	
					fileList = gm.getFileList((String)comboYear.getSelectedItem(), (String)comboMonth.getSelectedItem(), (String)comboDay.getSelectedItem());
					array = new ArrayList<Integer>();
					for (FileEt fileEt : fileList) {
						array.add(fileEt.getFileId());
						model.addElement(fileEt.getFilePath() + fileEt.getFileMd());
					}
					list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);					
				}
			});
			
			JButton button2 = new JButton("開く");
			button2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionevent){
					textArea.setText(gm.getText(array.get(list.getSelectedIndex())));
				}
			});
			
			
				
			
			general.setLayout(new BoxLayout(general.getContentPane(), BoxLayout.Y_AXIS));
			general.setAlwaysOnTop(true);
			//general.setResizable(false);
			general.setLayout(new FlowLayout());
			general.setBounds(200, 200, 370, 300);
			
			JPanel panel = new JPanel();
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			panel.add(label);
			panel2.add(comboYear);
			panel2.add(year);
			panel2.add(comboMonth);
			panel2.add(month);
			panel2.add(comboDay);
			panel2.add(day);
			panel2.add(button);
			panel2.add(button2);
			panel3.add(list);
			general.add(panel);
			general.add(panel2);
			general.add(panel3);
			general.setVisible(true);
		}
		// 「印刷」メニューを選んだ時
		if (e.getActionCommand() == "印刷") {
			try {
				textArea.print();
			} catch (PrinterException e1) {
				e1.printStackTrace();
			}
		}
		// 「検索」メニューを選んだ時
		if (e.getActionCommand() == "検索") {
			final JFrame search = new JFrame("検索");
			final JTextField text = new JTextField(20);
			final JButton button = new JButton("検索");
			search.setAlwaysOnTop(true);
			search.setResizable(false);
			search.setLayout(new FlowLayout());
			search.setBounds(200, 200, 400, 100);
			final JRadioButton radioButton1 = new JRadioButton("上から検索", true);
			final JRadioButton radioButton2 = new JRadioButton("下から検索");
			JLabel label = new JLabel("条件");
			
			// ボタンが押された時の処理
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionevent){
					Search s = new Search();
					if (radioButton1.isSelected()) {
						if (s.canTopSearch(textArea, text.getText())) {
							textArea = Search.strTopSearch(textArea, text.getText());
						} else {
							JDialog searchError = new JDialog(search, "検索エラー", true);
							searchError.setLayout(new FlowLayout());
							searchError.setBounds(200, 200, 400, 100);
							JLabel errorMessage = new JLabel("現在位置より下に検索対象が見つかりませんでした。");
							searchError.add(errorMessage);
							searchError.setVisible(true);
						}
					} else if (radioButton2.isSelected()) {
						if (s.canBottomSearch(textArea, text.getText())) {
							textArea = Search.strBottomSearch(textArea, text.getText());
						} else {
							JDialog searchError = new JDialog(search, "検索エラー", true);
							searchError.setLayout(new FlowLayout());
							searchError.setBounds(200, 200, 400, 100);
							JLabel errorMessage = new JLabel("現在位置より上に検索対象が見つかりませんでした。");
							searchError.add(errorMessage);
							searchError.setVisible(true);
						}
					}
				}
			});
			
			ButtonGroup buttonGroup = new ButtonGroup();
			buttonGroup.add(radioButton1);
			buttonGroup.add(radioButton2);
			search.add(label);
			search.add(text);
			search.add(button);
			search.add(radioButton1);
			search.add(radioButton2);
			search.setVisible(true);
		}
		// 「置換」メニューを選んだ時
		if (e.getActionCommand() == "置換") {
			final JFrame replace = new JFrame("置換");
			final JTextField text = new JTextField(20);
			final JTextField text2 = new JTextField(20);
			replace.setAlwaysOnTop(true);
			replace.setResizable(false);
			replace.setLayout(new BoxLayout(replace.getContentPane(), BoxLayout.Y_AXIS));
			replace.setBounds(200, 200, 400, 150);
			JLabel label = new JLabel("置換前の文字列");
			JLabel label2 = new JLabel("置換後の文字列");
			JButton button = new JButton("置換");
			
			// ボタンが押された時の処理
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionevent){
					Replacement r = new Replacement();
					replace.setAlwaysOnTop(false);
					if (r.canReplace(textArea, text.getText())) {
						textArea = r.strReplace(textArea, text.getText(), text2.getText());
						replace.requestFocus();
						replace.setAlwaysOnTop(false);
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
			
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			panel1.add(label);
			panel1.add(text);
			panel2.add(label2);
			panel2.add(text2);
			panel3.add(button);
			replace.add(panel1);
			replace.add(panel2);
			replace.add(panel3);
			replace.setVisible(true);
		}
		// 「切り取り」メニューを選んだ時
		if (e.getActionCommand() == "切り取り") {
			textArea.cut();
		}
		// 「貼り付け」メニューを選んだ時
		if (e.getActionCommand() == "貼り付け") {
			textArea.paste();
		}
	}

}

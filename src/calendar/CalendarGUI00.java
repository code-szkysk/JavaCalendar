package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalendarGUI00 extends JFrame implements ActionListener{

	JTextField[] tfDays;
	JButton next;
	JButton back;
	JButton reset;


	// コンストラクタ
	public CalendarGUI00() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());


	// コンテナ上部をさらに分割する
	JPanel panelA = new JPanel();
	panelA.setLayout(new BorderLayout());
	back = new JButton("<<");
	back.addActionListener(this);

	reset = new JButton();
	reset.setBackground(Color.WHITE);
	reset.setText("〇〇年〇〇月");
	reset.addActionListener(this);

	next = new JButton(">>");
	next.addActionListener(this);

	// panelAにボタンを配置
	panelA.add(back,BorderLayout.WEST);		// backボタンを左側
	panelA.add(reset,BorderLayout.CENTER);	// resetボタンを中央
	panelA.add(next,BorderLayout.EAST);		// nextボタンを右側


	// コンテナ中央部をさらに分割する
	JPanel panelB = new JPanel();
	panelB.setLayout(new GridLayout(7,7));

	// panelBに乗せるテキストフィールドを作る
	JTextField[] tfDOW = new JTextField[7];
	String[] dow = {"日","月","火","水","木","金","土"};

	// 各テキストフィールドの用意
	for(int i=0; i<tfDOW.length; i++) {
		tfDOW[i] = new JTextField();	// テキストフィールドオブジェクト作成

		tfDOW[i].setText(dow[i]);	// テキストフィールドに表示する文字を設定

		// テキストフィールドのフォントサイズ、中央揃えを設定
		setTextFieldProperty(tfDOW[i]);
		panelB.add(tfDOW[i]);
	}

	// 曜日テキストフィールドの文字色の設定
	setTextFieldsFontColor(tfDOW);


	// 日付表示用のテキストフィールドを用意
	int[] array = new int[42];		// 7 x 6 マス用意
	tfDays = new JTextField[42];

	for(int i=0; i<tfDays.length; i++) {
		tfDays[i] = new JTextField();

		// 日付マスに表示する文字列を指定
		tfDays[i].setText(String.valueOf(array[i]));
		setTextFieldProperty(tfDays[i]);
		tfDays[i].setBackground(Color.WHITE);

		panelB.add(tfDays[i]);
	}

	// 日付テキストフィールドの文字色の設定
	setTextFieldsFontColor(tfDays);


	// コンテナのパネルを配置する
	c.add(panelA,"North");		// panelAは上部に
	c.add(panelB,"Center");		// panelBは中央に

	}	// 長いコンストラクタここまで！


	// 曜日、日付のテキストフィールドのメソッド
	public void setTextFieldProperty(JTextField tf) {
		tf.setFont(new Font(Font.DIALOG, Font.BOLD, 16));	// Font指定
		tf.setHorizontalAlignment(JTextField.CENTER);	// 中央揃え
		tf.setEditable(false);	// 編集不可
	}

	// 曜日、日付のテキストフィールドの文字色設定
	public void setTextFieldsFontColor(JTextField[] tfs) {
		for(int i=0; i<tfs.length; i++) {
			if(i%7 == 0) {	// 日曜日は赤
				tfs[i].setForeground(Color.RED);
			}else if(i%7 == 6){	// 土曜日は青
				tfs[i].setForeground(Color.BLUE);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			System.out.println("backボタンが押された");
		}else if(e.getSource() == next) {
			System.out.println("nextボタンが押された");
		}else {
			System.out.println("resetボタンが押された");
		}
	}

	public static void main(String[] args) {
		CalendarGUI00 f = new CalendarGUI00();
		f.setVisible(true);
	}

}

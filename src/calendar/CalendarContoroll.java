package calendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarContoroll implements ActionListener{

	CalendarCell model;
	CalendarGUI00 view;

	// コンストラクタ
	public CalendarContoroll() {
		this.model = new CalendarCell();
		this.view = new CalendarGUI00();

		this.view.back.addActionListener(this);
		this.view.next.addActionListener(this);
		this.view.reset.addActionListener(this);

		this.view.back.removeActionListener(view);

		this.setTextFieldsDate();

		this.view.reset.setText(this.model.getYear() + "年" + this.model.getMonth() + "月");
	}

	// メソッド
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.view.back) {
			this.model.backMonth();
		}
		else if(e.getSource() == this.view.reset) {
			this.model.initialize();
		}
		else {
			this.model.nextMonth();
		}

		// GUI画面のテキストフィールドを更新する
		this.setTextFieldsDate();

		this.view.reset.setText(this.model.getYear() + "年" + this.model.getMonth() + "月");

	}

	public void setTextFieldsDate() {
		int[] array = this.model.getCell();

		for(int i=0; i<this.view.tfDays.length; i++) {
			if(array[i] > 0) {
				this.view.tfDays[i].setText(String.valueOf(array[i]));
			}
			else {
				this.view.tfDays[i].setText("--");
			}
		}
	}

}
package calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarCell {

	private int[] cell = new int[42];
	private LocalDate date;

	static final String[] DAYOFWEEK = {"日","月","火","水","木","金","土"};


	public CalendarCell() {
		this.initialize();
	}


	// フィールドdateを当月の一日に初期化する
	public void initialize() {
		LocalDate date = LocalDate.now();
		this.date = LocalDate.of(date.getYear(), date.getMonth(), 1);

		this.setCell();
	}

	// フィールドdateを翌日に設定する
	public void nextMonth() {
		this.date = this.date.plusMonths(1);

		this.setCell();
	}

	// フィールドdateを先月に設定する
	public void backMonth() {
		this.date = this.date.minusMonths(1);

		this.setCell();
	}

	private void setCell() {
		// dateに設定されている月の一日の曜日を調べる
		DayOfWeek dow = this.date.getDayOfWeek();
		int dowValue = dow.getValue();
		dowValue = dowValue % 7;

		// dateに設定されている月が何日まであるか調べる
		int lastDay = date.lengthOfMonth();

		// cellの中身を全て 0 にする
		for(int i=0; i<this.cell.length; i++) {
			this.cell[i] = 0;
		}

		// cell に 一日から末日までの日付を入れる
		int startIndex = dowValue;
		int endDate = lastDay;
		int day = 1;

		for(int i=0; i<this.cell.length; i++) {
			if(i >= startIndex && day <= endDate) {
				this.cell[i] = day++;
			}
		}
	}

	public int[] getCell() {
		return this.cell;
	}

	public int getYear() {
		return this.date.getYear();
	}

	public int getMonth() {
		return this.date.getMonthValue();
	}

}































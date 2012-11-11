package slot.win;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button[] button_table = new Button[44];
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH);
	int day = calendar.get(Calendar.DAY_OF_MONTH);
	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	TextView Date_Label;
	String label;
	int Month;
	private TextView textview;
	int month_total;
	private SQLiteDatabase db;
	DBHelper dbhelper;
	Cursor c;
	int count;
	int total = 0;
	TextView month_text;

	Bean bean = new Bean();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		button_table[0] = (Button) this.findViewById(R.id.hiduke_button1);
		button_table[1] = (Button) this.findViewById(R.id.hiduke_button2);
		button_table[2] = (Button) this.findViewById(R.id.hiduke_button3);
		button_table[3] = (Button) this.findViewById(R.id.hiduke_button4);
		button_table[4] = (Button) this.findViewById(R.id.hiduke_button5);
		button_table[5] = (Button) this.findViewById(R.id.hiduke_button6);
		button_table[6] = (Button) this.findViewById(R.id.hiduke_button7);
		button_table[7] = (Button) this.findViewById(R.id.hiduke_button8);
		button_table[8] = (Button) this.findViewById(R.id.hiduke_button9);
		button_table[9] = (Button) this.findViewById(R.id.hiduke_button10);
		button_table[10] = (Button) this.findViewById(R.id.hiduke_button11);
		button_table[11] = (Button) this.findViewById(R.id.hiduke_button12);
		button_table[12] = (Button) this.findViewById(R.id.hiduke_button13);
		button_table[13] = (Button) this.findViewById(R.id.hiduke_button14);
		button_table[14] = (Button) this.findViewById(R.id.hiduke_button15);
		button_table[15] = (Button) this.findViewById(R.id.hiduke_button16);
		button_table[16] = (Button) this.findViewById(R.id.hiduke_button17);
		button_table[17] = (Button) this.findViewById(R.id.hiduke_button18);
		button_table[18] = (Button) this.findViewById(R.id.hiduke_button19);
		button_table[19] = (Button) this.findViewById(R.id.hiduke_button20);
		button_table[20] = (Button) this.findViewById(R.id.hiduke_button21);
		button_table[21] = (Button) this.findViewById(R.id.hiduke_button22);
		button_table[22] = (Button) this.findViewById(R.id.hiduke_button23);
		button_table[23] = (Button) this.findViewById(R.id.hiduke_button24);
		button_table[24] = (Button) this.findViewById(R.id.hiduke_button25);
		button_table[25] = (Button) this.findViewById(R.id.hiduke_button26);
		button_table[26] = (Button) this.findViewById(R.id.hiduke_button27);
		button_table[27] = (Button) this.findViewById(R.id.hiduke_button28);
		button_table[28] = (Button) this.findViewById(R.id.hiduke_button29);
		button_table[29] = (Button) this.findViewById(R.id.hiduke_button30);
		button_table[30] = (Button) this.findViewById(R.id.hiduke_button31);
		button_table[31] = (Button) this.findViewById(R.id.hiduke_button32);
		button_table[32] = (Button) this.findViewById(R.id.hiduke_button33);
		button_table[33] = (Button) this.findViewById(R.id.hiduke_button34);
		button_table[34] = (Button) this.findViewById(R.id.hiduke_button35);
		button_table[35] = (Button) this.findViewById(R.id.hiduke_button36);
		button_table[36] = (Button) this.findViewById(R.id.hiduke_button37);
		button_table[37] = (Button) this.findViewById(R.id.hiduke_button38);
		button_table[38] = (Button) this.findViewById(R.id.hiduke_button39);
		button_table[39] = (Button) this.findViewById(R.id.hiduke_button40);
		button_table[40] = (Button) this.findViewById(R.id.hiduke_button41);
		button_table[41] = (Button) this.findViewById(R.id.hiduke_button42);
		button_table[42] = (Button) this.findViewById(R.id.back);
		button_table[43] = (Button) this.findViewById(R.id.forward);
		Date_Label = (TextView) this.findViewById(R.id.DATE_Label);
		month_text = (TextView) findViewById(R.id.month_total);

		OnClickListener listener = new b0_ClickListener();
		OnClickListener listener1 = new b1_ClickListener();
		OnClickListener listener2 = new b2_ClickListener();
		OnClickListener listener3 = new b3_ClickListener();
		OnClickListener listener4 = new b4_ClickListener();
		OnClickListener listener5 = new b5_ClickListener();
		OnClickListener listener6 = new b6_ClickListener();
		OnClickListener listener7 = new b7_ClickListener();
		OnClickListener listener8 = new b8_ClickListener();
		OnClickListener listener9 = new b9_ClickListener();
		OnClickListener listener10 = new b10_ClickListener();
		OnClickListener listener11 = new b11_ClickListener();
		OnClickListener listener12 = new b12_ClickListener();
		OnClickListener listener13 = new b13_ClickListener();
		OnClickListener listener14 = new b14_ClickListener();
		OnClickListener listener15 = new b15_ClickListener();
		OnClickListener listener16 = new b16_ClickListener();
		OnClickListener listener17 = new b17_ClickListener();
		OnClickListener listener18 = new b18_ClickListener();
		OnClickListener listener19 = new b19_ClickListener();
		OnClickListener listener20 = new b20_ClickListener();
		OnClickListener listener21 = new b21_ClickListener();
		OnClickListener listener22 = new b22_ClickListener();
		OnClickListener listener23 = new b23_ClickListener();
		OnClickListener listener24 = new b24_ClickListener();
		OnClickListener listener25 = new b25_ClickListener();
		OnClickListener listener26 = new b26_ClickListener();
		OnClickListener listener27 = new b27_ClickListener();
		OnClickListener listener28 = new b28_ClickListener();
		OnClickListener listener29 = new b29_ClickListener();
		OnClickListener listener30 = new b30_ClickListener();
		OnClickListener listener31 = new b31_ClickListener();
		OnClickListener listener32 = new b32_ClickListener();
		OnClickListener listener33 = new b33_ClickListener();
		OnClickListener listener34 = new b34_ClickListener();
		OnClickListener listener35 = new b35_ClickListener();
		OnClickListener listener36 = new b36_ClickListener();
		OnClickListener listener37 = new b37_ClickListener();
		OnClickListener listener38 = new b38_ClickListener();
		OnClickListener listener39 = new b39_ClickListener();
		OnClickListener listener40 = new b40_ClickListener();
		OnClickListener listener41 = new b41_ClickListener();

		button_table[0].setOnClickListener(listener);
		button_table[1].setOnClickListener(listener1);
		button_table[2].setOnClickListener(listener2);
		button_table[3].setOnClickListener(listener3);
		button_table[4].setOnClickListener(listener4);
		button_table[5].setOnClickListener(listener5);
		button_table[6].setOnClickListener(listener6);
		button_table[7].setOnClickListener(listener7);
		button_table[8].setOnClickListener(listener8);
		button_table[9].setOnClickListener(listener9);
		button_table[10].setOnClickListener(listener10);
		button_table[11].setOnClickListener(listener11);
		button_table[12].setOnClickListener(listener12);
		button_table[13].setOnClickListener(listener13);
		button_table[14].setOnClickListener(listener14);
		button_table[15].setOnClickListener(listener15);
		button_table[16].setOnClickListener(listener16);
		button_table[17].setOnClickListener(listener17);
		button_table[18].setOnClickListener(listener18);
		button_table[19].setOnClickListener(listener19);
		button_table[20].setOnClickListener(listener20);
		button_table[21].setOnClickListener(listener21);
		button_table[22].setOnClickListener(listener22);
		button_table[23].setOnClickListener(listener23);
		button_table[24].setOnClickListener(listener24);
		button_table[25].setOnClickListener(listener25);
		button_table[26].setOnClickListener(listener26);
		button_table[27].setOnClickListener(listener27);
		button_table[28].setOnClickListener(listener28);
		button_table[29].setOnClickListener(listener29);
		button_table[30].setOnClickListener(listener30);
		button_table[31].setOnClickListener(listener31);
		button_table[32].setOnClickListener(listener32);
		button_table[33].setOnClickListener(listener33);
		button_table[34].setOnClickListener(listener34);
		button_table[35].setOnClickListener(listener35);
		button_table[36].setOnClickListener(listener36);
		button_table[37].setOnClickListener(listener37);
		button_table[38].setOnClickListener(listener38);
		button_table[39].setOnClickListener(listener39);
		button_table[40].setOnClickListener(listener40);
		button_table[41].setOnClickListener(listener41);

		List<Integer> list_IE = new ArrayList<Integer>();

		for (int i = 42; i <= 43; i++) {

			button_table[i].setOnClickListener(this);

		}

		calendar.set(year, month, 1);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		// 日1,月2,・・・土7
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		Date_Label.setText(String.valueOf(String.valueOf(year + "年"
				+ (month + 1) + "月")));
		int lastDate = calendar.get(Calendar.DATE);
		for (int i = dayOfWeek - 1; i <= dayOfWeek + lastDate - 2; i++) {
			button_table[i].setText(String.valueOf(day));
			button_table[i].setTextSize(15);
			day = day + 1;
		}

		String date = String.valueOf(year) + "/" + String.valueOf(month + 1);
		dbhelper = new DBHelper(this);
		db = dbhelper.getWritableDatabase();
		MainSQL mainsql = new MainSQL(db, date);

		// SQLの中身をカーソルに登録
		c = mainsql.SelectDB();

		if (c == null) {
			count = 0;
		} else {
			count = c.getCount();
		}

		// カーソルの中身を配列に入れる
		if (count != 0) {
			c.moveToFirst();
			for (int i = 0; i < count; i++) {
				total = Integer.parseInt(c.getString(1))
						- Integer.parseInt(c.getString(0));
				list_IE.add(total);
				c.moveToNext();
			}
		}

		for (int i : list_IE) {
			month_total = month_total + i;
		}

		// １日のトータル収支を計算とセット
		month_text.setText("今月の収支 " + month_total);
		month_text.setTextSize(25);
		if (month_total >= 0) {
			textview.setBackgroundColor(Color.BLUE);
		} else {
			textview.setBackgroundColor(Color.RED);
		}
	}

	public void onClick(View v) {

		if (v == button_table[42]) {
			if (month == 0) {
				year = year - 1;
				month = 11;
			} else {
				month = month - 1;
			}
			Date_Label.setText(String.valueOf(String.valueOf(year + "年"
					+ (month + 1) + "月")));
			calendar.set(year, month, 1);
			day = calendar.get(Calendar.DAY_OF_MONTH);
			dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DATE, -1);
			int lastDate = calendar.get(Calendar.DATE);
			calendar.set(year, month, 1);
			// 日1,月2,・・・土7
			for (int i = 0; i < dayOfWeek; i++) {
				button_table[i].setText("");
			}
			for (int i = dayOfWeek - 1; i <= dayOfWeek + lastDate - 2; i++) {
				button_table[i].setText(String.valueOf(day));
				button_table[i].setTextSize(15);
				day = day + 1;
			}
			for (int i = dayOfWeek + lastDate - 1; i <= 41; i++) {
				button_table[i].setText("");
			}
		}

		if (v == button_table[43]) {
			if (month == 11) {
				year = year + 1;
				month = 0;
			} else {
				month = month + 1;
			}
			Date_Label.setText(String.valueOf(String.valueOf(year + "年"
					+ (month + 1) + "月")));
			calendar.set(year, month, 1);
			day = calendar.get(Calendar.DAY_OF_MONTH);
			dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DATE, -1);
			int lastDate = calendar.get(Calendar.DATE);
			calendar.set(year, month, 1);
			// 日1,月2,・・・土7
			for (int i = 0; i < dayOfWeek; i++) {
				button_table[i].setText("");
			}
			for (int i = dayOfWeek - 1; i <= dayOfWeek + lastDate - 2; i++) {
				button_table[i].setText(String.valueOf(day));
				button_table[i].setTextSize(15);
				day = day + 1;
			}
			for (int i = dayOfWeek + lastDate - 1; i <= 41; i++) {
				button_table[i].setText("");
			}
		}
	}

	class b0_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(0);
		}
	}

	class b1_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(1);
		}
	}

	class b2_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(2);
		}
	}

	class b3_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(3);
		}
	}

	class b4_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(4);
		}
	}

	class b5_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(5);
		}
	}

	class b6_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(6);
		}
	}

	class b7_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(7);
		}
	}

	class b8_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(8);
		}
	}

	class b9_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(9);
		}
	}

	class b10_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(10);
		}
	}

	class b11_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(11);
		}
	}

	class b12_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(12);
		}
	}

	class b13_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(13);
		}
	}

	class b14_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(14);
		}
	}

	class b15_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(15);
		}
	}

	class b16_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(16);
		}
	}

	class b17_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(17);
		}
	}

	class b18_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(18);
		}
	}

	class b19_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(19);
		}
	}

	class b20_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(20);
		}
	}

	class b21_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(21);
		}
	}

	class b22_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(22);
		}
	}

	class b23_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(23);
		}
	}

	class b24_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(24);
		}
	}

	class b25_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(25);
		}
	}

	class b26_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(26);
		}
	}

	class b27_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(27);
		}
	}

	class b28_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(28);
		}
	}

	class b29_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(29);
		}
	}

	class b30_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(30);
		}
	}

	class b31_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(31);
		}
	}

	class b32_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(32);
		}
	}

	class b33_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(33);
		}
	}

	class b34_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(34);
		}
	}

	class b35_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(35);
		}
	}

	class b36_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(36);
		}
	}

	class b37_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(37);
		}
	}

	class b38_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(38);
		}
	}

	class b39_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(39);
		}
	}

	class b40_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(40);
		}
	}

	class b41_ClickListener implements OnClickListener {
		public void onClick(View v) {
			Click(41);
		}
	}

	void Click(int a) {
		if (button_table[a].getText().equals("")) {
		} else {
			bean.date(year, month + 1,
					Integer.parseInt(button_table[a].getText().toString()));
			Intent intent = new Intent(MainActivity.this, ListActivity.class);
			intent.putExtra(
					"date",
					year
							+ "/"
							+ (month + 1)
							+ "/"
							+ Integer.parseInt(button_table[a].getText()
									.toString()));
			startActivity(intent);
		}
	}

	void Month_total(int year, int month) {
		textview.setText("今月の収支 " + month_total);
		textview.setTextSize(35);
		if (month_total >= 0) {
			textview.setBackgroundColor(Color.BLUE);
		} else {
			textview.setBackgroundColor(Color.RED);
		}
	}
}

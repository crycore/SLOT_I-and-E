package mamezou.com;

import java.util.Calendar;

import org.w3c.dom.Text;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */

	Button[] button_table = new Button[44];
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH);
	int day = calendar.get(Calendar.DAY_OF_MONTH);
	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	TextView Date_Label;
	String label;
	int Month;

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

		for (int i = 0; i <= 43; i++) {

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
		for (int i = dayOfWeek; i <= dayOfWeek + lastDate - 2; i++) {
			button_table[i].setText(String.valueOf(day));
			button_table[i].setTextSize(15);
			day = day + 1;
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
			for (int i = dayOfWeek; i <= dayOfWeek + lastDate - 1; i++) {
				button_table[i].setText(String.valueOf(day));
				button_table[i].setTextSize(15);
				day = day + 1;
			}
			for (int i = dayOfWeek + lastDate; i <= 41; i++) {
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
			for (int i = dayOfWeek -1 ; i <= dayOfWeek + lastDate; i++) {
				button_table[i].setText(String.valueOf(day));
				button_table[i].setTextSize(15);
				day = day + 1;
			}
			for (int i = dayOfWeek + lastDate; i <= 41; i++) {
				button_table[i].setText("");
			}
		}
	}
}
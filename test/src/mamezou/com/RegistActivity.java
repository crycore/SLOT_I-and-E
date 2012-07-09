package mamezou.com;

import org.apache.http.conn.scheme.PlainSocketFactory;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegistActivity extends Activity {

	Button[] button_table = new Button[2];
	private DBAdapter db;
	EditText Praice;
	EditText Type;
	EditText Invest;
	EditText Collect;
	EditText Note;
	DBAdapter dbadapter;

	String day;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);

		Intent in = getIntent();
		String date = in.getStringExtra("date");
		day = date;

		dbadapter = new DBAdapter(this, day);

		button_table[0] = (Button) this.findViewById(R.id.back_add);
		button_table[1] = (Button) this.findViewById(R.id.add_add);
		Praice = (EditText) findViewById(R.id.place);
		Type = (EditText) findViewById(R.id.name);
		Invest = (EditText) findViewById(R.id.invest);
		Collect = (EditText) findViewById(R.id.collect);
		Note = (EditText) findViewById(R.id.note);

		OnClickListener listener = new back_add_clicklistener();
		OnClickListener listener1 = new add_add_clicklistener();

		button_table[0].setOnClickListener(listener);
		button_table[1].setOnClickListener(listener1);
	}

	class back_add_clicklistener implements OnClickListener{

		public void onClick(View v) {
			finish();
		}

	}

	class add_add_clicklistener implements OnClickListener{

		public void onClick(View v) {
			Bean bean = new Bean();
			SpannableStringBuilder holl_name = (SpannableStringBuilder) Praice.getText();
			String name = holl_name.toString();

			SpannableStringBuilder Type_name = (SpannableStringBuilder) Type.getText();
			String type_name = Type_name.toString();

			SpannableStringBuilder sinvest = (SpannableStringBuilder) Invest.getText();
			String invest = sinvest.toString();

			SpannableStringBuilder scollect = (SpannableStringBuilder) Collect.getText();
			String collect = scollect.toString();

			SpannableStringBuilder snote = (SpannableStringBuilder) Note.getText();
			String note = snote.toString();

			bean.setBean(name, type_name, invest, collect, note);

			dbadapter.open();
			dbadapter.saveIandE(bean)
;			dbadapter.close();
		}

	}
}

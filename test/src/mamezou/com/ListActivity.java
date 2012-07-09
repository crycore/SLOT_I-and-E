package mamezou.com;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends Activity {

	Button[] button_table = new Button[2];
	private ListView listview;
	private TextView textview;
	int day_total = 0;
	Cursor c;
	DBAdapter dbadapter;
	int count;
	String day;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);

		button_table[0] = (Button) this.findViewById(R.id.back_list);
		button_table[1] = (Button) this.findViewById(R.id.add_list);

		OnClickListener listener = new back_list_Clicklistener();
		OnClickListener listener1 = new add_list_Clicklistener();

		button_table[0].setOnClickListener(listener);
		button_table[1].setOnClickListener(listener1);

		listview = (ListView) findViewById(R.id.listview);
		textview = (TextView) findViewById(R.id.day_total);
		List<String> list_type = new ArrayList<String>();
		List<Integer> list_IE = new ArrayList<Integer>();

		Intent in = getIntent();
		String date = in.getStringExtra("date");
		day = date;


		DBAdapter dbadapter = new DBAdapter(this, day);

		dbadapter.open();
		c = dbadapter.select_table();
		if(c == null){
			count = 0;
		}else{
			count = c.getCount();
		}

		if(count != 0){
			c.moveToFirst();
			for(int i = 0; i < count; i++){
				list_type.add(c.getString(0));
				list_IE.add(Integer.parseInt(c.getString(1) + c.getString(2)));
			}

			for (int i : list_IE) {
				day_total = day_total + i;
			}
		}
		textview.setText("本日の収支 " + day_total);
		textview.setTextSize(35);
		if (day_total >= 0) {
			textview.setBackgroundColor(Color.BLUE);
		} else {
			textview.setBackgroundColor(Color.RED);
		}
		dbadapter.close();
	}

	class back_list_Clicklistener implements OnClickListener {

		public void onClick(View v) {
			finish();
		}

	}

	class add_list_Clicklistener implements OnClickListener {

		public void onClick(View v) {
			Intent intent = new Intent(ListActivity.this, RegistActivity.class);
			intent.putExtra("date", day);
			startActivity(intent);
		}

	}
}
